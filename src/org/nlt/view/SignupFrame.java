package org.nlt.view;

import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import org.nlt.model.Users;

public class SignupFrame extends javax.swing.JFrame implements ParentInterface {

    public SignupFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        createAccountButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 0, 20));

        jLabel1.setText("ENTER YOUR NAME");
        jPanel1.add(jLabel1);
        jPanel1.add(nameTextField);

        jLabel2.setText("ENTER EMAIL ADDRESS");
        jPanel1.add(jLabel2);
        jPanel1.add(emailTextField);

        createAccountButton.setText("CREATE ACCOUNT");
        createAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountButtonActionPerformed(evt);
            }
        });
        jPanel1.add(createAccountButton);

        jButton2.setText("jButton2");
        jPanel1.add(jButton2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountButtonActionPerformed
        try {

            String name = nameTextField.getText().toUpperCase();
            String email = emailTextField.getText();

            if (name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name & Email Both Are REquired", title, JOptionPane.ERROR_MESSAGE);
            } else {
                Users existingUser = userList.stream().filter(P -> P.getEmail().equals(email)).findAny().orElse(null);
                if (existingUser != null) {
                    JOptionPane.showMessageDialog(this, "This Email Id Already Registered", title, JOptionPane.ERROR_MESSAGE);

                } else {
                    ses.beginTransaction();
                    Users user = new Users();
                    user.setName(name);
                    user.setCreated(new Date());
                    user.setEmail(email);
                    user.setModified(new Date());
                    Random r = new Random();
                    int password = r.nextInt(1000000);
                    user.setPassword(password + "");
                    user.setStatus(1);
                    ses.save(user);
                    ses.getTransaction().commit();

                    String sub = "Account Created " + title;
                    String emailText = name + " Your Login Password For " + title + " Account is: " + password;

                    Mailer.send("akhikale007@gmail.com", "wcdlpbsacrexaojl", email, sub, emailText);

                    JOptionPane.showMessageDialog(this, name + " Your Account Created!\nPassword Sent On Your Registred Email Id", title, JOptionPane.INFORMATION_MESSAGE);
                    loginFrame.setVisible(true);
                    this.dispose();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, title, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_createAccountButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createAccountButton;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTextField;
    // End of variables declaration//GEN-END:variables
}
