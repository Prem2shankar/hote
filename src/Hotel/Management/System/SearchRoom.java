package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {
    JComboBox bedType;
    JCheckBox checkBox;
    JTable table;
    JButton search, back;
    SearchRoom(){
        setLayout(null);
        setSize(700,500);
        setLocation(500,200);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBounds(5,5,690,490);
        jPanel.setBackground(new Color(3,45,48));
        jPanel.setForeground(Color.white);
        add(jPanel);

        JLabel searchRoom = new JLabel("Search For Room");
        searchRoom.setBounds(250,11,186,31);
        searchRoom.setForeground(Color.white);
        searchRoom.setFont(new Font("Tahoma", Font.BOLD, 20));
        jPanel.add(searchRoom);

        JLabel RoomBedType = new JLabel("Room Bed Type:");
        RoomBedType.setBounds(50,73,120,20);
        RoomBedType.setBackground(new Color(3,45,48));
        RoomBedType.setForeground(Color.white);
        RoomBedType.setFont(new Font("Tahoma",Font.BOLD,14));
        jPanel.add(RoomBedType);

        bedType = new JComboBox(new String[] {"Single bed","Double bed"});
        bedType.setBounds(170,73,120,20);
        bedType.setForeground(Color.white);
        bedType.setBackground(new Color(3,45,48));
        bedType.setFont(new Font("Tahoma",Font.PLAIN,12));
        jPanel.add(bedType);

        checkBox = new JCheckBox("Only Display Available");
        checkBox.setBounds(400,69,205,23);
        checkBox.setBackground(new Color(3,45,48));
        checkBox.setForeground(Color.white);
        checkBox.setFont(new Font("Tahoma",Font.BOLD,14));
        jPanel.add(checkBox);

        table = new JTable();
        table.setBounds(0,187,700,150);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        try{
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception E){
            E.printStackTrace();
        }
        jPanel.add(table);

        JLabel roomNo = new JLabel("Room Number");
        roomNo.setBounds(23,162,150,20);
        roomNo.setForeground(Color.white);
        roomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        jPanel.add(roomNo);

        JLabel Availability = new JLabel("Availability");
        Availability.setBounds(175,162,150,20);
        Availability.setForeground(Color.white);
        Availability.setFont(new Font("Tahoma",Font.BOLD,14));
        jPanel.add(Availability);

        JLabel cleanStatus = new JLabel("Clean Status");
        cleanStatus.setBounds(306,162,150,20);
        cleanStatus.setForeground(Color.white);
        cleanStatus.setFont(new Font("Tahoma",Font.BOLD,14));
        jPanel.add(cleanStatus);

        JLabel price = new JLabel("Price");
        price.setBounds(458,162,150,20);
        price.setForeground(Color.white);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        jPanel.add(price);

        JLabel bed_type = new JLabel("Bed Type");
        bed_type.setBounds(580,162,150,20);
        bed_type.setForeground(Color.white);
        bed_type.setFont(new Font("Tahoma",Font.BOLD,14));
        jPanel.add(bed_type);

        search = new JButton("Search");
        search.setBounds(200,400,120,30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.white);
        search.addActionListener(this);
        jPanel.add(search);

        back = new JButton("Back");
        back.setBounds(380,400,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        jPanel.add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            try{
                String BedType = (String) bedType.getSelectedItem();
                String query1 = "select * from room where bed_Type='"+BedType+"'";
                String query2 = "select * from room where availability='Available' and bed_Type='"+BedType+"'";
                Con c = new Con();
                if(checkBox.isSelected()){
                    ResultSet resultSet = c.statement.executeQuery(query2);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } else  {
                    ResultSet resultSet = c.statement.executeQuery(query1);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==back) {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
