package bytebuddies.entities;

import jakarta.persistence.*;

@Entity
@Table(schema = "rentalcomp")
public class Post {
    @Id
    @Column(name = "post_num")
    private  String postNum;
    @Column(name = "postal_place")
    private String postalPlace;

    public Post() {}

    public Post(String postNum, String postalPlace) {
        this.postNum = postNum;
        this.postalPlace = postalPlace;
    }

    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum;
    }

    public String getPostalPlace() {
        return postalPlace;
    }

    public void setPostalPlace(String postalPlace) {
        this.postalPlace = postalPlace;
    }
}
