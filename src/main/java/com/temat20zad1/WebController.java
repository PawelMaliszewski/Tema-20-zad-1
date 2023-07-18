package com.temat20zad1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    private final UserDataBase userDataBase;

    public WebController(UserDataBase userDataBase) {
        this.userDataBase = userDataBase;
    }

    @GetMapping("/users")
    @ResponseBody
    public String getUsers() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < userDataBase.getUserList().size(); i++) {
            result.append(userDataBase.getUserList().get(i).toString()).append("</br>");
        }
        return result.toString();
    }

    @GetMapping("/add")
    public String addUser(@RequestParam(required = false) String imie,
                                @RequestParam(required = false) String nazwisko,
                                @RequestParam(required = false) Integer wiek) {
        if (imie == null) {
            return "err.html";
        }
        addNewUser(imie, nazwisko, wiek);
        return "success.html";
    }

    @PostMapping("/addUserForm")
    String addUserForm(@RequestParam(required = false) String imie,
                             @RequestParam(required = false, defaultValue = "nie podano") String nazwisko,
                             @RequestParam(required = false, defaultValue = "0") Integer wiek) {
        if (imie.length() < 1) {
            return "redirect:/err.html";
        }
        addNewUser(imie, nazwisko, wiek);
        return "redirect:/success.html";
    }

    private void addNewUser(String imie, String nazwisko, Integer wiek) {
        userDataBase.addUserToTheList(new User(imie, nazwisko, wiek));
    }
}