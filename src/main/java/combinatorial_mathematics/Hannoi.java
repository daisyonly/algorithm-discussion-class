package combinatorial_mathematics;

public class Hannoi {
	
	public static void hannoi (int n, char from, char buffer, char to)
	{
	    if (n == 1)
	    {	       
	        System.out.println("Move disk " + n + " from " + from + " to " + to);

	    }
	    else
	    {
	        hannoi (n-1, from, to, buffer);	       
	        System.out.println("Move disk " + n + " from " + from + " to " + to );
	        hannoi (n-1, buffer, from, to);
	    }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hannoi.hannoi(3, 'A', 'B', 'C');

	}

}
