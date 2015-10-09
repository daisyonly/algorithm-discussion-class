package design_pattern.bridge;

//测试类

public class Test{

   public static void main(String[] args){

       AbstractNoodle noodle = new PorkNoodle(new PepperyStyle());

       noodle.eat();

       AbstractNoodle noodle2 = new PorkNoodle(new PlainStyle());

       noodle2.eat();

   }

}
