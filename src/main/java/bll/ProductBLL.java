package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.Validator;
import dao.ProductDAO;
import model.Product;

public class ProductBLL {

    private List<Validator<Product>> validators;
    private ProductDAO productDAO;

    /**
     * constructor for class
     */
    public ProductBLL() {
        validators = new ArrayList<Validator<Product>>();

        productDAO = new ProductDAO();
    }

    /**
     * @param id
     * find product by id
     * @return
     */
    public Product findById(int id) {
        Product st = productDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return st;
    }

    /**
     * @param product
     * insert specified product
     */
    public void insert(Product product){
        productDAO.insert(product);
    }

    /**
     * @param st
     * delete specified product
     */
    public void delete(Product st){
        if(st == null){
            throw new NoSuchElementException("The product with id =" + st.getId() + " was not found!");
        }
        else {
            productDAO.delete(st);
        }
    }

    /**
     * @param st
     * update specified product
     */
    public void update(Product st){
        if(st == null){
            throw new NoSuchElementException("The product with id =" + st.getId() + " was not found!");
        }
        else {
            productDAO.update(st);
        }
    }

    /**
     * @return
     * find all products
     */
    public List<Product> findAll(){
        List<Product> productList = productDAO.findAll();
        return productList;
    }}