/**
 * 
 */
package edu.udc.psw.coffee_shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author mdmatrakas
 * 
 */
public class DBConnection
{
    private static Connection connection = null; // gerencia a conexão
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";        
    private static String DATABASE_URL = "jdbc:mysql://localhost/coffee_shop?useSSL=false";
    private static String USR = "root";
    private static String PASS = "root";
    private static int connectionCount = 0;
    
    public static Connection getConnection()
    {
    	if(connection == null)
    	{
		    try 
		    {
		       Class.forName( JDBC_DRIVER ); // carrega classe de driver do banco de dados
		
		       // estabelece conexão com o banco de dados
		       connection = DriverManager.getConnection( DATABASE_URL, USR, PASS );
		    }
		    catch (SQLException sqlException)                                
		    {                                                                  
		       sqlException.printStackTrace();
		       System.exit( 1 );                                               
		    } // fim do catch
		    catch (ClassNotFoundException classNotFound)                     
		    {                                                                  
		       classNotFound.printStackTrace();            
		       System.exit( 1 );                                               
		    } // fim do catch
    	}
    	connectionCount++;
    	return connection;
    }
    
    public static boolean isConnected()
    {
    	if(connection == null)
    		return false;
    	return true;
    }
    
    public static void closeConnection() throws IllegalStateException
    {
    	if(connectionCount == 0) 
    		throw new IllegalStateException("Not Connected to Database");
    	connectionCount--;
    	if(connectionCount == 0)
    	{
	        try                                                        
	        {                                                          
	           connection.close();                                     
	        } // fim do try
	        catch ( Exception exception )                              
	        {                                                          
	           exception.printStackTrace();                            
	           System.exit( 1 );                                       
	        } // fim do catch
    	}
    }
}
