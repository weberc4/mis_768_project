
package aRecipe;

import java.util.List;

import edu.unlv.mis768.labwork17.Coffee;

public interface RecipeDAO {
		/**
		 * This method gets all the coffee records.
		 * @return An List with coffee objects
		 */
	   public List<Recipe> getAllRecipes();
	   
	   /**
	    * This method retrieves a coffee record based on the given coffee number.
	    * @param CNo Represents the primary key, coffee number.
	    * @return a coffee object
	    */

}
