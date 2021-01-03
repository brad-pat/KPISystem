/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brad.project.GUI.setup;

import com.brad.project.KPIHandler;
import com.brad.project.Storage;
import com.brad.project.objects.KPI;
import com.brad.project.objects.SubKPI;
import com.brad.project.objects.TempKPI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author brad
 */
public class SubKPISetup extends javax.swing.JFrame {

    /**
     * Creates new form SubKPISetup
     */
    public SubKPISetup() {
        initComponents();
        setVisible(true);
        setupHashMaps();
        assignButtonsToGroups();
        setup();
    }

    int currentenabled = 0;

    private void setup() {
        for (int i = 0; i < 12; i++) {
            showCollection(i, false);
            editCollection(i, "SubKPI Name:", "", "*1");
        }
        int index = Storage.getInstance().templistindex;
        TempKPI tkpi = Storage.getInstance().getTempKPIList().get(index);
        int subs = tkpi.getAmountOfSubKPIs();
        TitleTxt.setText(tkpi.getKPIName() + " Sub KPI Setup (" + (index + 1) + "/" + Storage.getInstance().getTempKPIList().size() + ")");
        for (int i = 0; i < subs; i++) {
            showCollection(i, true);
        }
        currentenabled = (subs - 1);

    }

    private void editCollection(int i, String nametxt, String kpi, String maths) {
        name_txts.get(i).setText(nametxt);
        kpinames.get(i).setText(kpi);
        mathsfields.get(i).setText(maths);
    }

    private HashMap<Integer, JLabel> name_txts = new HashMap<Integer, JLabel>();
    private HashMap<Integer, JLabel> maths_txts = new HashMap<Integer, JLabel>();
    private HashMap<Integer, JLabel> type_txts = new HashMap<Integer, JLabel>();
    private HashMap<Integer, JTextField> kpinames = new HashMap<Integer, JTextField>();
    private HashMap<Integer, JTextField> mathsfields = new HashMap<Integer, JTextField>();
    private HashMap<Integer, JRadioButton> but_units = new HashMap<Integer, JRadioButton>();
    private HashMap<Integer, JRadioButton> but_values = new HashMap<Integer, JRadioButton>();
    private HashMap<Integer, JRadioButton> but_attachs = new HashMap<Integer, JRadioButton>();
    private HashMap<Integer, JCheckBox> showbox = new HashMap<Integer, JCheckBox>();

    private void showCollection(int i, boolean show) {
        name_txts.get(i).setVisible(show);
        maths_txts.get(i).setVisible(show);
        type_txts.get(i).setVisible(show);
        kpinames.get(i).setVisible(show);
        mathsfields.get(i).setVisible(show);
        but_units.get(i).setVisible(show);
        but_values.get(i).setVisible(show);
        but_attachs.get(i).setVisible(show);
        showbox.get(i).setVisible(show);
    }

    private void setupHashMaps() {
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

        type_txts.put(0, TypeTxt0);
        type_txts.put(1, TypeTxt1);
        type_txts.put(2, TypeTxt2);
        type_txts.put(3, TypeTxt3);
        type_txts.put(4, TypeTxt4);
        type_txts.put(5, TypeTxt5);
        type_txts.put(6, TypeTxt6);
        type_txts.put(7, TypeTxt7);
        type_txts.put(8, TypeTxt8);
        type_txts.put(9, TypeTxt9);
        type_txts.put(10, TypeTxt10);
        type_txts.put(11, TypeTxt11);

        maths_txts.put(0, MathsTxt0);
        maths_txts.put(1, MathsTxt1);
        maths_txts.put(2, MathsTxt2);
        maths_txts.put(3, MathsTxt3);
        maths_txts.put(4, MathsTxt4);
        maths_txts.put(5, MathsTxt5);
        maths_txts.put(6, MathsTxt6);
        maths_txts.put(7, MathsTxt7);
        maths_txts.put(8, MathsTxt8);
        maths_txts.put(9, MathsTxt9);
        maths_txts.put(10, MathsTxt10);
        maths_txts.put(11, MathsTxt11);

        kpinames.put(0, KPIName0);
        kpinames.put(1, KPIName1);
        kpinames.put(2, KPIName2);
        kpinames.put(3, KPIName3);
        kpinames.put(4, KPIName4);
        kpinames.put(5, KPIName5);
        kpinames.put(6, KPIName6);
        kpinames.put(7, KPIName7);
        kpinames.put(8, KPIName8);
        kpinames.put(9, KPIName9);
        kpinames.put(10, KPIName10);
        kpinames.put(11, KPIName11);

        mathsfields.put(0, Maths0);
        mathsfields.put(1, Maths1);
        mathsfields.put(2, Maths2);
        mathsfields.put(3, Maths3);
        mathsfields.put(4, Maths4);
        mathsfields.put(5, Maths5);
        mathsfields.put(6, Maths6);
        mathsfields.put(7, Maths7);
        mathsfields.put(8, Maths8);
        mathsfields.put(9, Maths9);
        mathsfields.put(10, Maths10);
        mathsfields.put(11, Maths11);

        but_units.put(0, Unit0);
        but_values.put(0, ValueRadio0);
        but_attachs.put(0, Attach0);
        but_units.put(1, Unit1);
        but_values.put(1, ValueRadio1);
        but_attachs.put(1, Attach1);
        but_units.put(2, Unit2);
        but_values.put(2, ValueRadio2);
        but_attachs.put(2, Attach2);
        but_units.put(3, Unit3);
        but_values.put(3, ValueRadio3);
        but_attachs.put(3, Attach3);
        but_units.put(4, Unit4);
        but_values.put(4, ValueRadio4);
        but_attachs.put(4, Attach4);
        but_units.put(5, Unit5);
        but_values.put(5, ValueRadio5);
        but_attachs.put(5, Attach5);
        but_units.put(6, Unit6);
        but_values.put(6, ValueRadio6);
        but_attachs.put(6, Attach6);
        but_units.put(7, Unit7);
        but_values.put(7, ValueRadio7);
        but_attachs.put(7, Attach7);
        but_units.put(8, Unit8);
        but_values.put(8, ValueRadio8);
        but_attachs.put(8, Attach8);
        but_units.put(9, Unit9);
        but_values.put(9, ValueRadio9);
        but_attachs.put(9, Attach9);
        but_units.put(10, Unit10);
        but_values.put(10, ValueRadio10);
        but_attachs.put(10, Attach10);
        but_units.put(11, Unit11);
        but_values.put(11, ValueRadio11);
        but_attachs.put(11, Attach11);

        showbox.put(0, ShowBox0);
        showbox.put(1, ShowBox1);
        showbox.put(2, ShowBox2);
        showbox.put(3, ShowBox3);
        showbox.put(4, ShowBox4);
        showbox.put(5, ShowBox5);
        showbox.put(6, ShowBox6);
        showbox.put(7, ShowBox7);
        showbox.put(8, ShowBox8);
        showbox.put(9, ShowBox9);
        showbox.put(10, ShowBox10);
        showbox.put(11, ShowBox11);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        TitleTxt = new javax.swing.JLabel();
        PreviousButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        RemoveSubKPI = new javax.swing.JButton();
        AddSubKPI = new javax.swing.JButton();
        ReseetButton = new javax.swing.JButton();
        Maths0 = new javax.swing.JTextField();
        Unit0 = new javax.swing.JRadioButton();
        ValueRadio0 = new javax.swing.JRadioButton();
        Attach0 = new javax.swing.JRadioButton();
        NameTxt0 = new javax.swing.JLabel();
        KPIName0 = new javax.swing.JTextField();
        TypeTxt0 = new javax.swing.JLabel();
        MathsTxt0 = new javax.swing.JLabel();
        ShowBox0 = new javax.swing.JCheckBox();
        TypeTxt1 = new javax.swing.JLabel();
        MathsTxt1 = new javax.swing.JLabel();
        Maths1 = new javax.swing.JTextField();
        Unit1 = new javax.swing.JRadioButton();
        ShowBox1 = new javax.swing.JCheckBox();
        ValueRadio1 = new javax.swing.JRadioButton();
        Attach1 = new javax.swing.JRadioButton();
        NameTxt1 = new javax.swing.JLabel();
        KPIName1 = new javax.swing.JTextField();
        Maths2 = new javax.swing.JTextField();
        Unit2 = new javax.swing.JRadioButton();
        ValueRadio2 = new javax.swing.JRadioButton();
        Attach2 = new javax.swing.JRadioButton();
        NameTxt2 = new javax.swing.JLabel();
        KPIName2 = new javax.swing.JTextField();
        TypeTxt2 = new javax.swing.JLabel();
        MathsTxt2 = new javax.swing.JLabel();
        ShowBox2 = new javax.swing.JCheckBox();
        MathsTxt3 = new javax.swing.JLabel();
        ShowBox3 = new javax.swing.JCheckBox();
        Maths5 = new javax.swing.JTextField();
        TypeTxt4 = new javax.swing.JLabel();
        Unit5 = new javax.swing.JRadioButton();
        MathsTxt4 = new javax.swing.JLabel();
        ValueRadio5 = new javax.swing.JRadioButton();
        Maths4 = new javax.swing.JTextField();
        Attach5 = new javax.swing.JRadioButton();
        Unit4 = new javax.swing.JRadioButton();
        NameTxt5 = new javax.swing.JLabel();
        KPIName5 = new javax.swing.JTextField();
        ShowBox4 = new javax.swing.JCheckBox();
        ValueRadio4 = new javax.swing.JRadioButton();
        Maths3 = new javax.swing.JTextField();
        TypeTxt5 = new javax.swing.JLabel();
        Attach4 = new javax.swing.JRadioButton();
        Unit3 = new javax.swing.JRadioButton();
        NameTxt4 = new javax.swing.JLabel();
        ValueRadio3 = new javax.swing.JRadioButton();
        MathsTxt5 = new javax.swing.JLabel();
        KPIName4 = new javax.swing.JTextField();
        Attach3 = new javax.swing.JRadioButton();
        NameTxt3 = new javax.swing.JLabel();
        KPIName3 = new javax.swing.JTextField();
        TypeTxt3 = new javax.swing.JLabel();
        ShowBox5 = new javax.swing.JCheckBox();
        NameTxt8 = new javax.swing.JLabel();
        ValueRadio7 = new javax.swing.JRadioButton();
        MathsTxt6 = new javax.swing.JLabel();
        KPIName8 = new javax.swing.JTextField();
        Attach7 = new javax.swing.JRadioButton();
        NameTxt7 = new javax.swing.JLabel();
        KPIName7 = new javax.swing.JTextField();
        TypeTxt7 = new javax.swing.JLabel();
        ShowBox6 = new javax.swing.JCheckBox();
        MathsTxt7 = new javax.swing.JLabel();
        ShowBox7 = new javax.swing.JCheckBox();
        Maths6 = new javax.swing.JTextField();
        TypeTxt8 = new javax.swing.JLabel();
        Unit6 = new javax.swing.JRadioButton();
        MathsTxt8 = new javax.swing.JLabel();
        ValueRadio6 = new javax.swing.JRadioButton();
        Maths8 = new javax.swing.JTextField();
        Attach6 = new javax.swing.JRadioButton();
        Unit8 = new javax.swing.JRadioButton();
        NameTxt6 = new javax.swing.JLabel();
        KPIName6 = new javax.swing.JTextField();
        ShowBox8 = new javax.swing.JCheckBox();
        ValueRadio8 = new javax.swing.JRadioButton();
        Maths7 = new javax.swing.JTextField();
        TypeTxt6 = new javax.swing.JLabel();
        Attach8 = new javax.swing.JRadioButton();
        Unit7 = new javax.swing.JRadioButton();
        NameTxt11 = new javax.swing.JLabel();
        ValueRadio10 = new javax.swing.JRadioButton();
        MathsTxt9 = new javax.swing.JLabel();
        KPIName11 = new javax.swing.JTextField();
        Attach10 = new javax.swing.JRadioButton();
        NameTxt10 = new javax.swing.JLabel();
        KPIName10 = new javax.swing.JTextField();
        TypeTxt10 = new javax.swing.JLabel();
        ShowBox9 = new javax.swing.JCheckBox();
        MathsTxt10 = new javax.swing.JLabel();
        ShowBox10 = new javax.swing.JCheckBox();
        Maths9 = new javax.swing.JTextField();
        TypeTxt11 = new javax.swing.JLabel();
        Unit9 = new javax.swing.JRadioButton();
        MathsTxt11 = new javax.swing.JLabel();
        ValueRadio9 = new javax.swing.JRadioButton();
        Maths11 = new javax.swing.JTextField();
        Attach9 = new javax.swing.JRadioButton();
        Unit11 = new javax.swing.JRadioButton();
        NameTxt9 = new javax.swing.JLabel();
        KPIName9 = new javax.swing.JTextField();
        ShowBox11 = new javax.swing.JCheckBox();
        ValueRadio11 = new javax.swing.JRadioButton();
        Maths10 = new javax.swing.JTextField();
        TypeTxt9 = new javax.swing.JLabel();
        Attach11 = new javax.swing.JRadioButton();
        Unit10 = new javax.swing.JRadioButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleTxt.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        TitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleTxt.setText("Sub KPI Setup (Up to 12)..");

        PreviousButton.setText("< Previous");
        PreviousButton.setToolTipText("");
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        NextButton.setText("Next >");
        NextButton.setToolTipText("");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        RemoveSubKPI.setText("- Remove Latest SubSKPI");
        RemoveSubKPI.setToolTipText("");
        RemoveSubKPI.setActionCommand("- Remove Latest SubKPI");
        RemoveSubKPI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveSubKPIActionPerformed(evt);
            }
        });

        AddSubKPI.setText("Add SubKPI +");
        AddSubKPI.setToolTipText("");
        AddSubKPI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSubKPIActionPerformed(evt);
            }
        });

        ReseetButton.setText("Reset");
        ReseetButton.setToolTipText("");
        ReseetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReseetButtonActionPerformed(evt);
            }
        });

        Maths0.setText("Multiply by 10");

        Unit0.setText("Unit (x)");

        ValueRadio0.setText("Value (£)");

        Attach0.setText("Attach. (%)");
        Attach0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Attach0ActionPerformed(evt);
            }
        });

        NameTxt0.setText("Name:");

        KPIName0.setText("KPI Name 0");

        TypeTxt0.setText("Type:");

        MathsTxt0.setText("Maths:");

        ShowBox0.setText("Show?");

        TypeTxt1.setText("Type:");

        MathsTxt1.setText("Maths:");

        Maths1.setText("Multiply by 10");

        Unit1.setText("Unit (x)");

        ShowBox1.setText("Show?");

        ValueRadio1.setText("Value (£)");

        Attach1.setText("Attach. (%)");
        Attach1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Attach1ActionPerformed(evt);
            }
        });

        NameTxt1.setText("Name:");

        KPIName1.setText("KPI Name 0");

        Maths2.setText("Multiply by 10");

        Unit2.setText("Unit (x)");

        ValueRadio2.setText("Value (£)");

        Attach2.setText("Attach. (%)");
        Attach2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Attach2ActionPerformed(evt);
            }
        });

        NameTxt2.setText("Name:");

        KPIName2.setText("KPI Name 0");

        TypeTxt2.setText("Type:");

        MathsTxt2.setText("Maths:");

        ShowBox2.setText("Show?");

        MathsTxt3.setText("Maths:");

        ShowBox3.setText("Show?");

        Maths5.setText("Multiply by 10");

        TypeTxt4.setText("Type:");

        Unit5.setText("Unit (x)");

        MathsTxt4.setText("Maths:");

        ValueRadio5.setText("Value (£)");

        Maths4.setText("Multiply by 10");

        Attach5.setText("Attach. (%)");
        Attach5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Attach5ActionPerformed(evt);
            }
        });

        Unit4.setText("Unit (x)");

        NameTxt5.setText("Name:");

        KPIName5.setText("KPI Name 0");

        ShowBox4.setText("Show?");

        ValueRadio4.setText("Value (£)");

        Maths3.setText("Multiply by 10");

        TypeTxt5.setText("Type:");

        Attach4.setText("Attach. (%)");
        Attach4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Attach4ActionPerformed(evt);
            }
        });

        Unit3.setText("Unit (x)");

        NameTxt4.setText("Name:");

        ValueRadio3.setText("Value (£)");

        MathsTxt5.setText("Maths:");

        KPIName4.setText("KPI Name 0");

        Attach3.setText("Attach. (%)");
        Attach3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Attach3ActionPerformed(evt);
            }
        });

        NameTxt3.setText("Name:");

        KPIName3.setText("KPI Name 0");

        TypeTxt3.setText("Type:");

        ShowBox5.setText("Show?");

        NameTxt8.setText("Name:");

        ValueRadio7.setText("Value (£)");

        MathsTxt6.setText("Maths:");

        KPIName8.setText("KPI Name 0");
        KPIName8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KPIName8ActionPerformed(evt);
            }
        });

        Attach7.setText("Attach. (%)");
        Attach7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Attach7ActionPerformed(evt);
            }
        });

        NameTxt7.setText("Name:");

        KPIName7.setText("KPI Name 0");

        TypeTxt7.setText("Type:");

        ShowBox6.setText("Show?");

        MathsTxt7.setText("Maths:");

        ShowBox7.setText("Show?");

        Maths6.setText("Multiply by 10");

        TypeTxt8.setText("Type:");

        Unit6.setText("Unit (x)");

        MathsTxt8.setText("Maths:");

        ValueRadio6.setText("Value (£)");

        Maths8.setText("Multiply by 10");

        Attach6.setText("Attach. (%)");
        Attach6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Attach6ActionPerformed(evt);
            }
        });

        Unit8.setText("Unit (x)");

        NameTxt6.setText("Name:");

        KPIName6.setText("KPI Name 0");

        ShowBox8.setText("Show?");

        ValueRadio8.setText("Value (£)");

        Maths7.setText("Multiply by 10");

        TypeTxt6.setText("Type:");

        Attach8.setText("Attach. (%)");
        Attach8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Attach8ActionPerformed(evt);
            }
        });

        Unit7.setText("Unit (x)");

        NameTxt11.setText("Name:");

        ValueRadio10.setText("Value (£)");

        MathsTxt9.setText("Maths:");

        KPIName11.setText("KPI Name 0");

        Attach10.setText("Attach. (%)");
        Attach10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Attach10ActionPerformed(evt);
            }
        });

        NameTxt10.setText("Name:");

        KPIName10.setText("KPI Name 0");

        TypeTxt10.setText("Type:");

        ShowBox9.setText("Show?");

        MathsTxt10.setText("Maths:");

        ShowBox10.setText("Show?");

        Maths9.setText("Multiply by 10");

        TypeTxt11.setText("Type:");

        Unit9.setText("Unit (x)");

        MathsTxt11.setText("Maths:");

        ValueRadio9.setText("Value (£)");

        Maths11.setText("Multiply by 10");

        Attach9.setText("Attach. (%)");
        Attach9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Attach9ActionPerformed(evt);
            }
        });

        Unit11.setText("Unit (x)");

        NameTxt9.setText("Name:");

        KPIName9.setText("KPI Name 0");

        ShowBox11.setText("Show?");

        ValueRadio11.setText("Value (£)");

        Maths10.setText("Multiply by 10");

        TypeTxt9.setText("Type:");

        Attach11.setText("Attach. (%)");
        Attach11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Attach11ActionPerformed(evt);
            }
        });

        Unit10.setText("Unit (x)");
        Unit10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Unit10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TitleTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(PreviousButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RemoveSubKPI, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(NameTxt0, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(KPIName0))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(MathsTxt0)
                                            .addGap(18, 18, 18)
                                            .addComponent(Maths0))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(TypeTxt0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Unit0)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ValueRadio0)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Attach0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ShowBox0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(NameTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(KPIName1))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(MathsTxt1)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(Maths1))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(TypeTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(Unit1)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ValueRadio1)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(Attach1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(ShowBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(NameTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(KPIName4))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(MathsTxt4)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(Maths4))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(TypeTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(Unit4)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ValueRadio4)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(Attach4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(ShowBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(NameTxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(KPIName7))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(MathsTxt7)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(Maths7))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(TypeTxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(Unit7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ValueRadio7)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(Attach7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(ShowBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(NameTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(KPIName10))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(MathsTxt10)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(Maths10))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(TypeTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(Unit10)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ValueRadio10)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(Attach10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(ShowBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(NameTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(KPIName2))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(MathsTxt2)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(Maths2))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(TypeTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(Unit2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ValueRadio2)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(Attach2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(ShowBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(ReseetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AddSubKPI, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NameTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KPIName3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(MathsTxt3)
                                        .addGap(18, 18, 18)
                                        .addComponent(Maths3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(TypeTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Unit3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ValueRadio3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Attach3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ShowBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NameTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KPIName5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(MathsTxt5)
                                        .addGap(18, 18, 18)
                                        .addComponent(Maths5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(TypeTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Unit5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ValueRadio5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Attach5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ShowBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NameTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KPIName6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(MathsTxt6)
                                        .addGap(18, 18, 18)
                                        .addComponent(Maths6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(TypeTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Unit6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ValueRadio6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Attach6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ShowBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NameTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KPIName8))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(MathsTxt8)
                                        .addGap(18, 18, 18)
                                        .addComponent(Maths8))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(TypeTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Unit8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ValueRadio8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Attach8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ShowBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NameTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KPIName9))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(TypeTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Unit9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ValueRadio9))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(MathsTxt9)
                                        .addGap(18, 18, 18)
                                        .addComponent(Maths9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Attach9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ShowBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NameTxt11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KPIName11))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(MathsTxt11)
                                        .addGap(18, 18, 18)
                                        .addComponent(Maths11))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(TypeTxt11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Unit11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ValueRadio11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Attach11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ShowBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NameTxt0, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(KPIName0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TypeTxt0, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Unit0)
                                    .addComponent(ValueRadio0)
                                    .addComponent(Attach0))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(MathsTxt0, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Maths0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ShowBox0)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NameTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(KPIName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TypeTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Unit2)
                                    .addComponent(ValueRadio2)
                                    .addComponent(Attach2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(MathsTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Maths2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ShowBox2)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TypeTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Unit1)
                            .addComponent(ValueRadio1)
                            .addComponent(Attach1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MathsTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Maths1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ShowBox1))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NameTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KPIName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TypeTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Unit3)
                                .addComponent(ValueRadio3)
                                .addComponent(Attach3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MathsTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Maths3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ShowBox3)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NameTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KPIName5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TypeTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Unit5)
                                .addComponent(ValueRadio5)
                                .addComponent(Attach5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MathsTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Maths5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ShowBox5))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TypeTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Unit4)
                            .addComponent(ValueRadio4)
                            .addComponent(Attach4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MathsTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Maths4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ShowBox4))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NameTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KPIName6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TypeTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Unit6)
                                .addComponent(ValueRadio6)
                                .addComponent(Attach6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MathsTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Maths6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ShowBox6)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NameTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KPIName8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TypeTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Unit8)
                                .addComponent(ValueRadio8)
                                .addComponent(Attach8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MathsTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Maths8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ShowBox8))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TypeTxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Unit7)
                            .addComponent(ValueRadio7)
                            .addComponent(Attach7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MathsTxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Maths7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ShowBox7))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KPIName10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TypeTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Unit10)
                            .addComponent(ValueRadio10)
                            .addComponent(Attach10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MathsTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Maths10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ShowBox10)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NameTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KPIName9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TypeTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Unit9)
                                .addComponent(ValueRadio9)
                                .addComponent(Attach9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MathsTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Maths9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ShowBox9)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NameTxt11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KPIName11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TypeTxt11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Unit11)
                                .addComponent(ValueRadio11)
                                .addComponent(Attach11))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MathsTxt11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Maths11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ShowBox11)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddSubKPI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RemoveSubKPI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReseetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Attach0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Attach0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Attach0ActionPerformed

    private void Attach1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Attach1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Attach1ActionPerformed

    private void Attach2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Attach2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Attach2ActionPerformed

    private void Attach5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Attach5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Attach5ActionPerformed

    private void Attach4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Attach4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Attach4ActionPerformed

    private void Attach3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Attach3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Attach3ActionPerformed

    private void Attach7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Attach7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Attach7ActionPerformed

    private void Attach6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Attach6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Attach6ActionPerformed

    private void Attach8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Attach8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Attach8ActionPerformed

    private void Attach10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Attach10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Attach10ActionPerformed

    private void Attach9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Attach9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Attach9ActionPerformed

    private void Attach11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Attach11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Attach11ActionPerformed

    private void RemoveSubKPIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveSubKPIActionPerformed
        // TODO add your handling code here:
        showCollection(currentenabled, false);
        currentenabled = currentenabled - 1;
        if (currentenabled == 0) {
            RemoveSubKPI.setVisible(false);
        }
        if (currentenabled < 11) {
            AddSubKPI.setVisible(true);
        }
    }//GEN-LAST:event_RemoveSubKPIActionPerformed

    private void AddSubKPIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSubKPIActionPerformed
        // TODO add your handling code here:
        int toenable = currentenabled + 1;
        showCollection(toenable, true);
        currentenabled = toenable;
        if (currentenabled == 11) {
            AddSubKPI.setVisible(false);
        }
        if (currentenabled == 1) {
            RemoveSubKPI.setVisible(true);
        }
    }//GEN-LAST:event_AddSubKPIActionPerformed

    private void KPIName8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KPIName8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KPIName8ActionPerformed

    private void Unit10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Unit10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Unit10ActionPerformed

    private void ReseetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReseetButtonActionPerformed
        // TODO add your handling code here:
        setup();
    }//GEN-LAST:event_ReseetButtonActionPerformed

    private String getSubKPIName(int i) {
        return kpinames.get(i).getText();
    }

    private String getMaths(int i) {
        return mathsfields.get(i).getText();
    }

    private String getType(int i) {
        if (but_units.get(i).isSelected()) {
            return "unit";
        }
        if (but_values.get(i).isSelected()) {
            return "value";
        }
        if (but_attachs.get(i).isSelected()) {
            return "attachment";
        }
        return null;
    }

    private boolean getShow(int i) {
        return showbox.get(i).isSelected();
    }

    private void generateKPI() {
        TempKPI tkpi = Storage.getInstance().getTempKPIList().get(Storage.getInstance().templistindex);
        String kpiname = tkpi.getKPIName();
        int kpivalue = tkpi.getValue();
        ArrayList<SubKPI> templist = new ArrayList<SubKPI>();
        for (int i = 0; i <= currentenabled; i++) {
            String subkpiname = getSubKPIName(i);
            String type = getType(i);
            String math = getMaths(i);
            boolean show = getShow(i);
            if ((type != null) && (subkpiname != null) && (math != null)) {
                SubKPI subkpi = new SubKPI(subkpiname, kpiname, type, show, math);
                templist.add(subkpi);

            } else {
                System.out.println("Error: Something is null");
            }
        }
        KPI kpi = new KPI(kpiname, kpivalue, "null", templist);
        KPIHandler.getInstance().kpi_list.add(kpi);
    }

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        // TODO add your handling code here:
        if ((Storage.getInstance().templistindex + 1) == Storage.getInstance().getTempKPIList().size()) {
            generateKPI();
            KPIHandler.getInstance().printKPIs();
            this.dispose();
            new Users(false);
            //Next Page
        } else {
            generateKPI();
            Storage.getInstance().templistindex = (Storage.getInstance().templistindex + 1);
            setup();
        }
    }//GEN-LAST:event_NextButtonActionPerformed

    private void placeData(int ind) {
        KPI kpi = KPIHandler.getInstance().kpi_list.get(ind);
        TitleTxt.setText(kpi.getName() + " Sub KPI Setup (" + (ind + 1) + "/" + Storage.getInstance().getTempKPIList().size() + ")");
        for(int i=0; i<12; i++) {
            showCollection(i, false);
        }
        int size = kpi.getSubkpis().size();
        for(int i=0; i<size; i++) {
            showCollection(i, true);
            kpinames.get(i).setText(kpi.getSubkpis().get(i).getName());
            mathsfields.get(i).setText(kpi.getSubkpis().get(i).getMaths());
            showbox.get(i).setSelected(kpi.getSubkpis().get(i).isMonitored());
            String type = kpi.getSubkpis().get(i).getType();
            if(type.equalsIgnoreCase("unit")) but_units.get(i).setSelected(true);
            if(type.equalsIgnoreCase("value")) but_values.get(i).setSelected(true);
            if(type.equalsIgnoreCase("attachment")) but_attachs.get(i).setSelected(true);
        }
        int index = KPIHandler.getInstance().kpi_list.indexOf(kpi);
        KPIHandler.getInstance().kpi_list.remove(index);
        Storage.getInstance().templistindex = ind;
        showAllButtons(true);
    }
    
    private void showAllButtons(boolean show) {
        PreviousButton.setVisible(show);
        NextButton.setVisible(show);
        RemoveSubKPI.setVisible(show);
        AddSubKPI.setVisible(show);
    }
        
    
    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        // TODO add your handling code here:
        int indextomake = (Storage.getInstance().templistindex-1);
        placeData(indextomake);
    }//GEN-LAST:event_PreviousButtonActionPerformed

    private void assignButtonsToGroups() {
        Group0.add(Unit0);
        Group0.add(ValueRadio0);
        Group0.add(Attach0);
        Group1.add(Unit1);
        Group1.add(ValueRadio1);
        Group1.add(Attach1);
        Group2.add(Unit2);
        Group2.add(ValueRadio2);
        Group2.add(Attach2);
        Group3.add(Unit3);
        Group3.add(ValueRadio3);
        Group3.add(Attach3);
        Group4.add(Unit4);
        Group4.add(ValueRadio4);
        Group4.add(Attach4);
        Group5.add(Unit5);
        Group5.add(ValueRadio5);
        Group5.add(Attach5);
        Group6.add(Unit6);
        Group6.add(ValueRadio6);
        Group6.add(Attach6);
        Group7.add(Unit7);
        Group7.add(ValueRadio7);
        Group7.add(Attach7);
        Group8.add(Unit8);
        Group8.add(ValueRadio8);
        Group8.add(Attach8);
        Group9.add(Unit9);
        Group9.add(ValueRadio9);
        Group9.add(Attach9);
        Group10.add(Unit10);
        Group10.add(ValueRadio10);
        Group10.add(Attach10);
        Group11.add(Unit11);
        Group11.add(ValueRadio11);
        Group11.add(Attach11);
    }

    private ButtonGroup Group0 = new ButtonGroup();
    private ButtonGroup Group1 = new ButtonGroup();
    private ButtonGroup Group2 = new ButtonGroup();
    private ButtonGroup Group3 = new ButtonGroup();
    private ButtonGroup Group4 = new ButtonGroup();
    private ButtonGroup Group5 = new ButtonGroup();
    private ButtonGroup Group6 = new ButtonGroup();
    private ButtonGroup Group7 = new ButtonGroup();
    private ButtonGroup Group8 = new ButtonGroup();
    private ButtonGroup Group9 = new ButtonGroup();
    private ButtonGroup Group10 = new ButtonGroup();
    private ButtonGroup Group11 = new ButtonGroup();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddSubKPI;
    private javax.swing.JRadioButton Attach0;
    private javax.swing.JRadioButton Attach1;
    private javax.swing.JRadioButton Attach10;
    private javax.swing.JRadioButton Attach11;
    private javax.swing.JRadioButton Attach2;
    private javax.swing.JRadioButton Attach3;
    private javax.swing.JRadioButton Attach4;
    private javax.swing.JRadioButton Attach5;
    private javax.swing.JRadioButton Attach6;
    private javax.swing.JRadioButton Attach7;
    private javax.swing.JRadioButton Attach8;
    private javax.swing.JRadioButton Attach9;
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
    private javax.swing.JTextField Maths0;
    private javax.swing.JTextField Maths1;
    private javax.swing.JTextField Maths10;
    private javax.swing.JTextField Maths11;
    private javax.swing.JTextField Maths2;
    private javax.swing.JTextField Maths3;
    private javax.swing.JTextField Maths4;
    private javax.swing.JTextField Maths5;
    private javax.swing.JTextField Maths6;
    private javax.swing.JTextField Maths7;
    private javax.swing.JTextField Maths8;
    private javax.swing.JTextField Maths9;
    private javax.swing.JLabel MathsTxt0;
    private javax.swing.JLabel MathsTxt1;
    private javax.swing.JLabel MathsTxt10;
    private javax.swing.JLabel MathsTxt11;
    private javax.swing.JLabel MathsTxt2;
    private javax.swing.JLabel MathsTxt3;
    private javax.swing.JLabel MathsTxt4;
    private javax.swing.JLabel MathsTxt5;
    private javax.swing.JLabel MathsTxt6;
    private javax.swing.JLabel MathsTxt7;
    private javax.swing.JLabel MathsTxt8;
    private javax.swing.JLabel MathsTxt9;
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
    private javax.swing.JButton RemoveSubKPI;
    private javax.swing.JButton ReseetButton;
    private javax.swing.JCheckBox ShowBox0;
    private javax.swing.JCheckBox ShowBox1;
    private javax.swing.JCheckBox ShowBox10;
    private javax.swing.JCheckBox ShowBox11;
    private javax.swing.JCheckBox ShowBox2;
    private javax.swing.JCheckBox ShowBox3;
    private javax.swing.JCheckBox ShowBox4;
    private javax.swing.JCheckBox ShowBox5;
    private javax.swing.JCheckBox ShowBox6;
    private javax.swing.JCheckBox ShowBox7;
    private javax.swing.JCheckBox ShowBox8;
    private javax.swing.JCheckBox ShowBox9;
    private javax.swing.JLabel TitleTxt;
    private javax.swing.JLabel TypeTxt0;
    private javax.swing.JLabel TypeTxt1;
    private javax.swing.JLabel TypeTxt10;
    private javax.swing.JLabel TypeTxt11;
    private javax.swing.JLabel TypeTxt2;
    private javax.swing.JLabel TypeTxt3;
    private javax.swing.JLabel TypeTxt4;
    private javax.swing.JLabel TypeTxt5;
    private javax.swing.JLabel TypeTxt6;
    private javax.swing.JLabel TypeTxt7;
    private javax.swing.JLabel TypeTxt8;
    private javax.swing.JLabel TypeTxt9;
    private javax.swing.JRadioButton Unit0;
    private javax.swing.JRadioButton Unit1;
    private javax.swing.JRadioButton Unit10;
    private javax.swing.JRadioButton Unit11;
    private javax.swing.JRadioButton Unit2;
    private javax.swing.JRadioButton Unit3;
    private javax.swing.JRadioButton Unit4;
    private javax.swing.JRadioButton Unit5;
    private javax.swing.JRadioButton Unit6;
    private javax.swing.JRadioButton Unit7;
    private javax.swing.JRadioButton Unit8;
    private javax.swing.JRadioButton Unit9;
    private javax.swing.JRadioButton ValueRadio0;
    private javax.swing.JRadioButton ValueRadio1;
    private javax.swing.JRadioButton ValueRadio10;
    private javax.swing.JRadioButton ValueRadio11;
    private javax.swing.JRadioButton ValueRadio2;
    private javax.swing.JRadioButton ValueRadio3;
    private javax.swing.JRadioButton ValueRadio4;
    private javax.swing.JRadioButton ValueRadio5;
    private javax.swing.JRadioButton ValueRadio6;
    private javax.swing.JRadioButton ValueRadio7;
    private javax.swing.JRadioButton ValueRadio8;
    private javax.swing.JRadioButton ValueRadio9;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.Box.Filler filler1;
    // End of variables declaration//GEN-END:variables
}
