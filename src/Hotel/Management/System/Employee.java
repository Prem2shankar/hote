package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee extends JFrame {
    Employee(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(new Color(3,45,48));
        jPanel.setBounds(5,5,990,590);
        add(jPanel);

        JTable jTable =new JTable();
        jTable.setBackground(new Color(3,45,48));
        jTable.setBounds(10,34,980,450);
        jTable.setForeground(Color.white);
        jPanel.add(jTable);

        try{
            Con d = new Con();
            String query = "select * from employee";
            ResultSet resultset = d.statement.executeQuery(query);
            jTable.setModel(DbUtils.resultSetToTableModel(resultset));
        }catch (Exception E){
            E.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(350,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        jPanel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel name = new JLabel("Name");
        name.setBounds(41,11,70,19);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma", Font.BOLD,14));
        jPanel.add(name);

        JLabel Age = new JLabel("Age");
        Age.setBounds(159,11,70,19);
        Age.setForeground(Color.WHITE);
        Age.setFont(new Font("Tahoma", Font.BOLD,14));
        jPanel.add(Age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(273,11,70,19);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma", Font.BOLD,14));
        jPanel.add(gender);

        JLabel job = new JLabel("Job");
        job.setBounds(416,11,70,19);
        job.setForeground(Color.WHITE);
        job.setFont(new Font("Tahoma", Font.BOLD,14));
        jPanel.add(job);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(536,11,70,19);
        salary.setForeground(Color.WHITE);
        salary.setFont(new Font("Tahoma", Font.BOLD,14));
        jPanel.add(salary);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(656,11,70,19);
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("Tahoma", Font.BOLD,14));
        jPanel.add(phone);

        JLabel gmail = new JLabel("Gmail");
        gmail.setBounds(786,11,70,19);
        gmail.setForeground(Color.WHITE);
        gmail.setFont(new Font("Tahoma", Font.BOLD,14));
        jPanel.add(gmail);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(896,11,70,19);
        aadhar.setForeground(Color.WHITE);
        aadhar.setFont(new Font("Tahoma", Font.BOLD,14));
        jPanel.add(aadhar);

        setUndecorated(true);
        setLayout(null);
        setSize(1000,600);
        setLocation(330,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Employee();
    }
}
