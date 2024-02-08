package bytebuddies.service;

import bytebuddies.entities.Post;
import bytebuddies.entities.User;
import bytebuddies.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PostService postService;

    public void register(String tlfNum, String firstName, String lastName, String address, short postNum) {
        Post post = postService.getPost(postNum);
        if (post == null) return;

        User user = new User(tlfNum, firstName, lastName, address, post);
        userRepo.save(user);
    }


}
