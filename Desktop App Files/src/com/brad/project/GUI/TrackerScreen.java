/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brad.project.GUI;

import com.brad.project.ConnectionHandler;
import com.brad.project.KPIHandler;
import com.brad.project.Storage;
import com.brad.project.TargetHandler;
import com.brad.project.UserHandler;
import com.brad.project.objects.DisplayPacket;
import com.brad.project.objects.KPI;
import com.brad.project.objects.Target;
import com.brad.project.objects.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author brad
 */
public class TrackerScreen extends javax.swing.JFrame {

    /**
     * Creates new form TrackerScreen
     */
    public TrackerScreen() {
        initComponents();
        setUpTimeScales();
        generateStartingPage();
        setVisible(true);
        started = true;
    }

    private boolean started = false;


    private void setUpTimeScales() {
        
        for (String s : Storage.getInstance().store_time_scales_to_track) {
            if (!TargetHandler.getInstance().target_times.contains(s.trim()) && !s.equalsIgnoreCase("")) {
                TargetHandler.getInstance().target_times.add(s.trim());
            }
        }
        for (String s : Storage.getInstance().individual_time_scales_to_track) {
            if (!TargetHandler.getInstance().target_times.contains(s.trim()) && !s.equalsIgnoreCase("")) {
                TargetHandler.getInstance().target_times.add(s.trim());
            }
        }
    }

    private void display_open_page() {
        pageno = 1;
        NextButton.setVisible(true);
        PreviousButton.setVisible(false);
        int amount = kpis.size();
        if (amount >= 3) {
            setThreeData(kpis.get(0), kpis.get(1), kpis.get(2));
        }
        if (amount == 2) {
            setTwoData(kpis.get(0), kpis.get(1));
        }
        if (amount == 1) {
            setOneData(kpis.get(0));
        }
        if (amount == 0) {
            System.out.println("No data found");
        }
        OverallText.setText(overall);
    }

    int pageno = 1;
    List<KPI> kpis = KPIHandler.getInstance().kpi_list;

    private void generateStartingPage() {
        PageNumberText.setText("" + pageno);
        UserSelection.setModel(getUsersModel());
        TimeScaleSelection.setModel(getTimeScales());
        UserSelection.setSelectedIndex(1);
        TimeScaleSelection.setSelectedIndex(1);
        getData();
        display_open_page();
    }

    private void generate_previous_page() {
        if (pageno >= 1) {
            if (pageno == 2) {
                PageNumberText.setText("1");
                display_open_page();
            } else {
                NextButton.setVisible(true);
                pageno = pageno - 1;
                PageNumberText.setText("" + pageno);
                int toremove = pageno * 3;
                int amount = kpis.size() - toremove;
                if (amount >= 3) {
                    setThreeData(kpis.get(toremove), kpis.get(toremove + 1), kpis.get(toremove + 2));
                }
                if (amount == 2) {
                    setTwoData(kpis.get(toremove), kpis.get(toremove + 1));
                }
                if (amount == 1) {
                    setOneData(kpis.get(toremove));
                }
                if (amount == 0) {
                    System.out.println("No data found");
                }
            }
        }
    }

    private void generate_next_page() {
        if (pageno >= 1) {
            PreviousButton.setVisible(true);
            pageno++;
            PageNumberText.setText("" + pageno);
            int left = kpis.size() - 3;
            int amount = kpis.size() - pageno;
            //System.out.println("Page: " + pageno + " take off: " + toremove + " amount left: " + amount + " list size: " + kpis.size());
            if (left >= 3) {
                setThreeData(kpis.get(amount), kpis.get(amount + 1), kpis.get(amount + 2));
            }
            if (left == 2) {
                setTwoData(kpis.get(amount), kpis.get(amount + 1));
            }
            if (left == 1) {
                setOneData(kpis.get(amount));
            }
            if (left <= 0) {
                //System.out.println("No data found");
                NextButton.setVisible(false);
            }
        }
    }

    HashMap<KPI, String> differences = new HashMap<>();
    HashMap<KPI, String> performance = new HashMap<>();
    String overall;

    private void getData() {
        ConnectionHandler ch = new ConnectionHandler();
        String time = TargetHandler.getInstance().target_times.get(TimeScaleSelection.getSelectedIndex());
        String user = tempuserlist.get(UserSelection.getSelectedIndex());
        if (!user.equalsIgnoreCase("STORE")) {
            String upd = user.split(" - \\(")[1].replace(")", "").trim();
            user = upd;
        }
        for (KPI kpi : kpis) {
            //Type, KPIName, Timescale, User
            String kpiname = kpi.getName();
            String diffs = ch.fetchKPIData(Storage.getInstance().pi_ip + "targets/php/workoutoverallperformance.php",
                    "difference:" + kpiname + ":" + time + ":" + user);
            System.out.println(diffs);
            String perf = ch.fetchKPIData(Storage.getInstance().pi_ip + "targets/php/workoutoverallperformance.php",
                    "performance:" + kpiname + ":" + time + ":" + user);
            System.out.println(perf);
            differences.put(kpi, diffs.split("=")[1]);
            performance.put(kpi, perf.split("=")[1]);
        }
        String get_overall = ch.fetchKPIData(Storage.getInstance().pi_ip + "targets/php/workoutoverallperformance.php",
                "performance:ALL:" + time + ":" + user);
        System.out.println(get_overall);
        if(user.equalsIgnoreCase("STORE")) {
            overall = "Overall %: " + get_overall.split("STOREOVERALLPERFORMANCE=")[1].trim();
        } else {
            overall = "Overall %: " + get_overall.split("USEROVERALLPERFORMANCE=")[1].trim();
        }
    }

    private void setThreeData(KPI kpi1, KPI kpi2, KPI kpi3) {
        /**
         * LEFT SIDE
         */
        String kpi_name1 = kpi1.getName();
        String diff1 = differences.get(kpi1);
        String perf1 = performance.get(kpi1);
        left_details_handler(kpi_name1, diff1, perf1);
        /**
         * MIDDLE
         */
        String kpi_name2 = kpi2.getName();
        String diff2 = differences.get(kpi2);
        String perf2 = performance.get(kpi2);
        centre_details_handler(kpi_name2, diff2, perf2);
        /**
         * RIGHT SIDE
         */
        String kpi_name3 = kpi3.getName();
        String diff3 = differences.get(kpi3);
        String perf3 = performance.get(kpi3);
        right_details_handler(kpi_name3, diff3, perf3);
    }

    private void setTwoData(KPI kpi1, KPI kpi2) {
        //System.out.println("In set Teo data");
        /**
         * LEFT SIDE
         */
        String kpi_name1 = kpi1.getName();
        String diff1 = differences.get(kpi1);
        String perf1 = performance.get(kpi1);
        left_details_handler(kpi_name1, diff1, perf1);
        /**
         * MIDDLE
         */
        String kpi_name2 = kpi2.getName();
        String diff2 = differences.get(kpi2);
        String perf2 = performance.get(kpi2);
        centre_details_handler(kpi_name2, diff2, perf2);
        NextButton.setVisible(false);
        right_details_handler("", "", "");
    }

    private void setOneData(KPI kpi1) {
        /**
         * LEFT SIDE
         */
        String kpi_name1 = kpi1.getName();
        String diff1 = differences.get(kpi1);
        String perf1 = performance.get(kpi1);
        left_details_handler(kpi_name1, diff1, perf1);
        NextButton.setVisible(false);
        right_details_handler("", "", "");
        centre_details_handler("", "", "");
    }

    private void right_details_handler(String kpiname, String todo, String performance) {
        KPINameTitle2.setText(kpiname);
        OutOf2.setText(todo);
        ToDo2.setText(performance + " %");
    }

    private void centre_details_handler(String kpiname, String todo, String performance) {
        KPINameTitle1.setText(kpiname);
        OutOf1.setText(todo);
        ToDo1.setText(performance + " %");
    }

    private void left_details_handler(String kpiname, String todo, String performance) {
        KPINameTitle0.setText(kpiname);
        OutOf0.setText(todo);
        ToDo0.setText(performance + " %");
    }

    private ComboBoxModel getTimeScales() {
        String[] items = TargetHandler.getInstance().target_times.toArray(new String[0]);
        return new DefaultComboBoxModel(items);
    }

    List<String> tempuserlist = new ArrayList<String>();

    private ComboBoxModel getUsersModel() {
        tempuserlist.add("STORE");
        for (User u : UserHandler.getInstance().users) {
            String s = u.getName() + " - (" + u.getId() + ")";
            tempuserlist.add(s);
        }
        String[] items = tempuserlist.toArray(new String[0]);
        return new DefaultComboBoxModel(items);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleTxt = new javax.swing.JLabel();
        TimeScaleSelection = new javax.swing.JComboBox<>();
        UserSelection = new javax.swing.JComboBox<>();
        KPINameTitle0 = new javax.swing.JLabel();
        KPINameTitle1 = new javax.swing.JLabel();
        KPINameTitle2 = new javax.swing.JLabel();
        OutOf0 = new javax.swing.JLabel();
        OutOf1 = new javax.swing.JLabel();
        OutOf2 = new javax.swing.JLabel();
        ToDo0 = new javax.swing.JLabel();
        ToDo1 = new javax.swing.JLabel();
        ToDo2 = new javax.swing.JLabel();
        PreviousButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        OverallText = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        PageNumberText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleTxt.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        TitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleTxt.setText("Tracker");

        TimeScaleSelection.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        TimeScaleSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        TimeScaleSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeScaleSelectionActionPerformed(evt);
            }
        });

        UserSelection.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        UserSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        UserSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserSelectionActionPerformed(evt);
            }
        });

        KPINameTitle0.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        KPINameTitle0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KPINameTitle0.setText("KPI Name");

        KPINameTitle1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        KPINameTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KPINameTitle1.setText("KPI Name");

        KPINameTitle2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        KPINameTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KPINameTitle2.setText("KPI Name");

        OutOf0.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        OutOf0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OutOf0.setText("0/100");

        OutOf1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        OutOf1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OutOf1.setText("0/100");

        OutOf2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        OutOf2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OutOf2.setText("0/100");

        ToDo0.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ToDo0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ToDo0.setText("00 To Do");

        ToDo1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ToDo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ToDo1.setText("00 To Do");

        ToDo2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ToDo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ToDo2.setText("00 To Do");

        PreviousButton.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        PreviousButton.setText("< Previous");
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        NextButton.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        NextButton.setText("Next >");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        OverallText.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        OverallText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OverallText.setText("Overall %: 000%");

        BackButton.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        PageNumberText.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        PageNumberText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PageNumberText.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PageNumberText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TitleTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(UserSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TimeScaleSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KPINameTitle0, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OutOf0, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ToDo0, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ToDo1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ToDo2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(OutOf1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(OutOf2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(KPINameTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(KPINameTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(OverallText, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimeScaleSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KPINameTitle0, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KPINameTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KPINameTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OutOf0, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OutOf1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OutOf2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ToDo0, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ToDo1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ToDo2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PageNumberText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(118, 118, 118)
                .addComponent(OverallText, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        // TODO add your handling code here:
        generate_previous_page();
    }//GEN-LAST:event_PreviousButtonActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        // TODO add your handling code here:
        generate_next_page();
    }//GEN-LAST:event_NextButtonActionPerformed

    private void UserSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserSelectionActionPerformed
        // TODO add your handling code here:
        if (started == true) {
            performance.clear();
            differences.clear();
            getData();
            display_open_page();
        }
    }//GEN-LAST:event_UserSelectionActionPerformed

    private void TimeScaleSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeScaleSelectionActionPerformed
        // TODO add your handling code here:
        if (started == true) {
            performance.clear();
            differences.clear();
            getData();
            display_open_page();
        }
    }//GEN-LAST:event_TimeScaleSelectionActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new HomeScreen();
    }//GEN-LAST:event_BackButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel KPINameTitle0;
    private javax.swing.JLabel KPINameTitle1;
    private javax.swing.JLabel KPINameTitle2;
    private javax.swing.JButton NextButton;
    private javax.swing.JLabel OutOf0;
    private javax.swing.JLabel OutOf1;
    private javax.swing.JLabel OutOf2;
    private javax.swing.JLabel OverallText;
    private javax.swing.JLabel PageNumberText;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JComboBox<String> TimeScaleSelection;
    private javax.swing.JLabel TitleTxt;
    private javax.swing.JLabel ToDo0;
    private javax.swing.JLabel ToDo1;
    private javax.swing.JLabel ToDo2;
    private javax.swing.JComboBox<String> UserSelection;
    // End of variables declaration//GEN-END:variables
}
