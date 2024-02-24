package Inventory;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class SalesReport extends JFrame implements ActionListener{

    JLabel l1,l2;
    JButton b1;
    Choice c1,c2;
    JTextArea ta1;
    JPanel p1;
    String id;

    SalesReport(String id)
    {
        setSize(500,700);
        setLayout(new BorderLayout());

        p1 = new JPanel();
        this.id = id;
        int idnum = Integer.parseInt(id);

        l1 = new JLabel("Customer ID");
        p1.add(l1);

        c1 = new Choice();
        c1.add("select");
        try
        {
            Conn n = new Conn();
            ResultSet rs = n.s.executeQuery("select * from salesreport where userid = '"+idnum+"' group by customerid having count(*)>0 ");

            while (rs.next())
            {
                c1.add(rs.getString("customerid"));
            }
        }
        catch (Exception e){}
        p1.add(c1);

        l2 = new JLabel("Sales ID");
        p1.add(l2);

        c2 = new Choice();
        c2.add("select");
        /*try
        {
            Conn n = new Conn();
            int cusid = Integer.parseInt(c1.getSelectedItem());
            ResultSet rs = n.s.executeQuery("select * from salesreport where userid = '"+idnum+"' and customerid = '"+cusid+"'");

            while (rs.next())
            {
                c2.add(rs.getString("salesid"));
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Hi");
        }*/
        p1.add(c2);

        c1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn n = new Conn();
                    int cusid = Integer.parseInt(c1.getSelectedItem());
                    ResultSet rs = n.s.executeQuery("select * from salesreport where userid = '"+idnum+"' and customerid = '"+cusid+"'");


                    c2.removeAll();
                    c2.add("select");
                    while (rs.next())
                    {
                        c2.add(rs.getString("salesid"));
                    }

                }catch (Exception exx) {};
            }
        });

        ta1 = new JTextArea(50,15);
        JScrollPane jsp = new JScrollPane(ta1);
        ta1.setFont(new Font("Sanserif",Font.ITALIC,18));

        b1 = new JButton("Generate Invoice");

        add(p1,"North");

        add(jsp,"Center");
        add(b1,"South");

        b1.addActionListener(this);

        setLocation(350,40);
    }

    public void actionPerformed(ActionEvent ae)
    {
        try{
            Conn n = new Conn();

            int salid = Integer.parseInt(c2.getSelectedItem());

            ResultSet rs = n.s.executeQuery("select * from salesreport where customerid = '"+c1.getSelectedItem()+"' and salesid = '"+salid+"'");

            ta1.setText("                       Report for Sale ID : "+salid+"                         \n");
            if(rs.next())
            {
                ta1.append("\n    Customer Name:      "+rs.getString("customercode")+"\n");
                ta1.append("\n    Product Category:   "+rs.getString("productcategory")+"\n");
                ta1.append("\n    Product Name:       "+rs.getString("productcode")+"\n");
                ta1.append("\n    Date of Sale:   "+rs.getString("date")+"\n");
                ta1.append("\n    Sale Quantity:  "+rs.getString("quantity")+"\n");
                ta1.append("\n    Total Earning:         "+rs.getString("revenue")+"\n");
                ta1.append("\n--------------------------------------------------------------------------------------");
                ta1.append("\n");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SalesReport("0").setVisible(true);
    }
}