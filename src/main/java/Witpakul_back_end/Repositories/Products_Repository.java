package Witpakul_back_end.Repositories;
import Witpakul_back_end.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface Products_Repository extends JpaRepository <Product ,Integer> {
}
