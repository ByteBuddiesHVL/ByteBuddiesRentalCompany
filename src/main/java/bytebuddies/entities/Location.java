package bytebuddies.entities;

import jakarta.persistence.*;

@Entity
@Table(schema = "rentalcomp")
public class Location {
    @Id private String tlfNum;
    private String address;

    @ManyToOne
    @JoinColumn(name = "postNum")
    private Post postNum;

    public Location(String tlfNum, String address, Post postNum) {
        this.tlfNum = tlfNum;
        this.address = address;
        this.postNum = postNum;
    }

    public Location() {

    }
}
