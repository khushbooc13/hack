/*Scientists, researchers, mathematicians and thinkers propose theories for a number of things. 
For explaining a single thing, a number of theories are proposed. A number of theories are 
rendered invalid after a new and more relevant theory surfaces, giving a better and a more 
valid explanation for the subject of the theory. For this problem, we are only concerned with 
one field of study, lets say, A. In the field A, a number of theories were proposed for a number 
of domains in the field. 

For a particular theory, the time at which it was proposed be T1 and the time at which it 
becomes invalid be T2. We define the theory period for this particular theory as [T1, T2). 
Both T1 and T2 are recorded in seconds from some reference point, B. We are given the theory 
periods for a number of theories. It is possible that more than one theory in the field 
A might be valid at some second, T (Recorded with reference to B ). Let us call the value of 
the number of valid theories at the second T as popularity of the field at second T. 
The popularity of the field would be maximum at some point in time. Your task is simple, that 
is calculate this maximum value of popularity for the field A. 
*/

import java.util.*;
import java.io.*;
class Prateekandtheories{
	public static void main(String[] args) throws IOException{
		BufferedReader S=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t=Integer.parseInt(S.readLine());
		for(int zzz=0;zzz<t;zzz++) {
			int n=Integer.parseInt(S.readLine());
			int t1[]=new int[n];
			int t2[]=new int[n];
			for(int i=0;i<n;i++) {
				StringTokenizer st=new StringTokenizer(S.readLine());
				t1[i]=Integer.parseInt(st.nextToken());
				t2[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(t1);
			Arrays.sort(t2);
			int i=0,j=0,max=0,count=0;
			while(i<n) {
				if(t1[i]<t2[j]) {
					i++;
					count++;
					if(count>max)
						max=count;
				}
				else if(t1[i]>t2[j]) {
					j++;
					count--;
				}
				else
				{
					i++;
					j++;
				}
			}
			out.println(max);
		}//for
		out.close();
	}
}