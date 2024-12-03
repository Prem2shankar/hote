package Hotel.Management.System;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.a.result.NativeResultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login2 extends JFrame implements ActionListener {
    JTextField usernameTextField, passwordTextField;
    JButton login, cancle;
    Login2(){
        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        username.setForeground(Color.white);
        username.setFont(new Font("Tahoma",Font.BOLD,16));
        add(username);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(150,20,150,30);
        usernameTextField.setBackground(new Color(26,104,110));
        usernameTextField.setFont(new Font("Tahoma",Font.BOLD,16));
        usernameTextField.setForeground(Color.white);
        add(usernameTextField);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setForeground(Color.white);
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        add(password);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(150,70,150,30);
        passwordTextField.setBackground(new Color(26,104,110));
        passwordTextField.setFont(new Font("Tahoma",Font.BOLD,16));
        passwordTextField.setForeground(Color.white);
        add(passwordTextField);

        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setFont(new Font("serif", Font.BOLD, 15));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        cancle = new JButton("Cancle");
        cancle.setBounds(180,140,120,30);
        cancle.setFont(new Font("serif", Font.BOLD, 15));
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.white);
        cancle.addActionListener(this);
        add(cancle);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image image = imageIcon.getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(image);
        JLabel jLabel = new JLabel(i);
        jLabel.setBounds(318,-30,255,300);
        add(jLabel);

        setLayout(null);
        setLocation(400,270);
        setSize(600,300);
        getContentPane().setBackground(new Color(3,45,48));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            String userName = usernameTextField.getText();
            String password = passwordTextField.getText();
            try{
                Con d = new Con();
                String query = "select * from login2 where userName='"+userName+"' and password ='"+password+"'";
                ResultSet resultset = d.statement.executeQuery(query);
                if (resultset.next()){
                    new Admin();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid UserName and Password");
                }


            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==cancle) {
            setVisible(false);
            new DashBoard();
        }
    }

    public static void main(String[] args) {
        new Login2();
    }
}
