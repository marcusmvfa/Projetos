/**
 * 
 */
package edu.udc.psw.coffee_shop;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

import edu.udc.psw.coffee_shop.DBConnection;

/**
 * @author mdmatrakas
 * 
 */
public class SupplierTableModel extends AbstractTableModel
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private Statement			statement;
	private ResultSet			resultSet;
	private ResultSetMetaData	metaData;
	private int					numberOfRows;
	private String				query				= "SELECT * FROM suppliers";

	/**
	 * 
	 */
	public SupplierTableModel() // throws SQLException, ClassNotFoundException
	{
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

	// obtém a classe que representa o tipo de coluna
	public Class<?> getColumnClass(int column) throws IllegalStateException
	{
		// determina a classe Java de coluna
		try
		{
			String className = metaData.getColumnClassName(column + 1);

			// retorna objeto Class que representa className
			return Class.forName(className);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}

		return Object.class; // se ocorrerem os problemas acima, assume tipo
		// Object
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	public int getColumnCount() throws IllegalStateException
	{
		// determina número de colunas
		try
		{
			return metaData.getColumnCount();
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}

		return 0; // se ocorrerem os problemas acima, retorna 0 para o número de colunas
	}

	// obtém nome de uma coluna particular em ResultSet
	public String getColumnName(int column) throws IllegalStateException
	{
		// determina o nome de coluna
		try
		{
			return metaData.getColumnName(column + 1);
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}

		return ""; // se ocorrerem problemas, retorna string vazia para nome de
		// coluna
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	public int getRowCount() throws IllegalStateException
	{
		return numberOfRows;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	public Object getValueAt(int row, int column) throws IllegalStateException
	{
		// obtém um valor na linha e coluna de ResultSet especificada
		try
		{
			resultSet.absolute(row + 1);
			return resultSet.getObject(column + 1);
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}

		return ""; // se ocorrerem problemas, retorna objeto string vazio
	}


	// configura nova string de consulta de banco de dados
	public void setQuery() throws SQLException, IllegalStateException
	{
		// especifica consulta e a executa
		resultSet = statement.executeQuery(query);

		// obtém metadados para ResultSet
		metaData = resultSet.getMetaData();

		// determina o número de linhas em ResultSet
		resultSet.last(); // move para a última linha
		numberOfRows = resultSet.getRow(); // obtém número de linha

		// notifica a JTable de que modelo foi alterado
		fireTableStructureChanged();
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
