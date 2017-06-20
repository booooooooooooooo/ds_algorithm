//O(n)
//Manacher's algorithm
public class Solution {
    public String longestPalindrome(String s) {
      //exclude corner case
      if(s.length() == 0) return "";
      //make char arr for convenience
        char[] arr = new char[2 * s.length() + 3];
        arr[0] = '$';
        arr[1] = '#';
        arr[2 * s.length() + 2] = '@';
        for(int i = 0; i < s.length(); i++){
          arr[i * 2 + 2] = s.charAt(i);
          arr[i * 2 + 3] = '#';
        }

      //update MPL(maximum palindrome length) for each center
      int[] mpl = new int[2 * s.length() + 3];
      Arrays.fill(mpl, 0);
      int C = 0;
      int R = 0;
      for(int i = 1; i < arr.length - 1; i++){
        if(i < R){
          int mirr = 2 * C - i;
          mpl[i] = Math.min(mpl[mirr], R - i);
        }
        while(i + mpl[i] + 1 < arr.length && i - mpl[i] - 1 >= 0 && arr[i + mpl[i] + 1] == arr[i - mpl[i] - 1]){
          mpl[i]++;
        }
        if(i + mpl[i] > R){
          R = i + mpl[i];
          C = i;
        }

      }
      //get and return result
      int index = 0;
      for(int i = 1; i < mpl.length - 1; i++){
        if(mpl[i] > mpl[index]) index = i;
      }

      String result = "";
      for(int i = index - mpl[index]; i <= index + mpl[index]; i++){
        if(arr[i] != '#') result = result + arr[i];
      }
      return result;
    }
}


//O(n^2)
public class Solution {
    public String longestPalindrome(String s) {
      String result = "";

      for(int i = 0; i < s.length(); i++){
        int len;
        int l;
        int r;

        len = 1;
        l = i - 1;
        r = i + 1;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
          len += 2;
          l--;
          r++;
        }
        if(len > result.length()){
          result = s.substring(l + 1, r);
        }

        len = 0;
        l = i;
        r = i + 1;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
          len += 2;
          l--;
          r++;
        }
        if(len > result.length()){
          result = s.substring(l + 1, r);
        }
      }
      return result;
    }
}
