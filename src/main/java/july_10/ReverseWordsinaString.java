package july_10;

import javax.xml.stream.events.EndDocument;

public class ReverseWordsinaString {
	public String reverseWords(String s) {
		if(s==null) return null;
		char c[]=s.toCharArray();
		reverseWords(c,0,c.length);
		int start=0,end;
		for (int i = 0; i < c.length; i++) {
			if(c[i]==' '){
				//System.out.println(i);
				end=i;
				reverseWords(c, start, end);
				start=i+1;
			}			
		}
		reverseWords(c, start, c.length);
		
		StringBuilder aBuilder = new StringBuilder();
		String[] strs=String.valueOf(c).split(" ");
		for(int i=0;i<strs.length;i++){
			if(!strs[i].equals("")){
				aBuilder.append(strs[i]).append(" ");
			}
		}
		return aBuilder.toString().trim();
        
    }

	private void reverseWords(char[] c, int start, int end) {
		// TODO Auto-generated method stub
		int length=(end-start)/2;
		//System.out.println(start+" "+end+"  "+length);
		for(int i=0;i<length;i++){
			char tmp=c[start+i];
			c[start+i]=c[end-1-i];
			c[end-1-i]=tmp;
		}
		//System.out.println(String.valueOf(c));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsinaString aReverseWordsinaString= new ReverseWordsinaString();
		System.out.println(aReverseWordsinaString.reverseWords("the sky is blue"));

	}

}
