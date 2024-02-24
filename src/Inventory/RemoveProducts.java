package Inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class RemoveProducts extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    Choice c1,c2;
    JButton b1,b2;
    String id;

    RemoveProducts(String id)
    {
        super("Remove Product");

        setLayout(null);
        setBounds(400,200,700,400);
        getContentPane().setBackground(new Color(173,216,230));

        this.id = id;

        JLabel title = new JLabel("Remove Product");
        title.setBounds(210,0,300,30);
        title.setFont(new Font("Tacoma",Font.PLAIN,30));
        add(title);

        l1 = new JLabel("Product Category");
        l1.setBounds(70,100,100,20);

        c1 = new Choice();
        c1.add("select");

        try{
            Conn n = new Conn();
            String q = "select * from products where userid = '"+id+"' group by category having count(*) > 0";
            ResultSet rs = n.s.executeQuery(q);

            while(rs.next())
            {
                c1.add(rs.getString("category"));
            }

        }catch (Exception e) {}

        c1.setBounds(200,100,130,20);
        add(l1);
        add(c1);

        l2 = new JLabel("Product Name");
        l2.setBounds(70,160,120,20);

        l3 = new JLabel();
        l3.setBounds(200,160,100,20);
        add(l2);
        add(l3);

        l4 = new JLabel("Price");
        l4.setBounds(70,220,120,20);

        l5 = new JLabel();
        l5.setBounds(200,220,100,20);
        add(l4);
        add(l5);

        l6 = new JLabel("Product ID");
        l6.setBounds(380,100,80,20);

        c2 = new Choice();
        c2.add("select");

        try
        {
            Conn n = new Conn();
            String q = "select * from products where userid = '"+id+"' and category = '"+c1.getSelectedItem()+"'";
            ResultSet rs = n.s.executeQuery(q);

            while(rs.next())
            {
                c1.add(rs.getString("pid"));
            }

        } catch (Exception e){}

        c2.setBounds(460,100,120,20);
        add(l6);
        add(c2);

        l7 = new JLabel("Brand");
        l7.setBounds(380,160,100,20);

        l10 = new JLabel();
        l10.setBounds(460,160,100,20);
        add(l7);
        add(l10);

        try
        {
            Conn n = new Conn();
            ResultSet rs = n.s.executeQuery("select * from products where pid = '"+c1.getSelectedItem()+"' and userid = '"+id+"'");

            while(rs.next())
            {
                l3.setText(rs.getString("productcode"));
                l5.setText(rs.getString("sellingprice"));
                l10.setText(rs.getString("brand"));
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

        c1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{

                    Conn n = new Conn();
                    ResultSet rs = n.s.executeQuery("select * from products where category = '"+c1.getSelectedItem()+"' and userid = '"+id+"'");

                    c2.removeAll();
                    c2.add("select");

                    while(rs.next())
                    {
                        c2.add(rs.getString("pid"));
                    }

                }catch (Exception ex) {}
            }
        });

        c2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try
                {
                    Conn n = new Conn();
                    ResultSet rs = n.s.executeQuery("select * from products where category = '"+c1.getSelectedItem()+"' and pid = '"+c2.getSelectedItem()+"' and userid = '"+id+"'");

                    l3.setText(null);
                    l5.setText(null);
                    l10.setText(null);

                    while(rs.next())
                    {
                        l3.setText(rs.getString("productcode"));
                        l5.setText(rs.getString("sellingprice"));
                        l10.setText(rs.getString("brand"));
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

                ResultSet rs = n.s.executeQuery("select * from products where pid = '"+c2.getSelectedItem()+"' and category = '"+c1.getSelectedItem()+"' and userid = '"+id+"'");
                if(rs.next()) {

                    n.s.executeUpdate("delete from stocks where productid = '"+c2.getSelectedItem()+"' and userid = '"+id+"'");
                    n.s.executeUpdate("delete from products where category = '" + c1.getSelectedItem() + "' and pid = '" + c2.getSelectedItem() + "' and userid = '" + id + "'");

                    ResultSet rs2 = n.s.executeQuery("select * from products where pid = '" + c2.getSelectedItem() + "' and category = '" + c1.getSelectedItem() + "' and userid = '" + id + "'");

                    if (!rs2.next()) {
                        JOptionPane.showMessageDialog(null, "Product Deleted");
                    } else {
                        JOptionPane.showMessageDialog(null, "Try Again");
                    }
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
        new RemoveProducts("").setVisible(true);
    }

}