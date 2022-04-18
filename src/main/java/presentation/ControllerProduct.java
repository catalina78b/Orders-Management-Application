package presentation;

import bll.ClientBLL;
import bll.ProductBLL;
import dao.ClientDAO;
import dao.ProductDAO;
import model.Client;
import model.Product;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
/**
 * controller for product
 */

public class ControllerProduct {
    ProductView productView;
    Product product;
    ProductBLL productBLL;
    public ControllerProduct(){
        productView=new ProductView();
        product=new Product();
        productBLL=new ProductBLL();
    }
    void getDataFromFields()
    {
        productView.buttonAddProduct.addActionListener(e -> {
            product.setName(productView.textFieldName.getText());
            product.setPrice(Integer.parseInt(productView.textFieldPrice.getText()));
            product.setQuantity(Integer.parseInt(productView.textFieldQuantity.getText()));
            product.setId(Integer.parseInt(productView.textFieldID.getText()));
            productBLL.insert(product);

        });
        productView.table.getSelectionModel().addListSelectionListener(event -> {
            if (productView.table.getSelectedRow() > -1) {
                productView.textFieldID.setText(productView.table.getValueAt(productView.table.getSelectedRow(), 0).toString());
                productView.textFieldName.setText(productView.table.getValueAt(productView.table.getSelectedRow(), 1).toString());
                productView.textFieldPrice.setText(productView.table.getValueAt(productView.table.getSelectedRow(), 2).toString());
                productView.textFieldQuantity.setText(productView.table.getValueAt(productView.table.getSelectedRow(), 3).toString());

            }
        });
        productView.buttonDeleteProduct.addActionListener(e -> {
            product.setName(productView.textFieldName.getText());
            product.setPrice(Integer.parseInt(productView.textFieldPrice.getText()));
            product.setQuantity(Integer.parseInt(productView.textFieldQuantity.getText()));
            product.setId(Integer.parseInt(productView.textFieldID.getText()));
            productBLL.delete(product);

        });

        productView.buttonUpdateProduct.addActionListener(e -> {
            product.setName(productView.textFieldName.getText());
            product.setPrice(Integer.parseInt(productView.textFieldPrice.getText()));
            product.setQuantity(Integer.parseInt(productView.textFieldQuantity.getText()));
            product.setId(Integer.parseInt(productView.textFieldID.getText()));
            productBLL.update(product);

        });
        productView.buttonRefresh.addActionListener(e -> {
            DefaultTableModel dm = (DefaultTableModel)productView.table.getModel();
            dm.getDataVector().removeAllElements();
            dm.fireTableDataChanged();


        });
        productView.buttonBack.addActionListener(e -> {
            productView.frame.setVisible(false);
            Controller controller=new Controller();
            controller.openWindows();
        });

    }


}


