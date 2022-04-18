package dao;

import model.Client;

import java.util.List;

/**
 * class which extends AbstractDAO class and its methods
 */
public class ClientDAO extends AbstractDAO<Client> {
    @Override
    public List<Client> findAll() {
        return super.findAll();
    }

    @Override
    public int insert(Client client) {
        return super.insert(client);
    }

    @Override
    public Client update(Client client) {
        return super.update(client);
    }

    @Override
    public Client delete(Client client) {
        return super.delete(client);
    }

    // uses basic CRUD methods from superclass

}
