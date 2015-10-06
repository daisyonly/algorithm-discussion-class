package ms.wy;

import java.util.Scanner;

public class Fibonacci {


	static int N = 1000001;
	static int f[] = new int[31];
	static int mp[] = new int[N];
	public static void init(){
		f[0]=f[1] = 1;
		mp[1] =1;
		for(int i=2;i<30;i++){
			f[i] = f[i-1] + f[i-2];
			if(f[i]> 100001) break;
			mp[f[i]] = i;
			
		}
	}
	public static void main(String[] args) {
		init();
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int MOD = 1000000007;
		int ans = 0;
		int t[] = new int[32];
		for(int i=0;i<n;i++){
			int num = cin.nextInt();
			if(mp[num]!=0){
				if(mp[num] == 1){
					ans = (ans + t[0] + 1)%MOD;
					t[1] += t[0];
					t[1] %= MOD;
					t[0]++;
					t[0]%=MOD;
				}else{
					ans = (ans + t[mp[num]-1]);
					ans%=MOD;
					t[mp[num]]=(t[mp[num]]+t[mp[num]-1]);
					t[mp[num]]%=MOD;
				}
				
			}
		}
		System.out.println(ans);
	}
}
