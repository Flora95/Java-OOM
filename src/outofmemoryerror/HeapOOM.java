package outofmemoryerror;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

	static class TestObject {
		
	}
	
	public static void main(String[] args) {
		List<TestObject> list = new ArrayList<TestObject>();
		
		while (true) {
			list.add(new TestObject());
		}
	}
}
