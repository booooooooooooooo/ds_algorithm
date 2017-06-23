public class Solution {
    public int evalRPN(String[] tokens) {
      Stack<String> stack = new Stack<String>();
      int i = 0;
      while(i < tokens.length){
        if(tokens[i].equals("+")){
          String op1 = stack.pop();
          String op2 = stack.pop();
          Integer res = Integer.parseInt(op1) + Integer.parseInt(op2);
          stack.push(Integer.toString(res));
        }else if(tokens[i].equals("-")){
          String op1 = stack.pop();
          String op2 = stack.pop();
          Integer res = Integer.parseInt(op2) - Integer.parseInt(op1);
          stack.push(Integer.toString(res));
        }else if(tokens[i].equals("*")){
          String op1 = stack.pop();
          String op2 = stack.pop();
          Integer res = Integer.parseInt(op1) * Integer.parseInt(op2);
          stack.push(Integer.toString(res));
        }else if(tokens[i].equals("/")){
          String op1 = stack.pop();
          String op2 = stack.pop();
          Integer res = Integer.parseInt(op2) / Integer.parseInt(op1);
          stack.push(Integer.toString(res));
        }else
          stack.push(tokens[i]);
        i++;
      }
      return Integer.parseInt(stack.pop());
    }
}
