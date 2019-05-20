import java.util.*;
class TSP {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter no of nodes:");
		int n=sc.nextInt();
		int city[][]=new int[n][n];
		int visit[]=new int[n];
		System.out.println("Enter cost of matrix:");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				city[i][j]=sc.nextInt();
			}
			visit[i]=0;
		}
		System.out.println("Matrix is");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(city[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("Enter the city:");
		int st=sc.nextInt();
		TSP t= new TSP();
		int res_cost=mincost(1,visit,city,n);

	}
	static int mincost(int city, int visit[],int arr[],int n)
	{
		visit[city]=1;
		System.out.println(city+1+"->");
		int ncity=-1;
		ncity=least(city,visit,arr,n);
		System.out.println(ncity);
		if(ncity==-1)
		{
			ncity=0;
			System.out.println(ncity+1);
			return cost+arr[city][ncity];
		}
		mincost(ncity);
	}
	static int least(int c,int visit[],int arr[])
	{
		for(int i=0;i<n;i++)
		{
			if(arr[c][i]!=0 && visit[i]!=0)
		}
	}

}