package bll;

import bll.validators.EmailValidator;
import bll.validators.Validator;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Order;
import model.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * this class execute CRUD operations on order table
 */
public class OrderBLL {

    private List<Validator<Order>> validators;
    private OrderDAO orderDAO;
    private ProductDAO productDAO;

    /**
     * constructor for class
     */
    public OrderBLL() {
        validators = new ArrayList<Validator<Order>>();
        productDAO = new ProductDAO();
        orderDAO = new OrderDAO();
    }

    /**
     * @param id
     * @return
     * find order by id
     */
    public Order findOrderById(int id) {
        Order st = orderDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The student with id =" + id + " was not found!");
        }
        return st;
    }

    /**
     * @param order
     * @return
     * insert specified order in table
     */
    public int insert(Order order) {
        Product product = productDAO.findById(order.getIdproduct());
        if (product.getQuantity() >= order.getQuantity()) {
            product.setQuantity(product.getQuantity() - order.getQuantity());
            productDAO.update(product);
        } else {
            String message = "There are not enough products! Please select another quantity!";
            JOptionPane.showMessageDialog(new JFrame(), message, "Under-stock",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }


        if (order == null) {
            throw new NoSuchElementException("Order cannot be inserted");
        }
        return orderDAO.insert(order);
    }

    /**
     * @return
     * find all orders
     */
    public List<Order> findAll() {
        List<Order> list = orderDAO.findAll();
        if (list.isEmpty()) {
            throw new NoSuchElementException("empty table!");
        }
        return list;
    }

}

