package bytebuddies.service;

import bytebuddies.entities.Post;
import bytebuddies.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepo;

    public Post getPost(String postNum) {
        return postRepo.findById(postNum).orElse(null);
    }

}
