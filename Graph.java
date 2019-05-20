import java.util.*;
class Graph{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][]= new int[n][n];
		int city[]= new int[n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.println(i+1+","+(j+1));
				arr[i][j]=sc.nextInt();				
			}
			city[i]=0;

		}
		/*city[0]=1;
		int val=findCity(1,city,arr,n);
		int cost=2;
		cost+=arr[1][val];
		System.out.println(cost)*/
		mincost(0,city,arr,n);

		
	}
	static int findCity(int c,int city[],int arr[][],int n)
	{
		int index=0;
		int min=999;
		for(int i=0;i<n;i++)
		{
			min=arr[c][i];
			index=i;
			if(arr[c][i]!=0 && city[i]!=0)
			{
				if(arr[c][i]<min)
				{
					min=arr[c][i];
					index=i;
				}
			}
		}
		return index;
	}

	static void mincost(int c,int city[],int arr[][],int n)
	{
		int cost=0;
		city[c]=1;
		System.out.print(c+1+"->");
		int ncity=findCity(c,city,arr,n);
		cost+=arr[c][ncity];
		System.out.println(cost);
		mincost(ncity,city,arr,n);

	}

}