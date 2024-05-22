package org.nlt.view;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.nlt.model.Cities;
import org.nlt.model.States;
import static org.nlt.view.ParentInterface.cityFrame;
import static org.nlt.view.ParentInterface.personFrame;
import static org.nlt.view.ParentInterface.ses;

public class CityFrame extends javax.swing.JFrame implements ParentInterface {
    private Set<String> citySet;
    public CityFrame() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        stateComboBox = new javax.swing.JComboBox();
        addStateButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cityTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1, 0, 20));

        jPanel2.setLayout(new java.awt.GridLayout(3, 2, 20, 20));

        jLabel1.setText("ENTER CITY");
        jPanel2.add(jLabel1);
        jPanel2.add(nameTextField);

        jLabel2.setText("SELECT STATE");
        jPanel2.add(jLabel2);

        jPanel6.setLayout(new java.awt.BorderLayout());

        stateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(stateComboBox, java.awt.BorderLayout.CENTER);

        addStateButton.setText("NEW");
        addStateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStateButtonActionPerformed(evt);
            }
        });
        jPanel6.add(addStateButton, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel6);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2, 20, 0));

        submitButton.setText("SUBMIT");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel4.add(submitButton);

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel4.add(updateButton);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 2, 20, 0));

        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel5.add(deleteButton);

        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        jPanel5.add(resetButton);

        jPanel2.add(jPanel5);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(1, 1));

        cityTable.setModel(new javax.swing.table.DefaultTableModel(
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
        cityTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cityTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cityTable);

        jPanel3.add(jScrollPane1);

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
    }//GEN-LAST:event_resetButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
 try {

            String name = nameTextField.getText().toUpperCase();
            String stateName = stateComboBox.getSelectedItem().toString();

            if (name.isEmpty()||stateName.equalsIgnoreCase("SELECT")) {
                JOptionPane.showMessageDialog(this, "Invalid Data Entry To Submit Rocord!", "Person CRUD", JOptionPane.ERROR_MESSAGE);
            } else if (citySet.contains(name)) {
                JOptionPane.showMessageDialog(this, "Repeated City Not Allow", "Person CRUD", JOptionPane.ERROR_MESSAGE);
            } else {
                 ses.beginTransaction();
                 Query query=ses.createQuery("from States where status=1 and name='"+stateName+"'");
                List<States> stateList = query.list();
                
                
                Cities city = new Cities();
                city.setCreated(new Date());
                city.setModified(new Date());
                city.setName(name);
                city.setStatus(1);
                city.setState(stateList.get(0));
                city.setUser(loginUserObject);

               
                ses.save(city);
                ses.getTransaction().commit();

                JOptionPane.showMessageDialog(this, "Record Submitted Successfully", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
                setTableData();
                resetData();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void cityTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cityTableMouseClicked
    }//GEN-LAST:event_cityTableMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
    }//GEN-LAST:event_updateButtonActionPerformed

    private void addStateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStateButtonActionPerformed
        stateFrame.setVisible(true);
    }//GEN-LAST:event_addStateButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStateButton;
    private javax.swing.JTable cityTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton resetButton;
    public javax.swing.JComboBox stateComboBox;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

public void setTableData() {
    citySet=new HashSet<>();
    
        personFrame.cityComboBox.removeAllItems();
        personFrame.cityComboBox.addItem("SELECT");
        ses.beginTransaction();

        Query qu = ses.createQuery("from Cities where status=1 order by id");
        List<Cities> cityList = qu.list();

        String[] cols = {"ID", "NAME","STATE NAME"};

        String[][] data = new String[cityList.size()][cols.length];
        int i = 0;
        for (Cities c : cityList) {
            data[i][0] = c.getId() + "";
            data[i][1] = c.getName();
            data[i][2] = c.getState().getName();
            citySet.add(c.getName());
            personFrame.cityComboBox.addItem(c.getName());
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(data, cols);
        cityTable.setModel(model);
        ses.getTransaction().commit();
    }

 private void resetData() {
        nameTextField.setText("");
        stateComboBox.setSelectedIndex(0);
       // stt = null;
    }

}
