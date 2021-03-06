package sourcecode.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sourcecode.aop.target.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-tx.xml")
public class TestTX {

	@Autowired
	private UserService service;
	
	@Test
	public void test() {
		service.saveUser();
	}
}
