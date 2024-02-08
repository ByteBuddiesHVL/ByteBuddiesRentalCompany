package bytebuddies.entities;

import jakarta.persistence.*;

@Entity
@Table(schema = "rentalcomp")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;
    private int amount;

    public Transaction(int amount) {
        this.amount = amount;
    }

    public Transaction() {

    }
}
