package aRecipe;

import java.sql.*;


public class RecipeDBUtil {
	/**
	 * This method establishes the DB connection
	 * @return a database connection
	 */
	public static Connection getDBConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(RecipeDBConstants.DB_URL, RecipeDBConstants.USER_NAME, RecipeDBConstants.PASSWORD);
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		
		
		
		return conn;
		
	}

	/**
	 * This method closes the DB connection
	 * @param the connection to be closed
	 */
	public static void closeDBConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
			}
		}
	}

	
}
