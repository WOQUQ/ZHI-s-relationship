package version1_0.model;
/**
 * Model class for a label
 * @author WOQUQ
 *
 */
public class Label {
	String name;
	String area;
	String id;
	/**.
	 * Constructor for a label
	 * @param String name
	 * @return label
	 */
	public Label(String name,String area, String id) {
		this.id = id;
		this.name = name;
		this.area = area;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
