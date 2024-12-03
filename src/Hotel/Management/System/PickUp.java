package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUp extends JFrame {
    PickUp(){
        setLayout(null);
        setSize(800,600);
        setLocation(500,100);

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel pickUp = new JLabel("Pick Up Service");
        pickUp.setBounds(90,11,200,25);
        pickUp.setFont(new Font("Tahoma",Font.BOLD,25));
        pickUp.setForeground(Color.white);
        panel.add(pickUp);

        JLabel typCar = new JLabel("Type of Car");
        typCar.setBounds(32,97,89,20);
        typCar.setForeground(Color.white);
        typCar.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(typCar);

        Choice choice = new Choice();
        try{
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from driver");
            while (resultSet.next()){
                choice.add(resultSet.getString("car_name"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        choice.setBounds(123,94,150,25);
        panel.add(choice);

        JTable table = new JTable();
        table.setBounds(10,233,800,250);
        table.setForeground(Color.white);
        table.setBackground(new Color(3,45,48));
        try{
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception E){
            E.printStackTrace();
        }
        panel.add(table);

        JLabel name = new JLabel("Name");
        name.setBounds(24,208,46,14);
        name.setForeground(Color.white);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);
        JLabel age = new JLabel("Age");
        age.setBounds(165,208,46,14);
        age.setForeground(Color.WHITE);
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(264,208,46,14);
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        JLabel company = new JLabel("Company");
        company.setBounds(366,208,100,14);
        company.setForeground(Color.WHITE);
        panel.add(company);

        JLabel Carname = new JLabel("Car Name");
        Carname.setBounds(486,208,100,14);
        Carname.setForeground(Color.WHITE);
        panel.add(Carname);

        JLabel available = new JLabel("Available");
        available.setBounds(600,208,100,14);
        available.setForeground(Color.WHITE);
        panel.add(available);

        JLabel loacation = new JLabel("Loacation");
        loacation.setBounds(700,208,100,14);
        loacation.setForeground(Color.WHITE);
        panel.add(loacation);

        JButton display = new JButton("Display");
        display.setBounds(200,500,120,30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.white);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Con c = new Con();
                    String query = "select * from driver where car_name='"+choice.getSelectedItem()+"'";
                    ResultSet resultSet = c.statement.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(420,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setVisible(true);
    }
    public static void main(String[] args) {
        new PickUp();
    }
}
