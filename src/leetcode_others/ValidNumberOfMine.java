package leetcode_others;

//https://leetcode.com/problems/valid-number/
public class ValidNumberOfMine {
	
	public boolean isNumber(String s) {
		s = s.trim();
		boolean numberSeen = false;
		boolean eSeen = false;
		boolean numberAfterE = true;
		boolean dotSeen = false;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)>='0' && s.charAt(i)<='9'){
				numberSeen = true;
				numberAfterE = true;
			}else if(s.charAt(i)=='e'){
				if(eSeen||!numberSeen){
					return false;
				}
				eSeen= true;
				numberAfterE = false;
			}else if(s.charAt(i)=='.'){
				if(dotSeen||eSeen) return false;
				dotSeen= true;
			}else if(s.charAt(i)=='-'||s.charAt(i)=='+'){
				if(i!=0 && s.charAt(i-1)!='e') return false; 
			}else{
				return false;
			}
		}
		return numberSeen&&numberAfterE;	   
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidNumberOfMine aMine = new ValidNumberOfMine();
		System.out.println(aMine.isNumber(" 005047e+6"));

	}

}
