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

    @RequestMapping("/add")
    String addUserForm(@RequestParam(required = false) String imie,
                             @RequestParam(required = false, defaultValue = "nie wpisano danych") String nazwisko,
                             @RequestParam(required = false, defaultValue = "0") Integer wiek) {
        if (imie == null || imie.length() < 1) {
            return "redirect:/err.html";
        }
        addNewUser(imie, nazwisko, wiek);
        return "redirect:/success.html";

    }

    private void addNewUser(String imie, String nazwisko, Integer wiek) {
        userDataBase.addUserToTheList(new User(imie, nazwisko, wiek));
    }
}