package outofmemoryerror;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 */
public class MethodAreaOOM {
	
	static class TestObject {}

	public static void main(String[] args) {
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(TestObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				
				@Override
				public Object intercept(Object obj, Method m, Object[] objects,
						MethodProxy proxy) throws Throwable {
					return proxy.invokeSuper(obj, objects);
				}
			});
			enhancer.create();
		}
	}
}
