/**
@author: Chanpreet, Gurpreet and Sukhjinder sigh
@application: using different methods and functions for TIC TAC TOE game 
@date: 21 March,2023
@time:11.00 am
*/

// importing the scanner class

import java.util.Scanner;

public class TicTacToeGame
{

  // drawing the board using new method
  public static void drawboard(char[][] board)
  {
    for(int i=0; i<3; i++)
    {
        for(int j=0; j<3; j++) 
        {
            System.out.print( "|" +board[i][j]);
         }
         System.out.println("|");
       }
  }

  
  // using new method to check whether the play has won or not
  public static char hasWon(char[][] board)
  {
    for(int i=0; i<3; i++)
    {
      if(board[i][0]==board[i][1] && board[i][1]==board[i][2] && board[i][0]!='-')
      {
        return board[i][0];
      }
    }

    for(int j=0; j<3; j++)
    {
      if(board[0][j]==board[1][j] && board[1][j]==board[2][j] && board[0][j]!='-')
      {
        return board[0][j];
      }
    }

    if(board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[0][0]!='-')
    {
      return board[0][0];
    }

     if(board[2][0]==board[1][1] && board[1][1]==board[0][2] && board[2][0]!='-')
    {
      return board[2][0];
    }
      return '-';
  }


  // we use a method with the help of Boolean to check whether the board is full or not
  public static boolean isTied(char[][] board)
   {
    for(int i=0; i<3; i++)
       {
        for(int j=0; j<3; j++)
         {
            if(board[i][j]== '-'){
              return false;
             }
        }  
       }
       return true;
   }

  // USING MAIN METHOD

  public static void main(String[] args)
    {
    
       // using scanner function
       System.out.println(" Let's Play Tic Tac Toe Game!");
       Scanner sc= new Scanner(System.in);

       //Asking the user for names of players
       System.out.println("Enter the First Player Name: ");
       String player1 = sc.nextLine();

       System.out.println("Enter the Second Player Name: ");
       String player2 = sc.nextLine();

       // use a 2d array to create a 3*3 Tic Tac Toe board
       char board[] []=  new char[3] [3];

       // fill the board with dashes
      for(int i=0; i<3; i++)
       {
        for(int j=0; j<3; j++)
         {
             board[i][j]= '-';
        }  
       }


       // boolean variable is used to check whose turn it is 
       boolean isPlayer1 = true;
       boolean gameEnd = false;

       while(!gameEnd)
       {
       drawboard(board);

       // keep track of what symbol we are used to play
       char symbol;

       if(isPlayer1)
       {
        symbol= 'x';
       }
       else{
        symbol='o';
       }


      // print out the player’s turn
       if(isPlayer1)
       {
         System.out.println(player1+ "'s Turn (x)! ");
       }
       else{
        System.out.println(player2+ "'s Turn (o)! ");
       }
       

       // creating two variables of "int" datatype
       int row=0;
       int col=0;
       
        while(true)
       {

       // asking the user for rows and columns
       System.out.println("Enter the row number from 0 to 2: ");
       row= sc.nextInt();

       System.out.println("Enter the column number from 0 to 2: ");
       col= sc.nextInt();
       

       // using if else statement
       if(row<0 || col>2 || row>2|| col<0)
         {
          // First to check, Are the rows and columns are out of bounds? 

           System.out.println(" Your rows and columns are out of bounds. Re-enter slot number: 0 to 2");  
         } 

        else if(board[row][col]!= '-')
         {
          // secondly, to check Is one of the players has used the move, which is already used by other player?

           System.out.println( "Slot already taken. Re-enter slot number: From 0 to 2");
         }
         else{
            break;
         }
        }


       // set the position on the board to the player's symbol
        board[row][col]=symbol;
         

         // check if player has won
         if(hasWon(board)=='x')
         {
           System.out.println(player1+ " has won!");
            gameEnd = true;
         }
         else if(hasWon(board)=='o')
         {
           System.out.println(player2+ " has won!");
            gameEnd = true;
         }
         else{

          // nobody has won
          if(isTied(board))
          {
            System.out.println("It's a tie");
            gameEnd = true;
          }
          else{
             isPlayer1= !isPlayer1;   
          }
         }
       }
       drawboard(board);
    }
}
