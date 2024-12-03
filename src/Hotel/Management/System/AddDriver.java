package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {
    JTextField nameTextField, ageTextField, carCompanyTextField, carNameTextField, locationTextField;
    JComboBox genderComBox, avabilityComboBox;
    JButton add, back;
    AddDriver(){
        super("Add Driver ");
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(new Color(3,45,48));
        jPanel.setBounds(5,5,875,490);
        add(jPanel);

        JLabel heading = new JLabel("ADD DRIVER");
        heading.setBounds(450,24,445,35);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        jPanel.add(heading);

        JLabel name = new JLabel("NAME");
        name.setBounds(60,30,150,25);
        name.setForeground(Color.white);
        name.setFont(new Font("serif",Font.BOLD, 15));
        jPanel.add(name);
        nameTextField = new JTextField();
        nameTextField.setBounds(200,30,150,25);
        nameTextField.setBackground(new Color(16,108,115));
        nameTextField.setFont(new Font("Tahoma",Font.BOLD,12));
        nameTextField.setForeground(Color.white);
        jPanel.add(nameTextField);

        JLabel age = new JLabel("AGE");
        age.setBounds(60,70,150,25);
        age.setForeground(Color.white);
        age.setFont(new Font("serif",Font.BOLD, 15));
        jPanel.add(age);
        ageTextField = new JTextField();
        ageTextField.setBounds(200,70,150,25);
        ageTextField.setBackground(new Color(16,108,115));
        ageTextField.setFont(new Font("Tahoma",Font.BOLD,12));
        ageTextField.setForeground(Color.white);
        jPanel.add(ageTextField);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60,110,150,25);
        gender.setForeground(Color.white);
        gender.setFont(new Font("serif",Font.BOLD, 15));
        jPanel.add(gender);
        genderComBox = new JComboBox(new String[]{"Male","Female"});
        genderComBox.setBounds(200,110,150,25);
        genderComBox.setBackground(new Color(16,108,115));
        genderComBox.setFont(new Font("Tahoma",Font.BOLD,12));
        genderComBox.setForeground(Color.white);
        jPanel.add(genderComBox);

        JLabel carCompany = new JLabel("CAR COMPANY");
        carCompany.setBounds(60,150,150,25);
        carCompany.setForeground(Color.white);
        carCompany.setFont(new Font("serif",Font.BOLD, 15));
        jPanel.add(carCompany);
        carCompanyTextField = new JTextField();
        carCompanyTextField.setBounds(200,150,150,25);
        carCompanyTextField.setBackground(new Color(16,108,115));
        carCompanyTextField.setFont(new Font("Tahoma",Font.BOLD,12));
        carCompanyTextField.setForeground(Color.white);
        jPanel.add(carCompanyTextField);

        JLabel carName = new JLabel("CAR NAME");
        carName.setBounds(60,190,150,25);
        carName.setForeground(Color.white);
        carName.setFont(new Font("serif",Font.BOLD, 15));
        jPanel.add(carName);
        carNameTextField = new JTextField();
        carNameTextField.setBounds(200,190,150,25);
        carNameTextField.setBackground(new Color(16,108,115));
        carNameTextField.setFont(new Font("Tahoma",Font.BOLD,12));
        carNameTextField.setForeground(Color.white);
        jPanel.add(carNameTextField);

        JLabel avability = new JLabel("AVAILABLE");
        avability.setBounds(60,230,150,25);
        avability.setForeground(Color.white);
        avability.setFont(new Font("serif",Font.BOLD, 15));
        jPanel.add(avability);
        avabilityComboBox = new JComboBox(new String[]{"Yes","No"});
        avabilityComboBox.setBounds(200,230,150,25);
        avabilityComboBox.setBackground(new Color(16,108,115));
        avabilityComboBox.setFont(new Font("Tahoma",Font.BOLD,12));
        avabilityComboBox.setForeground(Color.white);
        jPanel.add(avabilityComboBox);

        JLabel location = new JLabel("LOCATION");
        location.setBounds(60,270,150,25);
        location.setForeground(Color.white);
        location.setFont(new Font("serif",Font.BOLD, 15));
        jPanel.add(location);
        locationTextField = new JTextField();
        locationTextField.setBounds(200,270,150,25);
        locationTextField.setBackground(new Color(16,108,115));
        locationTextField.setFont(new Font("Tahoma",Font.BOLD,12));
        locationTextField.setForeground(Color.white);
        jPanel.add(locationTextField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(image);
        JLabel jLabel= new JLabel(i);
        jLabel.setBounds(500,100,300,300);
        jPanel.add(jLabel);

        add = new JButton("ADD");
        add.setBounds(100,330,80,25);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(this);
        jPanel.add(add);

        back = new JButton("BACK");
        back.setBounds(200,330,80,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        jPanel.add(back);

        setUndecorated(true);
        setLayout(null);
        setLocation(20,110);
        setSize(885,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            String name = nameTextField.getText();
            String age = ageTextField.getText();
            String gender = (String) genderComBox.getSelectedItem();
            String carCompany = carCompanyTextField.getText();
            String carName = carNameTextField.getText();
            String available = (String) avabilityComboBox.getSelectedItem();
            String location = locationTextField.getText();

            try{
                Con d = new Con();
                String query = "Insert into driver values( '"+name+"', '"+age+"','"+gender+"','"+carCompany+"','"+carName+"','"+available+"','"+location+"' )";
                d.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Driver Details added Successfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
