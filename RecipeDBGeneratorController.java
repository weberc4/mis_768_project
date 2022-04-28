package aRecipe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RecipeDBGeneratorController {

    @FXML
    private Button getInstructions;

    @FXML
    private Button getNutrition;

    @FXML
    private Label ingredients;

    @FXML
    private Label recipeName;

    @FXML
    private Button saveRecipe;

    @FXML
    private Label showRows;

	
	// Declare the Connection object
	Connection conn;
    // Declare the ResultSet object
    ResultSet result;	
    
    
//	@FXML
//	private void receiveData(ActionEvent event) {
//	  // Step 1
//	  Node node = (Node) event.getSource();
//	  Stage stage = (Stage) node.getScene().getWindow();
//	  // Step 2
//	  Recipe r = (Recipe) stage.getUserData();
//
//	
//	}
	
    public void initData(ResultSet re) throws SQLException {
    	// assign the passed ResultSet object to the result variable in this class
    	result = re;
    	
    	try {
    		// Display the number of rows
    		result.last();		    		// Move to the last row
    		int numRows = result.getRow();  // Get the current row number
    		result.first();		    		// Move back to the first row
    		showRows.setText("Total Rows: "+numRows);

    		//Update the labels to show the content of the current row; i.e., the first row
    		showRowContent(result);
    	}
    	catch (Exception ex){
    		System.out.println("ERROR at initData(): " + ex.getMessage());
    	}
    }

	public void showRowContent(ResultSet result) {
		try {
			//Display the content of the current row
    		recipeName.setText(result.getString("Name"));
	
			
		} catch(Exception ex){
			System.out.println("ERROR: " + ex.getMessage());
		}
	}


	
	
}
