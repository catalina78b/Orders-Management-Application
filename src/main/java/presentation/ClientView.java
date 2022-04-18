package presentation;

import bll.ClientBLL;
import model.Client;
import start.ReflectionExample;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * view for clients page
 */
public class ClientView {

    JFrame frame = new JFrame("Clients Page");
    TextField textFieldName, textFieldAdress, textFieldID, textFieldEMAIL;
    JLabel jLabelName,jLabelAdress,jLabelID,jLabelEMAIL;
    JButton buttonAddClient, buttonDeleteClient, buttonUpdateClient,buttonRefresh,buttonBack;
    JPanel p1 = new JPanel(new BorderLayout());
    JPanel p2 = new JPanel(new BorderLayout());
    JPanel p3 = new JPanel(new BorderLayout());
    JPanel p=new JPanel();
    JPanel jPanel=new JPanel();
    Font myFont;
    DefaultTableModel model;
    JTable table;
    ClientBLL clientBLL;
    JPanel panel;
    JScrollPane pane;

    public ClientView() {

        myFont = new Font("Serif", Font.BOLD, 13);

        frame.setBackground(new Color(143, 196, 184));
        p1.setBackground(new Color(143, 196, 184));
        p2.setBackground(new Color(143, 196, 184));
        p3.setBackground(new Color(143, 196, 184));


        textFieldName=new TextField();
        textFieldAdress=new TextField();
        textFieldID=new TextField();
        textFieldEMAIL=new TextField();

        jLabelAdress=new JLabel("Adress:");
        jLabelEMAIL=new JLabel("EMAIL:");
        jLabelID=new JLabel("ID:");
        jLabelName=new JLabel("Name:");

        jLabelName.setFont(myFont);
        jLabelID.setFont(myFont);
        jLabelEMAIL.setFont(myFont);
        jLabelAdress.setFont(myFont);

        buttonBack = new JButton("Back");
        buttonBack.setBackground(new Color(51, 51, 51));
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(myFont);

        buttonAddClient = new JButton("Add Client");
        buttonAddClient.setBackground(new Color(51, 51, 51));
        buttonAddClient.setForeground(Color.WHITE);
        buttonAddClient.setFont(myFont);

        buttonDeleteClient=new JButton("Delete Client");
        buttonDeleteClient.setBackground(new Color(51, 51, 51));
        buttonDeleteClient.setForeground(Color.WHITE);
        buttonDeleteClient.setFont(myFont);

        buttonUpdateClient=new JButton("Update Client");
        buttonUpdateClient.setBackground(new Color(51, 51, 51));
        buttonUpdateClient.setForeground(Color.WHITE);
        buttonUpdateClient.setFont(myFont);

        buttonRefresh=new JButton("Refresh table");
        buttonRefresh.setBackground(new Color(51, 51, 51));
        buttonRefresh.setForeground(Color.WHITE);
        buttonRefresh.setFont(myFont);

        buttonAddClient.setBounds(50, 50, 120, 20);
        buttonUpdateClient.setBounds(50, 70, 120, 20);
        buttonDeleteClient.setBounds(50, 90, 120, 20);
        buttonRefresh.setBounds(50, 110, 120, 20);


        jLabelID.setBounds(50,50,120,20);
        textFieldID.setBounds(100,50,150,20);

        jLabelName.setBounds(50,70,120,20);
        textFieldName.setBounds(100,70,150,20);

        jLabelEMAIL.setBounds(50,90,120,20);
        textFieldEMAIL.setBounds(100,90,150,20);

        jLabelAdress.setBounds(50,110,120,20);
        textFieldAdress.setBounds(100,110,150,20);

        p1.add(textFieldID);
        p1.add(jLabelID);
        p1.add(textFieldName);
        p1.add(jLabelName);
        p1.add(textFieldAdress);
        p1.add(jLabelAdress);
        p1.add(textFieldEMAIL);
        p1.add(jLabelEMAIL);

        p3.add(buttonRefresh);
        p3.add(buttonAddClient);
        p3.add(buttonDeleteClient);
        p3.add(buttonUpdateClient);

//        String columns[] = { "ID", "Name", "Address","EMAIL" };
//        clientBLL=new ClientBLL();
//        List<Client> list=clientBLL.findAll();
//        String data[][] = new String[100][4];
//
//        int i = 0;
//        for (Client client:list
//             ) {int id = client.getId();
//            String name = client.getName();
//            String address = client.getAddress();
//            String email=client.getEmail();
//            data[i][0] = id + "";
//            data[i][1] = name;
//            data[i][2] = address;
//            data[i][3] = email;
//            i++;
//
//        }
//
//
//        model= new DefaultTableModel(data, columns);
        ReflectionExample<Client> reflectionExample=new ReflectionExample<Client>();
        clientBLL=new ClientBLL();
        List<Client> list=clientBLL.findAll();

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
        pane = new JScrollPane(table);
        pane.setSize(500,200);

      panel= new JPanel();
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
