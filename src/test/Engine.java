package test;

public class Engine implements Cloneable{
    long engineId;

    public long getEngineId() {
        return engineId;
    }

    public void setEngineId(long engineId) {
        this.engineId = engineId;
    }
    @Override
    public Engine clone () throws CloneNotSupportedException{
        return (Engine)super.clone();
    }
}
