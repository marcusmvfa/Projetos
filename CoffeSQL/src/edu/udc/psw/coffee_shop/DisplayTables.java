/**
 * 
 */
package edu.udc.psw.coffee_shop;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.udc.psw.coffee_shop.CoffeeTableModel;
import edu.udc.psw.coffee_shop.SupplierTableModel;

/**
 * @author mdmatrakas
 * 
 */
public class DisplayTables extends JFrame
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	CoffeeTableModel			coffeeTableModel;
	SupplierTableModel			supplierTableModel;
	boolean						coffeeSupplier		= true;
	JTable						resultTable;
	JButton						coffeeButton;
	JButton						supplierButton;
	private JButton				btnInsert;

	public DisplayTables()
	{
		coffeeTableModel = new CoffeeTableModel();
		supplierTableModel = new SupplierTableModel();

		// configura o JButton para enviar consulta
		coffeeButton = new JButton("Coffees");
		supplierButton = new JButton("Suppliers");
		btnInsert = new JButton("Insert");

		// cria o Box para gerenciar o posicionamento da queryArea e do
		// submitButton na GUI
		Box box = Box.createHorizontalBox();
		box.add(coffeeButton);
		box.add(supplierButton);
		coffeeButton.setEnabled(false);
		supplierButton.setEnabled(true);
		btnInsert.setEnabled(true);

		// cria o delegado JTable para tableModel
		resultTable = new JTable(coffeeTableModel);

		// posiciona os componentes GUI no painel de conteúdo
		getContentPane().add(box, BorderLayout.NORTH);

		btnInsert.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				InsertCoffee in = new InsertCoffee(coffeeTableModel);
				in.setVisible(true);
			}
		});
		box.add(btnInsert);
		JScrollPane scrollPane = new JScrollPane(resultTable);
		scrollPane.setEnabled(false);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		// cria evento ouvinte para coffeeButton
		coffeeButton.addActionListener(new ActionListener()
		{
			// passa consulta para modelo de tabela
			public void actionPerformed(ActionEvent event)
			{
				if (coffeeSupplier)
					return;

				try
				{
					coffeeTableModel.setQuery();
				}
				catch (IllegalStateException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// troca o modela da tabela
				resultTable.setModel(coffeeTableModel);
				resultTable.setRowSelectionInterval(0, 0);
				coffeeButton.setEnabled(false);
				supplierButton.setEnabled(true);
				btnInsert.setEnabled(true);
				coffeeSupplier = !coffeeSupplier;

			}
		});

		// cria evento ouvinte para supplierButton
		supplierButton.addActionListener(new ActionListener()
		{
			// passa consulta para modelo de tabela
			public void actionPerformed(ActionEvent event)
			{
				if (!coffeeSupplier)
					return;

				try
				{
					supplierTableModel.setQuery();
				}
				catch (IllegalStateException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// troca o modela da tabela
				resultTable.setModel(supplierTableModel);
				resultTable.setRowSelectionInterval(0, 0);
				coffeeButton.setEnabled(true);
				supplierButton.setEnabled(false);
				btnInsert.setEnabled(false);
				coffeeSupplier = !coffeeSupplier;

			}
		});

		resultTable.setRowSelectionInterval(0, 0);
		setSize(500, 250); // configura o tamanho da janela
		setVisible(true); // exibe a janela

		// dispõe da janela quando o usuário fecha o aplicativo (isso
		// sobrescreve o padrão de HIDE_ON_CLOSE)
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// assegura que a conexão de banco de dados é fechada quando usuário
		// fecha o aplicativo
		addWindowListener(new WindowAdapter()
		{
			// desconecta-se do banco de dados e sai quando a janela for fechada
			public void windowClosed(WindowEvent event)
			{
				// coffeeTableModel.disconnectFromDatabase();
				supplierTableModel.disconnectFromDatabase();
				System.exit(0);
			}
		});
	}
}
