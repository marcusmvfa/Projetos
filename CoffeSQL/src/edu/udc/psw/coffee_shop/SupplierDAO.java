package edu.udc.psw.coffee_shop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.udc.psw.coffee_shop.DBConnection;
import edu.udc.psw.coffee_shop.Supplier;

public class SupplierDAO
{
	private Supplier	supplier;
	private Statement	statement;
	private ResultSet	resultSet;
	private int			numberOfRows;
	private String		query	= "SELECT * FROM suppliers";
	private String		update = "UPDATE (sup_name, street, city, state, zip) from suppliers with ";

	static private final String[] columnsNames = { "Identificador do Fornecedor", 
		"Nome do Fornecedor", "Endereço", "Cidade", "Estado", "CEP"  
	};
	
	static private final int numColumns = 6;

	public SupplierDAO()
	{
		supplier = new Supplier();
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
			supplier.setSupId(resultSet.getInt(1));
			supplier.setSupName(resultSet.getString(2));
			supplier.setStreet(resultSet.getString(3));
			supplier.setCity(resultSet.getString(4));
			supplier.setState(resultSet.getString(5));
			supplier.setZip(resultSet.getInt(6));
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}

	public Supplier getCoffee()
	{
		return supplier;
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
			case 6:
				return Integer.class;
			case 2:
			case 3:
			case 4:
			case 5:
				return String.class;
		}
		return Object.class; // se ocorrerem os problemas acima, assume tipo Object
	}
	
	public Object getColumn(int column)
	{
		switch(column)
		{
			case 1:
				return supplier.getSupId();
			case 2:
				return supplier.getSupName();
			case 3:
				return supplier.getStreet();
			case 4:
				return supplier.getCity();
			case 5:
				return supplier.getState();
			case 6:
				return supplier.getZip();
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
		String newData = update + "('" + supplier.getSupName() + "', '" + 
		supplier.getStreet() + "', '" + supplier.getCity() + "', '" + supplier.getState() + 
		"', '" + supplier.getZip() + "');";
		statement.executeUpdate(newData);
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

		supplier.setSupId(resultSet.getInt(1));
		supplier.setSupName(resultSet.getString(2));
		supplier.setStreet(resultSet.getString(3));
		supplier.setCity(resultSet.getString(4));
		supplier.setState(resultSet.getString(5));
		supplier.setZip(resultSet.getInt(6));
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
