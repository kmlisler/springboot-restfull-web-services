package com.kamilisler.rest.websevices.restfullwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Component
public class UserDaoService {
    private static  List<User> users = new ArrayList<>();
    private static int usersCount = 3;
    static {
        users.add(new User(1,"Kamil İşler",new Date()));
        users.add(new User(2,"Ahmet İşler",new Date()));
        users.add(new User(3,"Ali Veli",new Date()));
    }
    public List<User> findAll(){
        return users;
    }
    public User saveUser(User user){
        if (user.getId() == null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }
    public User findUser(Integer id){

        for(User user: users) {
            if (Objects.equals(user.getId(), id)){
               return user;
            }
        }
        return null;
    }
    public User deleteUser(Integer id){

        for (int i= 0; i<users.size();i++){
            if (Objects.equals(users.get(i).getId(), id)){
                User removedUser = users.get(i);
                users.remove(removedUser);
                return removedUser;
            }
        }
        return null;
    }
}
