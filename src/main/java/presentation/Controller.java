package presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * main controller
 */
public class Controller {
    View view;
    ControllerClient controllerClient;
    ControllerProduct controllerProduct;
    ControllerOrder controllerOrder;
    public Controller()
    {
        view=new View();
    }
    public void openWindows()
    {
        view.buttonClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.frame.setVisible(false);
                controllerClient=new ControllerClient();
                controllerClient.getDataFromFields();
            }
        });
        view.buttonProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.frame.setVisible(false);
                controllerProduct=new ControllerProduct();
                controllerProduct.getDataFromFields();
            }
        });
        view.buttonOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.frame.setVisible(false);
                controllerOrder=new ControllerOrder();
                controllerOrder.getDataFromFields();
            }
        });

    }


}
