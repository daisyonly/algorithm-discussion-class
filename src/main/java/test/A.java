package test;

class A {
	public int num;
	public A(int num){
		this.num= num;
	}
	  
    @Override  
    public boolean equals(Object obj) {  
        System.out.println("判断equals");  
        return true;  
    }  
  
    @Override  
    public int hashCode() {  
        System.out.println("判断hashcode");  
        return 1;  
    }  
}  

