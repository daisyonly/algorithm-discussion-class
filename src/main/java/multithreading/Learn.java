package multithreading;

//http://blog.csdn.net/morewindows/article/details/7392749
class OutputA implements Runnable{
	Resource r;
	OutputA(Resource r){
		this.r=r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			r.getA();;
		}
	}
	
}

class OutputB implements Runnable{
	Resource r;
	OutputB(Resource r){
		this.r=r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			r.getB();;
		}
	}
	
}
class OutputC implements Runnable{
	Resource r;
	OutputC(Resource r){
		this.r=r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			r.getC();;
		}
	}
	
}

class Resource{
	boolean flagA=true,flagB=false,flagC=false;
	public void getA() {
		while(!flagA){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flagA =false;
		flagB = true;
		System.out.print('A');
		notifyAll();
	}
    public void getB() {
    	while(!flagB){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flagB =false;
		flagC = true;
		System.out.print('B');
		notifyAll();
	}
    public void getC() {
    	while(!flagC){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flagC =false;
		flagA = true;
		System.out.print('C');
		notifyAll();
   	}
}
public class Learn {
	public static void main(String[] args) {
		Resource r = new Resource();	
		Thread A = new Thread(new OutputA(r));
		Thread B = new Thread(new OutputA(r));
		Thread C = new Thread(new OutputA(r));
		A.start();
		B.start();
		C.start();	
	}

}
