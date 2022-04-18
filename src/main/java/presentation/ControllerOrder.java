package presentation;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import dao.ClientDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Client;
import model.Order;
import model.Product;

import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * controller for order
 */
public class ControllerOrder {
    OrderView orderView;
    Order order;
    OrderBLL orderBLL;
    ClientBLL clientBLL;
    ProductBLL productBLL;
    Client client;
    Product product;

    public ControllerOrder() {
        orderView = new OrderView();
        order = new Order();
        orderBLL = new OrderBLL();
        client=new Client();
        product=new Product();
        clientBLL=new ClientBLL();
        productBLL=new ProductBLL();
    }

    void getDataFromFields() {
        orderView.tableClients.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (orderView.tableClients.getSelectedRow() > -1) {

                    order.setIdclient((Integer.parseInt(orderView.tableClients.getValueAt(orderView.tableClients.getSelectedRow(), 0)+"")));

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
                orderView.tableProducts.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (orderView.tableProducts.getSelectedRow() > -1) {

                            order.setIdproduct(Integer.parseInt(orderView.tableProducts.getValueAt(orderView.tableProducts.getSelectedRow(), 0)+""));

                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
        orderView.buttonCreateOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order.setQuantity(Integer.parseInt(orderView.textFieldQuantity.getText()));
                order.setIdorder(orderBLL.insert(order));

            }
        });

        orderView.buttonBack.addActionListener(e -> {
            orderView.frame.setVisible(false);
            Controller controller = new Controller();
            controller.openWindows();
        });

        orderView.buttonShowOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             ShowOrders showOrders=new ShowOrders();
            }
        });
        orderView.buttonGenerateBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String string="bill"+order.getIdorder()+"";
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    FileWriter myWriter = new FileWriter(string+".txt");
                    client=clientBLL.findClientById(order.getIdclient());
                    product=productBLL.findById(order.getIdproduct());
                    myWriter.write("Name:"+client.getName()+"\n");
                    myWriter.write("Adress:"+client.getAddress()+"\n");
                    myWriter.write("Product:"+product.getName()+"\n");
                    myWriter.write("Quantity:"+order.getQuantity()+"\n");
                    myWriter.write("Total price:"+order.getQuantity()*product.getPrice()+"\n");
                    myWriter.write("\n \n \n \n \n");
                    myWriter.write(dtf.format(now));
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException IOexception) {
                    System.out.println("An error occurred.");
                    IOexception.printStackTrace();
                }
            }
        });

    }
}
