package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame {
    CustomerInfo(){
        setLayout(null);
        setSize(900,600);
        setLocation(400,100);

        JPanel jPanel = new JPanel();
        jPanel.setBounds(5,5,890,590);
        jPanel.setBackground(new Color(3,45,48));
        jPanel.setLayout(null);
        add(jPanel);

        JLabel id = new JLabel("ID");
        id.setBounds(31,11,100,14);
        id.setFont( new Font("Tahoma", Font.BOLD,14));
        id.setForeground(Color.white);
        jPanel.add(id);

        JLabel number = new JLabel("Number");
        number.setBounds(150,11,100,14);
        number.setFont( new Font("Tahoma", Font.BOLD,14));
        number.setForeground(Color.white);
        jPanel.add(number);

        JLabel name = new JLabel("Name");
        name.setBounds(270,11,100,14);
        name.setFont( new Font("Tahoma", Font.BOLD,14));
        name.setForeground(Color.white);
        jPanel.add(name);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(360,11,100,14);
        gender.setFont( new Font("Tahoma", Font.BOLD,14));
        gender.setForeground(Color.white);
        jPanel.add(gender);

        JLabel country = new JLabel("Country");
        country.setBounds(460,11,100,14);
        country.setFont( new Font("Tahoma", Font.BOLD,14));
        country.setForeground(Color.white);
        jPanel.add(country);

        JLabel room = new JLabel("Room Number");
        room.setBounds(570,11,150,14);
        room.setFont( new Font("Tahoma", Font.BOLD,14));
        room.setForeground(Color.white);
        jPanel.add(room);

        JLabel ciTime = new JLabel("CI Time");
        ciTime.setBounds(700,11,100,14);
        ciTime.setFont( new Font("Tahoma", Font.BOLD,14));
        ciTime.setForeground(Color.white);
        jPanel.add(ciTime);

        JLabel deposite = new JLabel("Deposit");
        deposite.setBounds(800,11,100,14);
        deposite.setFont( new Font("Tahoma", Font.BOLD,14));
        deposite.setForeground(Color.white);
        jPanel.add(deposite);


        JTable table = new JTable();
        table.setBackground(new Color(3,45,48));
        table.setBounds(10,40,900,450);
        table.setFont(new Font("Tahoma",Font.PLAIN,14));
        table.setForeground(Color.white);
        try{
            Con c = new Con();
            String query = "select * from customer";
            ResultSet resultSet = c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception E){
            E.printStackTrace();
        }
        jPanel.add(table);

        JButton button = new JButton("Back");
        button.setBounds(450,510,120,30);
        button.setForeground(Color.white);
        button.setBackground(Color.BLACK);
        jPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setVisible(true);
    }
    public static void main(String[] args) {
        new CustomerInfo();
    }
}
