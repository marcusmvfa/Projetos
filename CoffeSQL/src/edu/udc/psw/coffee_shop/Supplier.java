/**
 * 
 */
package edu.udc.psw.coffee_shop;

/**
 * @author mdmatrakas
 *
 */
public class Supplier
{
	private int supId;
	private String supName;
	private String street;
	private String city;
	private String state;
	private int zip;
		
	public Supplier()
	{
		this.supId = 0;
		this.supName = "";
		this.street = "";
		this.city = "";
		this.state = "";
		this.zip =  0;
	}

	public Supplier(int supId, String supName, String street, String city, String state, int zip)
	{
		this.supId = supId;
		this.supName = supName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip =  zip;
	}

	public Supplier(String supName, String street, String city, String state, int zip)
	{
		this.supId = 0;
		this.supName = supName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip =  zip;
	}

	/**
	 * @return the supId
	 */
	public int getSupId()
	{
		return supId;
	}

	/**
	 * @param supId the supId to set
	 */
	public void setSupId(int supId)
	{
		this.supId = supId;
	}

	/**
	 * @return the supName
	 */
	public String getSupName()
	{
		return supName;
	}

	/**
	 * @param supName the supName to set
	 */
	public void setSupName(String supName)
	{
		this.supName = supName;
	}

	/**
	 * @return the street
	 */
	public String getStreet()
	{
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street)
	{
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city)
	{
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState()
	{
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state)
	{
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public int getZip()
	{
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip)
	{
		this.zip = zip;
	}
}
