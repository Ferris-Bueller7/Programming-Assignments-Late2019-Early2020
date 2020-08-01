// Ethan Covert Assignment2 3/18/20
public class Node 
{
	String data;
	Node left;
	Node right;
	int key;
	
	public Node(int key,String data)
	{
		this.key = key;
		this.data = data;
		left = null;
		right = null;
	}
	
//	public Node(int key, String value, Node left, Node right)
//	{
//		this.key = key;
//		data = value;
//		this.left = left;
//		this.right = right;
//	}

	public int key()
	{
		return key;
	}
	
	public void add(int key, String value)
	{
		if(contains(key) == true)
		{
			System.out.println("Sorry key is already in use");
		}
		else
		{
			if(this.key < key && right != null)
			{
				right.add(key, value);
			}
			else if(this.key > key && left !=null)
			{
				left.add(key, value);
			}
			else if(this.key > key && left == null)
			{
				left = new Node(key, value);
			}
			else if(this.key < key && right == null)
			{
				right = new Node(key, value);
			}
			else
			{
				System.out.println("Something broke");
			}
		}
	}

	
	
	public boolean remove(int goalKey, Node parent) 
	{
        if(goalKey < this.key) 
        {
              if(left != null) 
              {
                    return left.remove(goalKey, this);
              }
              else
              {
                    return false;
              }
        } 
        else if(goalKey > this.key) 
        {
              if(right != null)
              {
                    return right.remove(goalKey, this);
              }
              else
              {
                    return false;
              }
        } 
        else 
        {
              if(left != null && right != null) 
              {
                    this.key = right.minValue();
                    right.remove(this.key, this);
              } 
              else if(parent.left == this) 
              {
            	  if(left != null)
            	  {
            		  parent.left = left;
            	  }
            	  else
            	  {
            		  parent.left = right;
            	  }
              }
              else if(parent.right == this) 
              {
            	  if(left != null)
            	  {
            		  parent.right = left;
            	  }
            	  else
            	  {
            		  parent.right = right;
            	  }
              }
              return true;
        }
  }

  public int minValue() 
  {
        if (left == null)
        {
              return key;
        }
        else
        {
              return left.minValue();
        }
  }
  
	public boolean contains(int key)
	{
		if(left == null && right == null && this.key != key)
		{
			return false;
		}
		else
		{
			
			if(this.key == key)
			{
				return true;
			}
			else if(this.key < key && left != null)
			{
				return left.contains(key);
			}
			else if(this.key > key && right != null)
			{
				return right.contains(key);
			}
			else if ((this.key < key && left == null) || (this.key > key && right == null))
			{
				return false;
			}
			else
			{
				System.out.println("Why am I here");
				return true;
			}
		}	
	}
	
	public void clear(Node parent)
	{
		
	}
	
	public Node left()
	{
		return left;
	}
	
	public Node right()
	{
		return right;
	}
	
	public String value()
	{
		return data;
	}
	
	public void printInfix()
	{	
		if(left == null && right == null)
		{
			System.out.print(data+" ");
			return;
		}
			left.printInfix();
			System.out.print(data + " ");
			right.printInfix();			
	}
	
	public void printTree(int index)
	{
		for(int i = 0; i < index; i++)
		{
			System.out.print("  ");
		}
		System.out.println(key);
		if(left != null)
		{
			left.printTree(index+1);
		}
		if(right != null)
		{
			right.printTree(index+1);
		}
	}


}
