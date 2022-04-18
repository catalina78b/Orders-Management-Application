package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.EmailValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;

public class ClientBLL {

	private List<Validator<Client>> validators;
	private ClientDAO clientDAO;

	/**
	 * constructor that initialize instance variables
	 */
	public ClientBLL() {
		validators = new ArrayList<Validator<Client>>();
		validators.add(new EmailValidator());

		clientDAO = new ClientDAO();
	}

	/**
	 * @param id
	 * @return st
	 */
	public Client findClientById(int id) {
		Client st = clientDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The client with id =" + id + " was not found!");
		}
		return st;
	}

	/**
	 * @param client
	 * insert specified client through parameter
	 */
	public void insert(Client client){
		clientDAO.insert(client);
	}

	/**
	 * @param st
	 * delete specified client through parameter
	 */
	public void delete(Client st){
		if(st == null){
			throw new NoSuchElementException("The client with id =" + st.getId() + " was not found!");
		}
		else {
			clientDAO.delete(st);
		}
	}

	/**
	 * @param st
	 * update specified client through parameter
	 */
	public void update(Client st){
		if(st == null){
			throw new NoSuchElementException("The client with id =" + st.getId() + " was not found!");
		}
		else {
			clientDAO.update(st);
		}
	}

	/**
	 * @return clients
	 * return a list of clients
	 */
	public List<Client> findAll(){
		List<Client> clients = clientDAO.findAll();
		return clients;
	}
}
