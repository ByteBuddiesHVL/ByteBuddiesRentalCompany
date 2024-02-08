package bytebuddies.entities;

import bytebuddies.entities.Post;
import jakarta.persistence.*;

@Entity
@Table(schema = "rentalcomp")
public class User {
    @Id
    private String tlfNum;
    private String firstName;
    private String lastName;
    private String address;

    @ManyToOne
    @JoinColumn(name = "postNum")
    private Post postNum;

    public User(String tlfNum, String firstName, String lastName, String address, Post postNum) {
        this.tlfNum = tlfNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postNum = postNum;
    }

    public User() {}
}
