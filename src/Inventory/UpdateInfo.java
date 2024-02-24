package Inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateInfo extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,ll1,ll2,ll5;
    JTextField ll3,ll4,ll6,ll7;
    JButton B,B1;
    String id;
    UpdateInfo(String id)
    {
       super("Update");

       setBounds(300,200,900,470);
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);

       this.id = id;

       JLabel title = new JLabel("Update Profile");
       title.setBounds(60,20,140,30);
       title.setFont(new Font("Tacoma",Font.PLAIN,20));
       add(title);

        l1 = new JLabel("User ID");
        l1.setBounds(70,80,100,30);
        add(l1);

        ll1 = new JLabel();
        ll1.setBounds(250,80,120,20);
        add(ll1);

        l2 = new JLabel("Name");
        l2.setBounds(70,120,100,30);
        add(l2);

        ll2 = new JLabel();
        ll2.setBounds(250,120,120,20);
        add(ll2);

        l3 = new JLabel("User Name");
        l3.setBounds(70,160,100,30);
        add(l3);

        ll3 = new JTextField(20);
        ll3.setBounds(250,160,120,20);
        add(ll3);

        l4 = new JLabel("Email");
        l4.setBounds(70,200,100,30);
        add(l4);

        ll4 = new JTextField(20);
        ll4.setBounds(250,200,140,20);
        add(ll4);

        l5 = new JLabel("Shop No");
        l5.setBounds(70,240,100,30);
        add(l5);

        ll5 = new JLabel();
        ll5.setBounds(250,240,120,20);
        add(ll5);

        l6 = new JLabel("Location");
        l6.setBounds(70,280,100,30);
        add(l6);

        ll6 = new JTextField(20);
        ll6.setBounds(250,280,120,20);
        add(ll6);

        l7 = new JLabel("Phone No.");
        l7.setBounds(70,320,100,30);
        add(l7);

        ll7 = new JTextField(20);
        ll7.setBounds(250,320,120,20);
        add(ll7);

        try{
            Conn n = new Conn();
            ResultSet rs = n.s.executeQuery("select * from users where id = '"+id+"'");

            while(rs.next())
            {
                ll1.setText(rs.getString("id"));
                ll2.setText(rs.getString("fullname"));
                ll3.setText(rs.getString("username"));
                ll4.setText(rs.getString("email"));
                ll5.setText(rs.getString("shop_no"));
                ll6.setText(rs.getString("location"));
                ll7.setText(rs.getString("phone"));
            }
        } catch (Exception e) {}

        B = new JButton("Update");
        B.setBackground(Color.BLACK);
        B.setForeground(Color.WHITE);
        B.setBounds(90,380,100,25);
        B.addActionListener(this);
        add(B);

        B1 = new JButton("Back");
        B1.setBackground(Color.BLACK);
        B1.setForeground(Color.WHITE);
        B1.setBounds(240,380,100,25);
        B1.addActionListener(this);
        add(B1);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Resources/update_info.png"));
        Image imc = ic.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(imc);
        JLabel lim = new JLabel(ic1);
        lim.setBounds(400,10,500,400);
        add(lim);

    }

    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource() == B)
       {
           try{
               Conn n = new Conn();
                n.s.executeUpdate("update users set username = '"+ll3.getText()+"', location = '"+ll6.getText()+"', phone = '"+ll7.getText()+"', email = '"+ll4.getText()+"' where id = '"+id+"'");

                JOptionPane.showMessageDialog(null,"Profile Updated");
                this.setVisible(false);
           } catch (Exception e) {}
       }
       else if(ae.getSource() == B1)
       {
           this.setVisible(false);
           new Profile(id).setVisible(true);
       }
    }

    public static void main(String[] args) {
        new UpdateInfo("").setVisible(true);
    }
}
