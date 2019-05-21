/*Rhezo and his friend Vanya love problem solving. They have a problem set 
containing N problems, with points assigned to each. Rhezo wants to solve 
problems in such a way that he gets the maximum number of points. Rhezo has 
a weird habit of solving only prime number of consecutive problems, that is, 
if he solves X consecutive problems from the problem set, then X should be prime. 
Vanya has already solved all problems from the problem set and he wonders how much 
maximum points Rhezo can get. Vanya can answer this, but can you?*/
import java.io.*;
import java.util.*;
class RhezoandPrimeProblems
{
	public static void main(String[] args) throws IOException{
		BufferedReader S=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int n=Integer.parseInt(S.readLine());
		long a[]=new long[n+1];
		a[0]=0;
		StringTokenizer st=new StringTokenizer(S.readLine());
		for(int i=1;i<=n;i++)
			a[i]=a[i-1]+Integer.parseInt(st.nextToken());
		ArrayList<Integer> prime=new ArrayList<Integer>();
		boolean b[]=new boolean[n+1];
		Arrays.fill(b,true);
		b[0]=false;
		b[1]=false;
		for(int i=2;i*i<=n;i++) {
			if(b[i]) {
				for(int j=i*i;j<=n;j+=i)
					b[j]=false;
			}
		}
		for(int i=2;i<=n;i++) {
			if(b[i])
				prime.add(i);
		}
		long d[]=new long[n+1];
		d[n]=0;
		for(int i=n-1;i>=1;i--) {
			int size=n-i+1;
			if(b[size])
				d[i]=a[n]-a[i-1];
			else {
				long max=d[i+1];
				for(int x:prime){
					if(x>size)
						break;
					if(i+x+1<=n)
						max=Math.max(max,d[i+x+1]+a[i+x-1]-a[i-1]);
					else
						max=Math.max(max,a[i+x-1]-a[i-1]);
				}
				d[i]=max;
			}//else
		}//for
		out.println(d[1]);
		out.close();
	}
}