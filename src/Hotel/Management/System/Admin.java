package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {
    JButton addEmployee, addRooms, addDriver, btnlogOut, btnBack;
    Admin(){
        super("You are on Admin section");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image i2 = i1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(70,80,120,120);
        add(i4);

        addEmployee = new JButton("ADD EMPLOYEE");
        addEmployee.setBounds(270,130,150,25);
        addEmployee.setBackground(Color.white);
        addEmployee.setForeground(Color.BLACK);
        addEmployee.setFont(new Font("Tahoma",Font.BOLD,12));
        addEmployee.addActionListener(this);
        add(addEmployee);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image i6 = i5.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel i8 = new JLabel(i7);
        i8.setBounds(70,240,120,120);
        add(i8);

        addRooms = new JButton("ADD ROOMS");
        addRooms.setBounds(270,290,150,25);
        addRooms.setBackground(Color.white);
        addRooms.setForeground(Color.BLACK);
        addRooms.setFont(new Font("Tahoma",Font.BOLD,12));
        addRooms.addActionListener(this);
        add(addRooms);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image img2 = img1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img4 = new JLabel(img3);
        img4.setBounds(70,400,120,120);
        add(img4);

        addDriver = new JButton("ADD Driver");
        addDriver.setBounds(270,450,150,25);
        addDriver.setBackground(Color.white);
        addDriver.setForeground(Color.BLACK);
        addDriver.setFont(new Font("Tahoma",Font.BOLD,12));
        addDriver.addActionListener(this);
        add(addDriver);

        ImageIcon glfImage = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image image = glfImage.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setBounds(970,300,250,250);
        add(jLabel);

        btnlogOut = new JButton("Log Out");
        btnlogOut.setBackground(Color.BLACK);
        btnlogOut.setForeground(Color.white);
        btnlogOut.setFont(new Font("Tahoma",Font.BOLD,15));
        btnlogOut.setBounds(50,620,95,30);
        btnlogOut.addActionListener(this);
        add(btnlogOut);

        btnBack = new JButton("Back");
        btnBack.setBounds(150,620,95,30);
        btnBack.setFont(new Font("Tahoma",Font.BOLD,15));
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.white);
        btnBack.addActionListener(this);
        add(btnBack);

        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setSize(1365,720);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource()==btnlogOut){
                new Login();
                setVisible(false);
            } else if (e.getSource()==btnBack) {
                new DashBoard();
                setVisible(false);
            } else if (e.getSource()==addEmployee) {
                new AddEmployee();
            } else if (e.getSource()==addRooms) {
                new AddRoom();
            } else if (e.getSource()==addDriver) {
                new AddDriver();
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
