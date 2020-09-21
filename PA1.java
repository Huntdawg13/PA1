import java.util.*; 
import java.io.*;
  
public class PA1 
{     
    public static void main(String args[]) 
    throws FileNotFoundException
    {
      long startTime = System.nanoTime();
      long endTime = System.nanoTime();
      double duration;
      
      File file;
      Scanner console = new Scanner(System.in);
		System.out.print("Enter integer-filled text file here: ");
		String FileName = console.next();
      file = new File(FileName);
      
      LinkedList<Integer> ll = new LinkedList<Integer>();

      while(!(file).exists())
      { 
          System.out.println("ERROR: NO FILE FOUND");
          System.out.print("Please reenter a file name: ");
          FileName = console.next();
          file = new File(FileName);
      }
      
      Scanner input = new Scanner(file);      
      int grabbedNumber;
      ll.add(input.nextInt());
      startTime = System.nanoTime();
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
      endTime = System.nanoTime();
      System.out.println(ll);
      duration = (endTime - startTime)/1000;
      System.out.println("It took " + duration + " microseconds to sort"); 
      
      startTime = System.nanoTime(); 
      System.out.println("The minimum value is: " + ll.getFirst());
      endTime = System.nanoTime();
      duration = (endTime - startTime)/1000;
      System.out.println("It took " + duration + " microseconds to find the minimum"); 
      
      startTime = System.nanoTime();
      getMed(ll);
      endTime = System.nanoTime();
      duration = (endTime - startTime)/1000;
      System.out.println("It took " + duration + " microseconds to find the median");
             
      startTime = System.nanoTime();
      System.out.println("The maximum value is: " + ll.getLast());
      endTime = System.nanoTime();
      duration = (endTime - startTime)/1000;
      System.out.println("It took " + duration + " microseconds to find the maximum");   
    }
     
     
     public static void getMed(LinkedList<Integer> ll)
     {
         if(ll.size() % 2 == 0)
            System.out.println("The median value is: " + ll.get((ll.size()/2)));
         else
            System.out.println("The median value is: " + ll.get((ll.size()-1)/2));   
     }
 
} 