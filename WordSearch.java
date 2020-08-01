/*
 * Author:    Ethan Covert 
 * Partner:   Eric
 * Class:     CSC 20 (Section 2)
 * Professor: Abida Mukarram
 *    
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
public class WordSearch
{
   public static void main(String[] args)  throws FileNotFoundException 
   {
      run();
   }
   
   // This is my main method that runs the program
   public static void run() throws FileNotFoundException 
   {
      String[] needles = new String[6];
      String[] hayStack = new String[8];
      boolean TORF = false;
      
      // This try catch block makes sure that the file is readable
      try
      {
         File f = new File("wordSearch.txt");
         loadArray(f, needles, hayStack);
      }
      
      //ends the program if file doesn't exist
      catch(FileNotFoundException error) 
      {
         System.out.println("NADA");
      }  
      Arrays.sort(needles);
      
      //Starts the main block of searching for words
      for(int i = 0; i < needles.length; i++)
      {
         boolean found = false;
         
         //this is the first word the program will look for
         String goal = needles[i];
         int index = 0;
         int row;
         
         // while word hasn't been found keep looping
         while(!found)
         {
            
            // calls my compare method that compares two strings
            if(compare(needles[i],hayStack[index]))
            {
               found = true;
               System.out.println("row: " + (index +1));
            }
            else
            {
               
               // if no more Strings in hayStack then print "Can't find"
               if(index == hayStack.length-1)
               {
                  System.out.println("Can't find: "+ needles[i]);
                  found = true;
               }
               
               // indexs the haystack array to keep looking for the word
               index++;
            }
         }
      }
               
   }
   
   // This array loads the first 6 words into a first array then loads the next 8 Strings into the next
   public static void loadArray(File f, String[] arr1, String[] arr2) throws FileNotFoundException
   {
      f = new File("wordSearch.txt");
      Scanner input = new Scanner(f);
      int counter = 0;
      boolean TORF = true;
      
      // while there is more to read and the variable TrueOrFalse is true
      while(input.hasNext() && TORF == true)
      {
         
         String temp = input.next();
         
         // if end of first array exit the while loop with TORF
         if(temp.equals("***"))
         {
            TORF = false;
         }
         
         // else keep loadin the array
         else
         {
            arr1[counter] = temp;
            counter++; 
         }
      }
      counter = 0;
      
      // load the next array while there is next and the counter !=8(max in file)
      while(input.hasNext() && counter != 8)
      {
         String temp = input.next();
         arr2[counter] = temp;
         counter++;
      }
   }
   
   // this compares two strings looking for the word
   public static boolean compare(String goal, String given)
   {
      boolean TORF = false;
      int index = 0;
      String find = goal.substring(1);
      int goalLength = goal.length()-1;
      
      // variable used to determine how many chances this string can use before getting word is physically impossible
      int attempts = Math.abs(goal.length() - given.length());
      
      // while TORF is false and there are still attempts left
      while(!TORF && index <= attempts)
      {
         // checks to see if the first character matches
         if(goal.charAt(0) == given.charAt(index))
         {
            
            // creates a substring of the string being tested of the correct length of the word desired
            String tester = given.substring(index+1, index+goalLength+1);
            
            // if the substrings match then the word matches!!!!
            if(find.equals(tester))
            {
               TORF = true;
               System.out.printf("Found %s at col: %d, ",goal,(index+1));
            }
            
            // index the char and keep looking
            else
            {
               index++;
            }
         }
         
         // index char and keep searching
         else
         {
            index++;
         }
      }
      return TORF;
   }   

}