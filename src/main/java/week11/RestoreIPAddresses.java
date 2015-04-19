package week11;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/restore-ip-addresses/
public class RestoreIPAddresses {
	
    public List<String> restoreIpAddresses(String s) {
    	List<String> list = new LinkedList<String>(); 
    	if(s.length()>12 || s.length()<4) return list;
    	char[] c = s.toCharArray();
    	int length = s.length();
    	for(int i=0; i<3; i++){
    		for(int j=i+1; j<i+4; j++){
    			for(int k=j+1; k<j+4; k++){
    				if(k >= (length-1)) continue;
    				System.out.println(i+","+j+","+k);
    				String tmp = getIP(c,i,j,k);
    				if(tmp != null) list.add(tmp);
    			}
    		}
    	}    	
		return list;        
    }

	private String getIP(char[] c, int i, int j, int k) {
		StringBuilder str = new StringBuilder();
		String tmp = check(c,0,i);
		if(tmp == null) return null;
		str.append(tmp).append(".");
		tmp = check(c,i+1,j);
		if(tmp==null) return null;
		str.append(tmp).append(".");
		tmp = check(c,j+1,k);
		if(tmp==null) return null;
		str.append(tmp).append(".");
		tmp = check(c,k+1,c.length-1);
		if(tmp==null) return null;
		str.append(tmp);
		return str.toString();
	}

	private String check(char[] c, int left, int right) {
		int sum=0;
		for(int i=left;i <= right;i++){
			sum = sum*10 + c[i]-'0';
		}
		if(sum > 255 || String.valueOf(sum).length()<(right-left+1)) return null;
		else return sum+"";
	}
	
	public static void main(String[] args){
		RestoreIPAddresses a= new RestoreIPAddresses();
		System.out.println(a.restoreIpAddresses("010010"));
	}
}
