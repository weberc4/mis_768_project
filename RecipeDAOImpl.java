package aRecipe;

import java.sql.*;



public class RecipeDAOImpl implements RecipeDAO {
	
	@Override
	public ResultSet getAllRecipes(Recipe r) {        
		
		ResultSet result = null;
		
		try {
			Connection conn = RecipeDBUtil.getDBConnection();
		    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);	
			
	        // Create a SELECT statement to get the specific row from the Customer table.
	        String sqlStatement = "Select * FROM recipes WHERE Keywords LIKE ? AND Keywords LIKE ? AND RecipeIngredientParts LIKE ? AND RecipeIngredientParts NOT LIKE ?";

	        // instantiate a PrepareStatement object using the SQL command
	        PreparedStatement prepStmt = conn.prepareStatement(sqlStatement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        
	        String occasion = r.getOccasion();
	        String region = r.getRegion();
	        String keyIngredient = r.getIngredients();
	        String avoidIngredient = r.getAvoidIngredients();
	        
	        // provide the values for query.
		    prepStmt.setString(1, "%"+occasion+"%"); 	
		    prepStmt.setString(2, "%"+region+"%"); 	        
		    prepStmt.setString(3, "%"+keyIngredient+"%"); 
		    prepStmt.setString(4, "%"+avoidIngredient+"%");

	        // Send the SELECT statement to the DBMS.
	        result = prepStmt.executeQuery();
            

	        if(result.next())
	        	return result;
	        else
	        	stmt.close();
            
            RecipeDBUtil.closeDBConnection(conn);


    		
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		return result;
	}
	
}

	

