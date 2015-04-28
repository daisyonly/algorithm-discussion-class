package fre3;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
	
	public List<String> letterCombinations(String digits) {
		List<String> ans = new LinkedList<String>();
		if(digits==null ||digits.length()==0) return ans;
		String[] mapping = {"0", "1", "abc", "def", "ghi", 
				"jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i=0;i<digits.length();i++){
			int num = digits.charAt(i)-'0';
			int size = ans.size();
			for(int j=0;j<size;j++){
				String tmp = ans.remove(0);
				for(char c:mapping[num].toCharArray()){
					ans.add(tmp+c);
				}
			}
		}
		return ans;       
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinationsofaPhoneNumber a = new LetterCombinationsofaPhoneNumber();
		System.out.print(a.letterCombinations("23"));
		

	}

}
