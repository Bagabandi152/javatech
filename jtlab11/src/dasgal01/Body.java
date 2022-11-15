package dasgal01;

import java.io.Serializable;

public class Body implements Serializable {
    double weight;
    double height;

    Body(double weight, double height){
        this.height = height;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Body{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
