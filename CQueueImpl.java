import java.util.*;
class arrayQueue
{
    int Queue[] ;
    int front, rare, size, count;
 
    /* Constructor */
    public arrayQueue(int n) 
    {
        size = n;
        Queue = new int[size];
        front = 0;
        rare =-1;
        count=0;
    }    
    public boolean isEmpty()
    {
        return front==-1;;
    }    
    public void insert(int i) 
    {
        System.out.println("Insert");
        if(count==size)
        {
            System.out.println("Queue Overflow");
        }    
        else
        {
            if(rare==size-1)
                rare=0;
            else
            {
                Queue[++rare]=i;
            }
        }
    }    
    /*  Function to remove front element from the queue */
    public int remove() 
    {
        int x;
        if(isEmpty())
        {
            System.out.println("Queue UnderFlow");
            return 0;
        }        
        else
        {
            count--;
            x=Queue[front];
            if(front==size-1)
                front=0;
            else
                front++;
            return x;
        }
    }
    /*  Function to display the status of the queue */
    public void display()
    {
        System.out.println("Display");
        if(rare<front)
        {
            for (int i=front;i<size ;i++ ) {
                System.out.println(Queue[i]);
            }
            for(int i=0;i<rare;i++)
                System.out.println(Queue[i]);
        }
        else
        {
            for(int i=front;i<=rare;i++)
                System.out.println(Queue[i]);
        }
    }
}
 
/* Class QueueImplement  */
public class CQueueImpl
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
 
        System.out.println("Array Queue Test\n");
        System.out.println("Enter Size of Integer Queue ");
        int n = scan.nextInt();
        /* creating object of class arrayQueue */
        arrayQueue q = new arrayQueue(n);        
        /* Perform Queue Operations */        
        char ch;
        do{
            System.out.println("\nQueue Operations");
            System.out.println("1. insert");
            System.out.println("2. remove");
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                q.insert( scan.nextInt() );
                q.display(); 
                break;                         
            case 2 : 
                System.out.println("Removed Element = "+q.remove());
                break;                                                  
            }           
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');                                                       
    }    
}