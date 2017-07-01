//I think my solution is correct BUT slow
//Also, I am not sharp on the logic of this problem. So I have made a lot of mistakes in the process.

import java.math.BigInteger;
public class Solution {
  private String num;
  private int target;
  private List<String> res;
  StringBuilder sb;
    //I assume num only contains digit characters.
    public List<String> addOperators(String num, int target) {
      //corner
      if(num == null || num.equals("")) return new ArrayList<String>();


      this.num = num;
      this.target = target;
      this.res = new ArrayList<String>();
      sb = new StringBuilder(num);
      dfs(0);
      return this.res;
    }
    private void dfs(int index){
      if(index >= sb.length() ){
        String exp = sb.toString();
        String ans = evaluate(exp);
        if(ans.equals(Integer.toString(this.target))) this.res.add(exp);
      }else if(index == 0){
        for(int i = 1; i <= sb.length(); i++){
          dfs(index + i);
        }
      }else if(sb.charAt(index) == '0'){
        sb.insert(index, '+');
        dfs(index + 2);
        sb.setCharAt(index, '-');
        dfs(index + 2);
        sb.setCharAt(index, '*');
        dfs(index + 2);
        sb.deleteCharAt(index);
      }else{
        sb.insert(index, '+');
        for(int i = 2; i <= sb.length() - index; i++)
          dfs(index + i);
        sb.setCharAt(index, '-');
        for(int i = 2; i <= sb.length() - index; i++)
          dfs(index + i);
        sb.setCharAt(index, '*');
        for(int i = 2; i <= sb.length() - index; i++)
          dfs(index + i);
        sb.deleteCharAt(index);

      }
    }
    private String evaluate(String exp){
      Stack<String> stack = new Stack<String>();
      int i = 0;
      while(i < exp.length()){
        int nextIndex;
        String token = "";
        if( !Character.isDigit( exp.charAt(i) ) ){
          token = String.valueOf(exp.charAt(i));
          nextIndex = i + 1;
        }else{
          int j = i;
          while(j < exp.length() && Character.isDigit(exp.charAt(j)) ) j++;
          token = exp.substring(i, j);
          nextIndex = j;
        }

        if(token.equals("+") || token.equals("-"))
          stack.push(token);
        else{//token is a number
          if(nextIndex == exp.length()){
            addOp2ToStack(stack, token);
          }else if(exp.charAt(nextIndex) == '*'){

            while(nextIndex < exp.length() && exp.charAt(nextIndex) != '+' && exp.charAt(nextIndex) != '-' )
              nextIndex++;
            String op2 = evalMul(exp, i, nextIndex);
            addOp2ToStack(stack, op2);
          }else{
            addOp2ToStack(stack, token);
          }
        }
        i = nextIndex;
      }
      return stack.pop();
    }
    private String evalMul(String exp, int start, int end){
      Stack<String> stack = new Stack<String>();
      int i = start;
      while(i < end){
        String token = "";
        if( !Character.isDigit( exp.charAt(i) ) ){
          token = String.valueOf(exp.charAt(i));
          i++;
        }else{
          int j = i;
          while(j < exp.length() && Character.isDigit(exp.charAt(j)) ) j++;
          token = exp.substring(i, j);
          i = j;
        }

        if(token.equals("*"))
          stack.push("*");
        else
          addOp2ToStack(stack, token);
      }
      return stack.pop();
    }
    private void addOp2ToStack(Stack<String> stack, String op2){
      if(stack.isEmpty())
        stack.push(op2);
      else{
        String opd = stack.pop();
        String op1 = stack.pop();
        stack.push(cal(op1, op2, opd));
      }

    }

    private String cal(String op1, String op2, String opd){
      if(opd.equals("-"))
        return  (new BigInteger(op1)).subtract(new BigInteger(op2)).toString();
      else if(opd.equals("+"))
        return  (new BigInteger(op1)).add(new BigInteger(op2)).toString();
      else //(opd.equals("*"))
        return  (new BigInteger(op1)).multiply(new BigInteger(op2)).toString();
    }


}
