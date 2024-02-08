package bytebuddies.entities;

import jakarta.persistence.*;

@Entity
@Table(schema = "rentalcomp")
public class Car {
    @Id
    private String regNum;
    private String brand;
    private String color;
    private String group;
    private boolean available;

    public Car(String regNum, String brand, String color, String group, boolean available) {
        this.regNum = regNum;
        this.brand = brand;
        this.color = color;
        this.group = group;
        this.available = available;
    }

    public Car() {

    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
