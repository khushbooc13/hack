import java.io.*;
import java.util.*;
class XsquareAndTwoArrays {
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0;i<n;i++) a[i] = s.nextInt();
        for(int i=0;i<n;i++) b[i] = s.nextInt();
        while(q-->0)
        {
            char ot = s.next().charAt(0);
            int l = s.nextInt();
            int r = s.nextInt();
            long sum=0l;
            if(ot=='1') {
                for(int i=l-1;i<r;i++) {
                    sum += a[i];
                    i++;
                    if(i<r) sum += b[i];
                }
            } else if(ot=='2') {
                for(int i=l-1;i<r;i++) {
                    sum += b[i];
                    i++;
                    if(i<r) sum += a[i];
                }
            }
            System.out.println(sum);
        }
    }
}