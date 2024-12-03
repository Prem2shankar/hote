package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame implements ActionListener {

    JLabel addRooms, roomNo, availability, price, cleaningSts,bedType ;
    JTextField addRoomsTextField,priceTextField;
    JComboBox availabilityTextField,cleaningStsComboBox,bedTypeComboBox;
    JButton btnAdd,btnBack;

    AddRoom(){
        super("You are on the add Room section");
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBounds(5,5,875,490);
        jPanel.setBackground(new Color(3,45,48));
        add(jPanel);

        addRooms = new JLabel("Add Rooms");
        addRooms.setBounds(194,10,160,22);
        addRooms.setFont(new Font("Tahoma",Font.BOLD,22));
        addRooms.setForeground(Color.white);
        jPanel.add(addRooms);

        roomNo = new JLabel("Room Number");
        roomNo.setBounds(64,70,152,22);
        roomNo.setFont(new Font("Tahoma",Font.BOLD,12));
        roomNo.setForeground(Color.white);
        jPanel.add(roomNo);

        addRoomsTextField = new JTextField();
        addRoomsTextField.setBounds(200,70,156,20);
        addRoomsTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        addRoomsTextField.setBackground(new Color(16,108,115));
        addRoomsTextField.setForeground(Color.white);
        jPanel.add(addRoomsTextField);

        availability = new JLabel("Availability");
        availability.setBounds(64,110,152,22);
        availability.setForeground(Color.white);
        availability.setFont(new Font("Tahoma",Font.BOLD,12));
        jPanel.add(availability);


        availabilityTextField =new JComboBox(new String[] {"Available", "Occupied"});
        availabilityTextField.setBounds(200,110,156,20);
        availabilityTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        availabilityTextField.setForeground(Color.WHITE);
        availabilityTextField.setBackground(new Color(16,108,115));
        jPanel.add(availabilityTextField);

        price = new JLabel("Price");
        price.setBounds(64,150,152,22);
        price.setForeground(Color.white);
        price.setFont(new Font("Tahoma",Font.BOLD,12));
        jPanel.add(price);

        priceTextField = new JTextField();
        priceTextField.setBounds(200,150,156,20);
        priceTextField.setBackground(new Color(16,108,115));
        priceTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        priceTextField.setForeground(Color.white);
        jPanel.add(priceTextField);

        cleaningSts = new JLabel("Cleaning Status");
        cleaningSts.setBounds(64,190,152,22);
        cleaningSts.setForeground(Color.white);
        cleaningSts.setFont(new Font("Tahoma",Font.BOLD,12));
        jPanel.add(cleaningSts);

        cleaningStsComboBox = new JComboBox(new String[] {"Clean","Dirty"});
        cleaningStsComboBox.setBounds(200,190,152,22);
        cleaningStsComboBox.setForeground(Color.white);
        cleaningStsComboBox.setBackground(new Color(16,108,115));
        cleaningStsComboBox.setFont(new Font("Tahoma",Font.PLAIN,14));
        jPanel.add(cleaningStsComboBox);

        bedType = new JLabel("Bed Type");
        bedType.setBounds(64,230,152,22);
        bedType.setForeground(Color.white);
        bedType.setFont(new Font("Tahoma",Font.BOLD,12));
        jPanel.add(bedType);

        bedTypeComboBox = new JComboBox(new String[] {"Single Bed","Double Bed"});
        bedTypeComboBox.setBounds(200,230,152,22);
        bedTypeComboBox.setFont(new Font("Tahoma",Font.PLAIN,14));
        bedTypeComboBox.setForeground(Color.white);
        bedTypeComboBox.setBackground(new Color(16,108,115));
        jPanel.add(bedTypeComboBox);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(64,321,111,33);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.setFont(new Font("Tahoma",Font.BOLD,12));
        btnAdd.setForeground(Color.white);
        btnAdd.addActionListener(this);
        jPanel.add(btnAdd);

        btnBack = new JButton("Back");
        btnBack.setBounds(198,321,111,33);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.white);
        btnBack.setFont(new Font("Tahoma",Font.BOLD,12));
        btnBack.addActionListener(this);
        jPanel.add(btnBack);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomser.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(image);
        JLabel j = new JLabel(i);
        j.setBounds(500,60,300,300 );
        jPanel.add(j);


        setUndecorated(true);
        //getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setLocation(20,110);
        setSize(885,500);
        //setBounds(20,20,885,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==btnAdd){
                String roomNo = addRoomsTextField.getText();
                String availability = (String) availabilityTextField.getSelectedItem();
                String price = priceTextField.getText();
                String cleanStatus = (String) cleaningStsComboBox.getSelectedItem();
                String bedType = (String) bedTypeComboBox.getSelectedItem();
                try{
                    Con database = new Con();
                    String query = "Insert into room values ('"+roomNo+"', '"+availability+"', '"+price+"', '"+cleanStatus+"','"+bedType+"' )";
                    database.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Room added successfully");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }

            }else if (e.getSource()==btnBack){
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
