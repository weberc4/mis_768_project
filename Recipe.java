package aRecipe;

//This is an UnpaidOrder class, created by Charles Weber, used to hold all of the fields/columns for an Unpaid Order row within its respective table
public class Recipe {
	//Fields
	String occasion;
	String region;
	String ingredients;
	String avoidIngredients;
	double minutes;
	

	
	public Recipe(String rOccasion, String rRegion, String rIngredients, String rAvoidIngredients, double rMinutes) {
		super();
		occasion = rOccasion;
		region = rRegion;
		ingredients = rIngredients;
		avoidIngredients = rAvoidIngredients;
		minutes = rMinutes;
	}
	
	public Recipe (){
		
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getAvoidIngredients() {
		return avoidIngredients;
	}

	public void setAvoidIngredients(String avoidIngredients) {
		this.avoidIngredients = avoidIngredients;
	}

	public double getMinutes() {
		return minutes;
	}

	public void setMinutes(double minutes) {
		this.minutes = minutes;
	}



	
	

}
