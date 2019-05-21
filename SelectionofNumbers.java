/*You are given N numbers placed in a line. You have to select K numbers from those numbers. 
The priority level of the numbers is different.
You can select numbers from end only. After selection the number gets erased from the line. 
You want to maximize the sum of priority level of all the numbers. Your task is to find the maximum 
sum of the priority values.*/ 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class SelectionOfNumbers {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String[] s = br.readLine().trim().split(" ");
		int n = Integer.parseInt(s[1]);
		int k = Math.min(Integer.parseInt(s[0]), n);
		s = br.readLine().trim().split(" ");
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(s[i]);
		}
		long sum = 0;
		for(int i = n-1; i >= n-k; i--) {
			sum += a[i];
		}
		int i = n-k+1;
		long ans = sum;
		while(i%n != 0) {
			sum += a[(i-1+k)%n] - a[(i-1)%n];
			if(ans < sum) ans = sum;
			i++;
		}
		System.out.println(ans);
	}
}