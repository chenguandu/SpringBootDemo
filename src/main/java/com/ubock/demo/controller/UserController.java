package com.ubock.demo.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ubock.demo.model.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//@RequestMapping(value = "/users");
@RestController
public class UserController {

    static Map<Long, User> mUserList = Collections.synchronizedMap(new HashMap<Long, User>());

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> list = new ArrayList<>(mUserList.values());
        return list;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        mUserList.put(user.getId(), user);
        return user.toString();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable long id, @ModelAttribute User user){
        User u = mUserList.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        mUserList.put(id, u);
        return user.toString();
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
    public String delUser(@PathVariable long id){
        User user = mUserList.remove(id);
        return user.toString();
    }
}
