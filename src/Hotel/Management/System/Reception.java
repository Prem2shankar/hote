package Hotel.Management.System;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception(){
        super("Welcome on Reception page");

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBounds(280,5,1238,820);
        jPanel.setBackground(new Color(3,45,48));
        add(jPanel);

        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(null);
        jPanel1.setBounds(5,5,270,820);
        jPanel1.setBackground(new Color(3,45,48));
        add(jPanel1);

        ImageIcon imageIcon= new ImageIcon(ClassLoader.getSystemResource("icon/cccc.gif"));
        Image image = imageIcon.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon1);
        jLabel.setBounds(300,10,650,650);
        jPanel.add(jLabel);

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image image1 = imageIcon2.getImage().getScaledInstance(220,220, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(image1);
        JLabel jLabel1 = new JLabel(imageIcon3);
        jLabel1.setBounds(20,500,220,220);
        jPanel1.add(jLabel1);

        JButton btn_NCF = new JButton("New Customer Form");
        btn_NCF.setBounds(30,30,200,30);
        btn_NCF.setBackground(Color.BLACK);
        btn_NCF.setForeground(Color.white);
        jPanel1.add(btn_NCF);
        btn_NCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new NewCustomer();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btn_room = new JButton("Room");
        btn_room.setBounds(30,70,200,30);
        btn_room.setBackground(Color.BLACK);
        btn_room.setForeground(Color.white);
        jPanel1.add(btn_room);
        btn_room.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try{
                        new Rooms();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btn_dept = new JButton("Department");
        btn_dept.setBounds(30,110,200,30);
        btn_dept.setBackground(Color.BLACK);
        btn_dept.setForeground(Color.white);
        jPanel1.add(btn_dept);
        btn_dept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Department();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btn_AllEmpInfo = new JButton("All Employee Info");
        btn_AllEmpInfo.setBounds(30,150,200,30);
        btn_AllEmpInfo.setBackground(Color.BLACK);
        btn_AllEmpInfo.setForeground(Color.white);
        jPanel1.add(btn_AllEmpInfo);
        btn_AllEmpInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Employee();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btn_CustInfo = new JButton("Customer Info");
        btn_CustInfo.setBounds(30,190,200,30);
        btn_CustInfo.setBackground(Color.BLACK);
        btn_CustInfo.setForeground(Color.white);
        jPanel1.add(btn_CustInfo);
        btn_CustInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new CustomerInfo();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btn_MangInfo = new JButton("Manager Info");
        btn_MangInfo.setBounds(30,230,200,30);
        btn_MangInfo.setForeground(Color.white);
        btn_MangInfo.setBackground(Color.BLACK);
        jPanel1.add(btn_MangInfo);
        btn_MangInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new ManagerInfo();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btn_ChkOut = new JButton("Check Out");
        btn_ChkOut.setBounds(30,270,200,30);
        btn_ChkOut.setBackground(Color.BLACK);
        btn_ChkOut.setForeground(Color.white);
        jPanel1.add(btn_ChkOut);
        btn_ChkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new CheckOut();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btn_UpdChkDet = new JButton("Update Check-in Details");
        btn_UpdChkDet.setBounds(30,310,200,30);
        btn_UpdChkDet.setBackground(Color.BLACK);
        btn_UpdChkDet.setForeground(Color.white);
        jPanel1.add(btn_UpdChkDet);
        btn_UpdChkDet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new UpdateCheck();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btn_UpdRmSts = new JButton("Update Room Status");
        btn_UpdRmSts.setBounds(30,350,200,30);
        btn_UpdRmSts.setBackground(Color.BLACK);
        btn_UpdRmSts.setForeground(Color.white);
        jPanel1.add(btn_UpdRmSts);
        btn_UpdRmSts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new UpdateRoom();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btn_PickSvs = new JButton("Pick up Service");
        btn_PickSvs.setBounds(30,390,200,30);
        btn_PickSvs.setBackground(Color.BLACK);
        btn_PickSvs.setForeground(Color.white);
        jPanel1.add(btn_PickSvs);
        btn_PickSvs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new PickUp();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btn_SerhRm = new JButton("Search Room");
        btn_SerhRm.setBounds(30,430,200,30);
        btn_SerhRm.setBackground(Color.BLACK);
        btn_SerhRm.setForeground(Color.white);
        jPanel1.add(btn_SerhRm);
        btn_SerhRm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new SearchRoom();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton LogOut = new JButton("LogOut");
        LogOut.setBounds(30,470,95,30);
        LogOut.setBackground(Color.BLACK);
        LogOut.setForeground(Color.white);
        jPanel1.add(LogOut);
        LogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    setVisible(false);
                    JOptionPane.showMessageDialog(null, "You LogOut Successfully");
                    System.out.println("Exit Code 500");
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(135,470,95,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        jPanel1.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    setVisible(false);
                    new DashBoard();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });




        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        setSize(1950,1090);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
