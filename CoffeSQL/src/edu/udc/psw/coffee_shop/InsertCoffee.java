package edu.udc.psw.coffee_shop;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.udc.psw.coffee_shop.CoffeeDAO;
import edu.udc.psw.coffee_shop.Coffee;
import edu.udc.psw.coffee_shop.CoffeeTableModel;

import java.sql.SQLException;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InsertCoffee extends JFrame {
	private JTextField nameField;
	private JTextField precoField;
	private JTextField vendasField;
	private JTextField totalField;
	private JTextField idField;
	public InsertCoffee(final CoffeeTableModel tableModel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setBounds(10, 52, 46, 14);
		getContentPane().add(lblPreco);
		
		JLabel lblVendas = new JLabel("Vendas");
		lblVendas.setBounds(10, 93, 46, 14);
		getContentPane().add(lblVendas);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(10, 134, 46, 14);
		getContentPane().add(lblTotal);
		
		nameField = new JTextField();
		nameField.setBounds(79, 11, 86, 20);
		getContentPane().add(nameField);
		nameField.setColumns(10);
		
		precoField = new JTextField();
		precoField.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) 
			{
				float pr = Float.parseFloat(precoField.getText());
				float vd = Float.parseFloat(vendasField.getText());
				totalField.setText(String.format("%f", pr*vd));
			}
		});
		precoField.setHorizontalAlignment(SwingConstants.RIGHT);
		precoField.setText("0");
		precoField.setBounds(79, 49, 86, 20);
		getContentPane().add(precoField);
		precoField.setColumns(10);
		
		vendasField = new JTextField();
		vendasField.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) 
			{
				float pr = Float.parseFloat(precoField.getText());
				float vd = Float.parseFloat(vendasField.getText());
				totalField.setText(String.format("%f", pr*vd));
			}
		});
		vendasField.setHorizontalAlignment(SwingConstants.RIGHT);
		vendasField.setText("0");
		vendasField.setBounds(79, 90, 86, 20);
		getContentPane().add(vendasField);
		vendasField.setColumns(10);
		
		totalField = new JTextField();
		totalField.setEnabled(false);
		totalField.setEditable(false);
		totalField.setHorizontalAlignment(SwingConstants.RIGHT);
		totalField.setText("0");
		totalField.setBounds(79, 131, 86, 20);
		getContentPane().add(totalField);
		totalField.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 175, 46, 14);
		getContentPane().add(lblId);
		
		idField = new JTextField();
		idField.setHorizontalAlignment(SwingConstants.RIGHT);
		idField.setBounds(79, 172, 86, 20);
		getContentPane().add(idField);
		idField.setColumns(10);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Coffee cof = new Coffee();
				cof.setName(nameField.getText());
				cof.setPrice(Double.parseDouble(precoField.getText()));
				cof.setSales(Integer.parseInt(vendasField.getText()));
				cof.setSup_Id(Integer.parseInt(idField.getText()));
				cof.setTotal(Integer.parseInt(totalField.getText()));
				
				CoffeeDAO dao = new CoffeeDAO();
				try {
					dao.insert(cof);
					tableModel.setQuery();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnInserir.setBounds(241, 171, 89, 23);
		getContentPane().add(btnInserir);
		
		setSize(365, 245);
	}

}
