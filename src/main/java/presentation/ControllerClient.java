package presentation;

import bll.ClientBLL;
import dao.ClientDAO;
import model.Client;
import start.ReflectionExample;

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
 * controller for client
 */
public class ControllerClient {
    ClientView clientView;
    Client client;
    ClientBLL clientBLL;
    public ControllerClient(){
        clientView=new ClientView();
        client=new Client();
        clientBLL=new ClientBLL();
    }
    void getDataFromFields()
    {
        clientView.buttonAddClient.addActionListener(e -> {
            client.setName(clientView.textFieldName.getText());
            client.setAddress(clientView.textFieldAdress.getText());
            client.setEmail(clientView.textFieldEMAIL.getText());
            client.setId(Integer.parseInt(clientView.textFieldID.getText()));
            clientBLL.insert(client);

        });
        clientView.table.getSelectionModel().addListSelectionListener(event -> {
            if (clientView.table.getSelectedRow() > -1) {
                clientView.textFieldID.setText(clientView.table.getValueAt(clientView.table.getSelectedRow(), 0).toString());
                clientView.textFieldName.setText(clientView.table.getValueAt(clientView.table.getSelectedRow(), 1).toString());
                clientView.textFieldAdress.setText(clientView.table.getValueAt(clientView.table.getSelectedRow(), 2).toString());
                clientView.textFieldEMAIL.setText(clientView.table.getValueAt(clientView.table.getSelectedRow(), 3).toString());

            }
        });
        clientView.buttonDeleteClient.addActionListener(e -> {
            client.setName(clientView.textFieldName.getText());
            client.setAddress(clientView.textFieldAdress.getText());
            client.setEmail(clientView.textFieldEMAIL.getText());
            client.setId(Integer.parseInt(clientView.textFieldID.getText()));
            clientBLL.delete(client);
        });

        clientView.buttonUpdateClient.addActionListener(e -> {
            client.setName(clientView.textFieldName.getText());
            client.setAddress(clientView.textFieldAdress.getText());
            client.setEmail(clientView.textFieldEMAIL.getText());
            client.setId(Integer.parseInt(clientView.textFieldID.getText()));
            clientBLL.update(client);
        });
        clientView.buttonRefresh.addActionListener(e -> {
            clientView.frame.setVisible(false);

        });
        clientView.buttonBack.addActionListener(e -> {
            clientView.frame.setVisible(false);
            Controller controller=new Controller();
            controller.openWindows();
        });

    }

    }

