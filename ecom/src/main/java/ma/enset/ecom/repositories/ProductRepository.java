package ma.enset.ecom.repositories;

import ma.enset.ecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, String> {

}
