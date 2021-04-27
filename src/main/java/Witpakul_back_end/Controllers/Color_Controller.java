package Witpakul_back_end.Controllers;
import Witpakul_back_end.Repositories.Colors_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import Witpakul_back_end.Models.Color;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class Color_Controller {
    @Autowired
    private Colors_Repository Colors_Repository;

    @GetMapping("/api/color")
    public List<Color> listAllColors(){
        return Colors_Repository.findAll();
    }
}
