package aRecipe;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class RecipeDBGeneratorController {

    @FXML
    private Button getInstructions;

    @FXML
    private Button getNutrition;

    @FXML
    private Button getRecipe;

    @FXML
    private Label recipeName;
    
    @FXML
    private Label recipeTime;
    
    @FXML
    private Label recipeIngredients;

    @FXML
    private Button saveRecipe;

	
	// Declare the Connection object
	Connection conn;
    // Declare the ResultSet object
    ResultSet result;	
    
    Recipe r;
	
	@FXML
	public void getNextRecipe()  {
		try {
			result.next();
			showRowContent(result);

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		
	}
	
	@FXML
	public void getPreviousRecipe()  {
		try {
			result.previous();
			
			showRowContent(result);
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		
	}
	
	@FXML
	public void getInstructions() throws SQLException {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Recipe Instructions");
    	alert.setContentText(result.getString("RecipeInstructions"));

    	alert.show();
	}
	
	@FXML
	public void getNutritionFacts() throws SQLException {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Recipe NutritionalInfo");
    	alert.setContentText("Per Serving \nCalories: "+result.getString("Calories")+"\nTotal Fats: "+result.getString("FatContent")
    	+"g\nTotal Carbohydrates: "+result.getString("CarbohydrateContent")+"g\nSodium: "+result.getString("SodiumContent")+"mg\nTotal Sugars: "
    	+result.getString("SugarContent")+"g\nProtein: "+result.getString("ProteinContent")+"g");

    	alert.show();
	}

    public void initData(ResultSet re) throws SQLException {
    	// assign the passed ResultSet object to the result variable in this class
    	result = re;
    	
    	try {
    		// Display the number of rows

    		//Update the labels to show the content of the current row; i.e., the first row
    		showRowContent(result);
    	}
    	catch (Exception ex){
    		System.out.println("ERROR at initData(): " + ex.getMessage());
    	}
    }
	
	/**
	 * This function displays the content of the current row in a result set.
	 * Three labels are used to display the content of the ProdNum, Description, and price columns
	 * Another label is used to display the row number
	 * @param result A ResultSet
	 */
	public void showRowContent(ResultSet result) {
		try {
			//Display the content of the current row
			recipeName.setText(result.getString("Name"));
			recipeIngredients.setText("Ingredients Required: "+result.getString("RecipeIngredientParts"));
			recipeTime.setText("Total Time: "+result.getString("TotalTime"));
			
		} catch(Exception ex){
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
	
	
    public void ReturnButtonListener(ActionEvent e){
    	// the FXML loader object to load the UI design
    	FXMLLoader loader = new FXMLLoader();
    	// specify the file location
    	loader.setLocation(getClass().getResource("RecipeSelection.fxml"));
    	
		// try-catch for possible errors in reading the FXML file.
    	try {
    		// the object representing the root node of the scene; load the UI
    		Parent parent = loader.load();
   	
			// set the scene
			Scene scene = new Scene(parent);
    	   	
	    	// get the current window; i.e. the stage
	    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
	    	// change the title of the window
	    	stage.setTitle("RecipeSelection");
	    	// set the scene for the stage
	    	stage.setScene(scene);
	    	// show the stage
	    	stage.show();
			} catch (IOException e1) {
				
				System.out.print(e1.getMessage());
			}
    }


	
	
}
	

