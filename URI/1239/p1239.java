import java.io.*;
import java.util.Stack;

public class p1239 {
  public static Stack store = new Stack();

  public static void main(String[] args) throws Exception{
    // initial store data
    store.push('$');

    // Setting Readers and Writters for URI
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // PrintWriter pw = new PrintWriter(System.out);

    // Setting Readers and Writters For reading files
    BufferedReader br = new BufferedReader(new FileReader("./in1239.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("./out1239.txt"));
    
    int in;
    while ((in = br.read()) != -1) {
      char ch = (char) in;
      if(operator(ch)){
        String tag = getTag(ch, storeHas(ch));
        pw.write(tag);
        refreshStore(ch, storeHas(ch));
      }
      else{
        pw.append(ch);
      }

    }

    pw.flush();
    pw.close();
    br.close();
  }

  public static boolean operator(char ch) {
    return ch == '_' || ch == '*';
  }

  public static boolean storeHas(char ch){
    return (char) store.peek() == ch;
  }

  public static String getTag (char tag, boolean closing) {
    if(tag == '_')
      return closing ? "</i>" : "<i>";
    else
      return closing ? "</b>" : "<b>";
  }

  public static void refreshStore(char tag, boolean has) {
    if(has) store.pop();
    else store.push(tag);
  }
  
}