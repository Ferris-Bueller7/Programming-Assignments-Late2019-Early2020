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
public class MatrixFill
{
   public static void main(String[] args) throws FileNotFoundException
   {
      run();
   }
   // uses the helper class to run the program
   public static void run() throws FileNotFoundException
   {
      File f = new File("data.txt"); 
      // only goes into program if file is valid
      if(HelperFill.validFile(f))
      {
         double[][] arr = HelperFill.readFile(f); 
         HelperFill.toString(arr);  
      }   
   }
   
}