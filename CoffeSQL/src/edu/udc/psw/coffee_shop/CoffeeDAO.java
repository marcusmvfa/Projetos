/**
 * 
 */
package edu.udc.psw.coffee_shop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.udc.psw.coffee_shop.DBConnection;
import edu.udc.psw.coffee_shop.Coffee;


/**
 * @author mdmatrakas
 * 
 */
public class CoffeeDAO
{
	private Coffee		coffee;
	private Statement	statement;
	private ResultSet	resultSet;
	private int			numberOfRows;
	private String		query  = "SELECT * FROM coffees";
	private String		update = "UPDATE (COF_NAME, PRICE, SALES, SUP_ID, TOTAL) from coffees with ";
	private String		insert = "INSERT into coffees (COF_NAME, PRICE, SALES, SUP_ID, TOTAL) values ";

	static private final String[] columnsNames = { "Nome do Cafe", 
		"Identificador do fornecedor", "Preço", "Vendas da semana", "Total de vandas"  
	};
	
	static private final int numColumns = 5;

	public CoffeeDAO()
	{
		coffee = new Coffee();
		try
		{
			// cria Statement para consultar banco de dados
			statement = DBConnection.getConnection().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			// configura consulta e a executa
			setQuery();
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}

	public void moveToRow(int row)
	{
		try
		{
			resultSet.absolute(row);
			coffee.setName(resultSet.getString(1));
			coffee.setSup_Id(resultSet.getInt(2));
			coffee.setPrice(resultSet.getDouble(3));
			coffee.setSales(resultSet.getInt(4));
			coffee.setTotal(resultSet.getInt(5));
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}

	public Coffee getCoffee()
	{
		return coffee;
	}
	
	public void setCoffee(Coffee newCoffee)
	{
		coffee.setName(newCoffee.getName());
		coffee.setSup_Id(newCoffee.getSup_Id());
		coffee.setPrice(newCoffee.getPrice());
		coffee.setSales(newCoffee.getSales());
		coffee.setTotal(newCoffee.getTotal());
	}

	public int getNumberOfRows()
	{
		return numberOfRows;
	}

	static public int getNumColumns()
	{
		return numColumns;
	}
	
	static public Class<?> getColumnClassName(int column)
	{
		switch(column)
		{
			case 1:
				return String.class; //Class.forName(String.class.getName()); String.class
			case 2:
				return Integer.class; //Class.forName(Integer.class.getName());
			case 3:
				return Double.class; //Class.forName(Double.class.getName());
			case 4:
			case 5:
				return Integer.class; //Class.forName(Integer.class.getName());
		}
		return Object.class; // se ocorrerem os problemas acima, assume tipo Object
	}
	
	public Object getColumn(int column)
	{
		switch(column)
		{
			case 1:
				return coffee.getName();
			case 2:
				return coffee.getSup_Id();
			case 3:
				return coffee.getPrice();
			case 4:
				return coffee.getSales();
			case 5:
				return coffee.getTotal();
		}
		return null;
	}
	
	static public String getColumnName(int column)
	{
		if(column > 0 && column < columnsNames.length)
			return columnsNames[column];
		return "";
	}
	
	public void save() throws SQLException, IllegalStateException
	{
		String newData = update + "('" + coffee.getName() + "', '" +
			coffee.getPrice() + "', '" + coffee.getSales() + "', '" + coffee.getSup_Id() +
			"', '" + coffee.getTotal() + "');";
		statement.executeUpdate(newData);
	}	
	
	public void insert(Coffee cof) throws SQLException, IllegalStateException
	{
		String newData = insert + "('" + cof.getName() + "', '" +
		cof.getPrice() + "', '" + cof.getSales() + "', '" + cof.getSup_Id() +
			"', '" + cof.getTotal() + "');";
		statement.executeUpdate(newData);
		
		setQuery();
	}
	
	// configura nova string de consulta de banco de dados
	public void setQuery() throws SQLException, IllegalStateException
	{
		// especifica consulta e a executa
		resultSet = statement.executeQuery(query);

		// obtém metadados para ResultSet
		// metaData = resultSet.getMetaData();

		// determina o número de linhas em ResultSet
		resultSet.last(); // move para a última linha
		numberOfRows = resultSet.getRow(); // obtém número de linha
		resultSet.first();

		coffee.setName(resultSet.getString(1));
		coffee.setSup_Id(resultSet.getInt(2));
		coffee.setPrice(resultSet.getDouble(3));
		coffee.setSales(resultSet.getInt(4));
		coffee.setTotal(resultSet.getInt(5));
	}

	// fecha Statement e Connection
	public void disconnectFromDatabase()
	{
		// fecha Statement e Connection
		try
		{
			statement.close();
			DBConnection.getConnection().close();
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		} 
	}

}
