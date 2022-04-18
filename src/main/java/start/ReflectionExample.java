package start;

import dao.AbstractDAO;

import javax.swing.table.DefaultTableModel;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Logger;


import java.lang.reflect.Field;

/**
 * @param <T>
 * class that show a Reflexion Technique Example
 */
public class ReflectionExample<T> {

	public ReflectionExample()
	{

	}


	public DefaultTableModel retrieveProperties(List<T> objects,DefaultTableModel defaultTableModel) throws IllegalAccessException {

		String columns[];
		String data[][];
		int rows=0,col=0,j=0;
		for (Field field : objects.get(0).getClass().getDeclaredFields()) {
			col++;}
		columns=new String[col];
		col=0;
		for (Field field : objects.get(0).getClass().getDeclaredFields()) {
			String fieldName = field.getName();
			columns[col]=fieldName;
			col++;
		}
		data=new String[100][col];

			for(int i=0;i< objects.size();i++)
			{
				j=0;
		for (Field field : objects.get(i).getClass().getDeclaredFields()) {
			field.setAccessible(true); // set modifier to public
			Object value=null;
			try {
				value = field.get(objects.get(i));

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			data[i][j]=value+"";
			j++;
		}

	}
		defaultTableModel= new DefaultTableModel(data, columns);
		return defaultTableModel;
}}
