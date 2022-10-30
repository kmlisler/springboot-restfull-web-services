package com.kamilisler.rest.websevices.restfullwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<Optional<User>> retrieveUser(@PathVariable Integer id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("id : "+id );
        }
        EntityModel<Optional<User>> model = EntityModel.of(user);
        // bir response ile birlikte diğer userların gösterilebileceği linki göstermek için hardcoded yazmak yerine
        // hateoas frameworkü ve MvcLinkBuilder ile response'a link koymayı sağladık
        // bu uygulamyı kullanan kişilere tüm user'ları gösterecek linki gösterdik. resource'larımıza veri döndürdük yani
        WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        model.add(linkToUsers.withRel("all-users"));

        return model;
    }

    @PostMapping("/users")
    public void createUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }


}
