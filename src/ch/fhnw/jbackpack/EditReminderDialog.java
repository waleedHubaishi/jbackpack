/*
 * EditReminderDialog.java
 *
 * Copyright (C) 2010 imedias
 *
 * This file is part of JBackpack.
 *
 * JBackpack is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * JBackpack is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Created on 22.07.2010, 22:43:26
 */
package ch.fhnw.jbackpack;

import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 * a dialog for editing the backup reminder settings
 * @author Ronny Standtke <Ronny.Standtke@gmx.net>
 */
public class EditReminderDialog extends javax.swing.JDialog {

    private static final ResourceBundle BUNDLE =
            ResourceBundle.getBundle("ch/fhnw/jbackpack/Strings");
    private boolean okButtonClicked;
    private int reminderTimeout;

    /** Creates new form EditReminderDialog
     * @param parent the parent frame
     * @param reminder if a remainder should be shown when logging in
     * @param reminderTimeout the timeout for the remainder in days
     */
    public EditReminderDialog(java.awt.Frame parent, boolean reminder,
            int reminderTimeout) {
        super(parent, true);
        this.reminderTimeout = reminderTimeout;
        initComponents();
        reminderCheckBox.setSelected(reminder);
        reminderCheckBoxActionPerformed(null);
        if (reminderTimeout > 0) {
            reminderSpinner.setValue(reminderTimeout);
        } else {
            reminderSpinner.setValue(1);
        }
        updateReminderLabel(reminderTimeout);
        setLocationRelativeTo(parent);
    }

    /**
     * returns <CODE>true</CODE>, if the user clicked the OK button,
     * <CODE>false</CODE> otherwise
     * @return <CODE>true</CODE>, if the user clicked the OK button,
     * <CODE>false</CODE> otherwise
     */
    public boolean okSelected() {
        return okButtonClicked;
    }

    /**
     * returns <tt>true</tt> if the user selected to show a reminder, when
     * the last backup is older thatn a certain number of days,
     * <tt>false</tt> otherwise
     * @return <tt>true</tt> if the user selected to show a reminder, when
     * the last backup is older thatn a certain number of days,
     * <tt>false</tt> otherwise
     */
    public boolean isReminderSelected() {
        return reminderCheckBox.isSelected();
    }

    /**
     * returns the configured reminder timeout in days
     * @return the configured reminder timeout in days
     */
    public int getReminderTimeout() {
        return reminderTimeout;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reminderCheckBox = new javax.swing.JCheckBox();
        reminderSpinner = new javax.swing.JSpinner();
        reminderLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ch/fhnw/jbackpack/Strings"); // NOI18N
        setTitle(bundle.getString("EditReminderDialog.title")); // NOI18N

        reminderCheckBox.setText(bundle.getString("EditReminderDialog.reminderCheckBox.text")); // NOI18N
        reminderCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reminderCheckBoxActionPerformed(evt);
            }
        });

        reminderSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        reminderSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                reminderSpinnerStateChanged(evt);
            }
        });

        reminderLabel.setText(bundle.getString("Days")); // NOI18N
        reminderLabel.setEnabled(false);

        okButton.setText(bundle.getString("EditReminderDialog.okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText(bundle.getString("EditReminderDialog.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reminderCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(reminderSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reminderLabel)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(18, 18, 18)
                .addComponent(cancelButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reminderCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reminderSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reminderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reminderCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reminderCheckBoxActionPerformed
        boolean selected = reminderCheckBox.isSelected();
        reminderSpinner.setEnabled(selected);
        reminderLabel.setEnabled(selected);
}//GEN-LAST:event_reminderCheckBoxActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if (reminderCheckBox.isSelected()) {
            String timeoutText = reminderSpinner.getValue().toString();
            if (timeoutText.isEmpty()) {
                reminderSpinner.requestFocusInWindow();
                showError(BUNDLE.getString("Error_No_Timeout"));
                return;
            }

            try {
                reminderTimeout = Integer.parseInt(timeoutText);
                if (reminderTimeout <= 0) {
                    showError(BUNDLE.getString(
                            "Error_Timeout_No_Positive_Integer"));
                    return;
                }
            } catch (NumberFormatException numberFormatException) {
                showError(BUNDLE.getString(
                        "Error_Timeout_No_Positive_Integer"));
                return;
            }
        }
        okButtonClicked = true;
        setVisible(false);
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void reminderSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_reminderSpinnerStateChanged
        int value = (Integer) reminderSpinner.getValue();
        updateReminderLabel(value);
    }//GEN-LAST:event_reminderSpinnerStateChanged

    private void updateReminderLabel(int value) {
        reminderLabel.setText(BUNDLE.getString(value == 1 ? "Day" : "Days"));
    }

    private void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage,
                BUNDLE.getString("Error"), JOptionPane.ERROR_MESSAGE);
        reminderSpinner.requestFocusInWindow();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox reminderCheckBox;
    private javax.swing.JLabel reminderLabel;
    private javax.swing.JSpinner reminderSpinner;
    // End of variables declaration//GEN-END:variables
}
