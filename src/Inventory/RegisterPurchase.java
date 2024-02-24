package Inventory;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;

public class RegisterPurchase extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,ll5,ll51,ll1,ll2;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    Choice c1,c2,c3;
    String id;

    RegisterPurchase(String id)
    {
        setLocation(400,200);
        setSize(700,500);

        this.id = id;

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        JLabel title = new JLabel("Register Purchase");
        title.setBounds(200,10,290,30);
        title.setFont(new Font("Tacoma",Font.PLAIN,24));
        p.add(title);

        l1 = new JLabel("Product Category");
        l1.setBounds(100,80,100,20);

        c1 = new Choice();
        try
        {
            Conn c = new Conn();
            String s = "select * from products where userid = '"+id+"' group by category having count(*)>0 ";
            ResultSet rs = c.s.executeQuery(s);

            while (rs.next())
            {
                c1.add(rs.getString("category"));
            }
        }catch (Exception e) {}
        c1.setBounds(240,80,200,20);
        p.add(l1);
        p.add(c1);

        l2 = new JLabel("Product Name");
        l2.setBounds(100,120,100,20);

        c2 = new Choice();
        c2.add("select");
        try
        {
            Conn c = new Conn();
            String s = "select * from products where category = '"+c1.getSelectedItem()+"' and userid = '"+id+"'";
            ResultSet rs = c.s.executeQuery(s);

            while (rs.next())
            {
                c2.add(rs.getString("productcode"));
            }
        }catch (Exception e) {}
        c2.setBounds(240,120,200,20);
        p.add(l2);
        p.add(c2);

        l3 = new JLabel("Product ID");
        l3.setBounds(100,160,100,20);

        ll1 = new JLabel();
        ll1.setBounds(240,160,100,20);
        p.add(l3);
        p.add(ll1);

        l4 = new JLabel("Cost Price");
        l4.setBounds(100,200,100,20);

        ll2 = new JLabel();
        ll2.setBounds(240,200,100,20);
        p.add(l4);
        p.add(ll2);

        try{
            Conn n = new Conn();
            ResultSet rs = n.s.executeQuery("select * from products where productcode = '"+c2.getSelectedItem()+"' and category = '"+c1.getSelectedItem()+"' and userid = '"+id+"'");

            while (rs.next())
            {
                ll1.setText(rs.getString("pid"));
                ll2.setText(rs.getString("costprice"));
            }
        } catch (Exception e){}


        l5 = new JLabel("Supplier ID");
        l5.setBounds(100,240,100,20);

        c3 = new Choice();
        c3.setBounds(240,240,200,20);
        c3.add("select");

        try{
            Conn n = new Conn();
            ResultSet rs = n.s.executeQuery("select * from suppliers where userid = '"+id+"'");

            while(rs.next())
            {
                c3.add(rs.getString("sid"));
            }
        } catch (Exception e){}
        p.add(l5);
        p.add(c3);

        ll5 = new JLabel("Supplier NickName");
        ll5.setBounds(100,280,130,20);
        p.add(ll5);

        ll51 = new JLabel();
        ll51.setBounds(240,280,130,20);
        p.add(ll51);

        try{
            Conn n = new Conn();
            ResultSet rs = n.s.executeQuery("select * from suppliers where sid = '"+c3.getSelectedItem()+"' and userid = '"+id+"'");

            while(rs.next())
            {
                ll51.setText(rs.getString("suppliercode"));
            }

        }catch (Exception e){}

        l6 = new JLabel("Date of Purchase");
        l6.setBounds(100,320,100,20);

        t1 = new JTextField(20);
        t1.setBounds(240,320,200,20);
        p.add(l6);
        p.add(t1);

        l7 = new JLabel("Quantity");
        l7.setBounds(100,360,100,20);

        t2 = new JTextField(20);
        t2.setBounds(240,360,200,20);
        p.add(l7);
        p.add(t2);

        c1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn n = new Conn();
                    ResultSet rs = n.s.executeQuery("select * from products where category = '"+c1.getSelectedItem()+"' and userid = '"+id+"'");

                    c2.removeAll();
                    c2.add("select");
                    while (rs.next())
                    {
                        c2.add(rs.getString("productcode"));
                    }

                }catch (Exception exx) {};
            }
        });

        c2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try
                {
                    Conn n = new Conn();
                    ResultSet rs = n.s.executeQuery("select * from products where productcode = '" + c2.getSelectedItem() + "' and category = '" + c1.getSelectedItem() + "' and userid = '"+id+"'");

                    ll1.setText(null);
                    ll2.setText(null);
                    while(rs.next()) {
                        ll1.setText(rs.getString("pid"));
                        ll2.setText(rs.getString("costprice"));
                    }
                }catch (Exception exx) {}
            }
        });

        c3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try
                {
                    Conn n = new Conn();
                    ResultSet rs = n.s.executeQuery("select * from suppliers where sid = '"+c3.getSelectedItem()+"' and userid = '"+id+"'");

                    ll51.setText(null);
                    while(rs.next()) {
                        ll51.setText(rs.getString("suppliercode"));
                    }
                }catch (Exception ex){}
            }
        });

        b1 = new JButton("Submit");
        b1.setBounds(120,400,140,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);

        b2 = new JButton("Cancel");
        b2.setBounds(320,400,140,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);

        b1.addActionListener(this);
        b2.addActionListener(this);

        p.add(b1);
        p.add(b2);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Resources/bill_calculation.png"));
        Image i = ic.getImage().getScaledInstance(200,230,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i);
        JLabel ll = new JLabel(ic2);

        add(ll,"West");

        getContentPane().setBackground(Color.WHITE);

    }

    public void actionPerformed(ActionEvent ae)
    {
         if(ae.getSource() == b1)
         {
             try
             {
                 Conn n = new Conn();
                 String quantity = t2.getText();
                 float quan = Float.parseFloat(quantity);

                 ResultSet rs = n.s.executeQuery("select * from products where productcode = '"+c2.getSelectedItem()+"' and category = '"+c1.getSelectedItem()+"' and userid = '"+id+"'");
                 String cost = "";
                 int pid = Integer.parseInt(ll1.getText());
                 if(rs.next())
                 {
                    cost = rs.getString("costprice");
                 }
                  float price = Float.parseFloat(cost);

                 float ans = quan * price;

                 rs = n.s.executeQuery("select * from stocks where productid = '"+pid+"' and userid = '"+id+"'");
                 if(rs.next()) {
                     int qq = Integer.parseInt(quantity);
                     int qq2 = rs.getInt("quantity") + qq;
                     n.s.executeUpdate("update stocks set quantity = '" + qq2 + "' where productid = '" + pid + "'");

                     String s = "insert into purchaseinfo(supplierid,productcode,date,quantity,totalcost,productcategory,suppliercode,userid) values('" + c3.getSelectedItem() + "','" + c2.getSelectedItem() + "','" + t1.getText() + "','" + quan + "','" + ans + "','" + c1.getSelectedItem() + "','" + ll51.getText() + "','" + id + "')";
                     n.s.executeUpdate(s);

                     ResultSet rs2 = n.s.executeQuery("select * from purchaseinfo where supplierid = '" + c3.getSelectedItem() + "' and productcode = '" + c2.getSelectedItem() + "' and userid = '" + id + "'");
                     if (rs2.next()) {
                         JOptionPane.showMessageDialog(null, "Purchase registered \n Purchase ID: " + rs2.getString("purchaseid"));
                     }
                 }
                 else {
                     JOptionPane.showMessageDialog(null,"No such Product in records");
                 }
                  this.setVisible(false);
             }catch (Exception e)
             {
                 e.printStackTrace();
             }
         }
         else if(ae.getSource() == b2)
         {
             this.setVisible(false);
         }
    }

    public static void main(String[] args) {
        new RegisterPurchase("").setVisible(true);
    }
}
