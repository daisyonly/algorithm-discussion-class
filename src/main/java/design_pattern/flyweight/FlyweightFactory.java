package design_pattern.flyweight;

import java.util.HashMap;
public class FlyweightFactory{
	private HashMap<Object,Flyweight> flyweights = new HashMap<Object, Flyweight>();
	//----------------------------1
	
	public FlyweightFactory(){
		
	}
	
	public Flyweight getFlyWeight(Object obj){
		Flyweight flyweight = (Flyweight) flyweights.get(obj);//----------------2
		
		if(flyweight == null){//---------------------------------------------------3
			//产生新的ConcreteFlyweight
			flyweight = new ConcreteFlyweight((String)obj);
			flyweights.put(obj, flyweight);//--------------------------------------5
		}
		return flyweight;//---------------------------------------------------------6
	}
	public int getFlyweightSize(){
		return flyweights.size();
	}
}