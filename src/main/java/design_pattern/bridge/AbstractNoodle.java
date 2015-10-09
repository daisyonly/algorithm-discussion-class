package design_pattern.bridge;

public abstract class AbstractNoodle{

    protected Peppery style;

    public AbstractNoodle(Peppery style){

         this.style = style;   

    }

    public abstract void eat();

}
