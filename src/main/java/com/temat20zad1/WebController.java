package com.temat20zad1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class WebController {

    private final UserDataBase userDataBase;

    public WebController(UserDataBase userDataBase) {
        this.userDataBase = userDataBase;
    }

    @GetMapping("/users")
    @ResponseBody
    public String getUsers() {
        return userDataBase.getUserList().toString();
    }

    @GetMapping("/add")
    @PostMapping("addUserForm")
    @ResponseBody
    public RedirectView addUser(@RequestParam(required = false) String imie,
                                @RequestParam(required = false) String nazwisko,
                                @RequestParam(required = false) Integer wiek) {
        if (imie == null) {
            return new RedirectView("err.html");
        }
        addNewUser(imie, nazwisko, wiek);
        return new RedirectView("success.html");
    }

    @PostMapping("/addUserForm")
    @ResponseBody
    RedirectView addUserForm(@RequestParam(required = false) String imie,
                             @RequestParam(required = false, defaultValue = "nie podano") String nazwisko,
                             @RequestParam(required = false, defaultValue = "0") Integer wiek) {
        if (imie.length() < 1) {
            System.out.println("redirect:/err.html");
            return new RedirectView("err.html");
        }
        addNewUser(imie, nazwisko, wiek);
        System.out.println("redirect:/success.html");
        return new RedirectView("success.html");
    }

    private void addNewUser(String imie, String nazwisko, Integer wiek) {
        userDataBase.addUserToTheList(new User(imie, nazwisko, wiek));
    }
}