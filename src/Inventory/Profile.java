package Inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Profile extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton B,B1;
    String id;
    Profile(String id)
    {
        setBounds(380,160,800,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        this.id = id;

        JLabel title = new JLabel("PROFILE");
        title.setBounds(300,0,500,40);
        title.setFont(new Font("Tacoma",Font.PLAIN,30));
        add(title);

        l1 = new JLabel("User ID");
        l1.setBounds(70,80,100,30);
        add(l1);

        JLabel ll1 = new JLabel();
        ll1.setBounds(250,80,100,30);
        add(ll1);

        l2 = new JLabel("Name");
        l2.setBounds(70,140,100,30);
        add(l2);

        JLabel ll2 = new JLabel();
        ll2.setBounds(250,140,100,30);
        add(ll2);

        l3 = new JLabel("User Name");
        l3.setBounds(70,200,100,30);
        add(l3);

        JLabel ll3 = new JLabel();
        ll3.setBounds(250,200,100,30);
        add(ll3);

        l4 = new JLabel("Email");
        l4.setBounds(70,260,100,30);
        add(l4);

        JLabel ll4 = new JLabel();
        ll4.setBounds(250,260,180,30);
        add(ll4);

        l5 = new JLabel("Shop No");
        l5.setBounds(500,80,100,30);
        add(l5);

        JLabel ll5 = new JLabel();
        ll5.setBounds(650,80,100,30);
        add(ll5);

        l6 = new JLabel("Location");
        l6.setBounds(500,140,100,30);
        add(l6);

        JLabel ll6 = new JLabel();
        ll6.setBounds(650,140,100,30);
        add(ll6);

        l7 = new JLabel("Phone No.");
        l7.setBounds(500,200,100,30);
        add(l7);

        JLabel ll7 = new JLabel();
        ll7.setBounds(650,200,100,30);
        add(ll7);

        try{
            Conn n = new Conn();
            ResultSet rs = n.s.executeQuery("select * from users where id = '"+id+"'");

            while (rs.next())
            {
                ll1.setText(rs.getString("id"));
                ll2.setText(rs.getString("fullname"));
                ll3.setText(rs.getString("username"));
                ll4.setText(rs.getString("email"));
                ll5.setText(rs.getString("shop_no"));
                ll6.setText(rs.getString("location"));
                ll7.setText(rs.getString("phone"));
            }

        }catch (Exception e) {}

        B = new JButton("Update");
        B.setBackground(Color.BLACK);
        B.setForeground(Color.WHITE);
        B.setBounds(220,320,100,25);
        B.addActionListener(this);
        add(B);

        B1 = new JButton("Back");
        B1.setBackground(Color.BLACK);
        B1.setForeground(Color.WHITE);
        B1.setBounds(400,320,100,25);
        B1.addActionListener(this);
        add(B1);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Resources/viewcustomer.jpg"));
        Image im = ic.getImage().getScaledInstance(600,310,Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(im);
        JLabel iml = new JLabel(ic1);
        iml.setBounds(20,320,600,310);
        add(iml);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == B)
        {
            new UpdateInfo(id).setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == B1){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Profile("").setVisible(true);
    }
}
