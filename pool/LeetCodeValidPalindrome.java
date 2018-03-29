// public class Solution {
//   public boolean isPalindrome(String s) {
//     // exclude null case
//     if (s == null)
//       return true;
//
//     // exclude empty case
//     if (s.isEmpty())
//       return true;
//
//     // Scan
//     int left = getNextLeft(-1, s);
//     int right = getNextRight(s.length(), s);
//     while (left < right) {
//       // If not same letter(ignore case), return false
//       char c1 = s.charAt(left);
//       char c2 = s.charAt(right);
//       if (c1 == c2 ||
//           (isAlphabet(c1) && isAlphabet(c2) && Math.abs(c1 - c2) == 32)) {
//         left = getNextLeft(left, s);
//         right = getNextRight(right, s);
//       } else
//         return false;
//     }
//
//     // return true
//     return true;
//   }
//
//   public int getNextLeft(int left, String s) {
//     left++;
//     while (left <= s.length() - 1) {
//       char c = s.charAt(left);
//       if (  isAlphaNumeric(c) )
//         break;
//       else
//         left++;
//     }
//     return left;
//   }
//
//   public int getNextRight(int right, String s) {
//     right--;
//     while (right >= 0) {
//       char c = s.charAt(right);
//       if (isAlphaNumeric(c) )
//         break;
//       else
//         right--;
//     }
//     return right;
//   }
//
//   public boolean isAlphabet(char c) {
//     return (65 <= c && c <= 90) || (97 <= c && c <= 122);
//   }
//   public boolean isAlphaNumeric(char c) {
//     return (65 <= c && c <= 90) || (97 <= c && c <= 122) ||
//         (48 <= c && c <= 57);
//   }
// }


public class Solution {
  public boolean isPalindrome(String s) {
    // exclude null case
    if (s == null)
      return true;

    // exclude empty case
    if (s.isEmpty())
      return true;

    // Scan
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      // If not same letter(ignore case), return false
      char c1 = s.charAt(left);
      char c2 = s.charAt(right);
      if( ! isAlphaNumeric(c1)) left++;
      else if( ! isAlphaNumeric(c2)) right--;
      else if (c1 == c2 ||
          (isAlphabet(c1) && isAlphabet(c2) && Math.abs(c1 - c2) == 32)) {
        left++;
        right--;
      } else
        return false;
    }


    // return true
    return true;
  }

  public boolean isAlphabet(char c) {
    return (65 <= c && c <= 90) || (97 <= c && c <= 122);
  }
  public boolean isAlphaNumeric(char c) {
    return (65 <= c && c <= 90) || (97 <= c && c <= 122) ||
        (48 <= c && c <= 57);
  }
}
