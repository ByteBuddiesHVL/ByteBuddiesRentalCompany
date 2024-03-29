package bytebuddies.entities;

import jakarta.persistence.*;

@Entity
@Table(schema = "rentalcomp", name = "rentalcompany")
public class RentalCompany {
    @Column(name = "comp_name")
    @Id private String name;
    @Column(name = "tlf_num")
    private String tlfNum;
    private String address;
    @ManyToOne
    @JoinColumn(name = "post_num")
    private Post postNum;

    public RentalCompany() {

    }
    public RentalCompany(String tlfNum, String address, Post postNum) {
        this.tlfNum = tlfNum;
        this.address = address;
        this.postNum = postNum;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTlfNum() {
        return tlfNum;
    }

    public void setTlfNum(String tlfNum) {
        this.tlfNum = tlfNum;
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
