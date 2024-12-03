package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSet;



public class Login extends JFrame implements ActionListener {
    JTextField userNameTextField;
    JPasswordField passwordTextField;
    JButton jLogin, jCancle;
    ImageIcon imageIcon;

    Login(){
        JLabel userName = new JLabel("Username");
        userName.setBounds(40,20,100,30);
        userName.setForeground(Color.white);
        userName.setFont(new Font("Tahoma",Font.BOLD,16));
        add(userName);

        userNameTextField = new JTextField();
        userNameTextField.setBounds(150,20,150,30);
        userNameTextField.setForeground(Color.white);
        userNameTextField.setBackground(new Color(26,104,110));
        userNameTextField.setFont(new Font("Tahoma", Font.BOLD,16));
        add(userNameTextField);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setForeground(Color.white);
        password.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(password);

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(150,70,150,30);
        passwordTextField.setBackground(new Color(26,104,110));
        passwordTextField.setForeground(Color.white);
        passwordTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(passwordTextField);

        jLogin = new JButton("Login");
        jLogin.setBounds(40,140,120,30);
        jLogin.setForeground(Color.white);
        jLogin.setFont(new Font("serif", Font.BOLD, 15));
        jLogin.setBackground(Color.BLACK);
        jLogin.addActionListener(this);
        add(jLogin);

        jCancle = new JButton("Cancel");
        jCancle.setBounds(180,140,120,30);
        jCancle.setForeground(Color.white);
        jCancle.setFont(new Font("serif", Font.BOLD, 15));
        jCancle.setBackground(Color.BLACK);
        jCancle.addActionListener(this);
        add(jCancle);

        imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image image = imageIcon.getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon2);
        jLabel.setBounds(318,-30,255,300);
        add(jLabel);


        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setLocation(400,270);
        setSize(600,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jLogin){
            try{
                Con c = new Con();
                String user = userNameTextField.getText();
                String pass = passwordTextField.getText();
                String query = "select * from login where username='"+user+"' and password ='"+pass+"' ";
                ResultSet resultset =  c.statement.executeQuery(query);
                if( resultset.next()){
                    new DashBoard();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                }
            }catch (Exception E){
                E.printStackTrace();
            }

        }else if(e.getSource()==jCancle){
            System.exit(102);

        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
