package test;

public class TestPrototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Bmw bmw1 = (Bmw)ModelType.BMW.getCar();
        Bmw bmw2 = (Bmw)ModelType.BMW.getCar();
        bmw1.setName("bmw1");
        bmw2.setName("bmw2");
        System.out.println(bmw1.getName());
        System.out.println(bmw2.getName());
        bmw1.getEngine().setEngineId(1);
        bmw2.getEngine().setEngineId(2);
        System.out.println(bmw1.getEngine().getEngineId());
        System.out.println(bmw2.getEngine().getEngineId());
    }
}
