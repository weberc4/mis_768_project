
package aRecipe;

import java.sql.ResultSet;
import java.util.List;

import edu.unlv.mis768.labwork17.Coffee;

public interface RecipeDAO {
		/**
		 * This method gets all the coffee records.
		 * @return An List with coffee objects
		 */
	   public ResultSet getAllRecipes(Recipe r);
	   
	   /**
	    * This method retrieves a coffee record based on the given coffee number.
	    * @param CNo Represents the primary key, coffee number.
	    * @return a coffee object
	    */

}
