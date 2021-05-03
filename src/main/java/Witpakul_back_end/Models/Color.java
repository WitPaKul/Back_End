package Witpakul_back_end.Models;
import lombok.Getter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Color {
    @Id
    @Getter @Column(name = "color_id")
    private int color_id;
    @Getter @Column(name = "color_name")
    private String color_name;
    public String toString() {
        return "color_id: " + color_id + "\n" +
                "color_name: " + color_name;
    }
}
