import java.util.*; 
import java.io.*;
  
public class PA1 
{     
    public static void main(String args[]) 
    throws FileNotFoundException
    {
      Scanner console = new Scanner(System.in);
		System.out.print("Enter integer-filled text file here: ");
		String FileName = console.next();
      
      LinkedList<Integer> ll = new LinkedList<Integer>();
      
      Scanner input = new Scanner(new File(FileName));
      int grabbedNumber;
      ll.add(input.nextInt());
      while(input.hasNextInt())
      {
         grabbedNumber = input.nextInt();
         for (int i=0; i < ll.size(); i++)
         {
             if(ll.size() == 0)
               {
                  ll.addFirst(grabbedNumber);
                  break;
               }
               
             else if(grabbedNumber >= ll.getLast())
             {
                  ll.addLast(grabbedNumber);
                  break;
             }
             
             else if (grabbedNumber <= ll.get(i))
               {
                  ll.add(i, grabbedNumber);
                  break;
               }
             
             else continue;
         }
      } 
      
       System.out.println(ll); 
     }
 
} 