/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mycalc;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Vector;


/**
 *
 * @author Admin
 */
public class BuiltFunction {
    static int Prec(char ch)
    {
        // dua ra muc uu tien cho toan tu
        switch (ch)
        {
        case '+':
        case '-':
            return 1;
      
        case '*':
        case '/':
            return 2;
      
        case '^':
            return 3;
        }
        return -1;
    }

    // The main method that converts
    // given infix expression
    // to postfix expression.
    static String infixToPostfix(String exp)
    {
        // khoi tao xau rong chua ket qua
        String result = new String("");
         
        // khoi tao stack rong
        Stack<Character> stack = new Stack<>();
         
        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);
             
            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c) || Character.compare(c, '.') == 0)   
            {
                result += c;
            }
              
            // If the scanned character is an '(',
            // push it to the stack.
            else if (c == '(')
            {
                stack.push(c);
            }
             
            //  If the scanned character is an ')',
            // pop and output from the stack
            // until an '(' is encountered.
            else if (c == ')')
            {
                //them khoang trang de tach ra
                result += ' ';
                while (!stack.isEmpty() && stack.peek() != '(')
                {
                    result += ' ';
                    result += stack.pop();
                }
                    stack.pop();
            }
            else // an operator is encountered
            {
                //them khoang trang de tach ra
                result += ' ';
                while (!stack.isEmpty() && Prec(c)<= Prec(stack.peek()))
                {
                    result += ' ';
                    result += stack.pop();
                }
                result += ' ';
                stack.push(c);
            }
      
        }
      
        // pop all the operators from the stack
        while (!stack.isEmpty())
        {
            //them khoang trang de tach ra
            result += ' ';
            if(stack.peek() == '(')
            {
                return "Invalid Expression";
            }
            result += stack.pop();
         }
        return result;
    }
    static Vector<String> inputTransform(String Str)
   {
       // tach xau ki tu dau vao thanh 1 vector dua vao cac khoang trang
      Vector<String> v = new Vector<String>(Arrays.asList(Str.split("\\s+")));
      return v;
   }
    // Driver method
    
    static String computePostfix(Vector<String> Vec)
    {
        //khoi tao bien s1, s2 chua cac gia tri pop
        Double s1,s2;
        
        //khoi tao stack
        Stack<Double> numbers = new Stack<>();
        for (int i = 0; i < Vec.size(); i++) 
        {
         if(Character.isDigit(Vec.get(i).charAt(0)))
        {
            // dua so vao stack
            double f=Double.parseDouble(Vec.get(i));  
            numbers.push(f);
        }
        else
        {
            //dua toan tu vao de tinh toan
            try{
                s2 =  new Double(numbers.pop());
             s1 =  new Double(numbers.pop());
            }
            catch(EmptyStackException err)
            {
                //xu ly cac loi cu phap
                return "syntax err";
            }
            
            
            switch(Vec.get(i).charAt(0))
            {
                case '+':
                    numbers.push( s1 + s2);
                    break;
                case '-':
                    numbers.push(s1 - s2);
                    break;
                case '*':
                    numbers.push(s1*s2);
                    break;
                case '/': 
                    try{
                        Double temp = s1/s2;
                        numbers.push(temp);
                    }
                    catch(ArithmeticException ex)
                            {
                                //xu ly chia cho 0
                                return ex.toString();
                            }
                    
                    break;
                case'^':
                    numbers.push(Math.pow(s1, s2));
                    break;
  
                default:
                    break;
                    
                    
            }
            
        }
        }
        
        return String.valueOf(numbers.pop());
    }
    
    
}
