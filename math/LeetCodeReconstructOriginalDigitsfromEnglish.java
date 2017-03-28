public class Solution {
    public String originalDigits(String s) {
      int[] freqLetterArr = new int[26];
      Arrays.fill(freqLetterArr, 0);
      int[] freqDigitArr = new int[10];
      Arrays.fill(freqDigitArr, 0);
      for(int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        freqLetterArr[c - 'a']++;
      }

      //count two using 'w'
      freqDigitArr[2] = freqLetterArr['w' - 'a'];
      freqLetterArr['t' - 'a'] -= freqLetterArr['w' - 'a'];
      freqLetterArr['o' - 'a'] -= freqLetterArr['w' - 'a'];
      freqLetterArr['w' - 'a'] = 0;
      //count zero using 'z'
      freqDigitArr[0] = freqLetterArr['z' - 'a'];
      freqLetterArr['e' - 'a'] -= freqLetterArr['z' - 'a'];
      freqLetterArr['r' - 'a'] -= freqLetterArr['z' - 'a'];
      freqLetterArr['o' - 'a'] -= freqLetterArr['z' - 'a'];
      freqLetterArr['z' - 'a'] = 0;
      //count six using 'x'
      freqDigitArr[6] = freqLetterArr['x' - 'a'];
      freqLetterArr['s' - 'a'] -= freqLetterArr['x' - 'a'];
      freqLetterArr['i' - 'a'] -= freqLetterArr['x' - 'a'];
      freqLetterArr['x' - 'a'] = 0;

      //count eight using 'g'
      freqDigitArr[8] = freqLetterArr['g' - 'a'];
      freqLetterArr['e' - 'a'] -= freqLetterArr['g' - 'a'];
      freqLetterArr['i' - 'a'] -= freqLetterArr['g' - 'a'];
      freqLetterArr['h' - 'a'] -= freqLetterArr['g' - 'a'];
      freqLetterArr['t' - 'a'] -= freqLetterArr['g' - 'a'];
      freqLetterArr['g' - 'a'] = 0;
      //count four using 'u'
      freqDigitArr[4] = freqLetterArr['u' - 'a'];
      freqLetterArr['f' - 'a'] -= freqLetterArr['u' - 'a'];
      freqLetterArr['o' - 'a'] -= freqLetterArr['u' - 'a'];
      freqLetterArr['r' - 'a'] -= freqLetterArr['u' - 'a'];
      freqLetterArr['u' - 'a'] = 0;
      //count five using 'f'
      freqDigitArr[5] = freqLetterArr['f' - 'a'];
      freqLetterArr['i' - 'a'] -= freqLetterArr['f' - 'a'];
      freqLetterArr['v' - 'a'] -= freqLetterArr['f' - 'a'];
      freqLetterArr['e' - 'a'] -= freqLetterArr['f' - 'a'];
      freqLetterArr['f' - 'a'] = 0;
      //count nine using 'i'
      freqDigitArr[9] = freqLetterArr['i' - 'a'];
      freqLetterArr['n' - 'a'] -= freqLetterArr['i' - 'a'];
      freqLetterArr['n' - 'a'] -= freqLetterArr['i' - 'a'];
      freqLetterArr['e' - 'a'] -= freqLetterArr['i' - 'a'];
      freqLetterArr['i' - 'a'] = 0;
      //count seven using 'v'
      freqDigitArr[7] = freqLetterArr['v' - 'a'];
      freqLetterArr['s' - 'a'] -= freqLetterArr['v' - 'a'];
      freqLetterArr['e' - 'a'] -= freqLetterArr['v' - 'a'];
      freqLetterArr['e' - 'a'] -= freqLetterArr['v' - 'a'];
      freqLetterArr['n' - 'a'] -= freqLetterArr['v' - 'a'];
      freqLetterArr['v' - 'a'] = 0;
      //count three using 'r'
      freqDigitArr[3] = freqLetterArr['r' - 'a'];
      freqLetterArr['t' - 'a'] -= freqLetterArr['r' - 'a'];
      freqLetterArr['h' - 'a'] -= freqLetterArr['r' - 'a'];
      freqLetterArr['e' - 'a'] -= freqLetterArr['r' - 'a'];
      freqLetterArr['e' - 'a'] -= freqLetterArr['r' - 'a'];
      freqLetterArr['r' - 'a'] = 0;
      //count one using 'o'
      freqDigitArr[1] = freqLetterArr['o' - 'a'];
      freqLetterArr['n' - 'a'] -= freqLetterArr['o' - 'a'];
      freqLetterArr['e' - 'a'] -= freqLetterArr['o' - 'a'];
      freqLetterArr['o' - 'a'] = 0;
      //Make up result
      String result = "";
      for(int i = 0; i < 10; i++){
        char[] chars = new char[freqDigitArr[i]];
        Arrays.fill(chars, (char)(i + '0'));
        result += new String(chars);
      }
      //return reuslt
      return result;
    }
}
