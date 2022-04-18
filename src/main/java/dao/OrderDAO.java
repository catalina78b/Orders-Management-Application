package dao;

import model.Order;

import java.util.List;

/**
 * class which extends AbstractDAO class and its methods
 */
    public class OrderDAO extends AbstractDAO<Order> {
        @Override
        public List<Order> findAll() {
            return super.findAll();
        }

        @Override
        public int insert(Order order) {
            return super.insert(order);
        }
    }

