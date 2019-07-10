package version1_0.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import version1_0.model.Label;

public class LabelDB {
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:zadb;create=true";
	/**
	 * 
	 * @param label
	 * @throws ClassNotFoundException,SQLException
	 * @author WOQUQ
	 */
	public void addLabelDB(Label label) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		
		java.sql.Statement query = connection.createStatement();
		
		String name = label.getName();
		String area = label.getArea();
		String id = label.getId();
		
		//get all id in the labelDB now
		ResultSet resultset = query.executeQuery("SELECT Name FROM label");
		
		String[] nameset = new String[1000];
		int i = 0;
		while(resultset.next()) {
			nameset[i] = resultset.getString(1);
			i++;
		}
		//check if the name of the new label has existed in the database
		Boolean newFlag = true;//true if the label is a new one
		for(int n = 0; n < nameset.length; n++) {
			if(name.equals(nameset[n])) {
				newFlag = false;
			}
		}
		
		if(newFlag) {
			//if the label is a new one, add it into the database
			query.executeUpdate("INSERT INTO label VALUES('"+name+"','"+area+"','"+id+"')");
		}
		
	}
	/**
	 * 
	 * @param name_ (the name of the wanted label )
	 * @return label
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @author WOQUQ
	 */
	public Label getLabelDB(String name_) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		java.sql.Statement query = connection.createStatement();
		
		ResultSet resultset = query.executeQuery("SELECT * FROM label WHERE name='"+name_+"'");
		
		String name = resultset.getString(1);
		String area = resultset.getString(2);
		String id  = resultset.getString(3);
		Label label = new Label(name,area,id);
		return label;
	}
	
}
