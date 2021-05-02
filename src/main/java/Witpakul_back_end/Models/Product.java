package Witpakul_back_end.Models;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter @Column(name = "product_code")
    private int product_code;
    @Getter @Setter @Column(name = "product_name")
    private String product_name;
    @Getter @Setter @Column(name = "product_description")
    private String product_description;
    @Getter @Setter @Column(name = "price")
    private float product_price;
    @Getter @Setter @Column(name = "manufactured_date")
    private LocalDate product_manufactured_date;
    @Getter @Setter @Column(name = "product_warranty")
    private int product_warranty;
    @Getter @Setter @Column(name = "product_images")
    private String product_images;
    @ManyToOne  @JoinColumn(name = "brand_id",nullable = false)
    @Getter @Setter private Brand product_brand;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Product_color" ,
            joinColumns = @JoinColumn(name = "product_code"),
            inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    @Getter @Setter private List<Color> product_colors;
    public Product(int product_code, String product_name, String product_description, float product_price, LocalDate product_manufactured_date,int product_warranty, Brand product_brand, List<Color> product_colors,String product_images) {
        this.product_code = product_code;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_manufactured_date = product_manufactured_date;
        this.product_warranty = product_warranty;
        this.product_brand = product_brand;
        this.product_colors = product_colors;
        this.product_images = product_images;
    }
    public Product(){

    }
}
