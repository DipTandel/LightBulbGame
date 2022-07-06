// LightBulb
// May 28, 2021
// ICS3U1, Dip
// Make a grid of lightbulbs, user can toggle lightbulbs on or off but the bulbs around them will switch states, goal is to turn all bulbs off

import java.util.Scanner;
import java.util.Random;
public class LightBulb {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Random rand = new Random();
    
    
    //This block of code is initializing variables
    int[][] setup = new int[5][5];
    int upperbound = 2;
    int row;
    int column;
    boolean win = false; //"win" and "check" will be needed later if the user gets all the bulbs off
    int check = 0;
    
    //This block of code is generating the grid of bulbs
    System.out.println("    1 2 3 4 5"); //prints the column labels for convenience
    System.out.println("    | | | | |");
    for (int i = 0; i < 5; i++) {
      System.out.print(i+1 + " - "); //prints the row labels for convenience 
      for (int j = 0; j < 5; j++) {
        setup[i][j] = rand.nextInt(upperbound);
        System.out.print(setup[i][j] + " ");
      }
      System.out.println();
    }
    
    //Explaning the game
    System.out.println();
    System.out.println("The 1's on the grid represent activated lightbulbs");
    System.out.println("You can change the state of any bulb on the grid");
    System.out.println("Simply enter the coordinates of the bulb you want to change when prompted");
    System.out.println("But be careful, the bulbs surrounding that bulb will also change states!");
    System.out.println("More specifically, the bulbs touching the left, right, top, and bottom of the bulb will also change");
    System.out.println("If you accidently enter the wrong set of coordinates, you can re-enter it to revert the changes");
    System.out.println("Try to turn off all of the lights, Good Luck!");
    System.out.println();
    
    //Creating the code for switching the bulbs (0 = off, 1 = on)
    do {
      System.out.print("Enter the ROW of the bulb you want to change: "); //prompt for x coordinate (row)
      row = in.nextInt();
      row = row-1; //accounting for the fact that were supposed to start at 0 and not 1
      System.out.print("Enter the COLUMN of the bulb you want to change: "); //prompt for y coordinate (column)
      column = in.nextInt();
      column = column-1; //accounting for the fact that were supposed to start at 0 and not 1
      
      //if the user puts in a coordinate that doesnt exist
      if (row < 0 || column < 0 || row > 5 || column > 5) {
        System.out.println("Please enter a valid number, a number between 1 and 5 (inclusive)"); 
      }               //then the user gets to try again
      
      //but if the coordinates are valid numbers then we can proceed with the code
      else {   
        //changing states of bulb entered
        if (setup[row][column] == 0) {
          setup[row][column] = 1;
        }
        else if (setup[row][column] == 1) {
          setup[row][column] = 0;
        }
        
        //changing states of surrounding bulbs
        
        //row-1 (top of bulb)
        if (row != 0) { //only changes the bulb on top if it isnt in the first row, because if it is the first row, then there is no bulb on top
          if (setup[row-1][column] == 0) {
            setup[row-1][column] = 1;
          }
          else if (setup[row-1][column] == 1) {
            setup[row-1][column] = 0;
          }
        }
        
        //column+1 (right of bulb)
        if (column != 4) { //only changes the bulb on the right if it isnt in the last column, because if it is the last column, then there is no bulb on the right
          if (setup[row][column+1] == 0) {
            setup[row][column+1] = 1;
          }
          else if (setup[row][column+1] == 1) {
            setup[row][column+1] = 0;
          }
        }
        
        //row+1 (bottom of bulb)
        if (row != 4) { //only changes the bulb under it if it isnt in the last row, because if it is the last row, then there is no bulb under it
          if (setup[row+1][column] == 0) {
            setup[row+1][column] = 1;
          }
          else if (setup[row+1][column] == 1) {
            setup[row+1][column] = 0;
          }
        }
        
        //column-1 (left of bulb)
        if (column != 0) { //only changes the bulb on the left if it isnt in the first column, because if it is the first column, then there is no bulb on the left
          if (setup[row][column-1] == 0) {
            setup[row][column-1] = 1;
          }
          else if (setup[row][column-1] == 1) {
            setup[row][column-1] = 0;
          }
        }
        
        
        //reprinting new grid
        System.out.println("    1 2 3 4 5"); //prints the column labels for convenience
        System.out.println("    | | | | |");
        for (int i = 0; i < 5; i++) {
          System.out.print(i+1 + " - "); //prints the row labels for convenience 
          for (int j = 0; j < 5; j++) {
            System.out.print(setup[i][j] + " ");
          }
          System.out.println();
        }
        
        //This chunk of code checks the entire grid for 0's (0 = bulb off)
        for (int i = 0; i < 5; i++) {
          for (int j = 0; j < 5; j++) {
            if (setup[i][j] != 0) { //if any of the bulbs are on (not 0) , then the value for "check" goes up
              check++;    //the goal is to have all bulbs off, and if that happens, then the value of "check" remains zero
            }
          }
        }
        if (check == 0) { //if "check" remains zero, it means the player has won
          win = true;     //making the value of "win" true and therefore, breaking the loop
        } 
        check = 0; //otherwise the value of check resets back to 0 and loops all over again
      }
    }while (win == false); 
    
    //message if loop breaks (user wins)
    System.out.println("Good job");
    System.out.println("Ice-Cream-Man approves!");
    System.out.println("This is a ticket to free ice-cream and fixed bones from Ice-Cream-Man");
    System.out.println("Screenshot and send to Ms.Hwang or Ice-Cream-Man himself to use");
    
  }
}