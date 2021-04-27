package Witpakul_back_end.Controllers;
import Witpakul_back_end.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import Witpakul_back_end.Repositories.Products_Repository;
import java.util.List;
@RestController
public class Product_Controller {
    @Autowired
    private Products_Repository Products_Repository;

    @GetMapping("/all")
    public List<Product> listAllProducts(){
        return Products_Repository.findAll();
    }
}
