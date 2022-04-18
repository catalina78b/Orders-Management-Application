package presentation;

import bll.ClientBLL;
import bll.ProductBLL;
import model.Client;
import model.Product;
import start.ReflectionExample;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
/**
 * view for product page
 */
public class ProductView {
    JFrame frame = new JFrame("Products Page");
    TextField textFieldName, textFieldPrice, textFieldID, textFieldQuantity;
    JLabel jLabelName, jLabelPrice,jLabelID, jLabelQuantity;
    JButton buttonAddProduct, buttonDeleteProduct, buttonUpdateProduct,buttonRefresh,buttonBack;
    JPanel p1 = new JPanel(new BorderLayout());
    JPanel p2 = new JPanel(new BorderLayout());
    JPanel p3 = new JPanel(new BorderLayout());
    JPanel p=new JPanel();
    JPanel jPanel=new JPanel();
    Font myFont;
    DefaultTableModel model;
    JTable table;
    ProductBLL productBLL;

    public ProductView() {

        myFont = new Font("Serif", Font.BOLD, 13);

        frame.setBackground(new Color(143, 196, 184));
        p1.setBackground(new Color(143, 196, 184));
        p2.setBackground(new Color(143, 196, 184));
        p3.setBackground(new Color(143, 196, 184));


        textFieldName=new TextField();
        textFieldPrice =new TextField();
        textFieldID=new TextField();
        textFieldQuantity =new TextField();

        jLabelPrice =new JLabel("Price:");
        jLabelQuantity =new JLabel("Quantity:");
        jLabelID=new JLabel("ID:");
        jLabelName=new JLabel("Name:");

        jLabelName.setFont(myFont);
        jLabelID.setFont(myFont);
        jLabelQuantity.setFont(myFont);
        jLabelPrice.setFont(myFont);

        buttonBack = new JButton("Back");
        buttonBack.setBackground(new Color(51, 51, 51));
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(myFont);

        buttonAddProduct = new JButton("Add Product");
        buttonAddProduct.setBackground(new Color(51, 51, 51));
        buttonAddProduct.setForeground(Color.WHITE);
        buttonAddProduct.setFont(myFont);

        buttonDeleteProduct =new JButton("Delete Product");
        buttonDeleteProduct.setBackground(new Color(51, 51, 51));
        buttonDeleteProduct.setForeground(Color.WHITE);
        buttonDeleteProduct.setFont(myFont);

        buttonUpdateProduct =new JButton("Update Product");
        buttonUpdateProduct.setBackground(new Color(51, 51, 51));
        buttonUpdateProduct.setForeground(Color.WHITE);
        buttonUpdateProduct.setFont(myFont);

        buttonRefresh=new JButton("Refresh table");
        buttonRefresh.setBackground(new Color(51, 51, 51));
        buttonRefresh.setForeground(Color.WHITE);
        buttonRefresh.setFont(myFont);

        buttonAddProduct.setBounds(50, 50, 160, 20);
        buttonUpdateProduct.setBounds(50, 70, 160, 20);
        buttonDeleteProduct.setBounds(50, 90, 160, 20);
        buttonRefresh.setBounds(50, 110, 160, 20);


        jLabelID.setBounds(40,50,120,20);
        textFieldID.setBounds(100,50,150,20);

        jLabelName.setBounds(40,70,120,20);
        textFieldName.setBounds(100,70,150,20);

        jLabelQuantity.setBounds(40,110,120,20);
        textFieldQuantity.setBounds(100,110,150,20);

        jLabelPrice.setBounds(40,90,120,20);
        textFieldPrice.setBounds(100,90,150,20);

        p1.add(textFieldID);
        p1.add(jLabelID);
        p1.add(textFieldName);
        p1.add(jLabelName);
        p1.add(textFieldPrice);
        p1.add(jLabelPrice);
        p1.add(textFieldQuantity);
        p1.add(jLabelQuantity);

        p3.add(buttonRefresh);
        p3.add(buttonAddProduct);
        p3.add(buttonDeleteProduct);
        p3.add(buttonUpdateProduct);

//        String columns[] = { "ID", "Name", "Price","Quantity"};
//        productBLL=new ProductBLL();
//        List<Product> list=productBLL.findAll();
//        String data[][] = new String[100][4];
//
//        int i = 0;
//        for (Product product:list
//        ) {int id = product.getId();
//            String name = product.getName();
//            int price = product.getPrice();
//            int quantity=product.getQuantity();
//            data[i][0] = id + "";
//            data[i][1] = name+"";
//            data[i][2] = price+"";
//            data[i][3] = quantity+"";
//            i++;
//
//        }


        ReflectionExample<Product> reflectionExample=new ReflectionExample<Product>();
        productBLL=new ProductBLL();
        List<Product> list=productBLL.findAll();

        try {
            model=reflectionExample.retrieveProperties(list,model);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        table = new JTable(model);

        table.getTableHeader().setBackground(new Color(143, 196, 184));
        table.setBackground(new Color(223, 237, 233));
        table.getTableHeader().setFont(myFont);
        table.setShowGrid(true);
        table.setShowVerticalLines(true);
        table.setSize(100,50);
        JScrollPane pane = new JScrollPane(table);
        pane.setSize(500,200);

        JPanel panel = new JPanel();
        panel.add(pane);
        panel.add(buttonBack);

        p.add(p1);
        p.add(p3);
        p1.setLayout(null);
        p3.setLayout(null);
        p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
        p.setSize(500,300);
        pane.setBorder(new LineBorder(new Color(51, 51, 51),5));
        jPanel.add(p);
        panel.setSize(500,200);
        panel.setBackground(new Color(143, 196, 184));
        jPanel.add(panel);
        //p.setLayout(null);
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        frame.add(jPanel);
        //frame.add(p3);
        frame.setSize(500, 800);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

}


