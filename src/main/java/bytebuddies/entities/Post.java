package bytebuddies.entities;

import jakarta.persistence.*;

@Entity
@Table(schema = "rentalcomp")
public class Post {
    @Id private Short postNum;
    private String postalPlace;

    public Post() {}

    public Post(Short postNum, String postalPlace) {
        this.postNum = postNum;
        this.postalPlace = postalPlace;
    }
}
