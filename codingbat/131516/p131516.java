import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class p131516 {
  public static void main(String args[]) throws Exception {

    // Setting Buffered Reader and PrintWriter
    BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("./output.txt"));
    
    String line;
    while ((line = br.readLine()) != null ) {
      pw.write( sameEnds(line) );
      pw.write("\n");
    }
    
    // Closing Buffered Reader and PrintWriter    
    pw.flush();
    pw.close();
    br.close();
  }

  public static String sameEnds(String string) {
    int mid = (string.length() / 2) + 1;
    while (mid-- > 0) {
      String start = string.substring( 0, mid );
      String end = string.substring(string.length() - mid);

      if(start.equals(end)) return start;
      
    }
    return "";
  }
  
}