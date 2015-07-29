package july_1;

import java.util.Stack;

public class BasicCalculator {
	
	public int calculate(String s) {
		Stack<Character> st= new Stack<Character>();
		int ans=0;
		//boolean add=true;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)!=')'&& s.charAt(i)!=' '){
				st.push(s.charAt(i));
			}else{
				if(s.charAt(i) == ')'){
					int sum=0,num=0,count=1;;
					while(!st.empty()){
						char c= st.pop();
						if(c=='(') break;
						if(c=='+'||c=='-'){
							if(c=='-'){
								char t='*';
								if(!st.empty()) t=st.peek();
								//System.out.println("test:"+t);
								if(t=='-'||t=='+'){
									st.pop();
									if(t=='-') sum=sum+num;
									else sum=sum-num;
								}else{
									sum=sum-num;
								}
							} 
							else sum=sum+num;
							count=1;
							num=0;
						}else{
							num=num+(c-'0')*count;
							count*=10;
						}
					}
					//System.out.println(sum+num);
					stAddNum(st,sum+num);
				}
			}
		}
		int num=0,count=1;;
		while(!st.empty()){
			char c= st.pop();
			if(c!='+'&& c!='-'){
				num=num+(c-'0')*count;
				count*=10;				
			}else{
				//System.out.println(num);
				if(c=='+'){
					ans+=num;
				}else{
					char t='*';
					if(!st.empty()) t=st.peek();
					//System.out.println("test:"+t);
					if(t=='-'||t=='+'){
						st.pop();
						if(t=='-') ans=ans+num;
						else ans=ans-num;
					}else{
						ans=ans-num;
					}
				}
				count=1;num=0;
			}
		}		
		return ans+num;
        
    }

	private void stAddNum(Stack<Character> st, int num) {
		// TODO Auto-generated method stub
		if(num<0){
			st.push('-');
			num=-num;
		}
		int count=1;
		while(num/count>=10){
			count=count*10;
		}
		while(count>=1){
			char a=(char) (num/count+'0');
			num=num-(num/count)*count;
			count/=10;
			st.push(a);
		}
	}
	public static void main(String[] args) {
		BasicCalculator a=new BasicCalculator();
		System.out.println(a.calculate("(5-(1+(5)))"));
	}

}
