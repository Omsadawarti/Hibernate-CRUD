package org.nlt.view;

import java.io.File;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.nlt.model.Persons;

public class PersonFrame extends javax.swing.JFrame implements ParentInterface {

    private Persons per;

    public PersonFrame() {
        initComponents();
        setTableData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ageTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        stateComboBox = new javax.swing.JComboBox();
        addNewStateButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        cityComboBox = new javax.swing.JComboBox();
        addNewCityButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        personTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        receiptMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1, 0, 10));

        jPanel2.setLayout(new java.awt.GridLayout(6, 2, 10, 10));

        jLabel1.setText("Enter Name");
        jPanel2.add(jLabel1);
        jPanel2.add(nameTextField);

        jLabel2.setText("Enter Age");
        jPanel2.add(jLabel2);
        jPanel2.add(ageTextField);

        jLabel3.setText("Enter Phone");
        jPanel2.add(jLabel3);
        jPanel2.add(phoneTextField);

        jLabel4.setText("Select State");
        jPanel2.add(jLabel4);

        jPanel6.setLayout(new java.awt.BorderLayout());

        stateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(stateComboBox, java.awt.BorderLayout.CENTER);

        addNewStateButton.setText("NEW");
        addNewStateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewStateButtonActionPerformed(evt);
            }
        });
        jPanel6.add(addNewStateButton, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel6);

        jLabel5.setText("Select City");
        jPanel2.add(jLabel5);

        jPanel7.setLayout(new java.awt.BorderLayout());

        cityComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel7.add(cityComboBox, java.awt.BorderLayout.CENTER);

        addNewCityButton.setText("NEW");
        addNewCityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewCityButtonActionPerformed(evt);
            }
        });
        jPanel7.add(addNewCityButton, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel7);

        jPanel5.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        submitButton.setText("SUBMIT");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel5.add(submitButton);

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel5.add(updateButton);

        jPanel2.add(jPanel5);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel4.add(deleteButton);

        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        jPanel4.add(resetButton);

        jPanel2.add(jPanel4);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(1, 1));

        personTable.setModel(new javax.swing.table.DefaultTableModel(
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
        personTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(personTable);

        jPanel3.add(jScrollPane1);

        jPanel1.add(jPanel3);

        jMenu1.setText("File");

        receiptMenuItem.setText("Receipt");
        receiptMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiptMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(receiptMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        try {

            String name = nameTextField.getText().toUpperCase();
            String age = ageTextField.getText().toUpperCase();
            String phone = phoneTextField.getText().toUpperCase();

            if (name.isEmpty() || age.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid Data Entry To Submit Rocord!", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Persons per = new Persons();
                per.setAge(Integer.parseInt(age));
                per.setCreated(new Date());
                per.setModified(new Date());
                per.setName(name);
                per.setPhone(Long.parseLong(phone));
                per.setStatus(1);

                ses.beginTransaction();
                ses.save(per);
                ses.getTransaction().commit();
                ses.close();

                JOptionPane.showMessageDialog(this, "Record Submitted Successfully", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
                setTableData();
                resetData();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void personTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personTableMouseClicked
        try {
            int id = Integer.parseInt(personTable.getValueAt(personTable.getSelectedRow(), 0).toString());
            ses.beginTransaction();

            // declare per as class var 
            per = (Persons) ses.get(Persons.class, id); //object to person
            nameTextField.setText(per.getName());
            ageTextField.setText(per.getAge() + "");
            phoneTextField.setText(per.getPhone() + "");

            ses.getTransaction().commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_personTableMouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            if (per == null) {
                JOptionPane.showMessageDialog(this, "Please Select Record To Update", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String name = nameTextField.getText().toUpperCase();
                String age = ageTextField.getText();
                String phone = phoneTextField.getText();

                if (name.isEmpty() || age.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Invalid Data Entry To Update Rocord!", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    per.setName(name);//overwrite old name with new name
                    per.setAge(Integer.parseInt(age));//overwrite old age with new age
                    per.setPhone(Long.parseLong(phone));//overwrite old age with new age
                    per.setModified(new Date());

                    SessionFactory sf = new Configuration().configure().buildSessionFactory();
                    Session ses = sf.openSession();
                    ses.beginTransaction();

                    ses.update(per);

                    ses.getTransaction().commit();
                    ses.close();
                    sf.close();

                    JOptionPane.showMessageDialog(this, "Record Updated Successfully", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
                    resetData();
                    setTableData();
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        resetData();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (per == null) {
            JOptionPane.showMessageDialog(this, "Please Select Record To Delete", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
        } else {

            per.setStatus(0);
            per.setModified(new Date());

            ses.beginTransaction();
            ses.update(per);
            ses.getTransaction().commit();

            JOptionPane.showMessageDialog(this, "Record Updated Successfully", "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
            resetData();
            setTableData();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addNewStateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewStateButtonActionPerformed
        stateFrame.setVisible(true);
        stateFrame.setTableData();


    }//GEN-LAST:event_addNewStateButtonActionPerformed

    private void addNewCityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewCityButtonActionPerformed
        cityFrame.setVisible(true);
    }//GEN-LAST:event_addNewCityButtonActionPerformed

    private void receiptMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiptMenuItemActionPerformed
      receiptFrame.setVisible(true);
      receiptFrame.setTableData();
        /* try {
            String recNo = JOptionPane.showInputDialog(this, "Enter Receipt No");

            File f = new File(".");
            String path = f.getCanonicalPath();
            String reportFile = path + File.separator + "build" + File.separator + "classes" + File.separator + "org" + File.separator + "nlt" + File.separator + "report" + File.separator + "receipt2.jrxml";
            System.out.println(reportFile);

            JasperDesign jd = JRXmlLoader.load(reportFile);
            String sql = "SELECT\n"
                    + "     receipts.`id` AS receipts_id,\n"
                    + "     receipts.`name` AS receipts_name,\n"
                    + "     receipts.`coursename` AS receipts_coursename,\n"
                    + "     receipts.`amountinword` AS receipts_amountinword,\n"
                    + "     receipts.`amount` AS receipts_amount,\n"
                    + "     receipts.`receiptno` AS receipts_receiptno,\n"
                    + "     receipts.`paydate` AS receipts_paydate,\n"
                    + "     receipts.`status` AS receipts_status\n"
                    + "FROM\n"
                    + "     `receipts` receipts where receipts.`receiptno`=" + recNo;

            // System.out.println(sql);
            JRDesignQuery query = new JRDesignQuery();

            query.setText(sql);

            jd.setQuery(query);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, ses.connection());

            String pdfFileName = f.getCanonicalPath() + File.separator + "receipt2.pdf";
            JasperExportManager.exportReportToPdfFile(jp, pdfFileName);

            JasperViewer.viewReport(jp, false);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, title, JOptionPane.ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_receiptMenuItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewCityButton;
    private javax.swing.JButton addNewStateButton;
    private javax.swing.JTextField ageTextField;
    public javax.swing.JComboBox cityComboBox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTable personTable;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JMenuItem receiptMenuItem;
    private javax.swing.JButton resetButton;
    public javax.swing.JComboBox stateComboBox;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    //call from ctor,submit,update,delete
    //will fetch records from db & put them into ui table
    private void setTableData() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session ses = sf.openSession();
        ses.beginTransaction();

        Query qu = ses.createQuery("from Persons where status=1");
        List<Persons> personList = qu.list();

        String[] cols = {"ID", "NAME", "AGE", "PHONE"};

        String[][] data = new String[personList.size()][cols.length];
        int i = 0;
        for (Persons p : personList) {
            data[i][0] = p.getId() + "";
            data[i][1] = p.getName();
            data[i][2] = p.getAge() + "";
            data[i][3] = p.getPhone() + "";
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(data, cols);
        personTable.setModel(model);
        ses.getTransaction().commit();
        ses.close();
        sf.close();
    }

    private void resetData() {
        nameTextField.setText("");
        ageTextField.setText("");
        phoneTextField.setText("");
        per = null;
    }
}
