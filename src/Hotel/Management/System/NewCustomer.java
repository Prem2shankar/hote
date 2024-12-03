package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener {
    JComboBox idTextField ;
    JTextField numberTextField, nameTextField, countryTextField, depositeTextField;
    JRadioButton male, female;
    JButton add, back;
    Choice altRmNoCho;
    JLabel date1;
    Date date;
    NewCustomer(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBounds(5,5,840,540);
        jPanel.setBackground(new Color(3,45,48));
        jPanel.setForeground(Color.white);
        add(jPanel);

        JLabel heading = new JLabel("NEW CUSTOMER FORM");
        heading.setFont(new Font("Tahoma", Font.BOLD,20));
        heading.setForeground(Color.white);
        heading.setBounds(118,11,260,53);
        jPanel.add(heading);

        JLabel id = new JLabel("ID :");
        id.setBounds(35,76,200,14);
        id.setForeground(Color.white);
        id.setFont(new Font("Tahoma",Font.PLAIN,14));
        jPanel.add(id);
        idTextField = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving License"});
        idTextField.setBounds(271,73,150,20);
        idTextField.setForeground(Color.white);
        idTextField.setBackground(new Color(3,45,48));
        idTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        jPanel.add(idTextField);

        JLabel number = new JLabel("Number :");
        number.setBounds(35,111,200,14);
        number.setForeground(Color.white);
        number.setFont(new Font("Tahoma",Font.PLAIN,14));
        jPanel.add(number);
        numberTextField = new JTextField();
        numberTextField.setBounds(271,111,150,20);
        numberTextField.setBackground(Color.white);
        numberTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        jPanel.add(numberTextField);

        JLabel name = new JLabel("Name :");
        name.setBounds(35,151,200,14);
        name.setForeground(Color.white);
        name.setFont(new Font("Tahoma",Font.PLAIN,14));
        jPanel.add(name);
        nameTextField = new JTextField();
        nameTextField.setBounds(271,151,150,20);
        nameTextField.setBackground(Color.white);
        nameTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        jPanel.add(nameTextField);

        JLabel gender = new JLabel("Gender :");
        gender.setBounds(35,191,200,14);
        gender.setForeground(Color.white);
        gender.setFont(new Font("Tahoma",Font.PLAIN,14));
        jPanel.add(gender);

        male = new JRadioButton("Male");
        male.setBackground(new Color(3,45,48));
        male.setFont(new Font("Tahoma",Font.BOLD, 14));
        male.setBounds(271,191,80,12);
        male.setForeground(Color.white);
        jPanel.add(male);

        female = new JRadioButton("Female");
        female.setBackground(new Color(3,45,48));
        female.setFont(new Font("Tahoma",Font.BOLD,14));
        female.setBounds(350,191,80,12);
        female.setForeground(Color.white);
        jPanel.add(female);

        JLabel country = new JLabel("Country :");
        country.setBounds(35,231,200,14);
        country.setForeground(Color.white);
        country.setFont(new Font("Tahoma",Font.PLAIN,14));
        jPanel.add(country);
        countryTextField = new JTextField();
        countryTextField.setBounds(271,231,150,20);
        countryTextField.setBackground(Color.white);
        countryTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        jPanel.add(countryTextField);

        JLabel altRmNo = new JLabel("Alloted Room Number :");
        altRmNo.setBounds(35,271,200,14);
        altRmNo.setForeground(Color.white);
        altRmNo.setFont(new Font("Tahoma",Font.PLAIN,14));
        jPanel.add(altRmNo);
        altRmNoCho = new Choice();
        try{
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from room");
            while (resultSet.next()){
                altRmNoCho.add(resultSet.getString("room_number"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        altRmNoCho.setBounds(271,274,150,20);
        altRmNoCho.setBackground(new Color(3,45,48));
        jPanel.add(altRmNoCho);

        JLabel checkedIn = new JLabel("Checked-In :");
        checkedIn.setBounds(35,311,200,14);
        checkedIn.setForeground(Color.white);
        checkedIn.setFont(new Font("Tahoma",Font.PLAIN,14));
        jPanel.add(checkedIn);

        Date date = new Date();
        date1 = new JLabel(""+date);
        date1.setBounds(271,316,200,14);
        date1.setBackground(new Color(3,45,48));
        date1.setForeground(Color.white);
        date1.setFont(new Font("Tahoma",Font.PLAIN,14));
        jPanel.add(date1);

        JLabel deposite = new JLabel("Deposite :");
        deposite.setBounds(35,351,200,14);
        deposite.setForeground(Color.white);
        deposite.setFont(new Font("Tahoma",Font.PLAIN,14));
        jPanel.add(deposite);
        depositeTextField = new JTextField();
        depositeTextField.setBounds(271,359,150,20);
        depositeTextField.setBackground(Color.white);
        depositeTextField.setFont(new Font("Tahoma",Font.PLAIN,14));
        jPanel.add(depositeTextField);

        add = new JButton("ADD");
        add.setBounds(100,430,120,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(this);
        jPanel.add(add);

        back = new JButton("BACK");
        back.setBounds(260,430,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        jPanel.add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(image);
        JLabel j  = new JLabel(i);
        j.setBounds(550,150,200,200);
        jPanel.add(j);

        setLayout(null);
        setSize(850,550);
        setLocation(400,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = (String) idTextField.getSelectedItem();
        String number = numberTextField.getText();
        String name = nameTextField.getText();
        String rdoButton =null;
        try{
            if(male.isSelected()){
                rdoButton="Male";
            } else if (female.isSelected()) {
                rdoButton = "Female";
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        String gender = rdoButton;
        String country = countryTextField.getText();
        String allocatedRoom = altRmNoCho.getSelectedItem();
        String checkIn = date1.getText();
        String deposite = depositeTextField.getText();
        if(e.getSource()==add){
            try{
                Con c = new Con();
                c.statement.executeUpdate("insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+allocatedRoom+"','"+checkIn+"', '"+deposite+"')");
                c.statement.executeUpdate("update room set availability='Occupied' where room_number="+allocatedRoom);
                JOptionPane.showMessageDialog(null, "Customer Added successfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }

}
