public class Solution {
  public String multiply(String num1, String num2) {
      //exclude corner case:None

      int[] arrResult = new int[num1.length() + num2.length()];
      arrResult[num1.length() + num2.length() - 1] = 0;
      for(int i = num1.length() - 1; i >= 0; i--){
        for(int j = num2.length() - 1; j >= 0; j--){
          int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
          int sum = mul + arrResult[i + j + 1];
          arrResult[i + j + 1] = sum % 10;
          arrResult[i + j] += sum / 10;
        }
      }

      StringBuilder sb = new StringBuilder();
      for(int a : arrResult){
        if(!(sb.length() == 0 && a == 0))
          sb.append(a);
      }
      return sb.length() == 0 ? "0" : sb.toString();
  }
}










//TLE. Too many string operations???
public class Solution {
    public String multiply(String num1, String num2) {
      //exclude corner case. None.

      return solve(num1, num2);
    }

    public String solve(String num1, String num2){
      if(num1.equals("") || num2.equals("")) return "0";
      if(num1.length() == 1 && num2.length() == 1){
        int mul = Integer.valueOf(num1) * Integer.valueOf(num2);
        return Integer.toString(mul);
      }

      int div1 = (num1.length() - 1) / 2;
      int div2 = (num2.length() - 1) / 2;

      String l1 = num1.substring(0, div1 + 1);
      String r1 = num1.substring(div1 + 1, num1.length());
      String l2 = num2.substring(0, div2 + 1);
      String r2 = num2.substring(div2 + 1, num2.length());

      String suffix1 = "";
      for(int i = 0; i < r1.length(); i++) suffix1 = suffix1 + "0";
      String suffix2 = "";
      for(int i = 0; i < r2.length(); i++) suffix2 = suffix2 + "0";

      String result = "";
      result = add(result, solve(l1 , l2 ) + suffix1 + suffix2 );
      result = add(result, solve(l1 , r2)+ suffix1 );
      result = add(result, solve(r1, l2) + suffix2 );
      result = add(result, solve(r1, r2) );

      return result;
    }
    private String add(String num1, String num2){
      String result = "";

      if(num2.length() > num1.length()){
        String temp = num2;
        num2 = num1;
        num1 = temp;
      }

      int tail1 = num1.length() - 1;
      int tail2 = num2.length() - 1;
      int carry = 0;
      while(tail1 >= 0 && tail2 >= 0){
        int temp = num1.charAt(tail1) - '0' + num2.charAt(tail2) - '0' + carry;
        result = (char)(temp - temp / 10 * 10 + '0') + result;
        carry = temp / 10;
        tail1--;
        tail2--;
      }
      while(tail1 >= 0){
        int temp = num1.charAt(tail1) - '0' + carry;
        result = (char)(temp - temp / 10 * 10 + '0') + result;
        carry = temp / 10;
        tail1--;
      }
      result = (char)(carry + '0') + result;
      //strip leading zero
      result = result.replaceFirst("^0+(?!$)", "");

      return result;
    }

}
