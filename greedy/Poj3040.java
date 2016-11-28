import java.util.*;
public class Poj3040 {
  public static void main(String args[]) {
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    int c = cin.nextInt();
    List<Entry> input = new ArrayList<Entry>();
    int[] denoLst = new int[n];
    int[] numLst = new int[n];
    for (int i = 0; i < n; i++) {
      int deno = cin.nextInt();
      int num = cin.nextInt();
      Entry entry = new Entry(deno, num);
      input.add(entry);
    }
    Collections.sort(input, new Comparator<Entry>() {
      @Override
      public int compare(Entry a, Entry b) {
        return a.deno > b.deno ? -1 : 1;
      }
    });
    for (int i = 0; i < n; i++) {
      denoLst[i] = input.get(i).deno;
      numLst[i] = input.get(i).num;
    }

    int numWeek = 0;
    while (true) {
      int[] choice = findChoice(denoLst, numLst, c);
      // for(int i = 0; i < choice.length; i++){
      //   System.out.printf("%d ", choice[i]);
      // }
      // System.out.println();
      if (choice[0] == Integer.MAX_VALUE) { // no slution any more
        System.out.println(numWeek);
        break;
      } else {
        int rise = Integer.MAX_VALUE;
        for (int i = 0; i < numLst.length; i++) {
          if (choice[i] != 0) {
            rise = Math.min(rise, numLst[i] / choice[i]);
          }
        }
        // System.out.printf("Rise: %d\n", rise);
        numWeek += rise;
        for (int i = 0; i < numLst.length; i++) {
          numLst[i] -= rise * choice[i];
        }
      }
    }
  }
  private static int[] findChoice(int[] denoLst, int[] numLst, int c) {
    int[] choice = new int[denoLst.length];
    Arrays.fill(choice, 0);
    int rest = c;
    for (int i = 0; i < denoLst.length; i++) {
      if (numLst[i] == 0)
        continue;
      else if (denoLst[i] >= c) {
        choice[i] = 1;
        rest = 0;

      } else if ((rest / denoLst[i]) <= numLst[i]) {
        choice[i] = rest / denoLst[i];
        rest = rest - rest / denoLst[i] * denoLst[i];
      } else {
        choice[i] = numLst[i];
        rest = rest - denoLst[i] * numLst[i];
      }
    }

    if (rest == 0)
      return choice;
    else { // rest > 0
      for (int i = denoLst.length - 1; i >= 0; i--) {
        if (numLst[i] - choice[i] > 0 && denoLst[i] > rest) {
          choice[i] += 1;
          return choice;
        }
      }
    }
    // no solution
    choice[0] = Integer.MAX_VALUE;
    return choice;
  }
}

class Entry {
  int deno;
  int num;
  Entry(int deno, int num) {
    this.deno = deno;
    this.num = num;
  }
}
