/*
 * DirectoryCheckDialog.java
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
 * Created on 18.06.2010, 11:15:26
 */
package ch.fhnw.jbackpack;

import ch.fhnw.util.FileTools;
import java.awt.Color;
import java.awt.Frame;
import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * A dialog that can be shown when checking a directory
 * @author Ronny Standtke <ronny.standtke@fhnw.ch>
 */
public class DirectoryCheckDialog extends javax.swing.JDialog {

    private final static ResourceBundle BUNDLE = ResourceBundle.getBundle(
            "ch/fhnw/jbackpack/Strings");
    private final Frame parent;
    private long freeSpace;

    /** Creates new form DirectoryCheckDialog with known free space
     * @param parent the parent frame
     */
    public DirectoryCheckDialog(Frame parent) {
        super(parent, true);
        this.parent = parent;
        initComponents();
        pack();
        setLocationRelativeTo(parent);
    }

    /**
     * [en/dis]able filename check
     * @param enabled if filename check is enabled
     * @param maximumFilenameLength the maximum filename length
     */
    public void setFilenameCheckEnabled(
            boolean enabled, int maximumFilenameLength) {
        filenameCheckPanel.setVisible(enabled);
        if (enabled) {
            String text = BUNDLE.getString("Nr_Of_Characters");
            text = MessageFormat.format(text, maximumFilenameLength);
            maxLengthTextField.setText(text);
        } else {
            pack();
            setLocationRelativeTo(parent);
        }
    }

    /**
     * sets if the free space is known and when known, how much space is free
     * @param known if the free space is known
     * @param freeSpace how much space is free
     */
    public void setFreeSpaceKnown(boolean known, long freeSpace) {
        if (known) {
            this.freeSpace = freeSpace;
            freeSpaceTextField.setText(
                    FileTools.getDataVolumeString(freeSpace, 1));
        } else {
            freeSpaceTextField.setText(BUNDLE.getString("Unknown"));
        }
    }

    /**
     * sets the number of alredy checked files
     * @param fileCount the number of alredy checked files
     */
    public void setFileCount(long fileCount) {
        String text = BUNDLE.getString("Checking_File");
        text = MessageFormat.format(text, fileCount);
        fileCounterLabel.setText(text);
    }

    /**
     * sets the currently checked file
     * @param currentFile the currently checked file
     */
    public void setCurrentFile(String currentFile) {
        currentFileLabel.setText(currentFile);
    }

    /**
     * sets the current size
     * @param size the current size
     */
    public void setCurrentSize(long size) {
        sizeTextField.setText(FileTools.getDataVolumeString(size, 1));
        if (freeSpace != 0) {
            int progress = (int) ((100 * size) / freeSpace);
            progressBar.setValue(progress);
            progressBar.setString(progress + "%");
        }
    }

    /**
     * sets the status of the filename check
     * @param fine the status of the filename check
     */
    public void setFilenameCheckstatus(boolean fine) {
        if (fine) {
            lengthStatusTextField.setText(BUNDLE.getString("OK"));
            lengthStatusTextField.setForeground(Color.GREEN);
        } else {
            lengthStatusTextField.setText(BUNDLE.getString("Error"));
            lengthStatusTextField.setForeground(Color.RED);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fileCounterLabel = new javax.swing.JLabel();
        currentFileLabel = new JSqueezedLabel();
        sizeCheckPanel = new javax.swing.JPanel();
        freeSpaceLabel = new javax.swing.JLabel();
        freeSpaceTextField = new javax.swing.JTextField();
        sizeLabel = new javax.swing.JLabel();
        sizeTextField = new javax.swing.JTextField();
        progressBar = new javax.swing.JProgressBar();
        filenameCheckPanel = new javax.swing.JPanel();
        maxLengthLabel = new javax.swing.JLabel();
        maxLengthTextField = new javax.swing.JTextField();
        lengthStatusLabel = new javax.swing.JLabel();
        lengthStatusTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ch/fhnw/jbackpack/Strings"); // NOI18N
        setTitle(bundle.getString("DirectoryCheckDialog.title")); // NOI18N
        getContentPane().setLayout(new java.awt.GridBagLayout());

        fileCounterLabel.setText(bundle.getString("Checking_File")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        getContentPane().add(fileCounterLabel, gridBagConstraints);

        currentFileLabel.setFont(currentFileLabel.getFont().deriveFont(currentFileLabel.getFont().getStyle() & ~java.awt.Font.BOLD, currentFileLabel.getFont().getSize()-1));
        currentFileLabel.setText(bundle.getString("DirectoryCheckDialog.currentFileLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 10);
        getContentPane().add(currentFileLabel, gridBagConstraints);

        sizeCheckPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("DirectoryCheckDialog.sizeCheckPanel.border.title"))); // NOI18N

        freeSpaceLabel.setText(bundle.getString("DirectoryCheckDialog.freeSpaceLabel.text")); // NOI18N

        freeSpaceTextField.setColumns(7);
        freeSpaceTextField.setEditable(false);

        sizeLabel.setText(bundle.getString("DirectoryCheckDialog.sizeLabel.text")); // NOI18N

        sizeTextField.setColumns(7);
        sizeTextField.setEditable(false);

        progressBar.setStringPainted(true);

        javax.swing.GroupLayout sizeCheckPanelLayout = new javax.swing.GroupLayout(sizeCheckPanel);
        sizeCheckPanel.setLayout(sizeCheckPanelLayout);
        sizeCheckPanelLayout.setHorizontalGroup(
            sizeCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sizeCheckPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sizeCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sizeCheckPanelLayout.createSequentialGroup()
                        .addComponent(freeSpaceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(freeSpaceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                    .addGroup(sizeCheckPanelLayout.createSequentialGroup()
                        .addComponent(sizeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sizeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
                .addContainerGap())
        );

        sizeCheckPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {freeSpaceLabel, sizeLabel});

        sizeCheckPanelLayout.setVerticalGroup(
            sizeCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sizeCheckPanelLayout.createSequentialGroup()
                .addGroup(sizeCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(freeSpaceLabel)
                    .addComponent(freeSpaceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sizeCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sizeLabel)
                    .addComponent(sizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(sizeCheckPanel, gridBagConstraints);

        filenameCheckPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("DirectoryCheckDialog.filenameCheckPanel.border.title"))); // NOI18N

        maxLengthLabel.setText(bundle.getString("DirectoryCheckDialog.maxLengthLabel.text")); // NOI18N

        maxLengthTextField.setEditable(false);

        lengthStatusLabel.setText(bundle.getString("DirectoryCheckDialog.lengthStatusLabel.text")); // NOI18N

        lengthStatusTextField.setEditable(false);

        javax.swing.GroupLayout filenameCheckPanelLayout = new javax.swing.GroupLayout(filenameCheckPanel);
        filenameCheckPanel.setLayout(filenameCheckPanelLayout);
        filenameCheckPanelLayout.setHorizontalGroup(
            filenameCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filenameCheckPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filenameCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filenameCheckPanelLayout.createSequentialGroup()
                        .addComponent(maxLengthLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maxLengthTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                    .addGroup(filenameCheckPanelLayout.createSequentialGroup()
                        .addComponent(lengthStatusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lengthStatusTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
                .addContainerGap())
        );

        filenameCheckPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lengthStatusLabel, maxLengthLabel});

        filenameCheckPanelLayout.setVerticalGroup(
            filenameCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filenameCheckPanelLayout.createSequentialGroup()
                .addGroup(filenameCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxLengthLabel)
                    .addComponent(maxLengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filenameCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lengthStatusLabel)
                    .addComponent(lengthStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        getContentPane().add(filenameCheckPanel, gridBagConstraints);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-437)/2, (screenSize.height-334)/2, 437, 334);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currentFileLabel;
    private javax.swing.JLabel fileCounterLabel;
    private javax.swing.JPanel filenameCheckPanel;
    private javax.swing.JLabel freeSpaceLabel;
    private javax.swing.JTextField freeSpaceTextField;
    private javax.swing.JLabel lengthStatusLabel;
    private javax.swing.JTextField lengthStatusTextField;
    private javax.swing.JLabel maxLengthLabel;
    private javax.swing.JTextField maxLengthTextField;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JPanel sizeCheckPanel;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JTextField sizeTextField;
    // End of variables declaration//GEN-END:variables
}
