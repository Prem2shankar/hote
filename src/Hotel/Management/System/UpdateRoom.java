package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame {
    UpdateRoom(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label2  = new JLabel("ID :");
        label2.setBounds(25,88,46,14);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);
        Choice choice = new Choice();
        choice.setBounds(248,85,140,20);
        choice.setBackground(Color.white);
        try{
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from customer");
            while (resultSet.next()){
                choice.add(resultSet.getString("number"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }
        panel.add(choice);

        JLabel label3  = new JLabel("Room Number :");
        label3.setBounds(25,129,107,14);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField3 = new JTextField();
        textField3.setBounds(248,129,140,20);
        panel.add(textField3);

        JLabel label4  = new JLabel("Availability :");
        label4.setBounds(25,174,97,14);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField4 = new JTextField();
        textField4.setBounds(248,174,140,20);
        panel.add(textField4);

        JLabel label5  = new JLabel("Clean Status: ");
        label5.setBounds(25,216,97,14);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField5 = new JTextField();
        textField5.setBounds(248,216,140,20);
        panel.add(textField5);



        JButton back = new JButton("Back");
        back.setBounds(180,355,89,23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(60,355,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Con c = new Con();
                    ResultSet resultSet1 = c.statement.executeQuery("select * from customer where number='"+choice.getSelectedItem()+"'");

                    while (resultSet1.next()){
                        textField3.setText(resultSet1.getString("allocated_Room"));
                    }
                    String roomNo = textField3.getText();
                    ResultSet resultSet2 = c.statement.executeQuery("select * from room where room_number='"+roomNo+"'");

                    while (resultSet2.next()){
                        textField4.setText(resultSet2.getString("availability"));
                        textField5.setText(resultSet2.getString("cleaning_status"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton update = new JButton("Update");
        update.setBounds(120,315,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String roomNo = textField3.getText();
                String availability =  textField4.getText();
                String cleanStatus = textField5.getText();
                try{
                    Con c = new Con();
                    String q = "Update room set cleaning_status='"+cleanStatus+"' where room_number='"+roomNo+"'";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Room Updated Successfully");
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });



        setLayout(null);
        setSize(950,500);
        setLocation(400,200);
        setVisible(true);

    }
    public static void main(String[] args) {
        new UpdateRoom();
    }
}
