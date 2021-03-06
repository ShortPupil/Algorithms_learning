package Chapter1_1;

import java.util.Scanner;
import java.util.Stack;

public class P80_Evaluate {

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		while(!sc.hasNextLine()) {
			String s = sc.nextLine();
			if	(s.equals("(")) ops.push(s);
			else if (s.equals("+") || s.equals("-") 
					|| s.equals("*")|| s.equals("/")
					|| s.equals("sqrt")) 
				ops.push(s);
			else if(s.equals(")")){
				String op = ops.pop();
				double v = vals.pop();
				if(op.equals("+")) v = vals.pop() + v;
				else if(op.equals("-")) v = vals.pop() - v;
				else if(op.equals("*")) v = vals.pop() * v;
				else if(op.equals("/")) v = vals.pop() / v;
				else if(op.equals("sqrt")) v = Math.sqrt(v);
				vals.push(v);
			}
			else vals.push(Double.parseDouble(s));
		}
		System.out.println(vals.pop());
		sc.close();
	}
}
