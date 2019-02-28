import java.util.Scanner;
import java.util.*;
import java.io.*;
public class Maze {
  private char[][]maze;
  private boolean animate;//false by default
  private String fileName;
  public Maze(String filename) throws FileNotFoundException{
    int count = 0;
    fileName = filename;
    File text = new File(filename);
    Scanner print = new Scanner(text);
    while (print.hasNextLine()){
      String temp = print.nextLine();
      for (int i = 0; i < temp.length(); i++){
        maze[count][i] = temp.charAt(i);
      }
      count++;
      }
  }
    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:

         throw a FileNotFoundException or IllegalStateException

    */
    public void setAnimate(boolean b){
      animate = b;
    }
    public void clearTerminal(){
    //erase terminal, go to top left of screen.
      System.out.println("\033[2J\033[1;1H");
    }
    public String toString(){
      return "WRITE THIS METHOD";
    }
}
