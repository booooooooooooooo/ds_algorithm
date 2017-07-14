public class Solution {
    public int leastInterval(char[] tasks, int n) {
      int[] freq = new int[26];
      Arrays.fill(freq, 0);
      for(char t : tasks)
        freq[t - 'A']++;
      Arrays.sort(freq);
      int i = 24;
      while(i >= 0 && freq[i] == freq[i + 1]) i--;
      return Math.max(tasks.length, (n + 1) * (freq[25] - 1) + (25 - i) * 1 );
    }
}
