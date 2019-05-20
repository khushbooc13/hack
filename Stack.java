import java.util.*;
class Stack{

	int arr[];
	int top,size,len;

	public Stack(int n)
	{
		size=n;
		top=-1;
		arr[]= new int [n];
		len=0;
	}
	public boolean isEmpty()
	{
		return top==-1;
	}

	public int getSize()
	{
		return len;
	}
	public boolean isFull()
	{
		return top==size-1;
	}

	public int topElement()
	{
		return arr[top];
	}

	public void push(int i)
	{
		if(isFull())
			System.out.println("Stack Overflow");
		else
			arr[++top]=i;
		len++;
	}

	public int pop(){
		if(isEmpty())
			System.out.println("Stack UnderFlow");
		else
			len--;
			return arr[top--];
	}

	public void display()
	{
		for(int i=top;i>-1;i++)
			System.out.print(arr[i]+"\t");
	}

}

public class StackImpl{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of stack");
		int n=sc.nextInt();
		Stack stk= new Stack(n);
		char ch;
		do{
			System.out.println("1.Push \n 2.Pop \n 3.Peek 4.display 5.exit");
			int choice= sc.nextInt();
			switch (choice)
			{
				case 1:
					System.out.println("Enter no of element to be pushed");
					stk.push(sc.nextInt());
					break;

				case 2:
					System.out.println("Poped element is "+stk.pop());
					break;
				
				case 3:
					System.out.println("Top Element is "+stk.topElement());
					break;

				case 4:
					System.out.println("Stack is:"+stk.display());
					break;
			}
			System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
		} while (ch == 'Y'|| ch == 'y');   
		
	}
}