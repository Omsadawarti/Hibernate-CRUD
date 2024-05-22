package org.nlt.view;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.nlt.model.States;
import static org.nlt.view.ParentInterface.ses;

public class StateFrame extends javax.swing.JFrame implements ParentInterface {

    private States stt = null;
    private Set<String> stateSet;

    public StateFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stateTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Enter State");

        submitButton.setText("SUBMIT");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        resetButton.setText("RESET");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameTextField)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)
                    .addComponent(resetButton))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new java.awt.GridLayout(1, 1));

        stateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        stateTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stateTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(stateTable);

        jPanel2.add(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        try {

            String name = nameTextField.getText().toUpperCase();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid Data Entry To Submit Rocord!", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
            } else if (stateSet.contains(name)) {
                JOptionPane.showMessageDialog(this, "Repeated State Not Allow", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);

            } else {
                States state = new States();
                state.setCreated(new Date());
                state.setModified(new Date());
                state.setName(name);
                state.setStatus(1);

                ses.beginTransaction();
                ses.save(state);
                ses.getTransaction().commit();

                JOptionPane.showMessageDialog(this, "Record Submitted Successfully", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
                setTableData();
                resetData();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            String name = nameTextField.getText().toUpperCase();
            if (stt == null) {
                JOptionPane.showMessageDialog(this, "Please Select Record To Update", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
            } else if (stateSet.contains(name)) {
                JOptionPane.showMessageDialog(this, "Repeated State Not Allow", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);

            } else {

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Invalid Data Entry To Update Rocord!", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    stt.setName(name);//overwrite old name with new name
                    stt.setModified(new Date());

                    ses.beginTransaction();

                    ses.update(stt);

                    ses.getTransaction().commit();

                    JOptionPane.showMessageDialog(this, "Record Updated Successfully", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
                    resetData();
                    setTableData();
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (stt == null) {
            JOptionPane.showMessageDialog(this, "Please Select Record To Delete", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
        } else {

            stt.setStatus(0);
            stt.setModified(new Date());

            ses.beginTransaction();
            ses.update(stt);
            ses.getTransaction().commit();

            JOptionPane.showMessageDialog(this, "Record Deleted Successfully", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
            resetData();
            setTableData();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void stateTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stateTableMouseClicked
        try {
            int id = Integer.parseInt(stateTable.getValueAt(stateTable.getSelectedRow(), 0).toString());
            ses.beginTransaction();

            // declare per as class var 
            stt = (States) ses.get(States.class, id); //object to person
            nameTextField.setText(stt.getName());
            ses.getTransaction().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_stateTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton resetButton;
    private javax.swing.JTable stateTable;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    public void setTableData() {
        stateSet = new HashSet();
        personFrame.stateComboBox.removeAllItems();
        personFrame.stateComboBox.addItem("SELECT");
        
        cityFrame.stateComboBox.removeAllItems();
        cityFrame.stateComboBox.addItem("SELECT");

        ses.beginTransaction();

        Query qu = ses.createQuery("from States where status=1 order by id");
        List<States> stateList = qu.list();

        String[] cols = {"ID", "NAME"};

        String[][] data = new String[stateList.size()][cols.length];
        int i = 0;
        for (States s : stateList) {
            data[i][0] = s.getId() + "";
            data[i][1] = s.getName();
            stateSet.add(s.getName());
            personFrame.stateComboBox.addItem(s.getName());
            cityFrame.stateComboBox.addItem(s.getName());
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(data, cols);
        stateTable.setModel(model);
        ses.getTransaction().commit();
    }

    private void resetData() {
        nameTextField.setText("");
        stt = null;
    }
}
