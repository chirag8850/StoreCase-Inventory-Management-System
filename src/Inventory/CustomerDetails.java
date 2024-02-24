package Inventory;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;

public class CustomerDetails extends JFrame implements ActionListener {

    JTable t1;
    JButton b1,b2,b3;
    JLabel l1,l2;
    Choice c1,c2;
    String id;

    String[] x = {"CustomerID","Nickname","Fullname","Location","Phone Number"};

    String[][] y = new String[200][5];

    int i=0,j=0;

    CustomerDetails(String id)
    {
       super("Customer Details");
       setSize(580,530);
       setLocation(400,200);
       setLayout(null);
       getContentPane().setBackground(Color.WHITE);

       this.id = id;

       l1 = new JLabel("Customer ID");
       l1.setBounds(20,20,100,20);
       add(l1);

       c1 = new Choice();
       c1.add("0");

       l2 = new JLabel("Location");
       l2.setBounds(280,20,80,20);
       add(l2);

       c2 = new Choice();
       c2.add("any");

       t1 = new JTable(y,x);

       try{
           Conn c = new Conn();
           String s1 = "select * from customers where userid = '"+id+"'";
           ResultSet rs = c.s.executeQuery(s1);
           t1.setModel(DbUtils.resultSetToTableModel(rs));

           String s2 = "select * from customers where userid = '"+id+"'";
           rs = c.s.executeQuery(s2);
           while(rs.next()) {
               c1.add(String.valueOf(rs.getInt("cid")));
           }

           String s3 = "select * from customers where userid = '"+id+"'";
           rs = c.s.executeQuery(s3);
           while (rs.next())
           {
               c2.add(rs.getString("location"));
           }
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }

       c1.setBounds(120,20,100,20);
       add(c1);

        b1 = new JButton("Search");
        b1.setBounds(20,60,100,20);
        b1.addActionListener(this);
        add(b1);

        c2.setBounds(360,20,100,20);
        add(c2);

        b2 = new JButton("Print");
        b2.setBounds(140,60,100,20);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("All");
        b3.setBounds(400,60,100,20);
        b3.addActionListener(this);
        add(b3);

       JScrollPane sp = new JScrollPane(t1);
       sp.setBounds(0,100,700,500);
       add(sp);
       b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            try {
                Conn n = new Conn();
                String a = c1.getSelectedItem();
                int cid = Integer.parseInt(a);

                String location = c2.getSelectedItem();
                String q;

                if(c1.getSelectedItem() == "0" && c2.getSelectedItem() == "any")
                {
                    q = "select * from customers where userid = '"+id+"'";
                }
                else if(c1.getSelectedItem() == "0")
                {
                    q = "select * from customers where location = '"+location+"' and userid = '"+id+"'";
                }
                else if(c2.getSelectedItem() == "any")
                {
                    q = "select * from customers where cid = '"+cid+"' and userid = '"+id+"'";
                }
                else {
                   q = "select * from customers where cid = '" + cid + "' and userid = '" + id + "' and location = '" + location + "'";
                }

                ResultSet rs = n.s.executeQuery(q);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else if(ae.getSource() == b3)
        {
            try{
                Conn c = new Conn();
                String s1 = "select * from customers where userid = '"+id+"'";
                ResultSet rs = c.s.executeQuery(s1);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e) {}
        }
        else if(ae.getSource() == b2) {
            try {
                t1.print();
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        new CustomerDetails("").setVisible(true);
    }
}
