package ma.enset.ecom.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Data Trasfer Object ==> DTO
//n'est pas une entité JPA
@Data @NoArgsConstructor @AllArgsConstructor
public class ProductDTO {
    private String id;
    private String nom;
    private double prix;
    private double quantity;
    private CategoryDTO categoryDTO;
}
