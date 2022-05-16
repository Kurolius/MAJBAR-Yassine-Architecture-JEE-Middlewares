package ma.enset.ecom.web;

import ma.enset.ecom.dtos.ProductDTO;
import ma.enset.ecom.entities.Product;
import ma.enset.ecom.repositories.ProductRepository;
import ma.enset.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductRestController {
    @Autowired
    private ProductService productService;

    /**
     * Restful API 5 regles
     * 1 les URI
     * 2 les methodes http comme identifiant des operations (GET/PUT/POST/PUT/DELETE/PATCH)
     * PATCH ==> modifier que les shamps mentionnés
    * */
    @GetMapping("/products")
    public List<ProductDTO> productList(){
        return productService.lisProducts();
    }

    /**
     *
    * */
    @GetMapping("/products/{id}")
    public  ProductDTO getProduct(@PathVariable(name="id") String id){
        return productService.getProduct(id);
    }


    @PostMapping("/products")
    public  ProductDTO saveProduct(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }

    @PutMapping("/products/{id}")
    public  ProductDTO updateProduct(@RequestBody ProductDTO productDTO,@PathVariable String id){
        productDTO.setId(id);
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable String id){
         productService.deleteProduct(id);
    }
}
