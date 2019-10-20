package sourcecode.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sourcecode.aop.target.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:spring/spring-aop.xml")
@ContextConfiguration(locations="classpath:spring/spring-aop-annotation.xml")
public class TestAOP {

	@Autowired
	private UserService userService;

	private static String annotationConfig = "spring/spring-aop-annotation.xml";
	
	
	@Test
	public void testXML() {
		userService.saveUser();
	}

	@Test
	public void testAnnotation() {
		this.userService.saveUser();
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(annotationConfig);
		UserService userService = (UserService) context.getBean("userServiceImpl");
		userService.saveUser();
	}
}
