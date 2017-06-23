
public class Solution {
    //Assume input string s is a valid arithmetic expression
    public int calculate(String s) {
      Stack<String> stack = new Stack<String>();
      int i = 0;
      while(i < s.length()){
        String token = "";
        if( !Character.isDigit( s.charAt(i) ) ){
          token = String.valueOf(s.charAt(i));
          i++;
        }else{
          int j = i;
          while(j < s.length() && Character.isDigit(s.charAt(j)) ) j++;
          token = s.substring(i, j);
          i = j;
        }
        addToStack(stack, token);

      }
      return Integer.parseInt(stack.pop());
    }
    private void addToStack(Stack<String> stack, String token){
      if(token.equals(" ")) return;
      else if(token.equals("(") || token.equals("+") || token.equals("-"))
        stack.push(token);
      else if(token.equals(")")){
        String back = stack.pop();
        stack.pop();
        addToStack(stack, back);
      }else{
        if(stack.isEmpty())
          stack.push(token);
        else if(stack.peek().equals("(")){
          stack.push(token);
        }else{
          String opd = stack.pop();
          String op1 = stack.pop();
          stack.push(cal(op1, token, opd));
        }
      }
    }
    private String cal(String op1, String op2, String opd){
      if(opd.equals("-"))
        return  Integer.toString(Integer.parseInt(op1) - Integer.parseInt(op2)) ;
      else
        return  Integer.toString(Integer.parseInt(op1) + Integer.parseInt(op2)) ;
    }
}
