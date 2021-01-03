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
import com.brad.project.objects.KPI;
import com.brad.project.objects.Target;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author brad
 */
public class TargetsScreen extends javax.swing.JFrame {

    /**
     * Creates new form TargetsScreen
     */
    public TargetsScreen() {
        initComponents();
        this.setVisible(true);
        if(TargetHandler.getInstance().general_times.isEmpty()) {
            TargetHandler.getInstance().general_times.add("Daily");
            TargetHandler.getInstance().general_times.add("Weekly");
            TargetHandler.getInstance().general_times.add("Monthly");
            TargetHandler.getInstance().general_times.add("Quarterly");
            TargetHandler.getInstance().general_times.add("Halfly");
            TargetHandler.getInstance().general_times.add("Yearly");
        }
        setUpMaps();
        for(int i = 0; i < 12; i++) {
            showCollection(i, false);
        }
        setUpKPIs();
    }
    
    private void setUpKPIs() {
        assignTimingsToDropdowns();
        List<KPI> kpi_list = KPIHandler.getInstance().kpi_list;
        for(KPI kpi : kpi_list) {
            int index = kpi_list.indexOf(kpi);
            setDataToCollection(index, kpi);
        }
    }
    
    private void assignTimingsToDropdowns() {
        for(Entry<Integer, JComboBox> entry : times.entrySet()) {
            entry.getValue().setModel(getTimingsModel());
        }
    }
    
    private ComboBoxModel getTimingsModel() {        
        String[] timings = TargetHandler.getInstance().general_times.toArray(new String[0]);
        return new DefaultComboBoxModel(timings);
    }

    private void setUpMaps() {
        /**
         * KPI Name Texts
         */
        kpiname_texts.put(0, NameTxt0);
        kpiname_texts.put(1, NameTxt1);
        kpiname_texts.put(2, NameTxt2);
        kpiname_texts.put(3, NameTxt3);
        kpiname_texts.put(4, NameTxt4);
        kpiname_texts.put(5, NameTxt5);
        kpiname_texts.put(6, NameTxt6);
        kpiname_texts.put(7, NameTxt7);
        kpiname_texts.put(8, NameTxt8);
        kpiname_texts.put(9, NameTxt9);
        kpiname_texts.put(10, NameTxt10);
        kpiname_texts.put(11, NameTxt11);
        /**
         * KPI Text Fields
         */
        kpis.put(0, KPIName0);
        kpis.put(1, KPIName1);
        kpis.put(2, KPIName2);
        kpis.put(3, KPIName3);
        kpis.put(4, KPIName4);
        kpis.put(5, KPIName5);
        kpis.put(6, KPIName6);
        kpis.put(7, KPIName7);
        kpis.put(8, KPIName8);
        kpis.put(9, KPIName9);
        kpis.put(10, KPIName10);
        kpis.put(11, KPIName11);
        /**
         * Target Texts
         */
        target_texts.put(0, TargetTxt0);
        target_texts.put(1, TargetTxt1);
        target_texts.put(2, TargetTxt2);
        target_texts.put(3, TargetTxt3);
        target_texts.put(4, TargetTxt4);
        target_texts.put(5, TargetTxt5);
        target_texts.put(6, TargetTxt6);
        target_texts.put(7, TargetTxt7);
        target_texts.put(8, TargetTxt8);
        target_texts.put(9, TargetTxt9);
        target_texts.put(10, TargetTxt10);
        target_texts.put(11, TargetTxt11);
        /**
         * Target Fields
         */
        targets.put(0, Target0);
        targets.put(1, Target1);
        targets.put(2, Target2);
        targets.put(3, Target3);
        targets.put(4, Target4);
        targets.put(5, Target5);
        targets.put(6, Target6);
        targets.put(7, Target7);
        targets.put(8, Target8);
        targets.put(9, Target9);
        targets.put(10, Target10);
        targets.put(11, Target11);
        /**
         * Times
         */
        times.put(0, TargetTimes0);
        times.put(1, TargetTimes1);
        times.put(2, TargetTimes2);
        times.put(3, TargetTimes3);
        times.put(4, TargetTimes4);
        times.put(5, TargetTimes5);
        times.put(6, TargetTimes6);
        times.put(7, TargetTimes7);
        times.put(8, TargetTimes8);
        times.put(9, TargetTimes9);
        times.put(10, TargetTimes10);
        times.put(11, TargetTimes11);
    }

    HashMap<Integer, JLabel> kpiname_texts = new HashMap<Integer, JLabel>();
    HashMap<Integer, JTextField> kpis = new HashMap<Integer, JTextField>();
    HashMap<Integer, JLabel> target_texts = new HashMap<Integer, JLabel>();
    HashMap<Integer, JTextField> targets = new HashMap<Integer, JTextField>();
    HashMap<Integer, JComboBox> times = new HashMap<Integer, JComboBox>();

    private void setDataToCollection(int i, KPI kpi) {
        showCollection(i, true);
        Target target = TargetHandler.getInstance().getTargetForKPIByKPIObject(kpi);
        kpis.get(i).setText(kpi.getName());
        if(target != null) {
            //TARGET EXISTS
            targets.get(i).setText(target.getTarget() + "");
            times.get(i).setSelectedIndex(TargetHandler.getInstance().target_times.indexOf(target.getTimescale()));
        }
        else {
            //TARGET DOESNT EXIST
            targets.get(i).setText("0.00");
        }
    }
    
    private void showCollection(int i, boolean show) {
        kpiname_texts.get(i).setVisible(show);
        kpis.get(i).setVisible(show);
        target_texts.get(i).setVisible(show);
        targets.get(i).setVisible(show);
        times.get(i).setVisible(show);
    }
    
    private String getTargetInput(int i) {
        String s = targets.get(i).getText();
        return s;
    }
    
    private void grabData() {
        TargetHandler.getInstance().targets.clear();
        for(KPI kpi : KPIHandler.getInstance().kpi_list) {
            int index = KPIHandler.getInstance().kpi_list.indexOf(kpi);
            String target = getTargetInput(index);
            String targettime = getTiming(index);
            try {
                double tgt = Double.parseDouble(target);
                if(tgt != 0) TargetHandler.getInstance().targets.add(new Target(kpi.getName(), Double.parseDouble(target), targettime));
            }
            catch(NumberFormatException e) {
                
            }            
        }
    }
    
    private String getTiming(int i) {
        int index =  times.get(i).getSelectedIndex();
        return TargetHandler.getInstance().general_times.get(index);
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleTxt = new javax.swing.JLabel();
        FinishButton = new javax.swing.JButton();
        SetSubTargets = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        TargetTxt1 = new javax.swing.JLabel();
        KPIName8 = new javax.swing.JTextField();
        TargetTimes3 = new javax.swing.JComboBox<>();
        TargetTimes4 = new javax.swing.JComboBox<>();
        Target11 = new javax.swing.JTextField();
        TargetTimes8 = new javax.swing.JComboBox<>();
        TargetTxt7 = new javax.swing.JLabel();
        NameTxt4 = new javax.swing.JLabel();
        Target0 = new javax.swing.JTextField();
        TargetTimes11 = new javax.swing.JComboBox<>();
        KPIName2 = new javax.swing.JTextField();
        KPIName3 = new javax.swing.JTextField();
        TargetTxt10 = new javax.swing.JLabel();
        TargetTimes2 = new javax.swing.JComboBox<>();
        KPIName5 = new javax.swing.JTextField();
        TargetTimes1 = new javax.swing.JComboBox<>();
        KPIName6 = new javax.swing.JTextField();
        TargetTimes7 = new javax.swing.JComboBox<>();
        Target4 = new javax.swing.JTextField();
        KPIName9 = new javax.swing.JTextField();
        KPIName7 = new javax.swing.JTextField();
        TargetTxt5 = new javax.swing.JLabel();
        KPIName0 = new javax.swing.JTextField();
        TargetTxt4 = new javax.swing.JLabel();
        KPIName10 = new javax.swing.JTextField();
        KPIName1 = new javax.swing.JTextField();
        NameTxt6 = new javax.swing.JLabel();
        Target10 = new javax.swing.JTextField();
        TargetTimes10 = new javax.swing.JComboBox<>();
        Target2 = new javax.swing.JTextField();
        KPIName11 = new javax.swing.JTextField();
        TargetTxt11 = new javax.swing.JLabel();
        Target1 = new javax.swing.JTextField();
        NameTxt7 = new javax.swing.JLabel();
        Target8 = new javax.swing.JTextField();
        TargetTimes0 = new javax.swing.JComboBox<>();
        TargetTxt8 = new javax.swing.JLabel();
        TargetTxt9 = new javax.swing.JLabel();
        Target9 = new javax.swing.JTextField();
        NameTxt9 = new javax.swing.JLabel();
        NameTxt11 = new javax.swing.JLabel();
        NameTxt1 = new javax.swing.JLabel();
        TargetTxt2 = new javax.swing.JLabel();
        Target7 = new javax.swing.JTextField();
        NameTxt10 = new javax.swing.JLabel();
        TargetTimes6 = new javax.swing.JComboBox<>();
        TargetTxt6 = new javax.swing.JLabel();
        TargetTimes5 = new javax.swing.JComboBox<>();
        Target6 = new javax.swing.JTextField();
        Target3 = new javax.swing.JTextField();
        NameTxt2 = new javax.swing.JLabel();
        TargetTxt3 = new javax.swing.JLabel();
        TargetTxt0 = new javax.swing.JLabel();
        NameTxt0 = new javax.swing.JLabel();
        KPIName4 = new javax.swing.JTextField();
        Target5 = new javax.swing.JTextField();
        NameTxt3 = new javax.swing.JLabel();
        NameTxt5 = new javax.swing.JLabel();
        NameTxt8 = new javax.swing.JLabel();
        TargetTimes9 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleTxt.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        TitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleTxt.setText("Targets Setup");

        FinishButton.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        FinishButton.setText("Finish");
        FinishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishButtonActionPerformed(evt);
            }
        });

        SetSubTargets.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        SetSubTargets.setText("Set SubKPI Targets..");

        TargetTxt1.setText("Target:");

        KPIName8.setEditable(false);
        KPIName8.setText("KPI Name 0");

        TargetTimes3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly", "Quarterly", "Halfly", "Yearly" }));

        TargetTimes4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly", "Quarterly", "Halfly", "Yearly" }));

        Target11.setText("Target");
        Target11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Target11ActionPerformed(evt);
            }
        });

        TargetTimes8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly", "Quarterly", "Halfly", "Yearly" }));

        TargetTxt7.setText("Target:");

        NameTxt4.setText("Name:");

        Target0.setText("Target");
        Target0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Target0ActionPerformed(evt);
            }
        });

        TargetTimes11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly", "Quarterly", "Halfly", "Yearly" }));

        KPIName2.setEditable(false);
        KPIName2.setText("KPI Name 0");

        KPIName3.setEditable(false);
        KPIName3.setText("KPI Name 0");

        TargetTxt10.setText("Target:");

        TargetTimes2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly", "Quarterly", "Halfly", "Yearly" }));

        KPIName5.setEditable(false);
        KPIName5.setText("KPI Name 0");

        TargetTimes1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly", "Quarterly", "Halfly", "Yearly" }));
        TargetTimes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerfomed(evt);
            }
        });

        KPIName6.setEditable(false);
        KPIName6.setText("KPI Name 0");

        TargetTimes7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly", "Quarterly", "Halfly", "Yearly" }));

        Target4.setText("Target");
        Target4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Target4ActionPerformed(evt);
            }
        });

        KPIName9.setEditable(false);
        KPIName9.setText("KPI Name 0");

        KPIName7.setEditable(false);
        KPIName7.setText("KPI Name 0");

        TargetTxt5.setText("Target:");

        KPIName0.setEditable(false);
        KPIName0.setText("KPI Name 0");

        TargetTxt4.setText("Target:");

        KPIName10.setEditable(false);
        KPIName10.setText("KPI Name 0");

        KPIName1.setEditable(false);
        KPIName1.setText("KPI Name 0");

        NameTxt6.setText("Name:");

        Target10.setText("Target");
        Target10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Target10ActionPerformed(evt);
            }
        });

        TargetTimes10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly", "Quarterly", "Halfly", "Yearly" }));

        Target2.setText("Target");
        Target2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Target2ActionPerformed(evt);
            }
        });

        KPIName11.setEditable(false);
        KPIName11.setText("KPI Name 0");

        TargetTxt11.setText("Target:");

        Target1.setText("Target");
        Target1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Target1ActionPerformed(evt);
            }
        });

        NameTxt7.setText("Name:");

        Target8.setText("Target");
        Target8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Target8ActionPerformed(evt);
            }
        });

        TargetTimes0.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly", "Quarterly", "Halfly", "Yearly" }));
        TargetTimes0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerfomed(evt);
            }
        });

        TargetTxt8.setText("Target:");

        TargetTxt9.setText("Target:");

        Target9.setText("Target");
        Target9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Target9ActionPerformed(evt);
            }
        });

        NameTxt9.setText("Name:");

        NameTxt11.setText("Name:");

        NameTxt1.setText("Name:");

        TargetTxt2.setText("Target:");

        Target7.setText("Target");
        Target7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Target7ActionPerformed(evt);
            }
        });

        NameTxt10.setText("Name:");

        TargetTimes6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly", "Quarterly", "Halfly", "Yearly" }));

        TargetTxt6.setText("Target:");

        TargetTimes5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly", "Quarterly", "Halfly", "Yearly" }));

        Target6.setText("Target");
        Target6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Target6ActionPerformed(evt);
            }
        });

        Target3.setText("Target");
        Target3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Target3ActionPerformed(evt);
            }
        });

        NameTxt2.setText("Name:");

        TargetTxt3.setText("Target:");

        TargetTxt0.setText("Target:");

        NameTxt0.setText("Name:");

        KPIName4.setEditable(false);
        KPIName4.setText("KPI Name 0");

        Target5.setText("Target");
        Target5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Target5ActionPerformed(evt);
            }
        });

        NameTxt3.setText("Name:");

        NameTxt5.setText("Name:");

        NameTxt8.setText("Name:");

        TargetTimes9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly", "Quarterly", "Halfly", "Yearly" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TargetTxt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NameTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Target3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TargetTimes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(KPIName4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TargetTxt4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NameTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Target4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TargetTimes4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(KPIName3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TargetTxt5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NameTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Target5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TargetTimes5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(KPIName5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TargetTxt10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NameTxt11, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Target9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TargetTimes9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(KPIName9, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TargetTxt9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NameTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Target11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TargetTimes10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(KPIName11, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TargetTxt7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NameTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Target6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TargetTimes6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(KPIName6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TargetTxt6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NameTxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Target8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TargetTimes7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(KPIName8, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TargetTxt8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NameTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Target7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TargetTimes8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(KPIName7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TargetTxt11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NameTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Target10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TargetTimes11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(KPIName10, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TargetTxt0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NameTxt0, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Target0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TargetTimes0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(KPIName0, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TargetTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NameTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Target1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TargetTimes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(KPIName1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TargetTxt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NameTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Target2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TargetTimes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(KPIName2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt0, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName0, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TargetTxt0, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Target0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TargetTimes0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TargetTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Target2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TargetTimes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TargetTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Target1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TargetTimes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TargetTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Target3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TargetTimes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TargetTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Target5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TargetTimes5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TargetTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Target4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TargetTimes4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NameTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KPIName6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TargetTxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Target6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TargetTimes6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NameTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KPIName7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TargetTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Target7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TargetTimes8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TargetTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Target8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TargetTimes7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TargetTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Target9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TargetTimes9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TargetTxt11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Target10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TargetTimes11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TargetTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Target11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TargetTimes10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FinishButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TitleTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SetSubTargets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(SetSubTargets, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(FinishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Target0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Target0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Target0ActionPerformed

    private void Target1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Target1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Target1ActionPerformed

    private void Target2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Target2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Target2ActionPerformed

    private void Target5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Target5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Target5ActionPerformed

    private void Target4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Target4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Target4ActionPerformed

    private void Target3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Target3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Target3ActionPerformed

    private void Target6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Target6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Target6ActionPerformed

    private void Target7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Target7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Target7ActionPerformed

    private void Target8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Target8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Target8ActionPerformed

    private void Target9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Target9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Target9ActionPerformed

    private void Target10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Target10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Target10ActionPerformed

    private void Target11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Target11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Target11ActionPerformed

    private void ComboBoxActionPerfomed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerfomed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxActionPerfomed

    private void FinishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishButtonActionPerformed
        // TODO add your handling code here:
        grabData();
        List<Target> targets = TargetHandler.getInstance().targets;
        
        ConnectionHandler ch = new ConnectionHandler();
        for(Target t : targets) {
            System.out.println(t.getKpiname());
            String kpiname = t.getKpiname();
            double target = t.getTarget();
            String timescale = t.getTimescale();
            String res = ch.submitTarget(kpiname, target, timescale);
            System.out.println(res);
        }
        this.dispose();
        new HomeScreen();
    }//GEN-LAST:event_FinishButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FinishButton;
    private javax.swing.JTextField KPIName0;
    private javax.swing.JTextField KPIName1;
    private javax.swing.JTextField KPIName10;
    private javax.swing.JTextField KPIName11;
    private javax.swing.JTextField KPIName2;
    private javax.swing.JTextField KPIName3;
    private javax.swing.JTextField KPIName4;
    private javax.swing.JTextField KPIName5;
    private javax.swing.JTextField KPIName6;
    private javax.swing.JTextField KPIName7;
    private javax.swing.JTextField KPIName8;
    private javax.swing.JTextField KPIName9;
    private javax.swing.JLabel NameTxt0;
    private javax.swing.JLabel NameTxt1;
    private javax.swing.JLabel NameTxt10;
    private javax.swing.JLabel NameTxt11;
    private javax.swing.JLabel NameTxt2;
    private javax.swing.JLabel NameTxt3;
    private javax.swing.JLabel NameTxt4;
    private javax.swing.JLabel NameTxt5;
    private javax.swing.JLabel NameTxt6;
    private javax.swing.JLabel NameTxt7;
    private javax.swing.JLabel NameTxt8;
    private javax.swing.JLabel NameTxt9;
    private javax.swing.JButton SetSubTargets;
    private javax.swing.JTextField Target0;
    private javax.swing.JTextField Target1;
    private javax.swing.JTextField Target10;
    private javax.swing.JTextField Target11;
    private javax.swing.JTextField Target2;
    private javax.swing.JTextField Target3;
    private javax.swing.JTextField Target4;
    private javax.swing.JTextField Target5;
    private javax.swing.JTextField Target6;
    private javax.swing.JTextField Target7;
    private javax.swing.JTextField Target8;
    private javax.swing.JTextField Target9;
    private javax.swing.JComboBox<String> TargetTimes0;
    private javax.swing.JComboBox<String> TargetTimes1;
    private javax.swing.JComboBox<String> TargetTimes10;
    private javax.swing.JComboBox<String> TargetTimes11;
    private javax.swing.JComboBox<String> TargetTimes2;
    private javax.swing.JComboBox<String> TargetTimes3;
    private javax.swing.JComboBox<String> TargetTimes4;
    private javax.swing.JComboBox<String> TargetTimes5;
    private javax.swing.JComboBox<String> TargetTimes6;
    private javax.swing.JComboBox<String> TargetTimes7;
    private javax.swing.JComboBox<String> TargetTimes8;
    private javax.swing.JComboBox<String> TargetTimes9;
    private javax.swing.JLabel TargetTxt0;
    private javax.swing.JLabel TargetTxt1;
    private javax.swing.JLabel TargetTxt10;
    private javax.swing.JLabel TargetTxt11;
    private javax.swing.JLabel TargetTxt2;
    private javax.swing.JLabel TargetTxt3;
    private javax.swing.JLabel TargetTxt4;
    private javax.swing.JLabel TargetTxt5;
    private javax.swing.JLabel TargetTxt6;
    private javax.swing.JLabel TargetTxt7;
    private javax.swing.JLabel TargetTxt8;
    private javax.swing.JLabel TargetTxt9;
    private javax.swing.JLabel TitleTxt;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
