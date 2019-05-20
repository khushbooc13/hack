import java.util.*;
import java.lang.Math.*;
class LCS{

	void len(char [] x, char [] y, int n, int m){

		int l[][] = new int[n+1][m+1];

		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=m;j++)
			{
				if(i==0 || j==0)
					l[i][j]=0;
				else if(x[i-1]==y[j-1])
					l[i][j]=1+l[i-1][j-1];
				else
					l[i][j]=Math.max(l[i-1][j],l[i][j-1]);
			}
		}
		//return l[n][m];

		int index=l[n][m];
		int temp=index;
		char store[]= new char[index+1];
		store[index]=' ';

		int p=n,k=m;
		while(p>0 && k>0)
		{
			if(x[p-1]==y[k-1])
			{
				store[index-1]=x[p-1];

				p--;
				k--;
				index--;
			}
			else if(l[p-1][k]>l[p][k-1])
				p--;
			else
				k--;
		}
		System.out.println(l[n][m]);
		for(int j=0;j<=temp;j++)
			System.out.print(store[j]);

	}

	public static void main(String[] args) {
		LCS lsc = new LCS();
		Scanner sc = new Scanner (System.in);
		String a= sc.next();
		String b= sc.next();
		char x[]=a.toCharArray();
		char y[]=b.toCharArray();

		int n=a.length();
		int m=b.length();

		lsc.len(x,y,n,m);
		
	}
}