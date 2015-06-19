package inter_prepare;

public class LongestRepeatSubstring {
	public String getLongestRepeatSubstring(String str){
		int start = 0;
		int maxlen = 0;
		for(int i=0;i<str.length();i++){
			for(int j=i+1;j<str.length();j++){
				int index=0;
				while(j+index<str.length()){
					if(str.charAt(i+index)==str.charAt(j+index)){
						index++;
					}else{
						break;
					}					
				}
				if(maxlen<index){
					start = i;
					maxlen =index;
				}
			}
		}	
		return str.substring(start,start+maxlen);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestRepeatSubstring test = new LongestRepeatSubstring();
		System.out.println(test.getLongestRepeatSubstring("aabcabc"));

	}

}
