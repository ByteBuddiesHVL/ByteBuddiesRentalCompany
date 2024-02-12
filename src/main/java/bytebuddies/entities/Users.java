package bytebuddies.entities;

import jakarta.persistence.*;

@Entity
@Table(schema = "rentalcomp")
public class Users {
    @Id
    @Column(name = "tlf_num")
    private String tlfNum;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String address;

    @ManyToOne
    @JoinColumn(name = "post_num")
    private Post postNum;

    public Users(String tlfNum, String firstName, String lastName, String address, Post postNum) {
        this.tlfNum = tlfNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postNum = postNum;
    }

    public Users() {}

    public String getTlfNum() {
        return tlfNum;
    }

    public void setTlfNum(String tlfNum) {
        this.tlfNum = tlfNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Post getPostNum() {
        return postNum;
    }

    public void setPostNum(Post postNum) {
        this.postNum = postNum;
    }
}
