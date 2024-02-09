package tech.techharbor.Web;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.techharbor.Model.UserTableModel;
import tech.techharbor.Service.UserService;


import java.util.regex.Pattern;

@Controller
public class SingInRegisterController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public SingInRegisterController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registerUser() {

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name,
                               @RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String phoneNumber,
                               @RequestParam String password,
                               @RequestParam String confirmPassword) {

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Check if email is valid
        if (!Pattern.matches(emailRegex, email))
            throw new IllegalArgumentException("Invalid email address");


        if(password.equals(confirmPassword))
            this.userService.create(name,username,email,passwordEncoder.encode(password),phoneNumber);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginUser(){

        return "signIn";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password,
                            HttpSession session) {

        UserTableModel user = this.userService.findByUsername(username);
        if (user == null)
            throw new IllegalArgumentException("Invalid username");

        if(passwordEncoder.matches(password,user.getPassword())) {
            session.setAttribute("user",user);

            return "redirect:/";
        }


        return "redirect:/login";
    }


    @GetMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }



}
