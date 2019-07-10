package version1_0.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import version1_0.MainApp;

public class HomeOverviewController {
	//test
	@FXML
	private Button researchButton;
	@FXML
	private Button indexButton;
	@FXML
	private Button addButton;
	@FXML
	private Button helpButton;
	@FXML
	private Button quitButton;
	
	@FXML
	private ChoiceBox<String> choiceBox;
	@FXML
	private TextField textField;
	@FXML
	private Button goButton;
	
	//Reference to the main applicaiton 
	private MainApp mainApp;
	/**
	 * constructor
	 */
	public HomeOverviewController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	/**
	 * Is called by the main application to give a reference back to itself
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
	}
	
	@FXML
	private void openIndex() {
		try {
		//Load home overview
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/IndexOverview.fxml"));
		AnchorPane indexOverview = (AnchorPane) loader.load();
		
		//Set home overview into the center of root layout
		mainApp.rootLayout.setCenter(indexOverview);
		
		//give the controller access to the main applicaiton
		IndexOverviewController controller = loader.getController();
		controller.setMainApp(mainApp);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
