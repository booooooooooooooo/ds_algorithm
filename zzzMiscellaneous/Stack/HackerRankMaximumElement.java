import java.util.*;
public class HackerRankMaximumElement{
  public static void main(String args[]){
    int maxEle = 0;
    Stack<Integer> maxStack = new Stack<Integer>();
    Stack<Integer> eleStack = new Stack<Integer>();

    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    for(int i = 0; i < n; i++){
      int type = cin.nextInt();
      if(type == 1){
        int ele = cin.nextInt();
        eleStack.push(ele);
        maxStack.push(Math.max(ele, maxEle));
        maxEle = maxStack.empty() ? 0 : maxStack.peek();
      }else if(type == 2){
        eleStack.pop();
        maxStack.pop();
        maxEle = maxStack.empty() ? 0 : maxStack.peek();
      }else{//type == 3
        System.out.println(maxStack.peek());
      }
    }
    return;
  }
}
