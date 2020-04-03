package eg.edu.alexu.csd.datastructure.stack.cs20;


public class ExpressionEvaluator {

	boolean precedence;
	int check=0;
	
	
	 public  String insert(  String originalString,  String stringToBeInserted,  int index)     { 
		   
		        String newString = new String(); 
		  
		        for (int i = 0; i < originalString.length(); i++) { 
		  
		            if (i == index) { 
		                newString += stringToBeInserted;  } 
		       
		            newString += originalString.charAt(i);    
		        } 
		        return newString; 
	  } 
	 public  String insertend(  String originalString,  String stringToBeInserted,  int index)     { 
		   
	        String newString = new String(); 
	  
	        for (int i = 0; i < originalString.length(); i++) { 
	            newString += originalString.charAt(i);
	  
	            if (i == index) { 
	                newString += stringToBeInserted;  } 
	          
	        } 
	        return newString; 
} 

	
	public String check(String expression) {
		int count=0;
		int i=0;
		while(i<expression.length()) {
		if(i==0&&expression.charAt(i)=='-') {
		expression=insert(expression,"0",0);
		i++;
		}
		
		else if(i+2==expression.length()&&expression.charAt(i)=='-'&&(expression.charAt(i-1)=='+'||expression.charAt(i-1)=='*'||expression.charAt(i-1)=='-'||expression.charAt(i-1)=='/')) {
			expression=insert(expression,"(0",i);
			expression=insertend(expression,")",i+3);
			i++;
		}
		else if(expression.charAt(i)=='-'&&(expression.charAt(i+1)!='+'||expression.charAt(i+1)!='*'||expression.charAt(i+1)!='-'||expression.charAt(i+1)!='/')&&(expression.charAt(i-1)=='+'||expression.charAt(i-1)=='*'||expression.charAt(i-1)=='-'||expression.charAt(i-1)=='/')&&expression.charAt(i+1)=='(') {
			while(expression.charAt(i+count)!=')') {
				count++;
			}
			expression=insert(expression,"(0",i);
			expression=insert(expression,")",i+count+3);
		}
		else if(expression.charAt(i)=='-'&&(expression.charAt(i+1)!='+'||expression.charAt(i+1)!='*'||expression.charAt(i+1)!='-'||expression.charAt(i+1)!='/')&&(expression.charAt(i-1)=='+'||expression.charAt(i-1)=='*'||expression.charAt(i-1)=='-'||expression.charAt(i-1)=='/')) {
			expression=insert(expression,"(0",i);
			expression=insert(expression,")",i+4);
			i++;
			}
		else
			i++;
		}
		return expression;
	}
	
	public void check2(String expression) {
		boolean operator=false;
		int i=0;
	
		while(i<expression.length()) {
			if(expression.charAt(i)=='+'||expression.charAt(i)=='*'||expression.charAt(i)=='-'||expression.charAt(i)=='/')
				operator = true;
		if((expression.charAt(i)=='+'||expression.charAt(i)=='*'||expression.charAt(i)=='-'||expression.charAt(i)=='/')&&(expression.charAt(i+1)=='+'||expression.charAt(i+1)=='*'||expression.charAt(i+1)=='-'||expression.charAt(i+1)=='/')) {
			throw new RuntimeException("INVALID");
	
		}
	
		i++;
		}
		if(!operator)
			throw new RuntimeException("INVALID");
	}
	
	public void check3(String expression) {
		int i=0;
		boolean letter=false;
		while(i<expression.length()) {
			if(Character.isLetter(expression.charAt(i)))
				letter=true;
			i++;
		}
		if(letter)
			throw new RuntimeException("can not evaluate alphapitic symbols");
	}
	
	public String infixToPostfix(String expression) {
		expression=(String)check(expression);
		check2(expression);
		int i=0;
		String postfix="";
		Stack operator=new Stack(expression.length());
		
	while(i<expression.length()) {
			if(expression.charAt(i)==')') {
				while((char)operator.peek()!='(') {
				postfix+=operator.pop();
				postfix+=' ';
				}
				operator.pop();
				i++;
			}
			
			
			else if(expression.charAt(i)=='(') {
				operator.push(expression.charAt(i));
				i++;
			}
			
			
			
			
			else if(expression.charAt(i)=='+'||expression.charAt(i)=='-'||expression.charAt(i)=='*'||expression.charAt(i)=='/') {
				
				if(operator.size()!=0) {
					
				if(((char)operator.peek()=='+'||(char)operator.peek()=='-')&&(expression.charAt(i)=='*'||expression.charAt(i)=='/')) {
					precedence=true;
				}
				else {
					precedence=false;  }
			
				if((char)operator.peek()!='(') {
				if((check==2||check>2)&&!precedence) {
					while(operator.size()!=0&&(char)operator.peek()!='('&&!precedence) {
				    if((check==2||check>2)&&!precedence) {
					postfix+=operator.pop();
				    check--;
				    postfix+=' ';
				
					}
					if(operator.size()!=0) {
						
						if(((char)operator.peek()=='+'||(char)operator.peek()=='-')&&(expression.charAt(i)=='*'||expression.charAt(i)=='/')) {
							precedence=true;
						}
						else {
							precedence=false;  }
					}
				    
				}
				}
			
				}
				}
				operator.push(expression.charAt(i));
				i++;
			
			}
			
			
			
			else {
				
                while(expression.charAt(i)!='+'&&expression.charAt(i)!='-'&&expression.charAt(i)!='*'&&expression.charAt(i)!='/'&&expression.charAt(i)!=')') {
				postfix+=expression.charAt(i);
				check++;
				i++;
				if(i==expression.length()) {
					break;
				}
                }
                postfix+=' ';
			}
		
	}
	while(operator.top!=0) {
		postfix+=operator.pop();
		  postfix+=' ';
	}
	
	
		return postfix;
	}
	
	public int evaluate(String expression) {
		check3(expression);
		Stack operand=new Stack(expression.length());
		int result=0 ;
		int result2=0 ;
		int i=0;
		check=0;
		String num="";
		while(i<expression.length()) {
			if(expression.charAt(i)!='+'&&expression.charAt(i)!='-'&&expression.charAt(i)!='*'&&expression.charAt(i)!='/'&&expression.charAt(i)!=' ') {
			while(expression.charAt(i)!='+'&&expression.charAt(i)!='-'&&expression.charAt(i)!='*'&&expression.charAt(i)!='/'&&expression.charAt(i)!=' ') {
				num+=expression.charAt(i);
				i++;
			}
			check++;
			operand.push(Integer.valueOf(num));
			num="";
			}
			 
			else if((check==2||check>2)&&expression.charAt(i)!=' ') {
				switch (expression.charAt(i)) {
				case '+' :
					result=(int)operand.pop();
					result+=(int)operand.pop();
					operand.push(result);
					check--;
					break;
				case '-' :
					result=(int)operand.pop();
					result2=(int)operand.pop();
					result2-=result;
					operand.push(result2);
					check--;
					break;
				case '*' :
					result=(int)operand.pop();
					result*=(int)operand.pop();
					operand.push(result);
					check--;
					break;
				case '/' :
					result=(int) operand.pop();
					if(result==0)
						throw new RuntimeException("INVALID, dividion by zero ");
					result2=(int) operand.pop();
					result2/=result;
					operand.push(result2);
					check--;
					break;
				}
				i++;
				}
			
			else {
				i++;
			}		
			
		}
	
		return (int)operand.pop();
	}

}

