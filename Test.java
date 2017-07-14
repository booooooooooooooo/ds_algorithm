import java.util.*;

public class Test{
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    while(cin.hasNext()){
      String line = cin.nextLine();
      String[] tokens = line.split(" ");
      System.out.println(Arrays.toString(tokens));
    }


  }

}
