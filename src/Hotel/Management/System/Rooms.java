package Hotel.Management.System;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RectangularShape;
import java.sql.ResultSet;

public class Rooms extends JFrame {
     Rooms(){
         JPanel jPanel = new JPanel();
         jPanel.setBounds(5,5,890,590);
         jPanel.setBackground(new Color(3,45,48));
         jPanel.setLayout(null);
         add(jPanel);

         ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
         Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
         ImageIcon imageIcon1 = new ImageIcon(image);
         JLabel i = new JLabel(imageIcon1);
         i.setBounds(600,200,200,200);
         jPanel.add(i);

         JTable jTable = new JTable();
         jTable.setBounds(10,40,500,400);
         jTable.setBackground(new Color(3,45,48));
         jTable.setForeground(Color.white);
         jPanel.add(jTable);
         try {
             Con d = new Con();
             String query = "select * from room";
             ResultSet resultset =  d.statement.executeQuery(query);
             jTable.setModel(DbUtils.resultSetToTableModel(resultset));
         }catch (Exception E){
             E.printStackTrace();
         }

         JLabel roomNo = new JLabel("Room No.");
         roomNo.setBounds(12,15,80,19);
         roomNo.setFont(new Font("Tahoma",Font.BOLD,14));
         roomNo.setForeground(Color.white);
         jPanel.add(roomNo);

         JLabel availability = new JLabel("Availability");
         availability.setBounds(119,15,80,19);
         availability.setFont(new Font("Tahoma",Font.BOLD,14));
         availability.setForeground(Color.white);
         jPanel.add(availability);

         JLabel cleanStatus = new JLabel("Clean Status");
         cleanStatus.setBounds(216,15,150,19);
         cleanStatus.setFont(new Font("Tahoma",Font.BOLD,14));
         cleanStatus.setForeground(Color.white);
         jPanel.add(cleanStatus);

         JLabel price = new JLabel("Price");
         price.setBounds(330,15,80,19);
         price.setFont(new Font("Tahoma",Font.BOLD,14));
         price.setForeground(Color.white);
         jPanel.add(price);

         JLabel bedType = new JLabel("Bed Type");
         bedType.setBounds(417,15,80,19);
         bedType.setFont(new Font("Tahoma",Font.BOLD,14));
         bedType.setForeground(Color.white);
         jPanel.add(bedType);

         JButton back = new JButton("Back");
         back.setBounds(200,500,120,30);
         back.setFont(new Font("Tahoma",Font.BOLD,14));
         back.setBackground(Color.BLACK);
         back.setForeground(Color.white);
         jPanel.add(back);
         back.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 setVisible(false);
             }
         });


        setUndecorated(true);
         setLayout(null);
         setLocation(400,100);
         setSize(900,600);
         setVisible(true);
    }

    public static void main(String[] args) {
        new Rooms();
    }
}
