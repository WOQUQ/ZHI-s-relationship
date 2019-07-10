package version1_0.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.derby.iapi.sql.Statement;

import version1_0.model.Label;
import version1_0.model.Person;
import version1_0.util.DateUtil;

public class PersonDB {
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:zadb;create=true";
	
	public void addPersonDB(Person person) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		
		java.sql.Statement query = connection.createStatement();
		
		String id = person.getPersonId().get();
		String name = person.getName().get();
		String location = person.getLocation().get();
		String birthday = person.getBirthday().get().toString();
		String job = person.getJob().get();
		String age = person.getAge().get();
		String phoneNumber = person.getPhoneNumber().get();
		String weixin = person.getWeixin().get();
		String qq = person.getQq().get();
		String relation = person.getRelation().get();
		String note = person.getNote().get();
		String email = person.getEmail().get();
		
		String labelList = "";
		//ArrayList<String> labelList = new ArrayList<>();
		for(Label label : person.getLabelList()) {
			labelList += label.getId()+",";
		}//save the id of the labels such like 3,7,52,15,
		
		//check the number of persons in the database
		//ResultSet resultset = query.executeQuery("SELECT Id FROM person");
//		int currentId = 1;
//		while(resultset.next()) {
//			if(resultset.getInt(1))
//		}
		
		int result = query.executeUpdate("INSERT INTO person VALUES('"+id+"','"+name+"','"+location+"','"+birthday+"','"
									+job+"','"+age+"','"+phoneNumber+"','"+email+"','"+weixin+"','"+qq+"','"+relation+"','"
									+note+"','"+labelList+"')");
		
	}
	
	public Person getPersonDB(String id) throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		java.sql.Statement query =  connection.createStatement();
		ResultSet resultset =  query.executeQuery("SELECT * FROM person WHERE id='"+id+"'");

		
		while(resultset.next()) {
			String name = resultset.getString(1);
			String location = resultset.getString(2);
			String birthday = resultset.getString(3);
			String job = resultset.getString(4);
			String age = resultset.getString(5);
			String phoneNumber = resultset.getString(6);
			String email = resultset.getString(7);
			String weixin = resultset.getString(8);
			String qq = resultset.getString(9);
			String relation = resultset.getString(10);
			String note = resultset.getString(11);
			String labelList = resultset.getString(12);
			
			//DateUtil dateUtile = new DateUtil();
			LocalDate localdate = DateUtil.parse(birthday);
			Person person = new Person(id,name,location,localdate,job,age,phoneNumber,email,weixin,qq,relation,note);
		}
		
		return null;
		
	}
}
