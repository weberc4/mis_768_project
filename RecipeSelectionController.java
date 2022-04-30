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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

	public class RecipeSelectionController {

		// Declare the Connection object
		Connection conn;
	    // Declare the ResultSet object
	    ResultSet result;
		
	    Recipe r = new Recipe();
	    @FXML
	    private TextField avoidIngredients;

	    @FXML
	    private Button getRecipe;

	    @FXML
	    private TextField ingredientsOwned;

	    @FXML
	    private TextField occasion;

	    @FXML
	    private TextField region;

	    @FXML
	    public void generateRecipe(ActionEvent event) throws SQLException {


	    	try {
	    		
		    	String rOccasion = occasion.getText();
		    	
		    	String rRegion = region.getText();
		    	
		    	String rAvoidIngredients = avoidIngredients.getText();
		    			    	
		    	String rIngredientsOwned = ingredientsOwned.getText();
		    	
		    	r = new Recipe(rOccasion, rRegion, rAvoidIngredients, rIngredientsOwned);
	    		
		    	getResult();

//		    	if(!result.next()) {
//				    	Alert alert = new Alert(AlertType.WARNING);
//				    	alert.setTitle("No Recipe Found");
//				    	alert.setContentText("No recipe was found given desired attributes. \n Please try again.");
//
//				    	alert.showAndWait();
//		    	    
//			    	}
//		    	else {
			    
	        	FXMLLoader loader = new FXMLLoader();
	        	// specify the file location for the FXML file for the next window
	        	loader.setLocation(getClass().getResource("RecipeDBGenerator.fxml"));
	        	// load the UI for the next window
	        	Parent parent =loader.load();
	        	// set the scene
	        	Scene scene = new Scene(parent);

	        	// get the current stage, using the ActionEvent object
	        	Stage stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
	        	
	        	
//	        	stage.setUserData(r);
//	        	
	        	RecipeDBGeneratorController controller = loader.getController();
//
//	        	// call the method in the controller class
//	        	// Pass the ResultSet object to the Scene
	        	controller.initData(result);
	        	
	        	// change the title
	        	stage.setTitle("Recipe Found!");
	        	// set the new scene to the stage
	        	stage.setScene(scene);
	        	// show the stage
	        	stage.show();
		    	

	    	  } catch (IOException e) {
	    		  
	    	    System.err.println(String.format("Error: %s", e.getMessage()));
	    	  }
	    	
	    	
	    	}
	    
		private void getResult(){
			// Create named constants for the URL, user name and password
			try{
				RecipeDAOImpl rDAO = new RecipeDAOImpl();
				result = rDAO.getAllRecipes(r);

			    // Send the statement to the DBMS.
			 }
			 catch(Exception ex) {
				 System.out.println("ERROR: " + ex.getMessage());
			 }		
		}
		
	    
	    	
	    	
	    }
    
	    
	

