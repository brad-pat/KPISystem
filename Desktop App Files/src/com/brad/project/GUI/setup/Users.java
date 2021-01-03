package com.brad.project.GUI.setup;

import com.brad.project.ConnectionHandler;
import com.brad.project.GUI.HomeScreen;
import com.brad.project.UserHandler;
import com.brad.project.objects.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class Users extends javax.swing.JFrame {

    boolean setup = false;

    public Users(boolean issetup) {
        initComponents();
        setVisible(true);
        setup = issetup;
        if (issetup == false) {
            showReview(false);
        } else {
            for (User u : UserHandler.getInstance().users) {
                tempuserlist.add(u);
            }
            UsersList.setModel(getUserModel());
            showReview(true);
            for (int i = 0; i < tempuserlist.size(); i++) {
                setReviewData(i);
            }
        }
    }

    private void setReviewData(int i) {
        User u = tempuserlist.get(i);
        ReviewName.setText(u.getName());
        ReviewEmail.setText(u.getId());
        ReviewHours.setText(u.getCont_hours() + "");
        ReviewRole.setText(u.getRole());
        ReviewManager.setSelected(u.isManager());
        UsersList.setSelectedIndex(i);
    }

    private void showReview(boolean show) {
        ReviewEmail.setVisible(show);
        ReviewName.setVisible(show);
        ReviewHours.setVisible(show);
        ReviewRole.setVisible(show);
        ReviewManager.setVisible(show);
        UpdateButton.setVisible(show);
        RemoveUser.setVisible(show);
        ReviewNameTxt.setVisible(show);
        ReviewEmailTxt.setVisible(show);
        ReviewHoursTxt.setVisible(show);
        ReviewRoleTxt.setVisible(show);
        UsersList.setVisible(show);
    }

    List<User> tempuserlist = new ArrayList<User>();

    private List<String> formUsersAsStringList() {
        List<String> temp = new ArrayList<String>();
        for (User u : tempuserlist) {
            temp.add(u.getId());
        }
        return temp;
    }

    private ComboBoxModel getUserModel() {
        String[] items = formUsersAsStringList().toArray(new String[0]);
        return new DefaultComboBoxModel(items);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        TitleTxt = new javax.swing.JLabel();
        CreateUsersTxt = new javax.swing.JLabel();
        UsersList = new javax.swing.JComboBox<>();
        ReviewTitleTxt = new javax.swing.JLabel();
        NameTxtCurrent = new javax.swing.JLabel();
        EmailTxtCurrent = new javax.swing.JLabel();
        CreateManager = new javax.swing.JCheckBox();
        CreateName = new javax.swing.JTextField();
        CreateEmail = new javax.swing.JTextField();
        ReviewNameTxt = new javax.swing.JLabel();
        ReviewEmailTxt = new javax.swing.JLabel();
        ReviewManager = new javax.swing.JCheckBox();
        ReviewName = new javax.swing.JTextField();
        ReviewEmail = new javax.swing.JTextField();
        FinishButton = new javax.swing.JButton();
        RemoveUser = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        AddUserButton = new javax.swing.JButton();
        PreviousButton = new javax.swing.JButton();
        ReseetButton = new javax.swing.JButton();
        HoursTxtCurrent = new javax.swing.JLabel();
        CreateHours = new javax.swing.JTextField();
        ReviewHoursTxt = new javax.swing.JLabel();
        ReviewHours = new javax.swing.JTextField();
        ReviewRoleTxt = new javax.swing.JLabel();
        CreateRole = new javax.swing.JTextField();
        RoleTxtCurrent = new javax.swing.JLabel();
        ReviewRole = new javax.swing.JTextField();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleTxt.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        TitleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleTxt.setText("User Setup");

        CreateUsersTxt.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        CreateUsersTxt.setText("Create User:");

        UsersList.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        UsersList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        UsersList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsersListActionPerformed(evt);
            }
        });

        ReviewTitleTxt.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        ReviewTitleTxt.setText("Review Users:");

        NameTxtCurrent.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        NameTxtCurrent.setText("Name:");

        EmailTxtCurrent.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        EmailTxtCurrent.setText("Email:");

        CreateManager.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        CreateManager.setText("Manager?");
        CreateManager.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        CreateManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateManagerActionPerformed(evt);
            }
        });

        CreateName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        CreateEmail.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        ReviewNameTxt.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ReviewNameTxt.setText("Name:");

        ReviewEmailTxt.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ReviewEmailTxt.setText("Email:");

        ReviewManager.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ReviewManager.setText("Manager?");
        ReviewManager.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        ReviewName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ReviewName.setText("Name");

        ReviewEmail.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ReviewEmail.setText("Email");

        FinishButton.setText("Next >");
        FinishButton.setToolTipText("");
        FinishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishButtonActionPerformed(evt);
            }
        });

        RemoveUser.setText("- Remove User");
        RemoveUser.setToolTipText("");
        RemoveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveUserActionPerformed(evt);
            }
        });

        UpdateButton.setText("Update User");
        UpdateButton.setToolTipText("");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        AddUserButton.setText("Add User..");
        AddUserButton.setToolTipText("");
        AddUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserButtonActionPerformed(evt);
            }
        });

        PreviousButton.setText("< Previous");
        PreviousButton.setToolTipText("");
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        ReseetButton.setText("Reset");
        ReseetButton.setToolTipText("");
        ReseetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReseetButtonActionPerformed(evt);
            }
        });

        HoursTxtCurrent.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        HoursTxtCurrent.setText("Hours:");

        CreateHours.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        CreateHours.setActionCommand("<Not Set>");
        CreateHours.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        ReviewHoursTxt.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ReviewHoursTxt.setText("Hours:");

        ReviewHours.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ReviewHours.setText("Hours");
        ReviewHours.setActionCommand("<Not Set>");
        ReviewHours.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        ReviewRoleTxt.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ReviewRoleTxt.setText("Role:");

        CreateRole.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        CreateRole.setActionCommand("<Not Set>");
        CreateRole.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        RoleTxtCurrent.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        RoleTxtCurrent.setText("Role:");

        ReviewRole.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ReviewRole.setText("Hours");
        ReviewRole.setActionCommand("<Not Set>");
        ReviewRole.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TitleTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PreviousButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addComponent(ReseetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(FinishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(HoursTxtCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CreateHours))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(EmailTxtCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CreateEmail))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(NameTxtCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CreateName))
                                            .addComponent(CreateUsersTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(RoleTxtCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CreateRole)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(ReviewRoleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ReviewRole, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(ReviewHoursTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ReviewHours))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(ReviewEmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ReviewEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(ReviewNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ReviewName, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(ReviewTitleTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(UsersList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(3, 3, 3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CreateManager, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AddUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ReviewManager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RemoveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(8, 8, 8))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateUsersTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReviewTitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UsersList, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CreateName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ReviewNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ReviewName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(NameTxtCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailTxtCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReviewEmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReviewEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ReviewHoursTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ReviewHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(HoursTxtCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CreateHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ReviewRoleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ReviewRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RoleTxtCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CreateRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateManager)
                    .addComponent(ReviewManager))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RemoveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FinishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReseetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateManagerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateManagerActionPerformed

    private void RemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveUserActionPerformed
        // TODO add your handling code here:
        if (tempuserlist.size() <= 1) {
            tempuserlist.clear();
            showReview(false);
        } else {
            int index = UsersList.getSelectedIndex();
            if (setup == true) {
                deletes.add(tempuserlist.get(index));
            }
            tempuserlist.remove(index);
            UsersList.setSelectedIndex(0);
            setReviewData(0);
            UsersList.setModel(getUserModel());
        }
    }//GEN-LAST:event_RemoveUserActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:
        int selected = UsersList.getSelectedIndex();
        User u = tempuserlist.get(selected);
        u.setId(ReviewEmail.getText());
        u.setName(ReviewName.getText());
        u.setCont_hours(Integer.parseInt(ReviewHours.getText()));
        u.setRole(ReviewRole.getText());
        u.setManager(ReviewManager.isSelected());
        if(setup == true) {
            updates.add(u);
        }
        UsersList.setSelectedIndex(0);
        setReviewData(0);
        UsersList.setModel(getUserModel());

    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void AddUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserButtonActionPerformed
        // TODO add your handling code here:
        if (tempuserlist.isEmpty()) {
            showReview(true);
        }
        try {
            int hours = Integer.parseInt(CreateHours.getText());
            String name = CreateName.getText();
            String id = CreateEmail.getText();
            String role = CreateRole.getText();
            boolean manager = CreateManager.isSelected();
            User user = new User(id, name, role, manager, hours, 0);
            if(setup == false) {
                tempuserlist.add(user);
            } else {
                creates.add(user);
            }           
            UsersList.setModel(getUserModel());
            setReviewData(tempuserlist.size() - 1);
            clearCreate();
        } catch (NumberFormatException e) {

        }
    }//GEN-LAST:event_AddUserButtonActionPerformed

    private void clearCreate() {
        CreateName.setText("");
        CreateEmail.setText("");
        CreateHours.setText("");
        CreateRole.setText("");
        CreateManager.setSelected(false);
    }
    
    ArrayList<User> creates = new ArrayList<>();
    ArrayList<User> updates = new ArrayList<>();
    ArrayList<User> deletes = new ArrayList<>();

    private void UsersListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsersListActionPerformed
        // TODO add your handling code here:
        int index = UsersList.getSelectedIndex();
        setReviewData(index);
    }//GEN-LAST:event_UsersListActionPerformed

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        // TODO add your handling code here:
        if(setup == true) {
            new HomeScreen();
        }
    }//GEN-LAST:event_PreviousButtonActionPerformed

    private void ReseetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReseetButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReseetButtonActionPerformed

    private void FinishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishButtonActionPerformed
        // TODO add your handling code here:
        if (setup == false) {
            for (User u : tempuserlist) {
                UserHandler.getInstance().users.add(u);
            }
            this.dispose();
            new GeneralSettings();
        } else {
            ConnectionHandler ch = new ConnectionHandler();
            for (User u : creates) {
                if(!UserHandler.getInstance().users.contains(u)) {
                    ch.createUser(u);
                }
            }
            for (User u : updates) {
                ch.editUser(u);
            }
            for (User u : deletes) {
                ch.deleteUser(u.getId());
            }
            this.dispose();
            new HomeScreen();
        }
    }//GEN-LAST:event_FinishButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddUserButton;
    private javax.swing.JTextField CreateEmail;
    private javax.swing.JTextField CreateHours;
    private javax.swing.JCheckBox CreateManager;
    private javax.swing.JTextField CreateName;
    private javax.swing.JTextField CreateRole;
    private javax.swing.JLabel CreateUsersTxt;
    private javax.swing.JLabel EmailTxtCurrent;
    private javax.swing.JButton FinishButton;
    private javax.swing.JLabel HoursTxtCurrent;
    private javax.swing.JLabel NameTxtCurrent;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JButton RemoveUser;
    private javax.swing.JButton ReseetButton;
    private javax.swing.JTextField ReviewEmail;
    private javax.swing.JLabel ReviewEmailTxt;
    private javax.swing.JTextField ReviewHours;
    private javax.swing.JLabel ReviewHoursTxt;
    private javax.swing.JCheckBox ReviewManager;
    private javax.swing.JTextField ReviewName;
    private javax.swing.JLabel ReviewNameTxt;
    private javax.swing.JTextField ReviewRole;
    private javax.swing.JLabel ReviewRoleTxt;
    private javax.swing.JLabel ReviewTitleTxt;
    private javax.swing.JLabel RoleTxtCurrent;
    private javax.swing.JLabel TitleTxt;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JComboBox<String> UsersList;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
