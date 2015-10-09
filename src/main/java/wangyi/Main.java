package wangyi;
import java.util.*;
class Main{
    public static void main(String args[]){
       
        Scanner sc = new Scanner(System.in);
        
        
        int mHP=sc.nextInt();
        int lHP=sc.nextInt();
        int mHit=sc.nextInt();
        int lHit=sc.nextInt();
        int t=sc.nextInt();
        boolean lIsActive=true;
        boolean isbreak=false;
        while((t--)>0){
        	char mAct=sc.next().charAt(0);
        	char lAct=sc.next().charAt(0);
        	if(mAct=='A'){
        		if(lIsActive){
        			if(lAct=='A'){
            			lHP=lHP-mHit;
            			mHP=mHP-lHit;
            		}
        		
        		}else {
        			lIsActive=true;
        			if(lAct=='A') lHP=lHP-mHit;
        			else continue;
        			
				}
        	}else{
        		if(lAct=='B') 
        		{
        			lIsActive=true;
        		}else {
        			lIsActive=false;  
				}      		       		
        	}
        	if(mHP<=0){
        		System.out.println("YES");
        		isbreak=true;
        		break;
        	}
        	if(lHP<=0){
        		System.out.println("NO");
        		isbreak=true;
        		break;
        	}
        }
        if(!isbreak)
        {
        	if(lHP>=mHP){
    		System.out.println("YES");
        	}else {
        		System.out.println("NO");
        	}   
        }
            
       
    }
}