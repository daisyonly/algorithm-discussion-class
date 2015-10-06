package ms.me;

import java.util.HashMap;
import java.util.Scanner;

public class Fibonacci {
	
	static int[] nums;
	static HashMap<Integer, Integer> countF=new HashMap<Integer, Integer>();
	static HashMap<Integer, Integer> pre =new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		nums=new int[n];
		for(int i=0;i<n;i++){
			nums[i]=cin.nextInt();
		}
		cin.close();
		init();	
		int sum=0;
		int MOD=1000000007;
		for(int num :nums){
			if(num==1){
				sum=(sum+countF.get(1)+1)%MOD;
				countF.put(1, countF.get(1)+1);
			}
			else{
				if(num==2){
					int count1=countF.get(1);
					int cc=count1*(count1-1)/2;
					sum=(sum+cc%MOD)%MOD;
					
				}else {
					int pr=pre.get(num);
					sum=(sum+pr)%MOD;
				}
				countF.put(num, countF.get(num)+1);
			}
		}
		System.out.println(sum);
		
		
	}
	private static void init() {
		int fn=1,fnn=1;
		countF.put(1, 0);
		for(int i=2;i<100;i++){
			int f=fn+fnn;
			if(f>100000) break;
			countF.put(f, 0);
			pre.put(f, fn);
			fnn=fn;
			fn=f;
		}		
	}

}
