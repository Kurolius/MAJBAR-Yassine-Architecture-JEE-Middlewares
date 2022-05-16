package ma.enset.ecom.repositories;

import ma.enset.ecom.entities.Category;
import ma.enset.ecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
