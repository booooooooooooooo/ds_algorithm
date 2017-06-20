public class Solution {
    public String intToRoman(int num) {
      //exclude corner case
      if(num < 1 || num > 3999) return "";
      //constant element String
      String[] thousands = new String[]{"M","MM","MMM"};
      String[] hundreds = new String[]{"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
      String[] tens = new String[]{"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
      String[] ones = new String[]{"I","II","III","IV","V","VI","VII","VIII","IX"};
      //make thousands
      String s1 = num/1000 - 1 >= 0 ? thousands[num/1000 - 1] : "";
      //make hundreds
      String s2 = (num%1000) / 100 - 1 >= 0 ? hundreds[(num%1000) / 100 - 1] : "";
      //make tens
      String s3 = (num%100) / 10 - 1 >= 0 ? tens[(num%100) / 10 - 1 ] : "";
      //make ones
      String s4 = (num % 10) / 1 - 1 >= 0 ? ones[(num % 10) / 1 - 1] : "";
      //return result
      return s1 + s2 + s3 + s4;
    }
}
