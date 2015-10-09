package design_pattern.bridge;

//以下是猪肉面实现类

public class PorkNoodle extends AbstractNoodle{

  public PorkNoodle(Peppery style) {
		super(style);
		// TODO Auto-generated constructor stub
	}


   public void eat(){

         System.out.println( "猪肉面条的口味："+ style.style());

   }

}
