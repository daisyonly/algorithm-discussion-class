package design_pattern.decorator;

public class ChickenBurger extends Humburger {
	
	public ChickenBurger(){
		name = "鸡腿堡";
	}

	@Override
	public double getPrice() {
		return 10;
	}

}
