package sourcecode.ioc.xml.po;

//@Component
public class Student {

	private String name;

//	@Autowired
	private Course course;

	public Student() {
		System.out.println("student对象被创建");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCourse(Course course) {
		this.course = course;
		System.out.println("course对象被注入到student对象里");
	}

	public Course getCourse() {
		return course;
	}

	public void initMethod() {
		System.out.println("initMethod...");
	}

	public void destroyMethod() {
		System.out.println("destroyMethod...");
	}
	
	
}
