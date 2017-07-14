import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    while(cin.hasNext()){
      int c = cin.nextInt();
      int l = cin.nextInt();
      List<Cow> cows = new ArrayList<Cow>();
      for(int i = 0; i < c; i++) cows.add(new Cow(cin.nextInt(), cin.nextInt()));
      List<Lotion> lotions = new ArrayList<Lotion>();
      for(int i = 0; i < l; i++) lotions.add(new Lotion(cin.nextInt(), cin.nextInt() ) );
      System.out.println(solve(cows, lotions));
    }
  }
  private static int solve(List<Cow> cows, List<Lotion> lotions){
    //sort lotions by value acsendingly
    Collections.sort(lotions, new Comparator<Lotion>(){
      @Override
      public int compare(Lotion l1, Lotion l2){
        return l1.value - l2.value;
      }
    });
    //build min heap of cows by right
    Queue<Cow> minHeap = new PriorityQueue<Cow>(1, new Comparator<Cow>(){
      @Override
      public int compare(Cow c1, Cow c2){
        return c1.right - c2.right;
      }
    });
    minHeap.addAll(cows);
    //iterate and return result
    int result = 0;
    for(int i = 0; i < lotions.size(); i++){
      Queue<Cow> nextHeap = new  PriorityQueue<Cow>(1, new Comparator<Cow>(){
        @Override
        public int compare(Cow c1, Cow c2){
          return c1.right - c2.right;
        }
      });
      int value = lotions.get(i).value;
      int count = lotions.get(i).count;
      while(!minHeap.isEmpty()){
        Cow cow = minHeap.remove();
        if(cow.right < value){
          ;
        }else if(cow.left > value){
          nextHeap.add(cow);
        }else if(count > 0){
          count--;
          result++;
        }else
          nextHeap.add(cow);
      }
      minHeap = nextHeap;
    }
    return result;
  }
}

class Cow{
  public int left;
  public int right;
  public Cow(int left, int right){
    this.left = left;
    this.right = right;
  }
}

class Lotion{
  public int value;
  public int count;
  public Lotion(int value, int count){
    this.value = value;
    this.count = count;
  }
}
