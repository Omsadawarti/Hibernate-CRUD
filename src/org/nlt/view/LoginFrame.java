package org.nlt.view;

import javax.swing.JOptionPane;
import org.nlt.model.Users;
import static org.nlt.view.ParentInterface.userList;

public class LoginFrame extends javax.swing.JFrame implements ParentInterface {

    public LoginFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        signUpLabel = new javax.swing.JLabel();
        forgotPasswordLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 10, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("USERNAME");
        jPanel1.add(jLabel1);

        usernameTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usernameTextField.setText("roshannandurkar21@gmail.com");
        jPanel1.add(usernameTextField);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("PASSWORD");
        jPanel1.add(jLabel2);

        passwordTextField.setText("600255");
        jPanel1.add(passwordTextField);

        loginButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        loginButton.setText("LOGIN");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(loginButton);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        signUpLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        signUpLabel.setForeground(new java.awt.Color(0, 153, 51));
        signUpLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signUpLabel.setText("SIGNUP");
        signUpLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpLabelMouseClicked(evt);
            }
        });
        jPanel2.add(signUpLabel);

        forgotPasswordLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        forgotPasswordLabel.setForeground(new java.awt.Color(255, 0, 0));
        forgotPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forgotPasswordLabel.setText("FORGOT PASSWORD");
        forgotPasswordLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forgotPasswordLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPasswordLabelMouseClicked(evt);
            }
        });
        jPanel2.add(forgotPasswordLabel);

        jPanel1.add(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(595, 213));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signUpLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpLabelMouseClicked
        signupFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signUpLabelMouseClicked

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        try {
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();

            Users user = userList.stream().filter(P -> P.getEmail().equals(username) && P.getPassword().equals(password)).findAny().orElse(null);

            if (user == null) {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Person CRUD", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                loginUserObject.setName(user.getName());
                loginUserObject.setEmail(user.getEmail());
                loginUserObject.setId(user.getId());
                
                personFrame.setVisible(true);
                personFrame.setTitle("Login: "+loginUserObject.getName());
                stateFrame.setTableData();
                cityFrame.setTableData();//will add records int table & will add city name in city combo
                this.dispose();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void forgotPasswordLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPasswordLabelMouseClicked
        try {
            String inputEmail = JOptionPane.showInputDialog(this, "Enter Your Registred Email Id");
            Users existingUser = userList.stream().filter(P -> P.getEmail().equals(inputEmail)).findAny().orElse(null);
            if (existingUser != null) {
                String sub = "Account Created " + title;
                String emailText = existingUser.getName() + " Your Forgot Password For Login " + title + " Account is: " + existingUser.getPassword();
                Mailer.send("akhikale007@gmail.com", "wcdlpbsacrexaojl", existingUser.getEmail(), sub, emailText);
                JOptionPane.showMessageDialog(this, existingUser.getName() + " Your Password Sent On Your Registred Email Id. Please Check Your Email", title, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "This Email Id Not Registered", title, JOptionPane.ERROR_MESSAGE);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Person CRUD", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_forgotPasswordLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel forgotPasswordLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel signUpLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
