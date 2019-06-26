package version1_0;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
/**
 *  The main function
 *  
 * @author WOQUQ
 *
 */
public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("ZHI's relationship demo");
		
		initRootLayout();
		
		showHomeOverview();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Initializes the root layout
	 */
	public void initRootLayout() {
		//Load root layout from fxml file
		FXMLLoader loader = new  FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
		try {
			rootLayout = (BorderPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Show the scene containing the root layout
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	/**
	 * Show the home overview inside the root layout
	 */
	public void showHomeOverview() {
		try {
			//Load home overview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/HomeOverview.fxml"));
			AnchorPane homeOverview = (AnchorPane) loader.load();
			
			//Set home overview into the center of root layout
			rootLayout.setCenter(homeOverview);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}