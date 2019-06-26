package version1_0.model;
/**
 * Model class for a label
 * @author WOQUQ
 *
 */
public class Label {
	String name;
	String area;
	/**.
	 * Constructor for a label
	 * @param String name
	 * @return label
	 */
	public Label(String name,String area) {
		this.name = name;
		this.area = area;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
