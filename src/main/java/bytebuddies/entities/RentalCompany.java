package bytebuddies.entities;

import jakarta.persistence.*;

@Entity
@Table(schema = "rentalcomp")
public class RentalCompany {
    @Id private String name;
    private String tlfNum;
    private String address;
    @ManyToOne
    @JoinColumn(name = "postNum")
    private Post postNum;

    public RentalCompany() {

    }
    public RentalCompany(String tlfNum, String address, Post postNum) {
        this.tlfNum = tlfNum;
        this.address = address;
        this.postNum = postNum;
    }


}
