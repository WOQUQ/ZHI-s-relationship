package version1_0.model;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.beans.InvalidationListener;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 * Model class for a Person
 * 
 * @author WOQUQ
 * 
 */
public class Person {

	private StringProperty personId = new SimpleStringProperty("");//0001
	private  StringProperty name = new SimpleStringProperty(""); 
	private  StringProperty location = new SimpleStringProperty(""); 
	private  ObjectProperty<LocalDate> birthday =new SimpleObjectProperty<LocalDate>(LocalDate.of(1995, 10, 25));
	private  StringProperty job = new SimpleStringProperty(""); 
	private  StringProperty age = new SimpleStringProperty(""); 
	private  StringProperty email = new SimpleStringProperty("");
	public StringProperty getPersonId() {
		return personId;
	}

	public void setPersonId(StringProperty personId) {
		this.personId = personId;
	}

	public StringProperty getAge() {
		return age;
	}

	public void setAge(StringProperty age) {
		this.age = age;
	}

	private  StringProperty phoneNumber = new SimpleStringProperty(""); 
	private  StringProperty weixin = new SimpleStringProperty(""); 
	private  StringProperty qq = new SimpleStringProperty("");
	private  StringProperty relation = new SimpleStringProperty("");
	private  StringProperty note = new SimpleStringProperty("");
	private  ListProperty<Label> labelList =  new ListProperty<Label>() {
		
		public void removeListener(ListChangeListener<? super Label> arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public void addListener(ListChangeListener<? super Label> arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public void set(ObservableList<Label> arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public ObservableList<Label> get() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public void removeListener(InvalidationListener arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public void addListener(InvalidationListener arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public void removeListener(ChangeListener<? super ObservableList<Label>> arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public void addListener(ChangeListener<? super ObservableList<Label>> arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public Object getBean() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public void unbind() {
			// TODO Auto-generated method stub
			
		}
		
		public boolean isBound() {
			// TODO Auto-generated method stub
			return false;
		}
		
		public void bind(ObservableValue<? extends ObservableList<Label>> arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public ReadOnlyIntegerProperty sizeProperty() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public ReadOnlyBooleanProperty emptyProperty() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	/**
	 * Constructor
	 * 
	 */
	public Person(String id, String name,String location,LocalDate birthday,String job,
			String phoneNumber,String weixin,String qq,String relation,String note,String age,String email) {
		
		this.personId = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.location = new SimpleStringProperty(location);
		this.birthday = new SimpleObjectProperty<LocalDate>(birthday);
		this.job = new  SimpleStringProperty(job);
		this.phoneNumber = new SimpleStringProperty(phoneNumber);
		this.weixin = new SimpleStringProperty(weixin);
		this.qq = new SimpleStringProperty(qq);
		this.relation = new SimpleStringProperty(relation);
		this.note = new SimpleStringProperty(note);
		this.age = new SimpleStringProperty(age);
		this.email = new SimpleStringProperty(email);
	}

	public StringProperty getEmail() {
		return email;
	}

	public void setEmail(StringProperty email) {
		this.email = email;
	}

	public StringProperty getName() {
		return name;
	}

	public void setName(StringProperty name) {
		this.name = name;
	}

	public StringProperty getLocation() {
		return location;
	}

	public void setLocation(StringProperty location) {
		this.location = location;
	}

	public ObjectProperty<LocalDate> getBirthday() {
		return birthday;
	}

	public void setBirthday(ObjectProperty<LocalDate> birthday) {
		this.birthday = birthday;
	}

	public StringProperty getJob() {
		return job;
	}

	public void setJob(StringProperty job) {
		this.job = job;
	}

	public StringProperty getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(StringProperty phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public StringProperty getWeixin() {
		return weixin;
	}

	public void setWeixin(StringProperty weixin) {
		this.weixin = weixin;
	}

	public StringProperty getQq() {
		return qq;
	}

	public void setQq(StringProperty qq) {
		this.qq = qq;
	}

	public StringProperty getRelation() {
		return relation;
	}

	public void setRelation(StringProperty relation) {
		this.relation = relation;
	}

	public StringProperty getNote() {
		return note;
	}

	public void setNote(StringProperty note) {
		this.note = note;
	}

	public ListProperty<Label> getLabelList() {
		return labelList;
	}

	public void setLabelList(ListProperty<Label> labelList) {
		this.labelList = labelList;
	}
}
