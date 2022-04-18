package presentation;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
/**
 * main page view
 */

public class View {
    JFrame frame = new JFrame("Orders Management Application");
    JButton buttonProducts,buttonClients,buttonOrders;
    JPanel p = new JPanel(new BorderLayout());
    Image appIcon = Toolkit.getDefaultToolkit().getImage("icon.png");
    public View()
    {
        frame.setIconImage(appIcon);
        frame.setBackground(new Color(143, 196, 184));
        p.setBackground(new Color(143, 196, 184));

        ImageIcon icon = new ImageIcon("products.jpg");
        Image image = icon.getImage(); // transform it
        Image newimg = image.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        buttonProducts = new JButton(icon);
        buttonProducts.setBackground(new Color(51,51,51));

        ImageIcon icon2 = new ImageIcon("clients.png");
        Image image2 = icon2.getImage(); // transform it
        Image newimg2 = image2.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(newimg2);
        buttonClients=new JButton(icon2);
        buttonClients.setBackground(new Color(	51,51,51));

        ImageIcon icon3 = new ImageIcon("orders.png");
        Image image3 = icon3.getImage(); // transform it
        Image newimg3 = image3.getScaledInstance(90, 90,  Image.SCALE_FAST);
        icon3 = new ImageIcon(newimg3);
        buttonOrders=new JButton(icon3);
        buttonOrders.setBackground(new Color(	51,51,51));

        buttonClients.setBounds(50,50,100,100);
        buttonProducts.setBounds(150,50,100,100);
        buttonOrders.setBounds(250,50,100,100);

        p.setLayout(null);
        p.add(buttonProducts);
        p.add(buttonClients);
        p.add(buttonOrders);

        frame.add(p);
        frame.setSize(420, 250);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
