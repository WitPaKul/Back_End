package Witpakul_back_end.Models;
import lombok.Getter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Brand {
    @Id
    @Getter @Column(name = "brand_id")
    private int brand_id;
    @Getter @Column(name = "brand_name")
    private String brand_name;
    public String toString() {
        return "brand_id: " + brand_id + "\n" +
                "brand_name: " + brand_name;
    }
}
