package com.kamilisler.rest.websevices.restfullwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDaoService userService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable Integer id){
        User user = userService.findUser(id);
        if (user == null){
            throw new UserNotFoundException("id : "+id );
        }
        EntityModel<User> model = EntityModel.of(user);
        // bir response ile birlikte diğer userların gösterilebileceği linki göstermek için hardcoded yazmak yerine
        // hateoas frameworkü ve MvcLinkBuilder ile response'a link koymayı sağladık
        // bu uygulamyı kullanan kişilere tüm user'ları gösterecek linki gösterdik. resource'larımıza veri döndürdük yani
        WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        model.add(linkToUsers.withRel("all-users"));

        return model;
    }

    @PostMapping("/users")
    public void createUser(@Valid @RequestBody User user){
        User savedUser = userService.saveUser(user);
    }
    @PostMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        User savedUser = userService.deleteUser(id);
    }


}
