package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class DashBoard extends JFrame implements ActionListener {
    JButton reception,admin;
    DashBoard(){
        super("Hotel Management System DashBoard");

        reception = new JButton("RECEPTION");
        reception.setBounds(425,510,140,30);
        reception.setFont(new Font("Tahoma", Font.BOLD,15));
        reception.setBackground(new Color(255,98,0));
        reception.setForeground(Color.white);
        reception.addActionListener(this);
        add(reception);

        admin = new JButton("ADMIN");
        admin.setBounds(880,510,140,30);
        admin.setFont(new Font("Tahoma", Font.BOLD,15));
        admin.setBackground(new Color(255,98,0));
        admin.setForeground(Color.white);
        admin.addActionListener(this);
        add(admin);

        ImageIcon adminImg = new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image adminImage = adminImg.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);
        ImageIcon adminImg2 = new ImageIcon(adminImage);
        JLabel jLabel = new JLabel(adminImg2);
        jLabel.setBounds(850,300,200,195);
        add(jLabel);

        ImageIcon receptionImg = new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
        Image receptionImage = receptionImg.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);
        ImageIcon receptionImg2 = new ImageIcon(receptionImage);
        JLabel jLabel3 = new JLabel(receptionImg2);
        jLabel3.setBounds(400,300,200,195);
        add(jLabel3);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));
        Image image = imageIcon.getImage().getScaledInstance(1950,1090, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel jLabel2 = new JLabel(imageIcon2);
        jLabel2.setBounds(0,0,1950,1090);
        add(jLabel2);



        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==reception){
            new Reception();
            setVisible(false);
        } else if (e.getSource()==admin) {
            try{
                new Login2();
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DashBoard();
    }
}
