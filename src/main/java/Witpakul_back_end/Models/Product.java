package Witpakul_back_end.Models;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "product_code")
    private int product_code;
    public int getId() {
        return product_code;
    }
    @Getter @Setter @Column(name = "product_name")
    private String product_name;
    @Getter @Setter @Column(name = "product_description")
    private String product_description;
    @Getter @Setter @Column(name = "price")
    private float product_price;
    @Getter @Setter @Column(name = "manufactured_date")
    private LocalDate product_manufactured_date;
    @Getter @Setter @Column(name = "product_image")
    private String product_image;
    @ManyToOne  @JoinColumn(name = "brand_id",nullable = false)
    @Getter @Setter private Brand product_brand;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Product_color" ,
            joinColumns = @JoinColumn(name = "product_code", referencedColumnName = "product_code"),
            inverseJoinColumns = @JoinColumn(name = "color_id", referencedColumnName = "color_id")
    )
    @Getter @Setter private Set<Color> product_colors;
    public Product(int product_code, String product_name, String product_description, float product_price, LocalDate product_manufactured_date, Brand product_brand, Set<Color> product_colors,String product_image) {
        this.product_code = product_code;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_manufactured_date = product_manufactured_date;
        this.product_brand = product_brand;
        this.product_colors = product_colors;
        this.product_image = product_image;
    }
    public Product(){

    }
    public String toString() {
        return "product_code: " + product_code + "\n" +
                "product_name: " + product_name + "\n" +
                "product_description: " + product_description + "\n" +
                "product_price: " + product_price + "\n" +
                "product_manufactured_date: " + product_manufactured_date + "\n" +
                "product_brand: " + product_brand + "\n" +
                "product_colors: " + product_colors + "\n" +
                "product_image: " + product_image + "\n";
    }
}
