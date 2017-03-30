import java.util.*;
public class Poj1017 {
  public static void main(String args[]) {
    Scanner cin = new Scanner(System.in);
    while (cin.hasNext()) {
      int[] order = new int[6];
      boolean stop = true;
      for (int i = 0; i <= 5; i++) {
        order[i] = cin.nextInt();
        if (order[i] != 0) {
          stop = false;
        }
      }
      if (stop)
        break;
      System.out.println(solve(order));
    }
  }

  public static int solve(int[] order) {
    int p6 = order[5];
    int p5 = order[4];
    int p4 = order[3];
    int p3 = order[2] % 4 == 0 ? order[2] / 4
                               : order[2] / 4 + 1; //!!!Pay attention!!!
    int p2;
    int p1;

    int restFor2;
    if (order[2] % 4 == 0) {
      restFor2 = p4 * 5;
    } else if (order[2] % 4 == 1) {
      restFor2 = p4 * 5 + 5;
    } else if (order[2] % 4 == 2) {
      restFor2 = p4 * 5 + 3;
    } else {
      restFor2 = p4 * 5 + 1;
    }

    if (order[1] - restFor2 > 0) {
      p2 = (order[1] - restFor2) % 9 == 0 ? (order[1] - restFor2) / 9
                                          : (order[1] - restFor2) / 9 + 1;
    } else {
      p2 = 0;
    }

    int restFor1 = p6 * 0 + p5 * 11 + p4 * 20 + (p3 * 36 - order[2] * 9) +
                   (p2 * 36 - order[1] * 4);
    if (order[0] - restFor1 > 0) {
      p1 = (order[0] - restFor1) % 36 == 0 ? (order[0] - restFor1) / 36
                                           : (order[0] - restFor1) / 36 + 1;
    } else {
      p1 = 0;
    }
    return p1 + p2 + p3 + p4 + p5 + p6;
  }
}


//
// // package org.poj;
//
// import java.util.Scanner;
//
// /**
//  * Packets(http://poj.org/problem?id=1017)
//  * <p/>
//  * <p/>
//  * 装箱子,从大到小直接模拟,没有直接使用公式而是保留了最初的推理过程
//  */
// public class FillBoxGreedy {
//   public static void main(String[] args) {
//     Scanner cin = new Scanner(System.in);
//     int a, b, c, d, e, f;
//
//     while (cin.hasNext()) {
//       a = cin.nextInt();
//       b = cin.nextInt();
//       c = cin.nextInt();
//       d = cin.nextInt();
//       e = cin.nextInt();
//       f = cin.nextInt();
//       if (a == 0 && b == 0 && c == 0 && d == 0 && e == 0 && f == 0)
//         break;
//
//       // 只是装6*6的箱子,装5*5的限制
//       int sum = f + e;
//       // 剩下部分可以装1*1,每个限制可以装11个1*1,共11*e
//       a -= 11 * e;
//
//       // 装4*4的箱子
//       sum += d;
//       // 剩下部分可以装1*1或2*2,优先装2*2的,每个箱子最多装5个2*2,共5*d;
//       if (b > 5 * d)
//         b -= 5 * d;
//       else {
//         // 多余的装1*1
//         int left = 5 * d - b;
//         b = 0;
//         a -= left;
//       }
//
//       // 装3*3的箱子,每个箱子可以装4个3*3
//       sum += c / 4;
//       int left = c % 4;
//       // 可能有多的箱子
//       if (left != 0) {
//         sum++;
//         // left为1,2,3的时候，可以容纳多5,3,1个2*2(7-2*left), 7,6,5个1*1(8-left)
//         int l2 = 7 - 2 * left;
//         if (b > l2) {
//           b -= l2;
//           a -= (8 - left);
//           if (a < 0)
//             a = 0;
//         } else {
//           int l3 = 36 - left * 9 - b * 4;
//           b = 0;
//           a -= l3;
//         }
//       }
//
//       // 装2*2的箱子,每个箱子可以装9个2*2
//       sum += b / 9;
//       if (b % 9 != 0) {
//         sum++;
//         a -= 36 - b % 9 * 4;
//         if (a < 0)
//           a = 0;
//       }
//
//       // 装1*1的箱子,每个箱子可以装36个1*1
//       if (a > 0) {
//         sum += a / 36;
//         if (a % 36 != 0)
//           sum++;
//       }
//       System.out.println(sum);
//     }
//   }
// }
