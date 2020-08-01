/* 
Author: Ethan Covert
Date: 9/9/19
Class: CSC 20
Lab 1
Instructor: 
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
public class MagicBall
{
   public static void main(String[] args) throws FileNotFoundException    //This is the main method to call playGame
   {
      playGame();   
   }
   public static void playGame() throws FileNotFoundException //This method runs the entire game and calls readAnswers method
   {
      Scanner kb = new Scanner(System.in);
      String[] temp = readAnswers();
      boolean TORF = true;
      while(TORF)                                             //While the variable TORF is true this wil loop
      {
         System.out.println("What do you want to know?");
         kb.nextLine();
         int choice = getRandom();                          // this generates a random number from 1-20
         while(temp[choice] == null)                        // while the number picked = null keep trying for a new number
         {
            choice = getRandom();
         }
         System.out.println(temp[choice]);
         System.out.println();
         System.out.println("Would you like to play again?");
         String answer = kb.nextLine();
         while(!(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")))  //while the user does not answer yes or no keep asking
         {
            System.out.println("Please type \"Yes\" or \"no\"");
            answer = kb.nextLine();
         }
         if(answer.equals("no"))        // sets TORF to false exiting main while loop
         {
            TORF = false;
         }         
      }
      
      
   }
   public static String[] readAnswers() throws FileNotFoundException   //this reads the file and adds it to an Array
   {
      File f = new File("answers.txt");
      Scanner temp = new Scanner(f);
      String[] Answers = new String[20];
      int counter = 0;
      while(temp.hasNext()) // while the file has more to read keep looping
      {
           Answers[counter] = temp.nextLine();
           counter++;
      }
      return Answers;
      
   }
   public static int getRandom()  // this generates a random number between 1-20 each time it is called
   {
      Random rand = new Random();
      int temp = rand.nextInt(20);
      return temp;
   }
}