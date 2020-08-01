/**
  *   This Java class creates an object called Directory that takes a list of names 
    and phone numbers and implements them into a hashMap allowing the user to add 
    remove, and edit contacts as they see necessary.
  
  *  @Author  Ethan Covert
  *  @Version October 22, 2019 
  */
import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;
public class Directory
{
   Map<String,String> phoneBook = new HashMap<String,String>();
   
/**
  * This is the constructor block that sorts through the names and adds them to
  the HashMap.
    
   * @param names recieves the file name that has contact information
   */   
   public Directory(String names) throws FileNotFoundException
   {
      File f = new File(names);
      if(!f.exists())
      {
         throw new FileNotFoundException();
      }
      Scanner line = new Scanner(f);
      while(line.hasNextLine())
      {
         String temp = line.nextLine();
         String[] temp2 = temp.split(":");
         phoneBook.put(temp2[0],temp2[1]); 
      }
   }
   
/**
  * This method returns the phone number the person requested.
    
   * @param name is the person whose number you wish to recieve. 
   * @return String of the number you requested.
   */   
   public String getPhoneNumber(String name)
   {
      if(phoneBook.containsKey(name))
         return phoneBook.get(name);
      else
         return"";   
      
   }
   
/**
  * This method deletes the phone number the person requested.
    
   * @param name is the person whose number you wish to delete. 
   */   
   public void delete(String name)
   {
      if(phoneBook.containsKey(name))
      {
         phoneBook.remove(name);
         System.out.println(name+"'s number has been removed");
      }     
   }
   
/**
  * This method adds a phone number to the hashmap.
    
   * @param name is the person you are adding. 
   * @param number is the person's number.
   */   
   public void add(String name, String number)
   {
      phoneBook.put(name,number);
   }
   
/**
  * This method edits persons number.
    
  * @param name is the person whose number you wish to change. 
  * @param number is the persons new number.
  */ 
   public void change(String name, String number)
   {
      if(phoneBook.containsKey(name))
         phoneBook.put(name,number);
      else
         System.out.println("No contact named: " + name); 
   }
   
/**
  * This method formats and prints the numbers and names to the console.
  */   
   public void displayDirectory()
   {
      Iterator<String> itr = phoneBook.keySet().iterator();
      while(itr.hasNext())
      {
         String temp = itr.next();
         System.out.printf("%20s   %13s",temp,phoneBook.get(temp));
         System.out.println();
      }
   }
}