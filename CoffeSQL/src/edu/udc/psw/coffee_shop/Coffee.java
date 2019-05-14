/**
 * 
 */
package edu.udc.psw.coffee_shop;

/**
 * @author mdmatrakas
 *
 */
public class Coffee
{
	private String name;
	private int sup_id;
	private double price;
	private int sales;
	private int total;
		
	public Coffee()
	{
		name = "";
		sup_id = 0;
		price = 0.0;
		sales = 0;
		total =  0;
	}
	
	public Coffee(String n, double p, int s, int t)
	{
		name = n;
		price = p;
		sales = s;
		total = t;
		sup_id = 0;
	}

	public Coffee(int i, String n, double p, int s, int t)
	{
		name = n;
		price = p;
		sales = s;
		total = t;
		sup_id = i;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getSup_Id()
	{
		return sup_id;
	}

	public void setSup_Id(int sup_id)
	{
		this.sup_id = sup_id;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getSales()
	{
		return sales;
	}

	public void setSales(int sales)
	{
		this.sales = sales;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}
}
