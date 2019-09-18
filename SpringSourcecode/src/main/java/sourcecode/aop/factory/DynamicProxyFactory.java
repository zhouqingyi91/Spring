package sourcecode.aop.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import sourcecode.aop.target.UserService;
import sourcecode.aop.target.UserServiceImpl;

public class DynamicProxyFactory {

	/**
	 * JDK动态代理（目标对象必须实现接口）
	 * @param service
	 * @return
	 */
	public static UserService getProxyByJDK(final UserService service) {
		// Proxy是JDK中的API类
		// 第一个参数：目标对象的类加载器
		// 第二个参数：目标对象的接口
		// 第二个参数：代理对象的调用处理器
		UserService proxy = (UserService) Proxy.newProxyInstance(service.getClass().getClassLoader(),
				service.getClass().getInterfaces(), new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

						System.out.println("记录日志-开始");

						// 下面的代码，是反射中的API用法
						// 该行代码，实际调用的是目标对象的方法
						Object object = method.invoke(service, args);

						System.out.println("记录日志-结束");
						return object;
					}
				});

		return proxy;
	}

	/**
	 * Cglib动态代理（目标对象不需要实现接口）
	 * @param service
	 * @return
	 */
	public static UserService getProxyByCglib(UserService service) {
		// 创建增强器
		Enhancer enhancer = new Enhancer();
		// 设置需要增强的类的类对象
		enhancer.setSuperclass(service.getClass());

		// 设置回调函数
		enhancer.setCallback(new MethodInterceptor() {

			// object :代理对象（子类对象）
			// method :目标父类中的方法
			// MethodProxy：代理之后的对象的方法引用
			@Override
			public Object intercept(Object object, Method method, Object[] arg, MethodProxy methodProxy)
					throws Throwable {

				long start = System.currentTimeMillis();
				System.out.println("记录程序开始时间..." + start);

				// 因为代理对象是目标对象的子类
				// 该行代码，实际调用的是目标对象的方法
				// object :代理对象
				Object result = methodProxy.invokeSuper(object, arg);

				long end = System.currentTimeMillis();
				System.out.println("记录程序结束时间..." + end);
				System.out.println("记录程序执行总时长..." + (end - start));
				return result;
			}
		});

		// 获取增强之后的代理对象
		return (UserServiceImpl) enhancer.create();
	}
}
