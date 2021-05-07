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


@CrossOrigin
@RestController
public class Product_Controller {
    @Autowired
    private Products_Repository Products_Repository;

    @GetMapping("/all")
    public List<Product> listAllProducts(){
        return Products_Repository.findAll();
    }
    @PostMapping("/add_product")
    public int addProduct(@RequestBody Product newProduct) {
        newProduct = Products_Repository.save(newProduct);
        newProduct.setProduct_image("/image/get/" + newProduct.getId() + "_" + newProduct.getProduct_image());
        newProduct = Products_Repository.save(newProduct);
        return newProduct.getProduct_code();
    }
}
