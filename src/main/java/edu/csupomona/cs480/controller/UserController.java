package edu.csupomona.cs480.controller;

import edu.csupomona.cs480.data.entity.User;
import edu.csupomona.cs480.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //Create
    @RequestMapping("user/new")
    public String newProduct(Model model) {
        model.addAttribute("user", new User());
        return "userform";
    }

    //Create & Update
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/user/" + user.getId();
    }

    //Read
    @RequestMapping("user/{id}")
    public String showUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "usershow";
    }

    //List all
    @RequestMapping(value = "/users")
    public String list(Model model){
        model.addAttribute("users", userService.listAllUsers());
        return "users";
    }

    //Update
    @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userform";
    }

    //Delete
    @RequestMapping("user/delete/{id}")
    public String delete(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }


}
