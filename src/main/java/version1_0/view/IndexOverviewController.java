package version1_0.view;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import version1_0.MainApp;
import version1_0.model.Person;

public class IndexOverviewController {

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
	private TableView<Person> personTable;
	
	@FXML
	private TableColumn<Person,String> nameColumn;
	@FXML
	private TableColumn<Person,String> jobColumn;
	@FXML
	private TableColumn<Person,String> relationColumn;
	@FXML
	private TableColumn<Person,String> phoneColumn;
	@FXML
	private TableColumn<Person,String> weixinColumn;
	@FXML
	private TableColumn<Person,String> qqColumn;
	
	@FXML
	private CheckBox phoneCheckBox;
	@FXML
	private CheckBox weixinCheckBox;
	@FXML
	private CheckBox qqCheckBox;
	
	@FXML
	private ChoiceBox<String> areaChoiceBox;
	@FXML
	private ChoiceBox<String> labelChoiceBox;
	
	//reference to the main application
	private MainApp mainApp;
	/**
	 * Constructor
	 */
	public IndexOverviewController() {
		
	}
	
	@FXML
	private void initialize() {
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
		jobColumn.setCellValueFactory(cellData -> cellData.getValue().getJob());
		relationColumn.setCellValueFactory(cellData -> cellData.getValue().getRelation());
		phoneColumn.setCellValueFactory(cellData -> cellData.getValue().getPhoneNumber());
		weixinColumn.setCellValueFactory(cellData -> cellData.getValue().getWeixin());
		qqColumn.setCellValueFactory(cellData -> cellData.getValue().getQq());
	}
	
	/**
	 * get the person data from the home overview
	 */
	public void getDataFromHome() {
		
	}
	/**
	 * get the reference to the mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
		personTable.setItems(mainApp.getPersonData());
	}
}
