package eg.edu.alexu.csd.datastructure.stack.cs20;

import java.util.Scanner;

public class run {

	public static void main(String[] args) {
		String operation;
		Scanner scan=new Scanner(System.in);
		while(true) {
		 
              System.out.println("Please enter the operation : ");
  
                operation = scan.next();
          
        
		  
		
		  ExpressionEvaluator l=new ExpressionEvaluator();
		  System.out.println("\nthe result =");
		  System.out.println(l.evaluate(l.infixToPostfix(operation)));
		 
	}
	}
}

