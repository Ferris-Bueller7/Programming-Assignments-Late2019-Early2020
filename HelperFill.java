/*
 * Author:    Ethan Covert
 * Date:      9/19/19
 * Professor: Abida Mukarram
 * Project 1
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
public class HelperFill
{
   
   // checks to see if the file given is a valid file
   public static boolean validFile(File f) 
   {
      
      // if it is a valid file the scanner will work
      try
      {
         Scanner s = new Scanner(f);
      }
      
      // catches exception thrown and displays "File not found"
      catch(FileNotFoundException error)
      {
         System.out.println("File not found");
         return false;
      }
      return true;   
   }
   
   // reads the file and inputs results into an array
   public static double[][] readFile(File f) throws FileNotFoundException
   {
      Scanner line = new Scanner(f);
      
      // creates the original array with the minimum amount of slots 
      double[][] arr = new double[2][8];
      int doubleCount = 0;
      int intCount = 0;
      
      // while there are more lines to read keep looping
      while(line.hasNextLine())
      {
         Scanner token = new Scanner(line.nextLine());
         
         // while there are more tokens on the line keep looping
         while(token.hasNext())
         {
            
            // checks to see if the next value is an integer
            if(token.hasNextInt())
            {
               int tempInt = token.nextInt();
               boolean TORF = true;
               
               // checks to see if the token will be a duplicate
               for(int i = 0; i < arr[0].length; i++)
               {
                  if(tempInt == arr[0][i])
                  {
                     TORF = false;
                  }
               }
               
               // checks to see if larger array needed
               if(arr[0].length == intCount)
               {
                  arr = biggerArray(arr);  
               }
               
               // if TORF (the next input isn't already in the array) then put it in the array and add 1 to counter
               if(TORF)
               {
                  arr[0][intCount] = tempInt;
                  intCount++;
               }
            }
            
            // checks to see if next token is a double
            else if(token.hasNextDouble())
            {
               
               boolean TORF = true;
               double tempDouble = token.nextDouble(); 
               
               // checks to see if the next input is already in the array
               for(int i = 0; i < arr[0].length; i++)
               {
                  if(tempDouble == arr[1][i])
                  {
                     TORF = false;
                  }
               }               
               
               // checks to see if larger array is needed
               if(arr[0].length == doubleCount)
               {
                  arr = biggerArray(arr);
               }
               
               // if the next element isn't in the array then input it
               if(TORF)
               {
                  arr[1][doubleCount] = tempDouble;
                  doubleCount++;
               }
            }
            
            // Stores everything else into a String 
            else
            {
               String garbage = token.next();
            }
         }        
      }
      
      // returns completed array
      return arr;
    
   }
   
   // creates a larger array 
   public static double[][] biggerArray(double[][] arr)
   {
      
      // creates a new array twice the size of the given array
      double[][] arr1 = new double[2][arr[0].length*2];
      for(int i = 0; i < arr.length; i++)
      {
         
         // inputs the old elements into the new array
         for(int j = 0; j < arr[0].length; j++)
         {
            arr1[i][j] = arr[i][j];
         }
      }
      
      // returns the new larger array
      return arr1;
   }
   
   // formats the given array
   public static void toString(double[][] arr)
   {
      int row = 0;
      
         // loops for the length of the array (loops twice because 2D array)
         for(int i = 0; i < arr.length; i++)
         {
            
            // if row one (Int row)
            if(row == 0)
            {
               System.out.print("Int: ");
               
               // doesn't enter loop if array is empty
               if(arr[0][0] != 0.0)
               {   
                  
                  // loops for the first half of the array (the ints)
                  for(int j = 0; j < arr[0].length; j++)
                  {
                     
                     // only prints if not zero
                     if(arr[0][j] != 0.0)
                     {
                        System.out.print((int)arr[0][j]+ " "); 
                     }
                  } 
               }
               
               // if first element is zero then the array is empty so prints "No Ints"
               else
               {
                  System.out.print("No Integers");
               }
               System.out.println();        
            }
            
            // if the row isn't 1 then its row 2 (doubles)
            else
            {
               System.out.print("Double: ");
               
               // checks to see if array is empty
               if(arr[1][0] != 0.0)
               {
                  
                  // loops for the length of row 2 (double part)
                  for(int j = 0; j < arr[0].length; j++)
                  {
                     
                     // only prints non zeros
                     if(arr[1][j] != 0.0)
                     {
                        System.out.print(arr[1][j] + " ");
                     }
                  }
               }
               
               // if array is empty then print "No Doubles"
               else
               {
                  System.out.print("No Doubles");
               }   
               System.out.println();
            }
            // increment rows
            row++;
         }
   }   
}