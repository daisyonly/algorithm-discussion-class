package basic_algorithm;

import java.util.ArrayList;
import java.util.List;


public class KMPMe {
	
	
	public List<Integer> KMP(String text,String pattern) {
		List<Integer> ans=new ArrayList<Integer>();
		int next[]=getNext(pattern.toCharArray());
		char[] textC=text.toCharArray();
		char[] patternC=pattern.toCharArray();
		
		int i=0,j=0;
		while(i<textC.length){
			while(j!=-1&&textC[i]!=patternC[j]){
				j=next[j];
			}
			j++;
			i++;
			if(j==patternC.length){
				ans.add(i-patternC.length);
				j=next[j];
			}
		}		
		return ans;
	}

	private int[] getNext(char[] pattern) {
		int next[]=new int[pattern.length+1];		
		int i=0,j=-1;
		next[i]=j;
		while (i<pattern.length) {
			while(j!=-1 && pattern[i]!=pattern[j]){
				j=next[j];
			}
			i++;
			j++;
			next[i]=j;
		}
		return next;
	}
	
	public static void main(String[] args) {
		KMPMe test=new KMPMe();
		String ptrn = "abcabdabc";
		 
        String text = "abcabdabcabeabcabdabcabd";
		List<Integer> ans=test.KMP(text, ptrn);
		System.out.println(ans);
	}

}
