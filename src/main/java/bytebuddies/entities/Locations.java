package bytebuddies.entities;

import jakarta.persistence.*;

@Entity
@Table(schema = "rentalcomp")
public class Locations {
    @Id
    @Column(name = "tlf_num")
    private String tlfNum;
    private String address;

    @ManyToOne
    @JoinColumn(name = "post_num")
    private Post postNum;

    public Locations(String tlfNum, String address, Post postNum) {
        this.tlfNum = tlfNum;
        this.address = address;
        this.postNum = postNum;
    }

    public Locations() {
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
