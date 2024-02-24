package Inventory;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {

    JPanel p1;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c1;

    Signup()
    {
        super("Create");

        setBounds(400,250,700,400);

        p1 = new JPanel();
        p1.setBounds(30,30,650,300);
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        p1.setForeground(new Color(34,139,34));
        p1.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create User",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(173,216,230)));
        add(p1);

        l1 = new JLabel("FullName");
        l1.setForeground(Color.DARK_GRAY);
        l1.setFont(new Font("Tacoma",Font.BOLD,14));
        l1.setBounds(100,50,100,20);
        p1.add(l1);

        t1 = new JTextField();
        t1.setBounds(260,50,150,20);
        p1.add(t1);

        l7 = new JLabel("Email Address");
        l7.setForeground(Color.DARK_GRAY);
        l7.setFont(new Font("Tacoma",Font.BOLD,14));
        l7.setBounds(100,90,120,20);
        p1.add(l7);

        t7 = new JTextField();
        t7.setBounds(260,90,150,20);
        p1.add(t7);

        l2 = new JLabel("Username");
        l2.setForeground(Color.DARK_GRAY);
        l2.setFont(new Font("Tacoma",Font.BOLD,14));
        l2.setBounds(100,130,100,20);
        p1.add(l2);

        t2 = new JTextField();
        t2.setBounds(260,130,150,20);
        p1.add(t2);

        l3 = new JLabel("Password");
        l3.setForeground(Color.DARK_GRAY);
        l3.setFont(new Font("Tacoma",Font.BOLD,14));
        l3.setBounds(100,170,100,20);
        p1.add(l3);

        t3 = new JTextField();
        t3.setBounds(260,170,150,20);
        p1.add(t3);

        l4 = new JLabel("UserType");
        l4.setForeground(Color.DARK_GRAY);
        l4.setFont(new Font("Tacoma",Font.BOLD,14));
        l4.setBounds(100,210,100,20);
        p1.add(l4);

        l5 = new JLabel("User ID");
        l5.setForeground(Color.DARK_GRAY);
        l5.setFont(new Font("Tacoma",Font.BOLD,14));
        l5.setBounds(100,250,100,20);
        p1.add(l5);

        t5 = new JTextField();
        t5.setBounds(260,250,150,20);
        p1.add(t5);

        l6 = new JLabel("Admin ID");
        l6.setForeground(Color.DARK_GRAY);
        l6.setFont(new Font("Tacoma",Font.BOLD,14));
        l6.setBounds(100,250,100,20);
        l6.setVisible(false);
        p1.add(l6);

        t6 = new JTextField();
        t6.setBounds(260,250,150,20);
        t6.setVisible(false);
        p1.add(t6);

        c1 = new Choice();
        c1.setBounds(260,210,150,20);
        c1.add("User");
        c1.add("Administrator");
        c1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = c1.getSelectedItem();

                if(user.equals("User"))
                {
                    l6.setVisible(false);
                    t6.setVisible(false);
                    l5.setVisible(true);
                    t5.setVisible(true);

                }
                else
                {
                    l5.setVisible(false);
                    t5.setVisible(false);
                    l6.setVisible(true);
                    t6.setVisible(true);
                }
            }
        });
        p1.add(c1);

        b1 = new JButton("Create");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(140,300,120,30);
        p1.add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300,300,120,30);
        p1.add(b2);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Resources/customer_registration.png"));
        Image i = ic.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(i);

        JLabel l7 = new JLabel(ic1);
        l7.setBounds(450,30,250,250);
        p1.add(l7);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            try
            {
                Conn n = new Conn();
                String fullname = t1.getText();
                String username = t2.getText();
                String password = t3.getText();
                String email = t7.getText();
                String user = c1.getSelectedItem();
                String q = null;

                if(user.equals("User")) {
                    String user_id = t5.getText();
                    int u = Integer.parseInt(user_id);

                    q = "update users set fullname = '"+fullname+"',username = '"+username+"',password = '"+password+"', email = '"+email+"' where id ='"+u+"' and category = '"+user+"'";
                }
                else {
                    String admin_id = t6.getText();
                    int a = Integer.parseInt(admin_id);

                    q = "update users set fullname = '"+fullname+"',username = '"+username+"',password = '"+password+"', email = '"+email+"' where id ='"+a+"' and category = '"+user+"'";
                }
                n.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Account Created");
                this.setVisible(false);
                new Login().setVisible(true);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Invalid Details");
                e.printStackTrace();
            }
        }
        else if( ae.getSource() == b2)
        {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }
}
