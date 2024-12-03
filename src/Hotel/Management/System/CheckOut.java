package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame {
    CheckOut(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100,20,100,30);
        label.setFont(new Font("Tahoma",Font.PLAIN,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel UserId = new JLabel("Customer Id");
        UserId.setBounds(30,80,150,30);
        UserId.setFont(new Font("Tahoma",Font.BOLD,14));
        UserId.setForeground(Color.WHITE);
        panel.add(UserId);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);
        try{
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from customer");
            while (resultSet.next()){
                choice.add(resultSet.getString("number"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        JLabel roomNum = new JLabel("Room Number");
        roomNum.setBounds(30,130,150,30);
        roomNum.setFont(new Font("Tahoma",Font.BOLD,14));
        roomNum.setForeground(Color.WHITE);
        panel.add(roomNum);

        JLabel labelRoomnumber = new JLabel();
        labelRoomnumber.setBounds(200,130,150,30);
        labelRoomnumber.setFont(new Font("Tahoma",Font.BOLD,14));
        labelRoomnumber.setForeground(Color.WHITE);
        panel.add(labelRoomnumber);

        JLabel checkintime = new JLabel("Check-In Time");
        checkintime.setBounds(30,180,150,30);
        checkintime.setFont(new Font("Tahoma",Font.BOLD,14));
        checkintime.setForeground(Color.WHITE);
        panel.add(checkintime);


        JLabel labelcheckintime = new JLabel();
        labelcheckintime.setBounds(200,180,250,30);
        labelcheckintime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelcheckintime.setForeground(Color.WHITE);
        panel.add(labelcheckintime);

        JLabel checkouttime = new JLabel("Check-Out Time");
        checkouttime.setBounds(30,230,150,30);
        checkouttime.setFont(new Font("Tahoma",Font.BOLD,14));
        checkouttime.setForeground(Color.WHITE);
        panel.add(checkouttime);

        Date date = new Date();
        JLabel labelcheckouttime = new JLabel(""+date);
        labelcheckouttime.setBounds(200,230,250,30);
        labelcheckouttime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelcheckouttime.setForeground(Color.WHITE);
        panel.add(labelcheckouttime);

        JButton checkOut = new JButton("Check-Out");
        checkOut.setBounds(30,300,120,30);
        checkOut.setForeground(Color.WHITE);
        checkOut.setBackground(Color.BLACK);
        panel.add(checkOut);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Con c1 = new Con();
                    String roomNum = labelRoomnumber.getText();
                    String q1 = "delete from customer where number='"+choice.getSelectedItem()+"'";
                    String q2 ="update room set availability = 'Available' where room_number='"+roomNum+"'";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Check-Out Successfully");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(300,300,120,30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Con c = new Con();
                    ResultSet resultSet = c.statement.executeQuery("select * from customer where number='"+choice.getSelectedItem()+"'");
                    while (resultSet.next()){
                        labelRoomnumber.setText(resultSet.getString("allocated_Room"));
                        labelcheckintime.setText(resultSet.getString("check_In"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton back = new JButton("Back");
        back.setBounds(170,300,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setLayout(null);
        setSize(800,400);
        setLocation(500,210);
        setVisible(true);

    }
    public static void main(String[] args) {
        new CheckOut();
    }
}
