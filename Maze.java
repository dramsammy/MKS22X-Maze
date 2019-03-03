import java.util.Scanner;
import java.util.*;
import java.io.*;
public class Maze {
  private char[][]maze;
  private boolean animate;//false by default
  private String fileName;
  private int counter = 0;
  private int back;
  private int track;
  private int SRow = 0;
  private int SCol = 0;
  public Maze(String filename) throws FileNotFoundException{
    int rows = 0;
    int cols = 0;
    int count = 0;
    String col = "";
    fileName = filename;
    File text = new File(filename);
    Scanner print = new Scanner(text);
    while (print.hasNextLine()){
      rows++;
      col = print.nextLine();
    }

    cols = col.length();
    maze = new char[rows][cols];
    Scanner print1 = new Scanner(text);
    while (count < rows) {
      String temp = print1.nextLine();
      for (int i = 0; i < cols; i++){
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
  private boolean checkMoveN(int row, int col){
    return (!(maze[row - 1][col] == '#' || maze[row - 1][col] == '@' || maze[row - 1][col] == '.'));
  }
  private boolean checkMoveS(int row, int col){
    return (!(maze[row + 1][col] == '#' || maze[row + 1][col] == '@' || maze[row + 1][col] == '.'));
  }
  private boolean checkMoveE(int row, int col){
    return (!(maze[row][col + 1] == '#' || maze[row][col + 1] == '@' || maze[row][col + 1] == '.'));
  }
  private boolean checkMoveW(int row, int col){
    return (!(maze[row][col - 1] == '#' || maze[row][col - 1] == '@' || maze[row][col - 1] == '.'));
  }
  private boolean checkAllMoves(int row, int col){
    return (checkMoveN(row, col) || checkMoveS(row, col) || checkMoveE(row, col) || checkMoveW(row, col));
  }
  private boolean checkStart(int row, int col){
    if (SRow == row && SCol == col){
      return true;
    }
    return false;
  }
  private boolean backTrack(int row, int col){
    if (checkAllMoves(row, col)){
      back = row;
      track = col;
      return true;
    }
    if (maze[row - 1][col] == '@' && !checkStart(row - 1, col)){
      counter--;
      maze[row - 1][col] = '.';
      backTrack(row - 1, col);
    }
    if (maze[row + 1][col] == '@' && !checkStart(row + 1, col)){
      counter--;
      maze[row + 1][col] = '.';
      backTrack(row + 1, col);
    }
    if (maze[row][col + 1] == '@' && !checkStart(row, col + 1)){
      counter--;
      maze[row][col + 1] = '.';
      backTrack(row, col + 1);
    }
    if (maze[row][col - 1] == '@' && !checkStart(row, col - 1)){
      counter--;
      maze[row][col - 1] = '.';
      backTrack(row, col - 1);
    }
    return false;
  }
  public void clearTerminal(){
    //erase terminal, go to top left of screen.
    System.out.println("\033[2J\033[1;1H");
      }
  public String toString(){
    String returnValue = "";
    for (int i = 0; i < maze.length; i++){
      for (int a = 0; a < maze[0].length; a++){
        returnValue += maze[i][a];
      }
      returnValue += "\n";
    }
    return returnValue;
      }
  private int solve(int row, int col){ //you can add more parameters since this is private
    //automatic animation! You are welcome.
    if(animate){
      clearTerminal();
      System.out.println(this);
      wait(500);
      }
    if (maze[row][col] == 'E'){
      return counter;
    }
    if (checkMoveN(row, col)){
      maze[row - 1][col] = '@';
      counter++;
      solve(row - 1, col);
    }
    if (checkMoveS(row, col)){
      maze[row + 1][col] = '@';
      counter++;
      solve(row + 1, col);
    }
    if (checkMoveE(row, col)){
      maze[row][col + 1] = '@';
      counter++;
      solve(row, col + 1);
    }
    if (checkMoveW(row, col)){
      maze[row][col - 1] = '@';
      counter++;
      solve(row, col - 1);
    }
    if (!checkAllMoves(row, col)){
      if(backTrack(row, col) == true){
        solve(back, track);
      }
    }
      //COMPLETE SOLVE
    return counter; //so it compiles
      }
  public int solve(){
    for (int i = 0; i < maze.length; i++) {
      for (int a = 0; a < maze[0].length; a++){
        if (maze[i][a] == 'S'){
          SRow = i;
          SCol = a;
        }
      }
    }
    maze[SRow][SCol] = '@';
    return solve(SRow, SCol);
  }
  private void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // do nothing
        }
}
  public static void main(String[] args) {
    try{
      Maze test = new Maze("data1.dat");
      test.setAnimate(true);
      System.out.println(test);
      System.out.println(test.solve());
    }
    catch(FileNotFoundException e){
      System.out.println(e);
    }
    }
  }
