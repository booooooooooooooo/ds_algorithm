import java.util.*;

public class Test{
  public static void main(String args[]){
    System.out.println( (new Solution()).findSubstringInWraproundString("cac") );
  }
}


class Solution {
    public int findSubstringInWraproundString(String p) {
      int[] lenArr = new int[26];//lenArr[0] := max length of string start at 'a'
      Arrays.fill(lenArr, 0);

      int start = 0;
      while(start < p.length()){
        System.out.println(start);
        int end = start + 1;//[start, end)
        while(end < p.length()){
          if(isNext(p.charAt(end - 1), p.charAt(end)))
            end++;
          else
            break;
        }
        int index = p.charAt(start) - 'a';
        lenArr[index] = Math.max(lenArr[index], end - start);
        start = end;
      }

      for(int i = 0; i < 26; i++){
        int curLen = lenArr[i];
        for(int j = 1; j < curLen; j++){
          int tempLen = curLen - j;
          int tempIndex = i + j;
          lenArr[tempIndex] = Math.max(lenArr[tempIndex], tempLen);
        }
      }

      int result = 0;
      for(int i = 0; i < 26; i++)
        result += lenArr[i];

      return result;


    }
    public boolean isNext(char cur, char post){
      if(cur != 'z') return post == cur + 1;
      else return post == 'a';
    }
}
