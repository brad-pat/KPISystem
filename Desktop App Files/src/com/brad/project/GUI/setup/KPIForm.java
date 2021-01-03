/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brad.project.GUI.setup;

import com.brad.project.Storage;
import com.brad.project.objects.TempKPI;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author brad
 */
public class KPIForm extends javax.swing.JFrame {

    /**
     * Creates new form KPIForm
     */
    public KPIForm() {
        initComponents();
        setVisible(true);
        setupHashMaps();
        RemoveKPI.setVisible(false);
        for (int i = 0; i < 12; i++) {
            editCollection(i, "KPI Name:", "Value (in %):", "Total SubKPIs:", "", "", "1");
        }
        for (int i = 1; i < 12; i++) {
            showCollection(i, false);
        }
        TitleTxt.setText("Set Up KPI's.. (Up to 12)");
    }

    private HashMap<Integer, JLabel> name_txts = new HashMap<Integer, JLabel>();
    private HashMap<Integer, JLabel> value_txts = new HashMap<Integer, JLabel>();
    private HashMap<Integer, JLabel> subkpi_txts = new HashMap<Integer, JLabel>();
    private HashMap<Integer, JTextField> kpi_names = new HashMap<Integer, JTextField>();
    private HashMap<Integer, JTextField> values = new HashMap<Integer, JTextField>();
    private HashMap<Integer, JTextField> subkpis = new HashMap<Integer, JTextField>();

    private void editCollection(int i, String nametxt, String valuetxt, String subkpitxts, String kpi, String value, String subkpi) {
        name_txts.get(i).setText(nametxt);
        value_txts.get(i).setText(valuetxt);
        subkpi_txts.get(i).setText(subkpitxts);
        kpi_names.get(i).setText(kpi);
        values.get(i).setText(value);
        subkpis.get(i).setText(subkpi);
    }

    private void showCollection(int i, boolean show) {
        name_txts.get(i).setVisible(show);
        value_txts.get(i).setVisible(show);
        subkpi_txts.get(i).setVisible(show);
        kpi_names.get(i).setVisible(show);
        values.get(i).setVisible(show);
        subkpis.get(i).setVisible(show);
    }

    int currentenabled = 0;

    private void setupHashMaps() {
        /**
         * Name Texts
         */
        name_txts.put(0, NameTxt0);
        name_txts.put(1, NameTxt1);
        name_txts.put(2, NameTxt2);
        name_txts.put(3, NameTxt3);
        name_txts.put(4, NameTxt4);
        name_txts.put(5, NameTxt5);
        name_txts.put(6, NameTxt6);
        name_txts.put(7, NameTxt7);
        name_txts.put(8, NameTxt8);
        name_txts.put(9, NameTxt9);
        name_txts.put(10, NameTxt10);
        name_txts.put(11, NameTxt11);
        /**
         * Value Texts
         */
        value_txts.put(0, ValueTxt0);
        value_txts.put(1, ValueTxt1);
        value_txts.put(2, ValueTxt2);
        value_txts.put(3, ValueTxt3);
        value_txts.put(4, ValueTxt4);
        value_txts.put(5, ValueTxt5);
        value_txts.put(6, ValueTxt6);
        value_txts.put(7, ValueTxt7);
        value_txts.put(8, ValueTxt8);
        value_txts.put(9, ValueTxt9);
        value_txts.put(10, ValueTxt10);
        value_txts.put(11, ValueTxt11);
        /**
         * SubKPI Texts
         */
        subkpi_txts.put(0, SubKPITxt0);
        subkpi_txts.put(1, SubKPITxt1);
        subkpi_txts.put(2, SubKPITxt2);
        subkpi_txts.put(3, SubKPITxt3);
        subkpi_txts.put(4, SubKPITxt4);
        subkpi_txts.put(5, SubKPITxt5);
        subkpi_txts.put(6, SubKPITxt6);
        subkpi_txts.put(7, SubKPITxt7);
        subkpi_txts.put(8, SubKPITxt8);
        subkpi_txts.put(9, SubKPITxt9);
        subkpi_txts.put(10, SubKPITxt10);
        subkpi_txts.put(11, SubKPITxt11);
        /**
         * KPI TextField
         */
        kpi_names.put(0, KPIName0);
        kpi_names.put(1, KPIName1);
        kpi_names.put(2, KPIName2);
        kpi_names.put(3, KPIName3);
        kpi_names.put(4, KPIName4);
        kpi_names.put(5, KPIName5);
        kpi_names.put(6, KPIName6);
        kpi_names.put(7, KPIName7);
        kpi_names.put(8, KPIName8);
        kpi_names.put(9, KPIName9);
        kpi_names.put(10, KPIName10);
        kpi_names.put(11, KPIName11);
        /**
         * Values TextField
         */
        values.put(0, Value0);
        values.put(1, Value1);
        values.put(2, Value2);
        values.put(3, Value3);
        values.put(4, Value4);
        values.put(5, Value5);
        values.put(6, Value6);
        values.put(7, Value7);
        values.put(8, Value8);
        values.put(9, Value9);
        values.put(10, Value10);
        values.put(11, Value11);
        /**
         * Subkpis TextField
         */
        subkpis.put(0, SubKPI0);
        subkpis.put(1, SubKPI1);
        subkpis.put(2, SubKPI2);
        subkpis.put(3, SubKPI3);
        subkpis.put(4, SubKPI4);
        subkpis.put(5, SubKPI5);
        subkpis.put(6, SubKPI6);
        subkpis.put(7, SubKPI7);
        subkpis.put(8, SubKPI8);
        subkpis.put(9, SubKPI9);
        subkpis.put(10, SubKPI10);
        subkpis.put(11, SubKPI11);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        ResetButton = new javax.swing.JButton();
        TitleTxt = new javax.swing.JLabel();
        NextButton = new javax.swing.JButton();
        NameTxt0 = new javax.swing.JLabel();
        KPIName0 = new javax.swing.JTextField();
        ValueTxt0 = new javax.swing.JLabel();
        Value0 = new javax.swing.JTextField();
        SubKPITxt0 = new javax.swing.JLabel();
        SubKPI0 = new javax.swing.JTextField();
        PreviousButton = new javax.swing.JButton();
        AddKPI = new javax.swing.JButton();
        RemoveKPI = new javax.swing.JButton();
        NameTxt1 = new javax.swing.JLabel();
        KPIName1 = new javax.swing.JTextField();
        ValueTxt1 = new javax.swing.JLabel();
        Value1 = new javax.swing.JTextField();
        SubKPITxt1 = new javax.swing.JLabel();
        SubKPI1 = new javax.swing.JTextField();
        NameTxt2 = new javax.swing.JLabel();
        KPIName2 = new javax.swing.JTextField();
        ValueTxt2 = new javax.swing.JLabel();
        Value2 = new javax.swing.JTextField();
        SubKPITxt2 = new javax.swing.JLabel();
        SubKPI2 = new javax.swing.JTextField();
        NameTxt3 = new javax.swing.JLabel();
        KPIName3 = new javax.swing.JTextField();
        ValueTxt3 = new javax.swing.JLabel();
        Value3 = new javax.swing.JTextField();
        SubKPITxt3 = new javax.swing.JLabel();
        SubKPI3 = new javax.swing.JTextField();
        NameTxt4 = new javax.swing.JLabel();
        KPIName4 = new javax.swing.JTextField();
        ValueTxt4 = new javax.swing.JLabel();
        Value4 = new javax.swing.JTextField();
        SubKPITxt4 = new javax.swing.JLabel();
        SubKPI4 = new javax.swing.JTextField();
        NameTxt5 = new javax.swing.JLabel();
        KPIName5 = new javax.swing.JTextField();
        ValueTxt5 = new javax.swing.JLabel();
        Value5 = new javax.swing.JTextField();
        SubKPITxt5 = new javax.swing.JLabel();
        SubKPI5 = new javax.swing.JTextField();
        NameTxt6 = new javax.swing.JLabel();
        KPIName6 = new javax.swing.JTextField();
        ValueTxt6 = new javax.swing.JLabel();
        Value6 = new javax.swing.JTextField();
        SubKPITxt6 = new javax.swing.JLabel();
        SubKPI6 = new javax.swing.JTextField();
        NameTxt7 = new javax.swing.JLabel();
        KPIName7 = new javax.swing.JTextField();
        ValueTxt7 = new javax.swing.JLabel();
        Value7 = new javax.swing.JTextField();
        SubKPITxt7 = new javax.swing.JLabel();
        SubKPI7 = new javax.swing.JTextField();
        NameTxt8 = new javax.swing.JLabel();
        KPIName8 = new javax.swing.JTextField();
        ValueTxt8 = new javax.swing.JLabel();
        Value8 = new javax.swing.JTextField();
        SubKPITxt8 = new javax.swing.JLabel();
        SubKPI8 = new javax.swing.JTextField();
        NameTxt9 = new javax.swing.JLabel();
        KPIName9 = new javax.swing.JTextField();
        ValueTxt9 = new javax.swing.JLabel();
        Value9 = new javax.swing.JTextField();
        SubKPITxt9 = new javax.swing.JLabel();
        SubKPI9 = new javax.swing.JTextField();
        NameTxt10 = new javax.swing.JLabel();
        KPIName10 = new javax.swing.JTextField();
        ValueTxt10 = new javax.swing.JLabel();
        Value10 = new javax.swing.JTextField();
        SubKPITxt10 = new javax.swing.JLabel();
        SubKPI10 = new javax.swing.JTextField();
        NameTxt11 = new javax.swing.JLabel();
        KPIName11 = new javax.swing.JTextField();
        ValueTxt11 = new javax.swing.JLabel();
        Value11 = new javax.swing.JTextField();
        SubKPITxt11 = new javax.swing.JLabel();
        SubKPI11 = new javax.swing.JTextField();

        ResetButton.setText("Reset");
        ResetButton.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleTxt.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        TitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleTxt.setText("<TYPE> KPI Setup (Up to 12)..");

        NextButton.setText("Next >");
        NextButton.setToolTipText("");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        NameTxt0.setText("Name:");

        KPIName0.setText("KPI Name 0");

        ValueTxt0.setText("Value:");

        Value0.setText("Value%");
        Value0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Value0ActionPerformed(evt);
            }
        });

        SubKPITxt0.setText("Total SubKPIs:");

        SubKPI0.setText("0");

        PreviousButton.setText("< Previous");
        PreviousButton.setToolTipText("");
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        AddKPI.setText("Add KPI +");
        AddKPI.setToolTipText("");
        AddKPI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddKPIActionPerformed(evt);
            }
        });

        RemoveKPI.setText("- Remove Latest KPI");
        RemoveKPI.setToolTipText("");
        RemoveKPI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveKPIActionPerformed(evt);
            }
        });

        NameTxt1.setText("Name:");

        KPIName1.setText("KPI Name 0");

        ValueTxt1.setText("Value:");

        Value1.setText("Value%");
        Value1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Value1ActionPerformed(evt);
            }
        });

        SubKPITxt1.setText("Total SubKPIs:");

        SubKPI1.setText("0");

        NameTxt2.setText("Name:");

        KPIName2.setText("KPI Name 0");

        ValueTxt2.setText("Value:");

        Value2.setText("Value%");
        Value2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Value2ActionPerformed(evt);
            }
        });

        SubKPITxt2.setText("Total SubKPIs:");

        SubKPI2.setText("0");

        NameTxt3.setText("Name:");

        KPIName3.setText("KPI Name 0");

        ValueTxt3.setText("Value:");

        Value3.setText("Value%");
        Value3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Value3ActionPerformed(evt);
            }
        });

        SubKPITxt3.setText("Total SubKPIs:");

        SubKPI3.setText("0");

        NameTxt4.setText("Name:");

        KPIName4.setText("KPI Name 0");

        ValueTxt4.setText("Value:");

        Value4.setText("Value%");
        Value4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Value4ActionPerformed(evt);
            }
        });

        SubKPITxt4.setText("Total SubKPIs:");

        SubKPI4.setText("0");

        NameTxt5.setText("Name:");

        KPIName5.setText("KPI Name 0");

        ValueTxt5.setText("Value:");

        Value5.setText("Value%");
        Value5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Value5ActionPerformed(evt);
            }
        });

        SubKPITxt5.setText("Total SubKPIs:");

        SubKPI5.setText("0");

        NameTxt6.setText("Name:");

        KPIName6.setText("KPI Name 0");

        ValueTxt6.setText("Value:");

        Value6.setText("Value%");
        Value6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Value6ActionPerformed(evt);
            }
        });

        SubKPITxt6.setText("Total SubKPIs:");

        SubKPI6.setText("0");

        NameTxt7.setText("Name:");

        KPIName7.setText("KPI Name 0");

        ValueTxt7.setText("Value:");

        Value7.setText("Value%");
        Value7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Value7ActionPerformed(evt);
            }
        });

        SubKPITxt7.setText("Total SubKPIs:");

        SubKPI7.setText("0");

        NameTxt8.setText("Name:");

        KPIName8.setText("KPI Name 0");

        ValueTxt8.setText("Value:");

        Value8.setText("Value%");
        Value8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Value8ActionPerformed(evt);
            }
        });

        SubKPITxt8.setText("Total SubKPIs:");

        SubKPI8.setText("0");

        NameTxt9.setText("Name:");

        KPIName9.setText("KPI Name 0");

        ValueTxt9.setText("Value:");

        Value9.setText("Value%");
        Value9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Value9ActionPerformed(evt);
            }
        });

        SubKPITxt9.setText("Total SubKPIs:");

        SubKPI9.setText("0");

        NameTxt10.setText("Name:");

        KPIName10.setText("KPI Name 0");

        ValueTxt10.setText("Value:");

        Value10.setText("Value%");
        Value10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Value10ActionPerformed(evt);
            }
        });

        SubKPITxt10.setText("Total SubKPIs:");

        SubKPI10.setText("0");

        NameTxt11.setText("Name:");

        KPIName11.setText("KPI Name 0");

        ValueTxt11.setText("Value:");

        Value11.setText("Value%");
        Value11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Value11ActionPerformed(evt);
            }
        });

        SubKPITxt11.setText("Total SubKPIs:");

        SubKPI11.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TitleTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PreviousButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NameTxt0, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SubKPITxt0, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(ValueTxt0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SubKPI0)
                                    .addComponent(KPIName0, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(Value0)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NameTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SubKPITxt3, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(ValueTxt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SubKPI3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(KPIName3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Value3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(RemoveKPI, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NameTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SubKPITxt6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ValueTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SubKPI6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(KPIName6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Value6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SubKPITxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(ValueTxt1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(NameTxt1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(SubKPI1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(KPIName1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Value1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SubKPITxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(ValueTxt2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(NameTxt2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(SubKPI2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(KPIName2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Value2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(NameTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SubKPITxt4, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                            .addComponent(ValueTxt4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(SubKPI4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(KPIName4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Value4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SubKPITxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(ValueTxt5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(NameTxt5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(SubKPI5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(KPIName5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Value5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SubKPITxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(NameTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ValueTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(SubKPI10, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(KPIName10, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Value10, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SubKPITxt11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(NameTxt11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ValueTxt11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(SubKPI11, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(KPIName11, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Value11, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SubKPITxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(ValueTxt7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(NameTxt7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(SubKPI7, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(KPIName7, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Value7, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NameTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SubKPITxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ValueTxt8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(SubKPI8, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(KPIName8, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Value8, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(356, 356, 356)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NextButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(AddKPI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SubKPITxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NameTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ValueTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SubKPI9, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName9, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Value9, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt0, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName0, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ValueTxt0, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Value0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubKPITxt0, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SubKPI0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ValueTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Value2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubKPITxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SubKPI2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ValueTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Value1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubKPITxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SubKPI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NameTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KPIName3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ValueTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Value3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SubKPITxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SubKPI3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NameTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KPIName4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ValueTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Value4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SubKPITxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SubKPI4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ValueTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Value5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubKPITxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SubKPI5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NameTxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KPIName7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ValueTxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Value7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SubKPITxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SubKPI7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NameTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KPIName6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ValueTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Value6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SubKPITxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SubKPI6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ValueTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Value8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubKPITxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SubKPI8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ValueTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Value9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubKPITxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SubKPI9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ValueTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Value10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubKPITxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SubKPI10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ValueTxt11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Value11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubKPITxt11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SubKPI11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RemoveKPI, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddKPI, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NextButton, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(PreviousButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Value0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Value0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Value0ActionPerformed

    private void Value1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Value1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Value1ActionPerformed

    private void Value2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Value2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Value2ActionPerformed

    private void Value3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Value3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Value3ActionPerformed

    private void Value4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Value4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Value4ActionPerformed

    private void Value5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Value5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Value5ActionPerformed

    private void Value6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Value6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Value6ActionPerformed

    private void Value7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Value7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Value7ActionPerformed

    private void Value8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Value8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Value8ActionPerformed

    private void Value9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Value9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Value9ActionPerformed

    private void RemoveKPIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveKPIActionPerformed
        // TODO add your handling code here:
        showCollection(currentenabled, false);
        currentenabled = currentenabled - 1;
        if (currentenabled == 0) {
            RemoveKPI.setVisible(false);
        }
        if (currentenabled < 11) {
            AddKPI.setVisible(true);
        }

        //System.out.println("rm: " + currentenabled);
    }//GEN-LAST:event_RemoveKPIActionPerformed

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Welcome();
    }//GEN-LAST:event_PreviousButtonActionPerformed

    private void AddKPIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddKPIActionPerformed
        // TODO add your handling code here:
        int toenable = currentenabled + 1;
        showCollection(toenable, true);
        currentenabled = toenable;
        if (currentenabled == 11) {
            AddKPI.setVisible(false);
        }
        if (currentenabled == 1) {
            RemoveKPI.setVisible(true);
        }
        //System.out.println("mk: " + currentenabled);
    }//GEN-LAST:event_AddKPIActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i <= currentenabled; i++) {
            String kpiname = getKPIText(i);
            try {
                int value = Integer.parseInt(getKPIValue(i));
                int subkpiamount = Integer.parseInt(getSubKPIAmount(i));
                TempKPI temp = new TempKPI(kpiname, value, subkpiamount);
                Storage.getInstance().getTempKPIList().add(temp);
            } catch (NumberFormatException e) {

            }
        }
        if ((currentenabled + 1) == Storage.getInstance().getTempKPIList().size()) {
            //printTempList();
            this.dispose();
            new SubKPISetup();
        }
    }//GEN-LAST:event_NextButtonActionPerformed

    private void printTempList() {
        for (TempKPI kp : Storage.getInstance().getTempKPIList()) {
            System.out.println("--------");
            System.out.println(kp.getKPIName());
            System.out.println("Value: " + kp.getValue() + " Subs: " + kp.getAmountOfSubKPIs());
        }
    }

    private String getSubKPIAmount(int i) {
        return subkpis.get(i).getText();
    }

    private String getKPIValue(int i) {
        return values.get(i).getText();
    }

    private String getKPIText(int i) {
        return kpi_names.get(i).getText();
    }

    private void Value10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Value10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Value10ActionPerformed

    private void Value11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Value11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Value11ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddKPI;
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
    private javax.swing.JButton NextButton;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JButton RemoveKPI;
    private javax.swing.JButton ResetButton;
    private javax.swing.JTextField SubKPI0;
    private javax.swing.JTextField SubKPI1;
    private javax.swing.JTextField SubKPI10;
    private javax.swing.JTextField SubKPI11;
    private javax.swing.JTextField SubKPI2;
    private javax.swing.JTextField SubKPI3;
    private javax.swing.JTextField SubKPI4;
    private javax.swing.JTextField SubKPI5;
    private javax.swing.JTextField SubKPI6;
    private javax.swing.JTextField SubKPI7;
    private javax.swing.JTextField SubKPI8;
    private javax.swing.JTextField SubKPI9;
    private javax.swing.JLabel SubKPITxt0;
    private javax.swing.JLabel SubKPITxt1;
    private javax.swing.JLabel SubKPITxt10;
    private javax.swing.JLabel SubKPITxt11;
    private javax.swing.JLabel SubKPITxt2;
    private javax.swing.JLabel SubKPITxt3;
    private javax.swing.JLabel SubKPITxt4;
    private javax.swing.JLabel SubKPITxt5;
    private javax.swing.JLabel SubKPITxt6;
    private javax.swing.JLabel SubKPITxt7;
    private javax.swing.JLabel SubKPITxt8;
    private javax.swing.JLabel SubKPITxt9;
    private javax.swing.JLabel TitleTxt;
    private javax.swing.JTextField Value0;
    private javax.swing.JTextField Value1;
    private javax.swing.JTextField Value10;
    private javax.swing.JTextField Value11;
    private javax.swing.JTextField Value2;
    private javax.swing.JTextField Value3;
    private javax.swing.JTextField Value4;
    private javax.swing.JTextField Value5;
    private javax.swing.JTextField Value6;
    private javax.swing.JTextField Value7;
    private javax.swing.JTextField Value8;
    private javax.swing.JTextField Value9;
    private javax.swing.JLabel ValueTxt0;
    private javax.swing.JLabel ValueTxt1;
    private javax.swing.JLabel ValueTxt10;
    private javax.swing.JLabel ValueTxt11;
    private javax.swing.JLabel ValueTxt2;
    private javax.swing.JLabel ValueTxt3;
    private javax.swing.JLabel ValueTxt4;
    private javax.swing.JLabel ValueTxt5;
    private javax.swing.JLabel ValueTxt6;
    private javax.swing.JLabel ValueTxt7;
    private javax.swing.JLabel ValueTxt8;
    private javax.swing.JLabel ValueTxt9;
    private javax.swing.ButtonGroup buttonGroup1;
    // End of variables declaration//GEN-END:variables
}
