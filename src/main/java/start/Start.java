package start;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import bll.ClientBLL;
import model.Client;
import presentation.Controller;

/**
 * run the application
 */
public class Start {
	public static void main(String[] args) {
		Controller controller=new Controller();
		controller.openWindows();
	}

}
