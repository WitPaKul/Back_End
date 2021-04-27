package Witpakul_back_end.Controllers;

import Witpakul_back_end.Repositories.Brands_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import Witpakul_back_end.Models.Brand;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class Brand_Controller {
    @Autowired
    private Brands_Repository Brands_Repository;

    @GetMapping("/api/brand")
    public List<Brand> listAllBrands(){
        return Brands_Repository.findAll();
    }
}
