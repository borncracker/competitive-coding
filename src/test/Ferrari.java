package test;

public class Ferrari extends Car{
    private String name;
    private Engine engine;
    Ferrari(){
        this.name = "Ferrari";
        this.engine = new Engine();
    }
    public String getName() {
        return name;
    }
    @Override
    public Car clone() throws CloneNotSupportedException {
        Ferrari ferrari = (Ferrari)super.clone();
        ferrari.engine = engine.clone();
        return ferrari;
    }
}
