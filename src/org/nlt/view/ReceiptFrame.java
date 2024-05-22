package org.nlt.view;

import java.io.File;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.nlt.model.Persons;
import org.nlt.model.Receipts;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReceiptFrame extends javax.swing.JFrame implements ParentInterface {

    public ReceiptFrame() {
        initComponents();

        payDateDateChooser.setDate(new Date());//default current Date
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        courseComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        amoutTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        amountInWordsTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        payDateDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        maleRadiButton = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        printReceiptButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        receiptTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1, 0, 20));

        jPanel2.setLayout(new java.awt.GridLayout(7, 2));

        jLabel1.setText("STUDENT NAME");
        jPanel2.add(jLabel1);
        jPanel2.add(nameTextField);

        jLabel2.setText("SELECT COURSE");
        jPanel2.add(jLabel2);

        courseComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT", "JAVA", "C", "C++", "PYTHON" }));
        jPanel2.add(courseComboBox);

        jLabel3.setText("AMOUNT");
        jPanel2.add(jLabel3);

        amoutTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                amoutTextFieldFocusLost(evt);
            }
        });
        jPanel2.add(amoutTextField);

        jLabel4.setText("AMOUNT IN WORDS");
        jPanel2.add(jLabel4);
        jPanel2.add(amountInWordsTextField);

        jLabel5.setText("PAY DATE");
        jPanel2.add(jLabel5);
        jPanel2.add(payDateDateChooser);

        jLabel6.setText("GENDER");
        jPanel2.add(jLabel6);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        buttonGroup1.add(maleRadiButton);
        maleRadiButton.setSelected(true);
        maleRadiButton.setText("MALE");
        jPanel4.add(maleRadiButton);

        buttonGroup1.add(femaleRadioButton);
        femaleRadioButton.setText("FEMALE");
        jPanel4.add(femaleRadioButton);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        submitButton.setText("SUBMIT");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel5.add(submitButton);

        updateButton.setText("UPDATE");
        jPanel5.add(updateButton);

        jPanel2.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jButton3.setText("jButton3");
        jPanel6.add(jButton3);

        printReceiptButton.setText("PRINT RECEIPT");
        printReceiptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printReceiptButtonActionPerformed(evt);
            }
        });
        jPanel6.add(printReceiptButton);

        jPanel2.add(jPanel6);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(1, 1));

        receiptTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(receiptTable);

        jPanel3.add(jScrollPane1);

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        try {
            String name = nameTextField.getText().toUpperCase();
            String course = courseComboBox.getSelectedItem().toString();
            String amountInDigit = amoutTextField.getText();
            String amountInWords = amountInWordsTextField.getText();
            Date payDate = payDateDateChooser.getDate();
            String gender = maleRadiButton.isSelected() ? "Male" : "Female";

            if (name.isEmpty() || course.equalsIgnoreCase("SELECT") || amountInDigit.isEmpty() || amountInWords.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid Entry", title, JOptionPane.ERROR_MESSAGE);
            } else {
                Receipts receipt = new Receipts();
                receipt.setAmount(Integer.parseInt(amountInDigit));
                receipt.setName(name);
                receipt.setCourse(course);
                receipt.setAmountInWords(amountInWords);
                receipt.setPayDate(payDate);
                receipt.setGender(gender);
                receipt.setStatus(1);
                ses.beginTransaction();
                ses.save(receipt);
                ses.getTransaction().commit();
                resetData();
                setTableData();
                JOptionPane.showMessageDialog(this, "Student Receipt Submitted Successfully", title, JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, title, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    public void setTableData() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session ses = sf.openSession();
        ses.beginTransaction();

        Query qu = ses.createQuery("from Receipts where status=1");
        List<Receipts> receiptList = qu.list();

        String[] cols = {"ID", "NAME", "AMOUNT", "DATE"};

        String[][] data = new String[receiptList.size()][cols.length];
        int i = 0;
        for (Receipts r : receiptList) {
            data[i][0] = r.getId() + "";
            data[i][1] = r.getName();
            data[i][2] = r.getAmount() + "";
            data[i][3] = r.getPayDate() + "";
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(data, cols);
        receiptTable.setModel(model);
        ses.getTransaction().commit();
        ses.close();
        sf.close();
    }

    private void resetData() {

    }

    private void amoutTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amoutTextFieldFocusLost
        String amount = amoutTextField.getText();
        if (!amount.isEmpty()) {
            amountInWordsTextField.setText(EnglishNumberToWords.convert(Integer.parseInt(amount)).toUpperCase());
        }
    }//GEN-LAST:event_amoutTextFieldFocusLost

    private void printReceiptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printReceiptButtonActionPerformed
        try {
            String receiptId = receiptTable.getValueAt(receiptTable.getSelectedRow(), 0).toString();

            File f = new File(".");
            String path = f.getCanonicalPath();
            String reportFile = path + File.separator + "build" + File.separator + "classes" + File.separator + "org" + File.separator + "nlt" + File.separator + "report" + File.separator + "receipt2.jrxml";
            System.out.println(reportFile);

            JasperDesign jd = JRXmlLoader.load(reportFile);
            String sql = "SELECT\n"
                    + "     receipts.`id` AS receipts_id,\n"
                    + "     receipts.`amount` AS receipts_amount,\n"
                    + "     receipts.`amountInWords` AS receipts_amountInWords,\n"
                    + "     receipts.`course` AS receipts_course,\n"
                    + "     receipts.`gender` AS receipts_gender,\n"
                    + "     receipts.`name` AS receipts_name,\n"
                    + "     receipts.`payDate` AS receipts_payDate,\n"
                    + "     receipts.`status` AS receipts_status\n"
                    + "FROM\n"
                    + "     `receipts` receipts where receipts.`id`=" + receiptId;

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
            JOptionPane.showMessageDialog(this, "Please Select Record To Receipt Print", title, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_printReceiptButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountInWordsTextField;
    private javax.swing.JTextField amoutTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox courseComboBox;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton maleRadiButton;
    private javax.swing.JTextField nameTextField;
    private com.toedter.calendar.JDateChooser payDateDateChooser;
    private javax.swing.JButton printReceiptButton;
    private javax.swing.JTable receiptTable;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
