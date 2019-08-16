package panzer.models.parts;


import panzer.contracts.Part;
import panzer.models.BaseModel;

import java.math.BigDecimal;

public abstract class BasePart extends BaseModel implements Part {

    private double weight;
    private BigDecimal price;

    BasePart(String model, double weight, BigDecimal price) {
        super(model);
        this.setWeight(weight);
        this.setPrice(price);
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }

    protected void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       int index = this.getClass().getSimpleName().indexOf("Part");
       String partType = this.getClass().getSimpleName().substring(0,index);
       sb.append(String.format("%s Part - %s ",
               partType,
               this.getModel()));
       return sb.toString();
    }
}
