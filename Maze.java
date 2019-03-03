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
  private boolean checkMoveN(int row, int col){
    return (!(maze[row - 1][col] == '#' || maze[row - 1][col] == '@' || maze[row - 1][col] == '.'));
  }
  private boolean checkMoveS(int row, int col){
    return (!(maze[row + 1][col] == '#' || maze[row - 1][col] == '@' || maze[row + 1][col] == '.'));
  }
  private boolean checkMoveE(int row, int col){
    return (!(maze[row][col + 1] == '#' || maze[row - 1][col] == '@' || maze[row][col + 1] == '.'));
  }
  private boolean checkMoveW(int row, int col){
    return (!(maze[row][col - 1] == '#' || maze[row - 1][col] == '@' || maze[row][col - 1] == '.'));
  }
  private boolean checkAllMoves(int row, int col){
    return (checkMoveN(row, col) || checkMoveS(row, col) || checkMoveE(row, col) || checkMoveW(row, col));
  }
  private boolean backTrack(int row, int col){

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
  private int solve(int row, int col, boolean deadEnd){ //you can add more parameters since this is private
    //automatic animation! You are welcome.
    int counter = 0;
    if(animate){
      clearTerminal();
      System.out.println(this);
      wait(20);
      }
    if ((checkMoveN(row, col)){

    }
      //COMPLETE SOLVE
      return -1; //so it compiles
      }

    }
