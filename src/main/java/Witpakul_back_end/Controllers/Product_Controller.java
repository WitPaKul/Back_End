package Witpakul_back_end.Controllers;
import Witpakul_back_end.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import Witpakul_back_end.Repositories.Products_Repository;
import Witpakul_back_end.Repositories.Products_Repository;
import org.springframework.web.client.HttpServerErrorException;

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
    @DeleteMapping("/delete_product/{id}")
    private String deleteProduct(@PathVariable("id") int id) {
        Products_Repository.deleteById(id);
        return "Deleted";
    }
}
