package eg.edu.alexu.csd.datastructure.stack.cs20;

public class Stack implements IStack {

	int top;
	Object stack[];
	int stack_size;
	
	 Stack(int size) {
	 stack= new Object[size];
		top=0;
		stack_size=size;
	
	}
	
	public void push(Object element) {
		if(top==stack_size) {
			throw new RuntimeException("you can not push any other element") ;
		}
		else {
			stack[top]=element;
			top++;
		}
		
	}
	
	public Object pop() {
		
		if(top==0) {
			throw new RuntimeException("the stack is empty") ;
		}
		top--;
		Object data;
		data=stack[top];
		stack[top]=0;
		
		return data;
	 	
	}
	
	public Object peek() {
		if(top==0) {
			throw new RuntimeException("the stack is empty") ;
		}
		Object data;
		data=stack[top-1];
		
		return data;
	}
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		if(top==0) {
			return true;
		}
		else
			return false;
		
	}
	
}
