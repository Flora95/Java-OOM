package outofmemoryerror;

public class StackError {

	// 作用是使test2()在执行new StackError()时不断的在栈中创建StackError对象
	private StackError stackError = new StackError();

	/*
	 * VM Args: -Xss128k
	 * 措施：设置-Xss参数减少栈内存容量
	 * 结果：StackOverflowError
	 */
	public static void test1() {
		test1();
	}
	
	/*
	 * 措施：定义大量本地变量，增大方法帧中本地变量表的长度
	 * 结果：StackOverflowError
	 */
	public static void test2() {
		new StackError();
	}
	
	/*
	 * VM Args: -Xss128k
	 * 措施：不断的创建线程，使其耗尽内存抛出异常
	 * 结果：OutOfMemoryError
	 */
	public static void test3() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					while (true) {
						
					}
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		// 单线程
		//test1();
		test2();
		
		// 多线程
		//test3();
	}
}
