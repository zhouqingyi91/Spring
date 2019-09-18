package sourcecode.test;

import org.junit.Test;

import sourcecode.aop.factory.DynamicProxyFactory;
import sourcecode.aop.target.UserService;
import sourcecode.aop.target.UserServiceImpl;

public class TestDynamicProxy {

	/**
	 * 使用JDK的动态代理实现 它是基于接口实现的
	 */
	@Test
	public void getProxy() {

		// 目标对象
		UserService service = new UserServiceImpl();

		// 通过动态代理对象工厂，获取代理对象
		UserService proxy = DynamicProxyFactory.getProxyByJDK(service);

		// 调用目标对象方法
		service.saveUser();
		System.out.println("===============================================");
		// 调用代理对象方法
		proxy.saveUser();
	}

	/**
	 * 使用CGLib动态代理技术实现 它是基于继承的方式实现的
	 * 
	 */
	@Test
	public void getProxyByCgLib() {
		// 目标对象
		UserServiceImpl service = new UserServiceImpl();
		
		// 通过动态代理对象工厂，获取代理对象
		UserService proxy = DynamicProxyFactory.getProxyByCglib(service);

		// 调用目标对象方法
		service.saveUser();
		System.out.println("===============================================");
		// 调用代理对象方法
		proxy.saveUser();
	}
}
