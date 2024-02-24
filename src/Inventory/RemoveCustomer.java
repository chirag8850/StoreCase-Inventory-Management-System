package Inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class RemoveCustomer extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    Choice c;
    JButton b1,b2;
    String id;

    RemoveCustomer(String id)
    {
        super("Remove customer");

        setLayout(null);
        setBounds(400,200,700,400);
        getContentPane().setBackground(new Color(173,216,230));

        this.id = id;

        JLabel title = new JLabel("Remove Customer");
        title.setBounds(210,0,300,30);
        title.setFont(new Font("Tacoma",Font.PLAIN,30));
        add(title);

        l1 = new JLabel("Customer ID");
        l1.setBounds(70,100,100,20);

        c = new Choice();
        c.add("select");

        try{
            Conn n = new Conn();
            String q = "select * from customers where userid = '"+id+"'";
            ResultSet rs = n.s.executeQuery(q);

            while(rs.next())
            {
                c.add(rs.getString("cid"));
            }

        }catch (Exception e) {}

        c.setBounds(200,100,130,20);
        add(l1);
        add(c);

        l2 = new JLabel("Customer Nickname");
        l2.setBounds(70,160,120,20);

        l3 = new JLabel();
        l3.setBounds(200,160,100,20);
        add(l2);
        add(l3);

        l4 = new JLabel("Full Name");
        l4.setBounds(70,220,120,20);

        l5 = new JLabel();
        l5.setBounds(200,220,100,20);
        add(l4);
        add(l5);

        l6 = new JLabel("Location");
        l6.setBounds(380,100,120,20);

        l7 = new JLabel();
        l7.setBounds(460,100,100,20);
        add(l6);
        add(l7);

        l8 = new JLabel("Phone No.");
        l8.setBounds(380,160,120,20);

        l9 = new JLabel();
        l9.setBounds(460,160,100,20);
        add(l8);
        add(l9);

        try
        {
            Conn n = new Conn();
            ResultSet rs = n.s.executeQuery("select * from customers where cid = '"+c.getSelectedItem()+"' and userid = '"+id+"'");

            while(rs.next())
            {
                l3.setText(rs.getString("customercode"));
                l5.setText(rs.getString("fullname"));
                l7.setText(rs.getString("location"));
                l9.setText(rs.getString("phone"));
            }

        }catch (Exception e) {}

        b1 = new JButton("Delete");
        b1.setBounds(190,300,100,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(380,300,100,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);

        c.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{

                    Conn n = new Conn();
                    ResultSet rs = n.s.executeQuery("select * from customers where cid = '"+c.getSelectedItem()+"' and userid = '"+id+"'");

                    while(rs.next())
                    {
                        l3.setText(rs.getString("customercode"));
                        l5.setText(rs.getString("fullname"));
                        l7.setText(rs.getString("location"));
                        l9.setText(rs.getString("phone"));
                    }

                }catch (Exception ex) {}
            }
        });
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            try{

                Conn n = new Conn();
                n.s.executeUpdate("delete from customers where cid = '"+c.getSelectedItem()+"' and userid = '"+id+"'");

                ResultSet rs = n.s.executeQuery("select * from customers where cid = '"+c.getSelectedItem()+"' and userid = '"+id+"'");

                if(!rs.next())
                {
                    JOptionPane.showMessageDialog(null,"Customer Deleted");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Try Again");
                }

                this.setVisible(false);
            }catch (Exception e){};
        }
        else if(ae.getSource() == b2)
        {
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new RemoveCustomer("").setVisible(true);
    }

}
