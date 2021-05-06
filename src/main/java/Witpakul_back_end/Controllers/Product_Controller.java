package Witpakul_back_end.Controllers;
import Witpakul_back_end.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import Witpakul_back_end.Repositories.Products_Repository;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class Product_Controller {
    @Autowired
    private Products_Repository Products_Repository;

    @GetMapping("/all")
    public List<Product> listAllProducts(){
        return Products_Repository.findAll();
    }
    @PostMapping("/add_product")
    public Product addProduct(@RequestBody Product newProduct) {
        System.out.println(newProduct);
        newProduct = Products_Repository.save(newProduct);
        return newProduct;
    }
}
