package outofmemoryerror;

public class StackError {

	// ������ʹtest2()��ִ��new StackError()ʱ���ϵ���ջ�д���StackError����
	private StackError stackError = new StackError();

	/*
	 * VM Args: -Xss128k
	 * ��ʩ������-Xss��������ջ�ڴ�����
	 * �����StackOverflowError
	 */
	public static void test1() {
		test1();
	}
	
	/*
	 * ��ʩ������������ر��������󷽷�֡�б��ر�����ĳ���
	 * �����StackOverflowError
	 */
	public static void test2() {
		new StackError();
	}
	
	/*
	 * VM Args: -Xss128k
	 * ��ʩ�����ϵĴ����̣߳�ʹ��ľ��ڴ��׳��쳣
	 * �����OutOfMemoryError
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
		// ���߳�
		//test1();
		test2();
		
		// ���߳�
		//test3();
	}
}
