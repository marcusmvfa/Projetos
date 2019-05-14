/**
 * 
 */
package edu.udc.psw.coffee_shop;

import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

import edu.udc.psw.coffee_shop.CoffeeDAO;

/**
 * @author mdmatrakas
 * 
 */
public class CoffeeTableModel extends AbstractTableModel
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private static CoffeeDAO	coffeeTable;

	/**
	 * 
	 */
	public CoffeeTableModel() // throws SQLException, ClassNotFoundException
	{
		coffeeTable = new CoffeeDAO();

	}

	// obtém a classe que representa o tipo de coluna
	public Class<?> getColumnClass(int column)
	{
		return CoffeeDAO.getColumnClassName(column + 1);
	} // fim do método getColumnClass

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	public int getColumnCount()
	{
		return CoffeeDAO.getNumColumns();
	}

	// obtém nome de uma coluna particular em ResultSet
	public String getColumnName(int column)
	{
		return CoffeeDAO.getColumnName(column);
	} // fim do método getColumnName

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	public int getRowCount() throws IllegalStateException
	{
		return coffeeTable.getNumberOfRows();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	public Object getValueAt(int row, int column) throws IllegalStateException
	{
		coffeeTable.moveToRow(row + 1);
		return coffeeTable.getColumn(column + 1);
	}

	// configura nova string de consulta de banco de dados
	public void setQuery() throws SQLException, IllegalStateException
	{
		coffeeTable.setQuery();

		// notifica a JTable de que modelo foi alterado
		fireTableStructureChanged();
	} 
}
