package sourcecode.ioc.xml.po;

public class Course {

	private String name;

	public Course() {
		System.out.println("course对象被创建");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}