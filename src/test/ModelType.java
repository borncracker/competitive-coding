package test;

public enum ModelType {
    BMW("Bmw",new Bmw()),
    FERRARI("Ferrari", new Ferrari());
    String modelType;
    Car car;
    ModelType(String modelType, Car car){
        this.modelType = modelType;
        this.car = car;
    }
    public String getModelType(){
        return this.modelType;
    }
    public Car getCar() throws CloneNotSupportedException {
        return (Car)this.car.clone();
    }
}
