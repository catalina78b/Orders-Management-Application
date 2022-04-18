package presentation;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import model.Client;
import model.Order;
import model.Product;
import start.ReflectionExample;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 * view for showing all orders
 */

public class ShowOrders {
    JFrame frame = new JFrame("Orders Page");
    JPanel p1 = new JPanel(new BorderLayout());
    JPanel p=new JPanel();
    JPanel jPanel=new JPanel();
    Font myFont;
    DefaultTableModel modelOrders;
    JTable tableOrders;
    OrderBLL orderBLL;

    public ShowOrders() {

        myFont = new Font("Serif", Font.BOLD, 13);

        frame.setBackground(new Color(143, 196, 184));
        p1.setBackground(new Color(143, 196, 184));


        ReflectionExample<Order> reflectionExample = new ReflectionExample<Order>();
        orderBLL = new OrderBLL();
        java.util.List<Order> listOrders = orderBLL.findAll();

        try {
            modelOrders = reflectionExample.retrieveProperties(listOrders, modelOrders);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        class ForcedListSelectionModel extends DefaultListSelectionModel {

            public ForcedListSelectionModel () {
                setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }

            @Override
            public void clearSelection() {
            }

            @Override
            public void removeSelectionInterval(int index0, int index1) {
            }

        }



        tableOrders = new JTable(modelOrders);
        tableOrders.setSelectionModel(new ForcedListSelectionModel());

        tableOrders.getTableHeader().setBackground(new Color(143, 196, 184));
        tableOrders.setBackground(new Color(223, 237, 233));
        tableOrders.getTableHeader().setFont(myFont);
        tableOrders.setShowGrid(true);
        tableOrders.setShowVerticalLines(true);
        tableOrders.setSize(100, 50);

        JScrollPane pane1 = new JScrollPane(tableOrders);
        pane1.setSize(500, 200);


        JPanel panel = new JPanel();
        panel.add(pane1);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));

        p.add(p1);
        p1.setLayout(null);
        p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
        pane1.setBorder(new LineBorder(new Color(51, 51, 51), 5));
        jPanel.add(p);
        panel.setSize(500, 200);
        panel.setBackground(new Color(143, 196, 184));
        jPanel.add(panel);
        //p.setLayout(null);
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        frame.add(jPanel);
        //frame.add(p3);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setResizable(false);
        class CloseListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                Window win = SwingUtilities.getWindowAncestor((Component) e.getSource());
                win.dispose();
                System.out.println("Frame Closed. ");
            }
        }

    }
}