import java.util.*;
class Sort{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array n");
		int n= sc .nextInt();
		Integer x[][]= new Integer [n][2];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<2;j++)
			{
				x[i][j]=sc.nextInt();
			}
		}

		Arrays.sort(x, new Comparator <Integer []>()
		{
			public int compare(Integer [] e1 , Integer [] e2){
				if(e1[0]==e2[0])
				{
					return e2[1]-e1[1];
				}
				return e1[0]-e2[0];
			}
		});
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<2;j++)
			{
				System.out.print(x[i][j]+"\t");
			}
			System.out.println();
		}
	}
}