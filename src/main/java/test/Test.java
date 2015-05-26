package test;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Map<A,Object> map = new HashMap<A, Object>();    
	     map.put(new A(2), new Object());    
	     map.put(new A(3), new Object());    
	     for(A a:map.keySet()){
	    	 System.out.println(a.num);
	     }       
	     System.out.println(map.size()); 

	}

}
