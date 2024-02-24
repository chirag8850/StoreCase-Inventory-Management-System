package Inventory;

import javax.swing.*;
import java.awt.event.*;
import  java.awt.*;
import java.sql.*;

public class AddUsers extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    Choice c;
    JButton b1,b2;
    String center,id;
    int idnum;

     public AddUsers(String center, String id)
    {
        setLocation(400,200);
        setSize(700,490);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        this.center = center;
        this.id = id;
        idnum = Integer.parseInt(id);

        JLabel title = new JLabel("New User");
        title.setBounds(200,10,200,26);
        title.setFont(new Font("Tacoma",Font.PLAIN,24));
        p.add(title);

        l1 = new JLabel("Full Name");
        l1.setBounds(100,80,100,20);

        t1 = new JTextField();
        t1.setBounds(240,80,200,20);
        p.add(l1);
        p.add(t1);

        l2 = new JLabel("Location");
        l2.setBounds(100,120,100,20);

        t2 = new JTextField();
        t2.setBounds(240,120,200,20);
        p.add(l2);
        p.add(t2);

        l3 = new JLabel("Phone No.");
        l3.setBounds(100,160,100,20);

        t3 = new JTextField();
        t3.setBounds(240,160,200,20);
        p.add(l3);
        p.add(t3);

        l4 = new JLabel("Username");
        l4.setBounds(100,200,100,20);

        t4 = new JTextField();
        t4.setBounds(240,200,200,20);
        p.add(l4);
        p.add(t4);

        l5 = new JLabel("Password");
        l5.setBounds(100,240,100,20);

        t5 = new JTextField();
        t5.setBounds(240,240,200,20);
        p.add(l5);
        p.add(t5);

        l6 = new JLabel("Shop No.");
        l6.setBounds(100,280,100,20);

        t6 = new JTextField();
        t6.setBounds(240,280,200,20);
        p.add(l6);
        p.add(t6);

        b1 = new JButton("Create");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);

        b2 = new JButton("Cancel");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);

        if(idnum == 100)
        {
            l7 = new JLabel("Category");
            l7.setBounds(100,320,100,20);

            c = new Choice();
            c.setBounds(240,320,200,20);
            c.add("User");
            c.add("Administrator");
            p.add(l7);
            p.add(c);

            l8 = new JLabel("Center");
            l8.setBounds(100,360,100,20);

            t7 = new JTextField();
            t7.setBounds(240,360,200,20);
            p.add(l8);
            p.add(t7);

            b1.setBounds(120,400,140,30);
            b2.setBounds(320,400,140,30);
        }
        else
        {
            b1.setBounds(120,320,140,30);
            b2.setBounds(320,320,140,30);
        }

        b1.addActionListener(this);
        b2.addActionListener(this);

        p.add(b1);
        p.add(b2);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Resources/deposit_details.jpg"));
        Image i = ic.getImage().getScaledInstance(150,260,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i);
        JLabel ll = new JLabel(ic2);

        add(ll,"West");

        getContentPane().setBackground(Color.WHITE);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
            int x;
            String fullname = t1.getText();
            String location = t2.getText();
            String phone = t3.getText();
            String username = t4.getText();
            String password = t5.getText();
            String shop = t6.getText();
            String category = "User";

            String q;
            String q1;
            if(idnum == 100)
            {
                q = "insert into users(fullname,location,phone,username,password,category,shop_no,center) values('" + fullname + "','" + location + "','" + phone + "','" + username + "','" + password + "','" + c.getSelectedItem() + "','" + shop + "','" + t7.getText() + "')";
                q1 = "select * from users where fullname = '" + fullname + "' and center = '"+t7.getText()+"' and  phone = '" + phone + "' and category = '"+c.getSelectedItem()+"'";
            }
            else {
                q = "insert into users(fullname,location,phone,username,password,category,shop_no,center) values('" + fullname + "','" + location + "','" + phone + "','" + username + "','" + password + "','" + category + "','" + shop + "','" + center + "')";
                q1 = "select * from users where fullname = '" + fullname + "' and center = '"+center+"' and  phone = '" + phone + "' and category = '"+category+"'";
            }

                Conn c1 = new Conn();
                c1.s.executeUpdate(q);
                ResultSet rs = c1.s.executeQuery(q1);

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "User Created\n User ID:" + rs.getString("id"));
                    this.setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == b2)
        {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddUsers("","0").setVisible(true);
    }
}