package sourcecode.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sourcecode.ioc.xml.po.Student;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:spring/spring-ioc.xml")
public class TestIoCBasedXML {

	@Test
	public void testInitApplicationContext() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-ioc.xml");
		Student bean2 = (Student) context.getBean("student");
		System.out.println(bean2);
		Student bean = (Student) context.getBean("student");
		System.out.println(bean);
	}

}
