package aRecipe;

import java.sql.*;
import java.util.*;

import edu.unlv.mis768.labwork17.Coffee;
import edu.unlv.mis768.labwork18.CoffeeDBConstants;
import edu.unlv.mis768.labwork18.CoffeeDBUtil;


public class RecipeDAOImpl implements RecipeDAO {
	
	@Override
	public List<Recipe> getAllRecipes() {
        List<Recipe> recipeList = new ArrayList<Recipe>();
        
		try {
			Connection conn = CoffeeDBUtil.getDBConnection();
			Statement stmt = conn.createStatement(
            		ResultSet.TYPE_SCROLL_INSENSITIVE,
            		ResultSet.CONCUR_READ_ONLY);
			
			
			String sql = "SELECT * from " + CoffeeDBConstants.COFFEE_TABLE_NAME;
            ResultSet result = stmt.executeQuery(sql);
            
            
            
            result.last();                 // Move to last row
            int numRows = result.getRow(); // Get row number
            result.first();                // Move to first row

            for (int row = 0; row < numRows; row++) {
            	Recipe aRecipe = new Recipe(result.getString("Name"),
            			result.getString("ProdNum"),
            			result.getDouble("Price"));
            	
            	
            	
            	recipeList.add(aRecipe);


               result.next();
            }
            stmt.close();
            CoffeeDBUtil.closeDBConnection(conn);
   
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		return coffeeList;
	}

