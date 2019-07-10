package version1_0;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import version1_0.model.Person;
import version1_0.view.HomeOverviewController;
import javafx.fxml.FXMLLoader;
/**
 *  The main function
 *  
 * @author WOQUQ
 *
 */
public class MainApp extends Application {
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:zadb;create=true";
	
	private Stage primaryStage;
	public BorderPane rootLayout;
	
	/**
	 * create the databases
	 * 
	 */
	private static void createDB() {
		try {
			
			Class.forName(DRIVER);
			
			Connection connection = DriverManager.getConnection(JDBC_URL);
			connection.createStatement().execute("create table person(Id varchar(20), Name varchar(50), "
					+ "Location varchar(80), Birthday varchar(50), Job varchar(40), Age varchar(40), PhoneNumber varchar(40), "
					+ "Email varchae(40),Weixin varchar(40), Qq varchar(40), Relation varchar(40), Note varchar(250), LabelList varchar(40))");
			connection.createStatement().execute("create table maxId(maxId integer)");
			connection.createStatement().execute("create table label(Name varchar(20),Area varchar(20),Id varchar(20))");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * for test
	 */
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	
	/**
	 * Constructor
	 */
	public MainApp() {
		//Add the data to test
		personData.add(new Person("0001","1-1","1-2",LocalDate.of(1995, 10, 25),"1-4","1-5","1-6","1-7","1-8","1-9","1-10","1-11"));
		personData.add(new Person("0002","2-1","2-2",LocalDate.of(1995, 10, 25),"2-4","2-5","2-6","2-7","2-8","2-9","2-10","2-11"));
		personData.add(new Person("0003","3-1","3-2",LocalDate.of(1995, 10, 25),"3-4","3-5","3-6","3-7","3-8","3-9","3-10","3-11"));
		personData.add(new Person("0004","4-1","4-2",LocalDate.of(1995, 10, 25),"4-4","4-5","4-6","4-7","4-8","4-9","4-10","4-11"));
		personData.add(new Person("0005","5-1","5-2",LocalDate.of(1995, 10, 25),"5-4","5-5","5-6","5-7","5-8","5-9","5-10","5-11"));
	}
	
	public ObservableList<Person> getPersonData() {
		return personData;
	}

	public void setPersonData(ObservableList<Person> personData) {
		this.personData = personData;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("ZHI's relationship demo");
		
		initRootLayout();
		
		showHomeOverview();
	}

	public static void main(String[] args) {
		createDB();
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
			
			//Give the controller access to the main app
			HomeOverviewController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}