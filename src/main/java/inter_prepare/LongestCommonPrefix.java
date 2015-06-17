package inter_prepare;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length==0) return "";
		if(strs.length==1) return strs[0];
		StringBuilder str = new StringBuilder();
		for(int i=0;i<strs[0].length();i++){
			int count=0;
			for(int j=1;j<strs.length;j++){
				if(strs[j].length()>i && strs[j].charAt(i)==strs[0].charAt(i)) count++;
				else break;
			}
			if(count==strs.length-1) str.append(strs[0].charAt(i));
			else break;		
		}
		return str.toString();  
    }

}
