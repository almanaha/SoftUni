package panzer.models;

import panzer.contracts.Modelable;

public abstract class BaseModel implements Modelable {
    private String model;

    protected BaseModel(String model) {
       this.setModel(model);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    protected void setModel(String model) {
        this.model = model;
    }
}
