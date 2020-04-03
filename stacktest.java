package eg.edu.alexu.csd.datastructure.stack.cs20;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class stacktest {


	Stack test=new Stack(3);
	@Test
	void test() {
		assertThrows(RuntimeException.class,()->{test.pop();});
	
	}
	
	@Test
	void test1() {
		test.push(55);
		assertEquals(55,test.pop());
		assertThrows(RuntimeException.class,()->{test.pop();});
	
	}
	
	@Test
	void test2() {
		test.push(55);
		assertEquals(55,test.peek());
		
	
	}
	@Test
	void test3() {
		assertThrows(RuntimeException.class,()->{test.peek();});

	}
	
	
	@Test
	void test4() {
		test.push(55);
		assertEquals(1,test.size());
	
	}
	@Test
	void test5() {
	
		assertEquals(0,test.size());
	
	}
	
	@Test
	void test6() {
		test.push(55);
		test.push(44);
		test.push(33);
		
		
		assertThrows(RuntimeException.class,()->{test.push(100);});
		
	
	}
	
	
	@Test
	void test7() {
		test.push(55);
		assertEquals(55,test.peek());
		assertEquals(55,test.peek());
		
	
	}
	
	@Test
	void test8() {
		test.push(55);
		test.push(44);
		test.push(33);
		assertThrows(RuntimeException.class,()->{test.push(100);});
		assertEquals(33,test.pop());
		assertEquals(44,test.pop());
		assertEquals(55,test.pop());
		assertThrows(RuntimeException.class,()->{test.pop();});
		
	
	}
}
