package test;

public class Bmw extends Car{
    private String name;
    private Engine engine;
    Bmw(){
        this.name = "Bmw";
        this.engine = new Engine();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        Bmw bmw = (Bmw)super.clone();
        bmw.engine = engine.clone();
        return bmw;
    }
}
