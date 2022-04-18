package presentation;

import bll.ClientBLL;
import bll.ProductBLL;
import model.Client;
import model.Product;
import start.ReflectionExample;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 * view for order page
 */
public class OrderView {
    JFrame frame = new JFrame("Orders Page");
    TextField textFieldQuantity;
    JLabel jLabelSelectClient,jLabelSelectProduct,jLabelQuantity;
    JButton buttonBack,buttonCreateOrder,buttonGenerateBill,buttonShowOrders;
    JPanel p1 = new JPanel(new BorderLayout());
    JPanel p2 = new JPanel(new BorderLayout());
    JPanel p3 = new JPanel(new BorderLayout());
    JPanel p=new JPanel();
    JPanel jPanel=new JPanel();
    Font myFont;
    DefaultTableModel modelClients,modelProducts;
    JTable tableClients,tableProducts;
    ClientBLL clientBLL;
    ProductBLL productBLL;

    public OrderView() {

        myFont = new Font("Serif", Font.BOLD, 13);

        frame.setBackground(new Color(143, 196, 184));
        p1.setBackground(new Color(143, 196, 184));
        p2.setBackground(new Color(143, 196, 184));
        p3.setBackground(new Color(143, 196, 184));

        jLabelQuantity=new JLabel("Select desired quantity:");
        jLabelQuantity.setBounds(10,10,150,20);
        jLabelQuantity.setFont(myFont);

        textFieldQuantity=new TextField();
        textFieldQuantity.setBounds(160,10,120,20);

        jLabelSelectClient=new JLabel("Select client:");
        jLabelSelectClient.setBounds(10,100,200,20);
        jLabelSelectClient.setFont(myFont);

        jLabelSelectProduct=new JLabel("Select product:");
        jLabelSelectProduct.setBounds(400,100,200,20);
        jLabelSelectProduct.setFont(myFont);

        buttonCreateOrder=new JButton("Create order");
        buttonCreateOrder.setBounds(300,10,150,20);
        buttonCreateOrder.setBackground(new Color(51, 51, 51));
        buttonCreateOrder.setForeground(Color.WHITE);
        buttonCreateOrder.setFont(myFont);

        buttonShowOrders=new JButton("Show orders");
        buttonShowOrders.setBounds(300,70,150,20);
        buttonShowOrders.setBackground(new Color(51, 51, 51));
        buttonShowOrders.setForeground(Color.WHITE);
        buttonShowOrders.setFont(myFont);

        buttonGenerateBill=new JButton("Generate Bill");
        buttonGenerateBill.setBounds(300,40,150,20);
        buttonGenerateBill.setBackground(new Color(51, 51, 51));
        buttonGenerateBill.setForeground(Color.WHITE);
        buttonGenerateBill.setFont(myFont);

        buttonBack=new JButton("Back");
        buttonBack.setBounds(680,10,100,20);
        buttonBack.setBackground(new Color(98, 138, 123));
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(myFont);


        p1.add(jLabelQuantity);
        p1.add(textFieldQuantity);
        p1.add(buttonCreateOrder);
        p1.add(buttonGenerateBill);
        p1.add(buttonBack);
        p1.add(buttonShowOrders);

        ReflectionExample<Client> reflectionExample = new ReflectionExample<Client>();
        clientBLL = new ClientBLL();
        List<Client> listClients = clientBLL.findAll();

        try {
            modelClients = reflectionExample.retrieveProperties(listClients, modelClients);
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



        tableClients = new JTable(modelClients);
        tableClients.setSelectionModel(new ForcedListSelectionModel());

        tableClients.getTableHeader().setBackground(new Color(143, 196, 184));
        tableClients.setBackground(new Color(223, 237, 233));
        tableClients.getTableHeader().setFont(myFont);
        tableClients.setShowGrid(true);
        tableClients.setShowVerticalLines(true);
        tableClients.setSize(100, 50);

        JScrollPane pane1 = new JScrollPane(tableClients);
        pane1.setSize(500, 200);

        ReflectionExample<Product> reflectionExample2 = new ReflectionExample<Product>();
        productBLL = new ProductBLL();
        List<Product> productList = productBLL.findAll();


        try {
            modelProducts = reflectionExample2.retrieveProperties(productList, modelProducts);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        tableProducts = new JTable(modelProducts);
        tableProducts.setSelectionModel(new ForcedListSelectionModel());

        tableProducts.getTableHeader().setBackground(new Color(143, 196, 184));
        tableProducts.setBackground(new Color(223, 237, 233));
        tableProducts.getTableHeader().setFont(myFont);
        tableProducts.setShowGrid(true);
        tableProducts.setShowVerticalLines(true);
        tableProducts.setSize(100, 50);
        JScrollPane pane2 = new JScrollPane(tableProducts);
        pane2.setSize(500, 200);


        JPanel panel = new JPanel();
        panel.add(pane1);
        panel.add(pane2);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));

        //panel.add(buttonBack);

        p1.add(jLabelSelectClient);
        p1.add(jLabelSelectProduct);
        p.add(p1);
        p1.setLayout(null);
        p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
        pane1.setBorder(new LineBorder(new Color(51, 51, 51), 5));
        pane2.setBorder(new LineBorder(new Color(51, 51, 51), 5));
        jPanel.add(p);
        panel.setSize(500, 200);
        panel.setBackground(new Color(143, 196, 184));
        jPanel.add(panel);
        //p.setLayout(null);
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        frame.add(jPanel);
        //frame.add(p3);
        frame.setSize(800, 800);
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
