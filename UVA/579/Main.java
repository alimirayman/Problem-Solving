import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class Main {

  public static void main(String[] args) throws Exception {
    Main work = new Main();
    work.Begin();
  }

  void Begin() throws Exception {
    
    BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("./output.txt"));

    // For UVA
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // PrintWriter pw = new PrintWriter(System.out);

    String line = "";
    while ((line = br.readLine()) != null) {
      String[] time = line.split(":");

      double hr = Double.parseDouble( time[0] );
      double min = Double.parseDouble( time[1] );

      if(hr == 0) break;

      // Hour Calculation
      // (Hour / 12hr * 360deg) 
      // + (Minute / 60min * 5min / 60min * 360deg)
      hr = hr*30 + min/2;
      // Minute Calculation
      // (Minute / 60min * 360deg)
      min = min*6;

      double cal = Math.abs(min-hr);
      double res = (cal > 180) ? (360 - cal) : cal ; 

      pw.printf("%.3f\n",res);

    }

    pw.flush();
    pw.close();
    br.close();

  }
  
}