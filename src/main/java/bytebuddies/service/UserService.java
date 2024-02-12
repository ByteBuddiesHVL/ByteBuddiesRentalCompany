package bytebuddies.service;

import bytebuddies.entities.Post;
import bytebuddies.entities.Users;
import bytebuddies.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public void register(String tlfNum, String firstName, String lastName, String address, Post postNum) {
        userRepo.save(new Users(tlfNum, firstName, lastName, address, postNum));
    }

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public Users getById(String tlfNum) {
        return userRepo.findById(tlfNum).orElse(null);
    }

}
