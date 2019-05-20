import java.util.*;
class MotuPatlu{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		int front=0,rare=n-1;
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		int max=arr[0];
		for(int i=1;i<=n;i++)
		{
			if(max<arr[n-1])
			{
				max=arr[i+1];
				front++;
				if(rare==n-1)
				{
					front--;
				}
			}
			else if(max>arr[n-1])
			{
				max=max;
				rare--;
			}
		}

		System.out.println(max);
	}
}