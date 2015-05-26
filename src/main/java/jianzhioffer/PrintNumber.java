package jianzhioffer;

public class PrintNumber {
	
	 public void print1ToMaxofGigits(int n){
	      if(n<=0) return;
	      char number[] = new char[n];	      
	      print1toINumbers(number,n,0);
	 }

	private void print1toINumbers(char[] number, int n, int index) {
		// TODO Auto-generated method stub
		if(index == n){
			printNumber(number);
			return;
		}
		for(int i=0;i<10;i++){
			number[index] = (char) ('0' + i);
			print1toINumbers(number, n, index+1);
		}
	}
	private void printNumber(char[] number) {
		// TODO Auto-generated method stub
		boolean isBeginning0 = true;
		for(int i=0;i<number.length;i++){
			if(isBeginning0 && number[i] != '0'){
				isBeginning0 = false;
			}
			if (!isBeginning0) {
				System.out.print(number[i]);
			}
		}
		if (!isBeginning0) System.out.println();
	}

	public static void main(String[] args) {
		PrintNumber a = new PrintNumber();
		a.print1ToMaxofGigits(2);
	}

}
