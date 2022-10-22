package problem03;

import java.io.Serializable;
import java.util.Date;

public class Movie implements Serializable {
    //Киноны нэр, бүтээсэн он, бүтээсэн улс, төрөл, бүтээсэн нийт өртөг
    String name;
    Date createdDate;
    String createCountry;
    String type;
    Double totalPrice;

    public Movie(String name, Date createdDate, String createCountry, String type, Double totalPrice) {
        this.name = name;
        this.createdDate = createdDate;
        this.createCountry = createCountry;
        this.type = type;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreateCountry() {
        return createCountry;
    }

    public void setCreateCountry(String createCountry) {
        this.createCountry = createCountry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
