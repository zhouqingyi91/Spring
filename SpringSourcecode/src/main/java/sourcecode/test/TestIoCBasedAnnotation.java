package sourcecode.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sourcecode.ioc.annotation.po.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-ioc.xml")
public class TestIoCBasedAnnotation {

	@Test
	public void testInitApplicationContext() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc.xml");
		Student bean = (Student) context.getBean("student");
		Student bean2 = (Student) context.getBean("student");
		System.out.println(bean);
		System.out.println(bean2);
	}

}
