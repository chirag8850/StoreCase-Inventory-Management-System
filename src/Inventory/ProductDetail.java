package Inventory;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;

public class ProductDetail extends JFrame implements ActionListener {

    JTable t1;
    JButton b1,b2,b3;
    JLabel l1,l2;
    Choice c1,c2;
    String id;

    String[] x = {"ProductID","Productname","Cost Price","Selling Price","Brand","Category"};

    String[][] y = new String[200][5];

    int i=0,j=0;

    ProductDetail(String id)
    {
        super("Product Details");
        setSize(610,530);
        setLocation(400,200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        this.id = id;

        l1 = new JLabel("Product ID");
        l1.setBounds(20,20,100,20);
        add(l1);

        c1 = new Choice();
        c1.add("0");

        l2 = new JLabel("Category");
        l2.setBounds(280,20,80,20);
        add(l2);

        c2 = new Choice();
        c2.add("any");

        t1 = new JTable(y,x);

        try{
            Conn c = new Conn();
            String s1 = "select * from products where userid = '"+id+"'";
            ResultSet rs = c.s.executeQuery(s1);
            t1.setModel(DbUtils.resultSetToTableModel(rs));

            String s2 = "select * from products where userid = '"+id+"'";
            rs = c.s.executeQuery(s2);
            while(rs.next()) {
                c1.add(String.valueOf(rs.getInt("pid")));
            }

            String s3 = "select * from products where userid = '"+id+"' group by category having count(*)>0";
            rs = c.s.executeQuery(s3);
            while (rs.next())
            {
                c2.add(rs.getString("category"));
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
        b3.setBounds(480,60,100,20);
        b3.addActionListener(this);
        add(b3);

        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(0,100,700,500);
        add(sp);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            try {
                Conn n = new Conn();
                String a = c1.getSelectedItem();
                int pid = Integer.parseInt(a);

                String category = c2.getSelectedItem();
                String q;

                if(c1.getSelectedItem() == "0" && c2.getSelectedItem() == "any")
                {
                    q = "select * from products where userid = '"+id+"'";
                }
                else if(c1.getSelectedItem() == "0" )
                {
                    q = "select * from products where category = '"+category+"' and userid = '"+id+"'";
                }
                else if(c2.getSelectedItem() == "any")
                {
                    q = "select * from products where pid = '"+pid+"' and userid = '"+id+"'";
                }
                else {
                    q = "select * from products where pid = '" + pid + "' and category = '" + category + "' and userid = '" + id + "'";
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
                String s1 = "select * from products where userid = '"+id+"'";
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
        new ProductDetail("").setVisible(true);
    }
}
