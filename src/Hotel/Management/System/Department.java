package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setLocation(5,5);
        jPanel.setSize(690,490);
        jPanel.setBackground(new Color(3,45,48));
        add(jPanel);

        JTable jTable = new JTable();
        jTable.setBounds(0,40,700,350);
        jTable.setBackground(new Color(4,45,48));
        jTable.setForeground(Color.white);
        jPanel.add(jTable);

        try{
            Con d = new Con();
            String query = "select * from department";
            ResultSet resultset = d.statement.executeQuery(query);
            jTable.setModel(DbUtils.resultSetToTableModel(resultset));
        }catch (Exception E){
            E.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(400,410,120,30);
        jPanel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==back){
                    setVisible(false);
                }
            }
        });


        JLabel department = new JLabel("Department");
        department.setBounds(145,11,150,20);
        department.setFont(new Font("Tahoma",Font.BOLD,14));
        department.setForeground(Color.white);
        jPanel.add(department);

        JLabel budget = new JLabel("Budget");
        budget.setBounds(431,11,105,20);
        budget.setFont(new Font("Tahoma",Font.BOLD,14));
        budget.setForeground(Color.white);
        jPanel.add(budget);

        setUndecorated(true);
        setLayout(null);
        setLocation(550,150);
        setSize(700,500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Department();
    }
}
