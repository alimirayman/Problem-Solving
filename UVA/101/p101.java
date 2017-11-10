import java.io.*;
import java.util.*;

// Still Working on it
// Output doesn't match

public class p101 {

  private static ArrayList<Stack> store = new ArrayList<Stack>();
  
  public static void main(String args[]) throws Exception {
    // Setting Buffered Reader and PrintWriter
    BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("./output.txt"));

    int lim = Integer.parseInt( br.readLine() );

    fillStack(lim);

    String line;
    while ((line = br.readLine()) != null) {
      if(line.equals("quit")) break;

      String[] comands = line.split(" ");

      boolean move = comands[0].equals("move");
      boolean over = comands[2].equals("over");

      int from = Integer.parseInt(comands[1]);
      int to = Integer.parseInt(comands[3]);

      if(move){
        if(over) moveOver(from, to);
        else moveOnto(from, to);
      }else{
        if(over) pileOver(from, to);
        else pileOnto(from, to);
      }

    }

    pw.write( currentStack() );

    // Closing Buffered Reader and PrintWriter    
    pw.flush();
    pw.close();
    br.close();
  }

  public static String currentStack(){
    String output = "";
    Iterator ir = store.iterator();
    int i = 0;
    while (ir.hasNext()) {
      output += i++ + ":";
      Stack st = (Stack) ir.next();

      List<Integer> list = new ArrayList<Integer>(st);

      for (int x : list) {
        // System.out.println(x);
        output += " " + x;
      }

      // while (!st.empty()) {
      //   output += " " + st.pop();
      // }
      output += "\n";
    }
    return output;
  }

  public static void fillStack(int num){
    for(int i = 0; i < num; i++){
      Stack<Integer> a = new Stack<Integer>();
      a.push(i);
      store.add(a);
    }
  }

  private static boolean sameStacks(Stack a, Stack b) {
    return a.equals(b);
  }

  public static void moveOnto(int from, int to) {
    Stack fromStack = findStack(from);
    Stack toStack = findStack(to);

    if(sameStacks(fromStack, toStack))
      return;

    while (!fromStack.peek().equals(from)) {
      initStage( fromStack.pop() );
    }

    while (!toStack.peek().equals(to)) {
      initStage( toStack.pop());
    }

    toStack.push(from);
    fromStack.removeElement(from);
  }

  public static void moveOver(int from, int to) {
    Stack fromStack = findStack(from);
    Stack toStack = findStack(to);

    if (sameStacks(fromStack, toStack))
      return;

    while (!fromStack.peek().equals(from)) {
      initStage( fromStack.pop() );
    }
    
    toStack.push(from);
    fromStack.removeElement(from);
  }

  public static void pileOnto(int from, int to) {
    Stack fromStack = findStack(from);
    Stack toStack = findStack(to);

    if (sameStacks(fromStack, toStack))
      return;    

    while (!toStack.peek().equals(to)) {
      initStage( toStack.pop() );
    }

    while (!fromStack.peek().equals(from)) {
      Object a = fromStack.pop();
      toStack.push(a);
    }
    toStack.push(from);
    fromStack.removeElement(from);
  }

  public static void pileOver(int from, int to) {
    Stack fromStack = findStack(from);
    Stack toStack = findStack(to);

    if (sameStacks(fromStack, toStack))
      return;
    
    while (!fromStack.peek().equals(from)) {
      Object a = fromStack.pop();
      toStack.push(a);
    }
    toStack.push(from);
    fromStack.removeElement(from);
  }

  private static Stack findStack(int val) {
    Iterator irr = store.iterator();
    while(irr.hasNext()){
      Stack st = (Stack) irr.next();
      if(st.search(val) != -1){
        return st;
      }
    }
    return new Stack<>();
  }

  private static void initStage(Object val) {
    Iterator irr = store.iterator();
    int i = 0;
    while (irr.hasNext()) {
      Stack st = (Stack) irr.next();
      if(val.equals(i)) {
        st.push(val);
      }
      i++;
    }
  }

}