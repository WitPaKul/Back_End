package Witpakul_back_end.Models;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
public class Product {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter @Column(name = "product_code")
    private String product_code;
    @Getter @Setter @Column(name = "product_name")
    private String product_name;
    @Getter @Setter @Column(name = "product_description")
    private String product_description;
    @Getter @Setter @Column(name = "price")
    private float product_price;
    @Getter @Setter @Column(name = "manufactured_date")
    private LocalDate product_manufactured_date;
    @ManyToOne  @JoinColumn(name = "brand_id",nullable = false)
    @Getter @Setter private Brand product_brand;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_color" ,
            joinColumns = @JoinColumn(name = "product_code"),
            inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    @Getter @Setter private List<Color> product_colors;
    public Product(String product_code, String product_name, String product_description, float product_price, LocalDate product_manufactured_date, Brand product_brand, List<Color> product_colors) {
        this.product_code = product_code;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_manufactured_date = product_manufactured_date;
        this.product_brand = product_brand;
        this.product_colors = product_colors;
    }
    public Product(){

    }
}
