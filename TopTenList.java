/*
Ethan Covert
Project 4
12/01/19
*/
import java.io.*;
import java.util.*;

public class TopTenList{
public final static int MAX=10;
private
LinkNode front=null;
LinkNode current=null;
int count=0;
  public TopTenList(){
   front=null;
  }
  public TopTenList(String fileName)throws FileNotFoundException{
    Scanner file = new Scanner (new File(fileName));
    while (file.hasNextLine()){
      count++;
      String name=file.nextLine().trim();
      LinkNode element = new LinkNode(count,name);
      //System.out.println(name);
      if (front ==null )
         {
           front= element;
           current=element;
         }
      else current.setNext(element);
      current=element;
      //System.out.println(current.getSong());
    }

  }
  void printChart(){
    System.out.println("\n***** TOP TEN CHART **********\n");
    current=front;
    for (int i=1;i<=count;i++){    
      System.out.printf("%4d%26s\n",i/*current.getPosition()*/,current.getSong());
      current = current.getNext();
    }
  }

 String getSong(int position){
   String name ="ERROR";
   LinkNode t =front;
    if (position <1 || position > count)
     return name;
    else {
      for (int i=1;i<position;i++)
          t=t.getNext();
      name = t.getSong();
      return name;
    }
 }
 int getPosition(String song){
   current =front;
   int pos =0;
   while(current!=null){
      if (current.getSong().equalsIgnoreCase(song))
          pos = current.getPosition();
      current=current.getNext();
   }
      
   return pos;
 }
 void adjustPosition(LinkNode e,int position){
   if (e!=null)
    while (e!=null){
      e.setPosition(e.getPosition()+position);
      e=e.getNext();
    }
 }
 boolean deleteSong(int position)
 {
   int tmpCount = 1;
   //System.out.println(count);
   if(position > count || position < 1)
   {
      System.out.println("Invalid position no action taken returning to menu");
      return false;
   }
   else if(position == 1)
   {
      front = front.next; 
      count--;
      return true;
   }
   else if(position < 10)
   {
      LinkNode cur = front;
      while(tmpCount +1 != position)
      {
         tmpCount++;
         cur = cur.next;
      }
      LinkNode temp = cur;
      temp.next = cur.next.next; 
      count--;
      return true;
   }
   else
   {
      LinkNode cur = front;
      while(tmpCount +1 != position)
      {
         tmpCount++;
         cur = cur.next;
      }
      cur.next = null;
      count--;
      return true;
   }
 }
 boolean insertSong(int position,String song)
 {
   if(position < 1 || position > count+1)
   {
      System.out.println("Invalid position no action taken returning to menu");     
      return false;
   }
   else if(count == 10 && position != 1)
   {
      
      LinkNode added = new LinkNode(position,song);
      LinkNode cur = front;
      for(int i = 1; i+1 < position; i++)
      {
         cur = cur.next;
      }
      LinkNode tmp = cur.next;
      cur.next = added;
      added.next = tmp;
      return true; 
      }
   else if(count == 10)
   {
      LinkNode added = new LinkNode(position,song);
      LinkNode cur = front;
      front = added;
      added.next = cur;
      count--;
      return true;
   }
   else if(position == 1)
   {
      LinkNode added = new LinkNode(position,song);
      LinkNode cur = front;
      front = added;
      added.next = cur;
      count++;
      return true; 
   }  
   else
   {
      LinkNode added = new LinkNode(position,song);
      LinkNode cur = front;
      for(int i = 1; i+1 < position; i++)
      {
         cur = cur.next;
      }
      LinkNode tmp = cur.next;
      cur.next = added;
      added.next = tmp;
      count++;
      return true;
   }
 }
 boolean moveSong(int oldPosition, int newPosition)
 {
   if((oldPosition < 1 || oldPosition > count) || (newPosition < 1 || newPosition > count))
   {
      System.out.println("Invalid position no action taken returning to menu");
      return false;
   }
   else
   {
      LinkNode cur = front;
      int temp = 1;
      while(temp < oldPosition)
      {
         cur = cur.next;
         temp++;
      } 
      LinkNode move = cur;
      deleteSong(oldPosition);
      insertSong(newPosition,move.getSong());
      //deleteSong(oldPosition);
      return true;

      
   }
 }

}