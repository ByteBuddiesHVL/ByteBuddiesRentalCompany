package bytebuddies.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(schema = "rentalcomp")
public class Reservations {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Integer reservationId;
    @ManyToOne
    @JoinColumn(name = "user_tlf_num")
    private Users user;
    @Column(name = "credit_card")
    private String creditCard;
    @Column(name = "card_code")
    private String cardCode;
    private Boolean paid;
    private int amount;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "car")
    private Cars car;
    @ManyToOne
    @JoinColumn(name = "end_location")
    private Locations endLocation;

    public Reservations(Users user, String creditCard, String cardCode, Boolean paid, int amount, LocalDateTime startDate, LocalDateTime endDate, Cars car, Locations endLocation) {
        this.user = user;
        this.creditCard = creditCard;
        this.cardCode = cardCode;
        this.paid = paid;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.car = car;
        this.endLocation = endLocation;
    }

    public Reservations() {}

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Locations getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Locations endLocation) {
        this.endLocation = endLocation;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars cars) {
        this.car = cars;
    }
}
