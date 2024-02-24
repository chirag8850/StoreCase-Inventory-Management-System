package Inventory;

import javax.swing.*;
import java.awt.*;

public class Splash {
    public static void main(String[] args) {

        Fframe f = new Fframe();
        f.setVisible(true);

        int i;
        int x=1;

        for(i=2; i<=700; i+=4, x+=1)
        {
            f.setLocation(800-((i+x)/2),400-(i/2));
            f.setSize(i+x,i);

            try
            {
                Thread.sleep(10);
            }
            catch (Exception e){}
        }
    }
}

class Fframe extends JFrame implements Runnable
{
    Thread t1;

    Fframe()
    {
        super("Inventory Management");
        setLayout(new FlowLayout());

        ImageIcon ico = new ImageIcon(ClassLoader.getSystemResource("Resources/Inventory.png"));
        Image i = ico.getImage().getScaledInstance(1000,670,Image.SCALE_DEFAULT);
        ImageIcon ico2 = new ImageIcon(i);

        JLabel n = new JLabel(ico2);
        add(n);

        t1 = new Thread(this);
        t1.start();
    }

    public void run()
    {
        try
        {
            Thread.sleep(6000);
            this.setVisible(false);

            new Login().setVisible(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}