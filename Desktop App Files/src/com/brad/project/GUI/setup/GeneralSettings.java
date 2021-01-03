/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brad.project.GUI.setup;

import com.brad.project.ConnectionHandler;
import com.brad.project.GUI.HomeScreen;
import com.brad.project.GUI.LoginScreen;
import com.brad.project.KPIHandler;
import com.brad.project.Storage;
import com.brad.project.YAMLHandler;
import com.brad.project.objects.KPI;
import com.brad.project.objects.SubKPI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author brad
 */
public class GeneralSettings extends javax.swing.JFrame {

    /**
     * Creates new form GeneralSettings
     */
    public GeneralSettings() {
        this.selectedKPI = KPIHandler.getInstance().getKPIByName(kpis_as_strings.get(0));
        initComponents();
        setVisible(true);
        setup();
    }
    
    private void setup() {
        KPI kpi = KPIHandler.getInstance().getKPIByName(kpis_as_strings.get(0));
        KPISelection.setModel(getKPIModel());
        KPINameSet.setText(kpi.getName());
        TypeValueSet.setText(kpi.getValue() + "%");
        TypeOrValueTxt.setText("Value:");
        SubKPISelection.setModel(getSubKPIModel(kpi));
        SubKPISelection.setSelectedIndex(0);
        SubKPI skpi = kpi.getSubkpis().get(0);
        SubKPINameSet.setText(skpi.getName());
        TypeValueSet1.setText(skpi.getType());
        MathsSet.setText(skpi.getMaths());
        Show.setSelected(skpi.isMonitored());
    }
    
    private void updateReview() {
        int selected = KPISelection.getSelectedIndex();
        KPI kpi = KPIHandler.getInstance().getKPIByName(kpis_as_strings.get(selected));
        KPINameSet.setText(kpi.getName());
        TypeValueSet.setText(kpi.getValue() + "%");
        TypeOrValueTxt.setText("Value:");
        SubKPISelection.setModel(getSubKPIModel(kpi));
        SubKPISelection.setSelectedIndex(0);
        SubKPI skpi = kpi.getSubkpis().get(0);
        SubKPINameSet.setText(skpi.getName());
        TypeValueSet1.setText(skpi.getType());
        MathsSet.setText(skpi.getMaths());
        Show.setSelected(skpi.isMonitored());
        selectedKPI = kpi;
    }
    
    private void updateSubReview() {
        int selected = SubKPISelection.getSelectedIndex();
        skpis_as_strings = KPIHandler.getInstance().getSubKPINamesAsList(selectedKPI);
        SubKPI skpi = KPIHandler.getInstance().getSubKPIByNameAndKPI(skpis_as_strings.get(selected), selectedKPI);
        SubKPINameSet.setText(skpi.getName());
        TypeValueSet1.setText(skpi.getType());
        MathsSet.setText(skpi.getMaths());
        Show.setSelected(skpi.isMonitored());        
    }
    
    KPI selectedKPI;
    
    private void registerStoresTimeScales() {
        if(StoreDailyBox.isSelected()) Storage.getInstance().store_time_scales_to_track.add("daily");
        if(StoreWeeklyBox.isSelected()) Storage.getInstance().store_time_scales_to_track.add("weekly");
        if(StoreMonthBox.isSelected()) Storage.getInstance().store_time_scales_to_track.add("monthly");
        if(StoreQtrBox.isSelected()) Storage.getInstance().store_time_scales_to_track.add("quarterly");
        if(StoreHalfBox.isSelected()) Storage.getInstance().store_time_scales_to_track.add("halfly");
        if(StoreYearbox.isSelected()) Storage.getInstance().store_time_scales_to_track.add("yearly");
    }
    
    private void registerIndividualTimescales() {
        if(IndivDailyBox.isSelected()) Storage.getInstance().individual_time_scales_to_track.add("daily");
        if(IndivWeeklyBox.isSelected()) Storage.getInstance().individual_time_scales_to_track.add("weekly");
        if(IndivMonthBox.isSelected()) Storage.getInstance().individual_time_scales_to_track.add("monthly");
        if(IndivQtrBox.isSelected()) Storage.getInstance().individual_time_scales_to_track.add("quarterly");
        if(IndivHalfBox.isSelected()) Storage.getInstance().individual_time_scales_to_track.add("halfly");
        if(IndivYearbox.isSelected()) Storage.getInstance().individual_time_scales_to_track.add("yearly");        
    }
    
    private String getPiIP() {
        return PiIP.getText();
    }
    
    private boolean isStoreTracked() {
        return TrackStoreBox.isSelected();
    }
    
    private boolean isIndividualTracked() {
        return TrackIndivBox.isSelected();
    }
    
    List<String> kpis_as_strings = KPIHandler.getInstance().getKPINamesAsList();
    List<String> skpis_as_strings;
    
    private ComboBoxModel getKPIModel() {        
        String[] kpis = kpis_as_strings.toArray(new String[0]);
        return new DefaultComboBoxModel(kpis);
    }
    
    private ComboBoxModel getSubKPIModel(KPI kpi) {
        String[] skpis = KPIHandler.getInstance().getSubKPINamesAsList(kpi).toArray(new String[0]);
        return new DefaultComboBoxModel(skpis);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        PiIPTxt = new javax.swing.JLabel();
        TrackStoreBox = new javax.swing.JCheckBox();
        TrackIndivBox = new javax.swing.JCheckBox();
        StoreTimescalesBox = new javax.swing.JLabel();
        StoreDailyBox = new javax.swing.JCheckBox();
        StoreWeeklyBox = new javax.swing.JCheckBox();
        StoreMonthBox = new javax.swing.JCheckBox();
        StoreQtrBox = new javax.swing.JCheckBox();
        StoreYearbox = new javax.swing.JCheckBox();
        StoreHalfBox = new javax.swing.JCheckBox();
        IndividualTimescalesbox = new javax.swing.JLabel();
        IndivDailyBox = new javax.swing.JCheckBox();
        IndivWeeklyBox = new javax.swing.JCheckBox();
        IndivMonthBox = new javax.swing.JCheckBox();
        IndivQtrBox = new javax.swing.JCheckBox();
        IndivYearbox = new javax.swing.JCheckBox();
        IndivHalfBox = new javax.swing.JCheckBox();
        ReviewTxt = new javax.swing.JLabel();
        KPISelection = new javax.swing.JComboBox<>();
        KPINameTxt = new javax.swing.JLabel();
        KPINameSet = new javax.swing.JLabel();
        TypeOrValueTxt = new javax.swing.JLabel();
        TypeValueSet = new javax.swing.JLabel();
        SubKPISelection = new javax.swing.JComboBox<>();
        SubKPITxt = new javax.swing.JLabel();
        SubKPINameTxt = new javax.swing.JLabel();
        SubKPINameSet = new javax.swing.JLabel();
        TypeOrValueTxt1 = new javax.swing.JLabel();
        TypeValueSet1 = new javax.swing.JLabel();
        MathsTxt = new javax.swing.JLabel();
        MathsSet = new javax.swing.JLabel();
        Show = new javax.swing.JCheckBox();
        FinishButton = new javax.swing.JButton();
        PreviousButton = new javax.swing.JButton();
        PiIP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("General Settings & Review");

        PiIPTxt.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        PiIPTxt.setText("Raspberry Pi IP:");

        TrackStoreBox.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        TrackStoreBox.setText("Track Store?");

        TrackIndivBox.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        TrackIndivBox.setText("Track Individually?");

        StoreTimescalesBox.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        StoreTimescalesBox.setText("Time Scales to Measure for Store:");

        StoreDailyBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        StoreDailyBox.setText("Daily");

        StoreWeeklyBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        StoreWeeklyBox.setText("Weekly");

        StoreMonthBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        StoreMonthBox.setText("Monthly");

        StoreQtrBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        StoreQtrBox.setText("Quarterly");

        StoreYearbox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        StoreYearbox.setText("Yearly");

        StoreHalfBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        StoreHalfBox.setText("Halfly");

        IndividualTimescalesbox.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        IndividualTimescalesbox.setText("Time Scales to Measure for Individuals:");

        IndivDailyBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        IndivDailyBox.setText("Daily");

        IndivWeeklyBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        IndivWeeklyBox.setText("Weekly");

        IndivMonthBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        IndivMonthBox.setText("Monthly");

        IndivQtrBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        IndivQtrBox.setText("Quarterly");

        IndivYearbox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        IndivYearbox.setText("Yearly");

        IndivHalfBox.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        IndivHalfBox.setText("Halfly");

        ReviewTxt.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        ReviewTxt.setText("Review (Select KPI to review below):");

        KPISelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        KPISelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KPISelectionActionPerformed(evt);
            }
        });

        KPINameTxt.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        KPINameTxt.setText("KPI Name:");

        KPINameSet.setFont(new java.awt.Font("Lucida Grande", 2, 20)); // NOI18N
        KPINameSet.setText("Something KPI");

        TypeOrValueTxt.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        TypeOrValueTxt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TypeOrValueTxt.setText("Type:");

        TypeValueSet.setFont(new java.awt.Font("Lucida Grande", 2, 20)); // NOI18N
        TypeValueSet.setText("40%");

        SubKPISelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SubKPISelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubKPISelectionActionPerformed(evt);
            }
        });

        SubKPITxt.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        SubKPITxt.setText("Sub KPI Details:");

        SubKPINameTxt.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        SubKPINameTxt.setText("SubKPI Name:");

        SubKPINameSet.setFont(new java.awt.Font("Lucida Grande", 2, 20)); // NOI18N
        SubKPINameSet.setText("Something KPI");

        TypeOrValueTxt1.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        TypeOrValueTxt1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TypeOrValueTxt1.setText("Type:");

        TypeValueSet1.setFont(new java.awt.Font("Lucida Grande", 2, 20)); // NOI18N
        TypeValueSet1.setText("40%");

        MathsTxt.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        MathsTxt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        MathsTxt.setText("Maths:");

        MathsSet.setFont(new java.awt.Font("Lucida Grande", 2, 20)); // NOI18N
        MathsSet.setText("40%");

        Show.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        Show.setText("Show? (See in overall display)");

        FinishButton.setText("Finish");
        FinishButton.setToolTipText("");
        FinishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishButtonActionPerformed(evt);
            }
        });

        PreviousButton.setText("< Previous");
        PreviousButton.setToolTipText("");

        PiIP.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        PiIP.setText("http://81.110.252.31/");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(StoreTimescalesBox)
                                .addGap(212, 212, 212)
                                .addComponent(SubKPITxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(StoreQtrBox)
                                            .addComponent(StoreDailyBox))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(StoreWeeklyBox)
                                            .addComponent(StoreHalfBox))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(StoreMonthBox)
                                            .addComponent(StoreYearbox)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(IndivQtrBox)
                                            .addComponent(IndivDailyBox))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(IndivWeeklyBox)
                                            .addComponent(IndivHalfBox))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(IndivMonthBox)
                                            .addComponent(IndivYearbox))))
                                .addGap(286, 286, 286)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(MathsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(MathsSet, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(TypeOrValueTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(TypeValueSet1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(SubKPINameTxt)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(SubKPINameSet, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(SubKPISelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TrackIndivBox)
                                    .addComponent(IndividualTimescalesbox))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(FinishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TrackStoreBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PiIPTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(PiIP, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ReviewTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(KPISelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(TypeOrValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TypeValueSet, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(KPINameTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KPINameSet, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PiIPTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReviewTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(KPISelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PiIP)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TrackStoreBox)
                            .addComponent(KPINameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPINameSet, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TrackIndivBox)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TypeOrValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TypeValueSet, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(StoreTimescalesBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SubKPITxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(StoreDailyBox)
                            .addComponent(StoreWeeklyBox)
                            .addComponent(StoreMonthBox)
                            .addComponent(SubKPISelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(StoreQtrBox)
                            .addComponent(StoreHalfBox)
                            .addComponent(StoreYearbox))
                        .addGap(18, 18, 18)
                        .addComponent(IndividualTimescalesbox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubKPINameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SubKPINameSet, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TypeOrValueTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TypeValueSet1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IndivDailyBox)
                    .addComponent(IndivWeeklyBox)
                    .addComponent(IndivMonthBox)
                    .addComponent(MathsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MathsSet, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IndivQtrBox)
                    .addComponent(IndivHalfBox)
                    .addComponent(IndivYearbox)
                    .addComponent(Show, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FinishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KPISelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KPISelectionActionPerformed
        // TODO add your handling code here:
        updateReview();
    }//GEN-LAST:event_KPISelectionActionPerformed

    private void SubKPISelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubKPISelectionActionPerformed
        // TODO add your handling code here:
        updateSubReview();
    }//GEN-LAST:event_SubKPISelectionActionPerformed

    private void FinishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishButtonActionPerformed
        // TODO add your handling code here:
        registerStoresTimeScales();
        registerIndividualTimescales();
        Storage.getInstance().pi_ip = PiIP.getText();
        ConnectionHandler ch = new ConnectionHandler();
        ch.setup();
        YAMLHandler yaml = new YAMLHandler();
        try {
            yaml.write();
        } catch (IOException ex) {
            Logger.getLogger(GeneralSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        new HomeScreen();
        
    }//GEN-LAST:event_FinishButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FinishButton;
    private javax.swing.JCheckBox IndivDailyBox;
    private javax.swing.JCheckBox IndivHalfBox;
    private javax.swing.JCheckBox IndivMonthBox;
    private javax.swing.JCheckBox IndivQtrBox;
    private javax.swing.JCheckBox IndivWeeklyBox;
    private javax.swing.JCheckBox IndivYearbox;
    private javax.swing.JLabel IndividualTimescalesbox;
    private javax.swing.JLabel KPINameSet;
    private javax.swing.JLabel KPINameTxt;
    private javax.swing.JComboBox<String> KPISelection;
    private javax.swing.JLabel MathsSet;
    private javax.swing.JLabel MathsTxt;
    private javax.swing.JTextField PiIP;
    private javax.swing.JLabel PiIPTxt;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JLabel ReviewTxt;
    private javax.swing.JCheckBox Show;
    private javax.swing.JCheckBox StoreDailyBox;
    private javax.swing.JCheckBox StoreHalfBox;
    private javax.swing.JCheckBox StoreMonthBox;
    private javax.swing.JCheckBox StoreQtrBox;
    private javax.swing.JLabel StoreTimescalesBox;
    private javax.swing.JCheckBox StoreWeeklyBox;
    private javax.swing.JCheckBox StoreYearbox;
    private javax.swing.JLabel SubKPINameSet;
    private javax.swing.JLabel SubKPINameTxt;
    private javax.swing.JComboBox<String> SubKPISelection;
    private javax.swing.JLabel SubKPITxt;
    private javax.swing.JCheckBox TrackIndivBox;
    private javax.swing.JCheckBox TrackStoreBox;
    private javax.swing.JLabel TypeOrValueTxt;
    private javax.swing.JLabel TypeOrValueTxt1;
    private javax.swing.JLabel TypeValueSet;
    private javax.swing.JLabel TypeValueSet1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
