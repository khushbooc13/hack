/*
Akshara is a Maths teacher at Dynamic Public School.One day she decided to take 
an unusual test of all her students.She took all her students to a fair.T
here she took them to a candy room.The room had 2 doors and behind each door was 
unlimited supply of candies.The excitement of the students could not be measured.
Each student wanted a specific amount of candies.Now here was the test.
At a time 1 student could enter 1 door.After he exits another will enter.
No time is lost when there is change of students.For proccessing 1 candy 
it took 1 second.The teacher gave exactly X amount of time for all the students 
to get their specific amount of candies.So the students ask you for help in 
determining whether it is possible for all the students to get their candies 
or not in X amount of time.*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class AmazingTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int arr[] = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            HashSet<Integer> set = new HashSet<>();
            set.add(0);
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> temp_set = new HashSet<>();
                for (Integer temp : set) {
                    System.out.println(temp);
                    if (temp + arr[i] <= x && sum - (temp + arr[i]) <= x) {
                        flag = true;
                    }
                    temp_set.add((temp + arr[i]));
                }
                set.addAll(temp_set);
                set.add(arr[i]);
            }
 
            System.out.println(flag ? "YES" : "NO");
        }
    }
}