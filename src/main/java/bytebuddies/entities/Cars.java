package bytebuddies.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(schema = "rentalcomp")
public class Cars {
    @Id
    @Column(name = "reg_num")
    private String regNum;

    private String brand;
    private String color;
    @Column(name = "car_group")
    private String group;
    
    @ManyToOne
    @JoinColumn(name = "shop_location_tlf")
    private Locations location;
    @Column(name = "dist_driven")
    private int distDriven;

    // TODO skjekk mappedBy
    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    private List<Reservations> reservations;
    
    public Cars(String regNum, String brand, String color, String group, int distDriven, Locations location) {
        this.regNum = regNum;
        this.brand = brand;
        this.color = color;
        this.group = group;
        this.distDriven = distDriven;
        this.location = location;
    }

    public Cars() {

    }

    public Locations getLocation() {
        return location;
    }

    public Locations getLocationAt(LocalDateTime date) {
        final Locations[] loc = {location};
        final LocalDateTime[] closest = {LocalDateTime.of(2024, 1, 1, 0, 0)};
        reservations.forEach(res -> {
            if (res.getEndDate().isAfter(closest[0]) && res.getEndDate().isBefore(date)) {
                closest[0] = res.getEndDate();
                loc[0] = res.getEndLocation();
            }
        });
        return loc[0];
    }

    public void setLocation(Locations locations) {
        this.location = locations;
    }

    public List<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
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

    public int getDistDriven() {
        return distDriven;
    }

    public void setDistDriven(int distDriven) {
        this.distDriven = distDriven;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isAvailableBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return reservations.stream()
                .allMatch(c -> {
                    return c.getEndDate().isBefore(startDate) || c.getStartDate().isAfter(endDate);
                });
    }
}
