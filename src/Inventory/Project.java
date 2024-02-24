package Inventory;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Project extends JFrame implements ActionListener {
    String id,type, center;
    Project(String id, String type,String center)
    {
        super("Inventory Manager");
        this.id = id;
        this.type = type;
        this.center = center;


        setSize(1480,1030);

        // Adding background image
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("Resources/inventorybackground.jfif"));
        Image im = ic1.getImage().getScaledInstance(1800,950,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(im);
        JLabel l = new JLabel(ic2);
        add(l);

        // Menu bar
        JMenuBar m = new JMenuBar();

        // First Column
        JMenu User = new JMenu("User");
        JMenuItem u1 = new JMenuItem("Stocks");
        JMenuItem u2 = new JMenuItem("Profile");
        User.setForeground(Color.BLUE);

        // Stocks
        ImageIcon ui1 = new ImageIcon(ClassLoader.getSystemResource("Resources/currentstocks.png"));
        Image uim1 = ui1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        u1.setIcon(new ImageIcon(uim1));
        u1.setMnemonic('A');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        u1.setBackground(Color.WHITE);

        // Profile
        ImageIcon ui2 = new ImageIcon(ClassLoader.getSystemResource("Resources/profile.png"));
        Image uim2 = ui2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        u2.setIcon(new ImageIcon(uim2));
        u2.setMnemonic('B');
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        u2.setBackground(Color.WHITE);

        u1.addActionListener(this);
        u2.addActionListener(this);

        User.add(u1);
        User.add(u2);

        //-------------------------------------------------------------------------------------------------------------
        // Column
        JMenu AProfile = new JMenu("Profile");
        JMenuItem ap1 = new JMenuItem("Admin Profile");;
        AProfile.setForeground(Color.BLUE);

        // Profile
        ImageIcon ap2 = new ImageIcon(ClassLoader.getSystemResource("Resources/profile.png"));
        Image apm2 = ap2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ap1.setIcon(new ImageIcon(apm2));
        ap1.setMnemonic('C');
        ap1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        ap1.setBackground(Color.WHITE);

        ap1.addActionListener(this);

        AProfile.add(ap1);

        // Column
        JMenu AUser = new JMenu("Users");
        JMenuItem au1 = new JMenuItem("User Details");
        JMenuItem au2 = new JMenuItem("Add User");
        JMenuItem au3 = new JMenuItem("Remove User");
        AUser.setForeground(Color.BLUE);

        // Stocks
        ImageIcon aui1 = new ImageIcon(ClassLoader.getSystemResource("Resources/currentstocks.png"));
        Image auim1 = aui1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        au1.setIcon(new ImageIcon(auim1));
        au1.setMnemonic('D');
        au1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        au1.setBackground(Color.WHITE);

        // Profile
        ImageIcon aui2 = new ImageIcon(ClassLoader.getSystemResource("Resources/profile.png"));
        Image auim2 = aui2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        au2.setIcon(new ImageIcon(auim2));
        au2.setMnemonic('E');
        au2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        au2.setBackground(Color.WHITE);

        ImageIcon aui3 = new ImageIcon(ClassLoader.getSystemResource("Resources/profile.png"));
        Image auim3 = aui3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        au3.setIcon(new ImageIcon(auim3));
        au3.setMnemonic('F');
        au3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        au3.setBackground(Color.WHITE);

        au1.addActionListener(this);
        au2.addActionListener(this);
        au3.addActionListener(this);

        AUser.add(au1);
        AUser.add(au2);
        AUser.add(au3);

        //--------------------------------------------------------------------------------------------------------------

        // Second Column
        JMenu Customer = new JMenu("Customer");
        JMenuItem c1 = new JMenuItem("Customer Details");
        JMenuItem c2 = new JMenuItem("Add Customers");
        JMenuItem c3 = new JMenuItem("Remove Customers");
        Customer.setForeground(Color.RED);

        // Customer Details
        ImageIcon ci1 = new ImageIcon(ClassLoader.getSystemResource("Resources/customer_details.png"));
        Image cim1 = ci1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        c1.setIcon(new ImageIcon(cim1));
        c1.setMnemonic('G');
        c1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        c1.setBackground(Color.WHITE);

        // Add Customers
        ImageIcon ci2 = new ImageIcon(ClassLoader.getSystemResource("Resources/new_customer.png"));
        Image cim2 = ci2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        c2.setIcon(new ImageIcon(cim2));
        c2.setMnemonic('H');
        c2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        c2.setBackground(Color.WHITE);

        // Remove Customers
        ImageIcon ci3 = new ImageIcon(ClassLoader.getSystemResource("Resources/remove_customer.png"));
        Image cim3 = ci3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        c3.setIcon(new ImageIcon(cim3));
        c3.setMnemonic('I');
        c3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        c3.setBackground(Color.WHITE);

        c1.addActionListener(this);
        c2.addActionListener(this);
        c3.addActionListener(this);

        Customer.add(c1);
        Customer.add(c2);
        Customer.add(c3);

        //-------------------------------------------------------------------------------------------------------------

        // Third Column
        JMenu Supplier = new JMenu("Suppliers");
        JMenuItem s1 = new JMenuItem("Supplier Details");
        JMenuItem s2 = new JMenuItem("Add Suppliers");
        JMenuItem s3 = new JMenuItem("Remove Suppliers");
        Supplier.setForeground(Color.BLUE);

        // Supplier Details
        ImageIcon si1 = new ImageIcon(ClassLoader.getSystemResource("Resources/supplier_details.jpg"));
        Image sim1 = si1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        s1.setIcon(new ImageIcon(sim1));
        s1.setMnemonic('J');
        s1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, ActionEvent.CTRL_MASK));
        s1.setBackground(Color.WHITE);

        // Add Suppliers
        ImageIcon si2 = new ImageIcon(ClassLoader.getSystemResource("Resources/add_supplier.png"));
        Image sim2 = si2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        s2.setIcon(new ImageIcon(sim2));
        s2.setMnemonic('K');
        s2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
        s2.setBackground(Color.WHITE);

        // Remove Suppliers
        ImageIcon si3 = new ImageIcon(ClassLoader.getSystemResource("Resources/remove_supplier.jpg"));
        Image sim3 = si3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        s3.setIcon(new ImageIcon(sim3));
        s3.setMnemonic('L');
        s3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        s3.setBackground(Color.WHITE);

        s1.addActionListener(this);
        s2.addActionListener(this);
        s3.addActionListener(this);

        Supplier.add(s1);
        Supplier.add(s2);
        Supplier.add(s3);

        //--------------------------------------------------------------------------------------------------------------

        // Third Column
        JMenu Products = new JMenu("Products");
        JMenuItem p1 = new JMenuItem("Product Details");
        JMenuItem p2 = new JMenuItem("Add Products");
        JMenuItem p3 = new JMenuItem("Remove Products");
        Products.setForeground(Color.RED);

        // Product Details
        ImageIcon pi1 = new ImageIcon(ClassLoader.getSystemResource("Resources/supplier_details.jpg"));
        Image pim1 = pi1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        p1.setIcon(new ImageIcon(pim1));
        p1.setMnemonic('M');
        p1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        p1.setBackground(Color.WHITE);

        // Add Products
        ImageIcon pi2 = new ImageIcon(ClassLoader.getSystemResource("Resources/add_supplier.png"));
        Image pim2 = pi2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        p2.setIcon(new ImageIcon(pim2));
        p2.setMnemonic('N');
        p2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        p2.setBackground(Color.WHITE);

        // Remove Suppliers
        ImageIcon pi3 = new ImageIcon(ClassLoader.getSystemResource("Resources/remove_supplier.jpg"));
        Image pim3 = pi3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        p3.setIcon(new ImageIcon(pim3));
        p3.setMnemonic('O');
        p3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        p3.setBackground(Color.WHITE);

        p1.addActionListener(this);
        p2.addActionListener(this);
        p3.addActionListener(this);

        Products.add(p1);
        Products.add(p2);
        Products.add(p3);

        //--------------------------------------------------------------------------------------------------------------

        // Third Column
        JMenu Details = new JMenu("Register");
        JMenuItem d1 = new JMenuItem("Register Purchase");
        JMenuItem d2 = new JMenuItem("Register Sales");
        Details.setForeground(Color.BLUE);

        //Product info
        d1.setFont(new Font("monospaced",Font.BOLD,12));
        ImageIcon di1 = new ImageIcon(ClassLoader.getSystemResource("Resources/Product_info.png"));
        Image dim1 = di1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        d1.setIcon(new ImageIcon(dim1));
        d1.setMnemonic('P');
        d1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        d1.setBackground(Color.WHITE);

        // Sales Report
        d2.setFont(new Font("monospaced",Font.BOLD,12));
        ImageIcon di2 = new ImageIcon(ClassLoader.getSystemResource("Resources/Salesreport.jfif"));
        Image dim2 = di2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        d2.setIcon(new ImageIcon(dim2));
        d2.setMnemonic('Q');
        d2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
        d2.setBackground(Color.WHITE);

        d1.addActionListener(this);
        d2.addActionListener(this);

        Details.add(d1);
        Details.add(d2);

        //--------------------------------------------------------------------------------------------------------------

        // Third Column
        JMenu Report = new JMenu("Report");
        JMenuItem r1 = new JMenuItem("Purchase Report");
        JMenuItem r2 = new JMenuItem("Sales Report");
        Report.setForeground(Color.RED);

        //Product info
        r1.setFont(new Font("monospaced",Font.BOLD,12));
        ImageIcon ri1 = new ImageIcon(ClassLoader.getSystemResource("Resources/Product_info.png"));
        Image rim1 = ri1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        r1.setIcon(new ImageIcon(rim1));
        r1.setMnemonic('R');
        r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        r1.setBackground(Color.WHITE);

        // Sales Report
        r2.setFont(new Font("monospaced",Font.BOLD,12));
        ImageIcon ri2 = new ImageIcon(ClassLoader.getSystemResource("Resources/Salesreport.jfif"));
        Image rim2 = ri2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        r2.setIcon(new ImageIcon(rim2));
        r2.setMnemonic('S');
        r2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        r2.setBackground(Color.WHITE);

        r1.addActionListener(this);
        r2.addActionListener(this);

        Report.add(r1);
        Report.add(r2);

        //--------------------------------------------------------------------------------------------------------------


        /* Fourth Column */
        JMenu utility = new JMenu("Utility");
        JMenuItem ut1 = new JMenuItem("NotePad");
        JMenuItem ut2 = new JMenuItem("Calculator");
        JMenuItem ut3 = new JMenuItem("Web Browser");
        utility.setForeground(Color.BLUE);

        /* NotePad */
        ut1.setFont(new Font("monospaced",Font.BOLD,12));
        ImageIcon ico1 = new ImageIcon(ClassLoader.getSystemResource("Resources/notepad.png"));
        Image im1 = ico1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ut1.setIcon(new ImageIcon(im1));
        ut1.setMnemonic('T');
        ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        ut1.setBackground(Color.WHITE);

        /* Calculator */
        ut2.setFont(new Font("monospaced",Font.BOLD,12));
        ImageIcon ico2 = new ImageIcon(ClassLoader.getSystemResource("Resources/calculator.jpg"));
        Image im2 = ico2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ut2.setIcon(new ImageIcon(im2));
        ut2.setMnemonic('U');
        ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        ut2.setBackground(Color.WHITE);

        /* Web Browser */
        ut3.setFont(new Font("monospaced",Font.BOLD,12));
        ImageIcon ico3 = new ImageIcon(ClassLoader.getSystemResource("Resources/web_browser.png"));
        Image im3 = ico3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ut3.setIcon(new ImageIcon(im3));
        ut3.setMnemonic('V');
        ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        ut3.setBackground(Color.WHITE);

        ut1.addActionListener(this);
        ut2.addActionListener(this);
        ut3.addActionListener(this);

        utility.add(ut1);
        utility.add(ut2);
        utility.add(ut3);

        //--------------------------------------------------------------------------------------------------------------

        // Fifth Column
        JMenu Logout = new JMenu("Logout");
        JMenuItem l1 = new JMenuItem("Logout");
        Logout.setForeground(Color.RED);

        // Logout
        l1.setFont(new Font("monospaced",Font.BOLD,12));
        ImageIcon li1 = new ImageIcon(ClassLoader.getSystemResource("Resources/exit.png"));
        Image lim1 = li1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        l1.setIcon(new ImageIcon(lim1));
        l1.setMnemonic('W');
        l1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
        l1.setBackground(Color.WHITE);

        l1.addActionListener(this);
        Logout.add(l1);

        //--------------------------------------------------------------------------------------------------------------

        if(type == "User")
        {
            m.add(User);
            m.add(Customer);
            m.add(Supplier);
            m.add(Products);
            m.add(Details);
            m.add(Report);
        }
        else if(type == "Administrator")
        {
            m.add(AProfile);
            m.add(AUser);
        }
        m.add(utility);
        m.add(Logout);

        setJMenuBar(m);
        setFont(new Font("Sanserif",Font.BOLD,20));
        setVisible(false);
    }

    public void actionPerformed(ActionEvent ae)
    {
           String msg = ae.getActionCommand();

           if(msg.equals("Profile"))
           {
               new Profile(id).setVisible(true);
           }
           else if(msg.equals("Stocks"))
           {
               new Stocks(id).setVisible(true);
           }
           else if(msg.equals("Admin Profile"))
           {
               new AdminProfile(id).setVisible(true);
           }
           else if(msg.equals("User Details"))
           {
               new UserDetails(center,id).setVisible(true);
           }
           else if(msg.equals("Add User"))
           {
               new AddUsers(center,id).setVisible(true);
           }
           else if(msg.equals("Remove User"))
           {
               new RemoveUser(center,id).setVisible(true);
           }
           else if(msg.equals("Add Customers"))
           {
               new AddCustomers(id).setVisible(true);
           }
           else if(msg.equals("Customer Details"))
           {
               new CustomerDetails(id).setVisible(true);
           }
           else if(msg.equals("Remove Customers"))
           {
               new RemoveCustomer(id).setVisible(true);
           }
           else if(msg.equals("Supplier Details"))
           {
               new SuppliersDetails(id).setVisible(true);
           }
           else if(msg.equals("Add Suppliers"))
           {
               new AddSuppliers(id).setVisible(true);
           }
           else if(msg.equals("Remove Suppliers"))
           {
               new RemoveSuppliers(id).setVisible(true);
           }
           else if(msg.equals("Add Products"))
           {
               new AddProducts(id).setVisible(true);
           }
           else if(msg.equals("Product Details"))
           {
               new ProductDetail(id).setVisible(true);
           }
           else if(msg.equals("Remove Products"))
           {
               new RemoveProducts(id).setVisible(true);
           }
           else if(msg.equals("Register Purchase"))
           {
               new RegisterPurchase(id).setVisible(true);
           }
           else if(msg.equals("Register Sales"))
           {
               new RegisterSales(id).setVisible(true);
           }
           else if(msg.equals("Purchase Report"))
           {
               new PurchaseReport(id).setVisible(true);
           }
           else if(msg.equals("Sales Report"))
           {
               new SalesReport(id).setVisible(true);
           }
           else if(msg.equals("NotePad"))
           {
               try{
                   Runtime.getRuntime().exec("notepad.exe");
               }
               catch (Exception e) {}
           }
           else if(msg.equals("Calculator"))
           {
               try{
                   Runtime.getRuntime().exec("calc.exe");
               }
               catch (Exception e) {}
           }
           else if(msg.equals("Web Browser"))
           {
               try{
                   Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
               }
               catch (Exception e) {}
           }
           else if(msg.equals("Logout"))
           {
               System.exit(0);
           }
    }

    public static void main(String[] args) {
        new Project("","","").setVisible(true);
    }

}
