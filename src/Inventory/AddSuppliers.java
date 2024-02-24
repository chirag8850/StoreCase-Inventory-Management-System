package Inventory;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class AddSuppliers extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    String id;

    AddSuppliers(String id)
    {
        setLocation(400,200);
        setSize(700,400);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        this.id = id;

        JLabel title = new JLabel("New Suppliers");
        title.setBounds(200,10,200,26);
        title.setFont(new Font("Tacoma",Font.PLAIN,24));
        p.add(title);

        l1 = new JLabel("Nick Name");
        l1.setBounds(100,80,100,20);

        t1 = new JTextField();
        t1.setBounds(240,80,200,20);
        p.add(l1);
        p.add(t1);

        l2 = new JLabel("Full Name");
        l2.setBounds(100,120,100,20);

        t2 = new JTextField();
        t2.setBounds(240,120,200,20);
        p.add(l2);
        p.add(t2);

        l3 = new JLabel("Location");
        l3.setBounds(100,160,100,20);

        t3 = new JTextField();
        t3.setBounds(240,160,200,20);
        p.add(l3);
        p.add(t3);

        l4 = new JLabel("Phone No");
        l4.setBounds(100,200,100,20);

        t4 = new JTextField();
        t4.setBounds(240,200,200,20);
        p.add(l4);
        p.add(t4);

        b1 = new JButton("Create");
        b1.setBounds(100,280,140,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);

        b2 = new JButton("Cancel");
        b2.setBounds(300,280,140,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);

        b1.addActionListener(this);
        b2.addActionListener(this);

        p.add(b1);
        p.add(b2);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Resources/add_supplier.png"));
        Image i = ic.getImage().getScaledInstance(220,260,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i);
        JLabel ll = new JLabel(ic2);

        add(ll,"West");

        getContentPane().setBackground(Color.WHITE);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == b1) {
            int x;
            String nick = t1.getText();
            String fullname = t2.getText();
            String Location = t3.getText();
            String Phone = t4.getText();

            String q = "insert into suppliers(suppliercode,fullname,location,phone,userid) values('" + nick + "','" + fullname + "','" + Location + "','" + Phone + "','"+id+"')";
            String q1 = "select sid from suppliers where suppliercode = '" + nick + "' and userid = '"+id+"' and phone = '" + Phone + "'";

            try {
                Conn c1 = new Conn();
                c1.s.executeUpdate(q);
                ResultSet rs = c1.s.executeQuery(q1);

                if (rs.next()) {
                    x = rs.getInt("sid");
                    JOptionPane.showMessageDialog(null, "Supplier Created\n Supplier ID:" + x);
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
        new AddSuppliers("").setVisible(true);
    }
}
