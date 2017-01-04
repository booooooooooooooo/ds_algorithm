public class Solution {
    public int findSubstringInWraproundString(String p) {
      int[] lenArr = new int[26];//lenArr[0] := max length of string start at 'a'
      Arrays.fill(lenArr, 0);

      int start = 0;
      while(start < p.length()){
        int end = start + 1;//[start, end)
        while(end < p.length()){
          if(isNext(p.charAt(end - 1), p.charAt(end)))
            end++;
          else
            break;
        }
        for(int i = start; i < end; i++){
          int index = p.charAt(i) - 'a';
          int len = end - i;
          lenArr[index] = Math.max(lenArr[index], len);
        }
        start = end;
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
