import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze {
  public static void main(String[] args) {

  }
  public static String readFiles(){
    File text = new File("input.txt");
    Scanner inf = new Scanner(text);
    int Size = inf.nextLine().length() - 1;
    int Size2 = 0;
    while(inf.hasNextLine()){
      Size2++;
    }
    String[][] ary = new String[Size][Size2];
    while(inf.h){
      for (int i = 0; i < Size; i++){
        for (int a = 0; a < Size2; a++){
          ary[i][a] =
        }
      }
    }
  }
}
