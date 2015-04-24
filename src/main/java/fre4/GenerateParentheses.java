package fre4;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
	
	 public List<String> generateParenthesis(int n) {
		 List<String> ansList = new LinkedList<String>();
		 StringBuilder tmp = new StringBuilder();
		 findParenthesis(ansList,tmp,0,0,n);
		 return ansList;
	        
	 }
	
	private void findParenthesis(List<String> ansList, StringBuilder tmp,
			int leftcount, Integer rigntcount,int n) {
		if(tmp.length()==2*n){
			ansList.add(tmp.toString());
		}
		tmp.append("(");
		if(leftcount<n) findParenthesis(ansList, tmp, leftcount+1, rigntcount, n);
		tmp.deleteCharAt(tmp.length()-1).append(")");
		if(rigntcount<leftcount) findParenthesis(ansList, tmp, leftcount, rigntcount+1, n);		
		tmp.deleteCharAt(tmp.length()-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParentheses a = new GenerateParentheses();
		System.out.println(a.generateParenthesis(3));
	}

}
