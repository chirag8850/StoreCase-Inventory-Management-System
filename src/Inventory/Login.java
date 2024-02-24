package Inventory;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4;
    JTextField t1;
    JPasswordField ps1;
    Choice c1;
    JButton b1,b2,b3;

    Login()
    {
        super("Inventory Checkup");

        setLayout(null);

        l1 = new JLabel("UserName");
        l1.setBounds(290,20,100,20);
        add(l1);

        t1 = new JTextField(20);
        t1.setBounds(400,20,170,20);
        add(t1);

        l2 = new JLabel("Password");
        l2.setBounds(290,60,100,20);
        add(l2);

        ps1 = new JPasswordField(20);
        ps1.setBounds(400,60,170,20);
        add(ps1);

        l4 = new JLabel("LogIn as");
        l4.setBounds(290,100,100,20);
        add(l4);

        c1 = new Choice();
        c1.setBounds(400,100,170,20);
        c1.add("User");
        c1.add("Administrator");
        add(c1);

        // Login Page Image
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Resources/Inventoryicon.jpg"));
        Image i = ic.getImage().getScaledInstance(210,210,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i);
        l3 = new JLabel(ic2);
        l3.setBounds(0,0,250,250);
        add(l3);

        // Login Button
        ImageIcon ico3 = new ImageIcon(ClassLoader.getSystemResource("Resources/login.jpg"));
        Image i2 = ico3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        b1 = new JButton("Login",new ImageIcon(i2));
        b1.setBounds(320,160,100,20);
        b1.addActionListener(this);
        add(b1);

        // Cancel Button
        ImageIcon ico4 = new ImageIcon(ClassLoader.getSystemResource("Resources/Cancel.jpg"));
        Image i3 = ico4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        b2 = new JButton("Cancel",new ImageIcon(i3));
        b2.setBounds(450,160,100,20);
        b2.addActionListener(this);
        add(b2);

        // SignUp Button
        ImageIcon ico5 = new ImageIcon(ClassLoader.getSystemResource("Resources/sign_up.png"));
        Image i4 = ico5.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        b3 = new JButton("Sign Up",new ImageIcon(i4));
        b3.setBounds(380,200,130,20);
        b3.addActionListener(this);
        add(b3);

        setLayout(new BorderLayout());

        getContentPane().setBackground(Color.WHITE);
        setSize(640,300);
        setLocation(600,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1) {
            try {
                Conn n = new Conn();
                String s = t1.getText();
                String p = ps1.getText();

                String q = "select * from users where username = '" + s + "' and password = '" + p + "' and category = '"+c1.getSelectedItem()+"'";
                ResultSet rs = n.s.executeQuery(q);

                if (rs.next()) {

                     String ans = rs.getString("id");
                     String ans3 = rs.getString("center");
                    new Project(ans,c1.getSelectedItem(),ans3).setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    t1.setText("");
                    ps1.setText("");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error: " + e);
            }
        }
        else if(ae.getSource() == b2)
        {
            this.setVisible(false);
            System.exit(0);
        }
        else if(ae.getSource() == b3)
        {
            this.setVisible(false);
            new Signup().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
