package july_1;

import java.util.Stack;

public class BasicCalculatorII {
	
	public int calculate(String s) {
		Stack<Character> st= new Stack<Character>();
		int i=0;
		while(i<s.length()){
			char c=s.charAt(i);
			if((c>='0'&&c<='9')||c=='+'||c=='-'){
				st.push(s.charAt(i));
			}else if(c=='*'||c=='/'){
				int tmp=0,out;
				while(++i<s.length()){
					if(s.charAt(i)>='0'&&s.charAt(i)<='9')   
						tmp=tmp*10+s.charAt(i)-'0';
					else if(s.charAt(i)==' '){
						continue;
					}else{
					   --i;
					   break;
					}
				}
				int num=getnumfromst(st);
				if(c=='*') out=num*tmp;
				else out=num/tmp;
				//System.out.println(out);
				addtost(st,out);
			}			
			++i;
		}
		int ans=0,num=0,count=1;
		while(!st.empty()){
			char c=st.pop();
			//System.out.println(c);
			if(c>='0'&&c<='9'){
				num+=(c-'0')*count;
				count*=10;
			}else {
				//System.out.println(num);
				if(c=='+'){
					ans=ans+num;
				}else{
					ans=ans-num;
				}
				num=0;count=1;
			}
		}
		return ans+num;        
    }

	private void addtost(Stack<Character> st, int out) {
		// TODO Auto-generated method stub
		int count=1;
		while(out/count>=10){
			count=count*10;
		}
		while(count>=1){
			st.push((char) (out/count+'0'));
			out=out%count;
			count/=10;		
		}	
	}

	private int getnumfromst(Stack<Character> st) {
		// TODO Auto-generated method stub
		int sum=0,count=1;
		while(!st.isEmpty()){
			char c=st.peek();
			if(c=='-'||c=='+') break;
			st.pop();
			sum=sum+(c-'0')*count;
			count*=10;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicCalculatorII aBasicCalculatorII=new BasicCalculatorII();
		System.err.println(aBasicCalculatorII.calculate("2*3+4"));
		

	}

}
