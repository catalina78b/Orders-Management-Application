package dao;

import model.Product;

import java.util.List;
/**
 * class which extends AbstractDAO class and its methods
 */
public class ProductDAO extends AbstractDAO<Product> {
    @Override
    public List<Product> findAll() {
        return super.findAll();
    }

    @Override
    public int insert(Product product) {
        return super.insert(product);
    }

    @Override
    public Product update(Product product) {
        return super.update(product);
    }

    @Override
    public Product delete(Product product) {
        return super.delete(product);
    }
}

