import java.util.*;

public class p100{

  private static HashMap<Integer,Integer> store = new HashMap<Integer,Integer>();
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    store.put(2,2);
    store.put(1,1);

    while (sc.hasNext()){
      int num1 = sc.nextInt(), num2 = sc.nextInt();
      int start = num1, end = num2;
      if(num1 > num2){
        start = num2;end = num1;
      }
      for(int i = start ; i <= end; i++){ 
        store.put(i, makeCount(i, 0) );
      }
      System.out.println(num1+" "+num2+" "+maxArr(store, start, end));      
    }
  }

  public static int makeCount(int num, int count){
    if(store.	containsKey(num)) return store.get(num);

    if ( num % 2 == 0 ) num = num / 2;
    else num = num * 3 + 1;

    count = makeCount(num, count);
    store.put(num, count);
    return count + 1;
  }

  public static int maxArr(HashMap<Integer, Integer>arr, int start, int end){
    int max = 0;

    for(int i = start; i <= end; i++){
      if( arr.get(i) > max ) max = arr.get(i);
    }

    return max;
  }
}