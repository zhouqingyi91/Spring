package sourcecode.ioc.xml.po;

public class Student {

	private String name;

	private Course course;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void initMethod() {
		System.out.println("initMethod...");
	}

	public void destroyMethod() {
		System.out.println("destroyMethod...");
	}
	
	
}
