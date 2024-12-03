package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField nameTextField, ageTextField, salaryTextField, phoneTextField, aadharTextField, emailTextField;
    JComboBox jComboBox;
    JRadioButton female,male;
    JButton backbtn, addbtn;

    AddEmployee(){
        super("Add new Employee");
        JPanel jPanel = new JPanel();
        jPanel.setBounds(5,5,875,490);
        jPanel.setBackground(new Color(3,45,48));
        jPanel.setLayout(null);
        add(jPanel);

        JLabel name = new JLabel("NAME");
        name.setBounds(60,30,150,25);
        name.setFont(new Font("serif",Font.BOLD, 15));
        name.setForeground(Color.white);
        jPanel.add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(200,30,150,25);
        nameTextField.setFont(new Font("Tahoma",Font.BOLD,12));
        nameTextField.setBackground(new Color(16,108,115));
        nameTextField.setForeground(Color.white);
        jPanel.add(nameTextField);

        JLabel age = new JLabel("AGE");
        age.setBounds(60,70,150,25);
        age.setFont(new Font("serif",Font.BOLD,15));
        age.setForeground(Color.white);
        jPanel.add(age);

        ageTextField = new JTextField();
        ageTextField.setBounds(200,70,150,25);
        ageTextField.setFont(new Font("Tahoma",Font.BOLD,12));
        ageTextField.setBackground(new Color(16,108,115));
        ageTextField.setForeground(Color.white);
        jPanel.add(ageTextField);

        JLabel gender = new JLabel("GENDER");
        gender.setForeground(Color.white);
        gender.setBounds(60,110,150,25);
        gender.setFont(new Font("Serif",Font.BOLD,15));
        jPanel.add(gender);

        male = new JRadioButton("MALE");
        male.setForeground(Color.white);
        male.setFont(new Font("Tahoma",Font.BOLD,12));
        male.setBackground(new Color(3,45,48));
        male.setBounds(200,110,70,25);
        jPanel.add(male);

        female = new JRadioButton("FEMALE");
        female.setBounds(280,110,100,25);
        female.setFont(new Font("Tahoma",Font.BOLD,12));
        female.setBackground(new Color(3,45,48));
        female.setForeground(Color.white);
        jPanel.add(female);

        JLabel job = new JLabel("JOB");
        job.setBounds(60,150,150,25);
        job.setFont(new Font("Serif",Font.BOLD,15));
        job.setForeground(Color.white);
        jPanel.add(job);

        jComboBox = new JComboBox(new String[]
                {"Front Desk", "Housekeeping", "Kitchen Staff","Room Service", "Manager", "Accountant","Chef"});
        jComboBox.setBackground(new Color(16,108,115));
        jComboBox.setBounds(200,150,150,25);
        jComboBox.setFont(new Font("Tahoma",Font.BOLD,12));
        jComboBox.setForeground(Color.white);
        jPanel.add(jComboBox);

        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60,190,150,25);
        salary.setFont(new Font("serif",Font.BOLD,15));
        salary.setForeground(Color.white);
        jPanel.add(salary);

        salaryTextField = new JTextField();
        salaryTextField.setBounds(200,190,150,25);
        salaryTextField.setBackground(new Color(16,108,115));
        salaryTextField.setFont(new Font("Tahoma",Font.BOLD,12));
        salaryTextField.setForeground(Color.white);
        jPanel.add(salaryTextField);

        JLabel phone = new JLabel("PHONE");
        phone.setBounds(60,230,150,25);
        phone.setFont(new Font("serif",Font.BOLD,15));
        phone.setForeground(Color.white);
        jPanel.add(phone);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(200,230,150,25);
        phoneTextField.setBackground(new Color(16,108,115));
        phoneTextField.setFont(new Font("Tahoma",Font.BOLD,12));
        phoneTextField.setForeground(Color.white);
        jPanel.add(phoneTextField);

        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setBounds(60,270,150,25);
        aadhar.setFont(new Font("serif",Font.BOLD,15));
        aadhar.setForeground(Color.white);
        jPanel.add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setBounds(200,270,150,25);
        aadharTextField.setBackground(new Color(16,108,115));
        aadharTextField.setFont(new Font("Tahoma",Font.BOLD,12));
        aadharTextField.setForeground(Color.white);
        jPanel.add(aadharTextField);

        JLabel email = new JLabel("EMAIL");
        email.setBounds(60,310,150,25);
        email.setFont(new Font("serif",Font.BOLD,15));
        email.setForeground(Color.white);
        jPanel.add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(200,310,150,25);
        emailTextField.setBackground(new Color(16,108,115));
        emailTextField.setFont(new Font("Tahoma",Font.BOLD,12));
        emailTextField.setForeground(Color.white);
        jPanel.add(emailTextField);

        addbtn = new JButton("ADD");
        addbtn.setBounds(100,360,80,25);
        addbtn.setBackground(Color.BLACK);
        addbtn.setForeground(Color.white);
        addbtn.addActionListener(this);
        jPanel.add(addbtn);

        backbtn = new JButton("BACK");
        backbtn.setBounds(200,360,80,25);
        backbtn.setBackground(Color.BLACK);
        backbtn.setForeground(Color.white);
        backbtn.addActionListener(this);
        jPanel.add(backbtn);

        JLabel heading = new JLabel("ADD ENPLOYEE DETAILS");
        heading.setForeground(Color.white);
        heading.setBounds(450,24,445,35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        jPanel.add(heading);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image image = imageIcon.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(image);
        JLabel jLabel = new JLabel(i);
        jLabel.setBounds(500,100,300,300);
        jPanel.add(jLabel);

        setUndecorated(true);
        setLayout(null);
        setLocation(20,110);
        setVisible(true);
        setSize(885,500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addbtn){
            String name = nameTextField.getText();
            String age = ageTextField.getText();
            String gender = null;
            if (male.isSelected()){
                gender="Male";
            } else if (female.isSelected()) {
                gender="Female";
            }
            String job = (String) jComboBox.getSelectedItem();
            String salary = salaryTextField.getText();
            String phone = phoneTextField.getText();
            String aadhar = aadharTextField.getText();
            String email = emailTextField.getText();
            try{
                Con database = new Con();
                String query = "Insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
                database.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==backbtn) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
