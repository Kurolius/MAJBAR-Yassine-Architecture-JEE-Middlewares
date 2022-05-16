# Activité pratique N°10
## (Rest API Data Transfer Object))
### Introduction
Dans ce chapitre on a vu le  concepte de Rest API avec le Data Transfer Object.
### La structure du projet :
![image](https://user-images.githubusercontent.com/84138772/168617729-de00eb56-909e-451b-8a03-26a56563529c.png)
### entités
#### Product
```java=10
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String id;
    private String nom;
    private double prix;
    private double quantity;
    private CategoryDTO categoryDTO;
}
```
#### Category
```java=10
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
}
```
### DTOS
#### ProductDTO
```java=10
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String id;
    private String nom;
    private double prix;
    private double quantity;
    private CategoryDTO categoryDTO;
}
```
#### CategoryDTO
```java=10
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
}
```
### MAPPERS
#### CatalogMappers
```java=10
@Service
public class CatalogMappers {
    public ProductDTO fromProduct(Product product){
        ProductDTO productDTO = new ProductDTO();
        //BeanUtils.copyProperties(a,b) : si les objets ont les memes propriétés il fait le transfert (get/set)
        //des copies de a à b
        BeanUtils.copyProperties(product,productDTO);
        productDTO.setCategoryDTO(fromCategory(product.getCategory()));
        return productDTO;
    }
    public Product fromProdcutDTO(ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        product.setCategory((fromCategoryDTO(productDTO.getCategoryDTO())));
        return product;
    }

    public CategoryDTO fromCategory(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        BeanUtils.copyProperties(category,categoryDTO);
        return categoryDTO;
    }

    public Category fromCategoryDTO(CategoryDTO categoryDTO){
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        return category;
    }
}
```
### Repositories 
#### CategoryRepository
```java=10
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
```
#### ProductRepository
```java=10
public interface ProductRepository extends JpaRepository<Product, String> {

}
```
### service
#### ProductService
```java=10
public interface ProductService {
    ProductDTO save(ProductDTO productDTO);
    List<ProductDTO> lisProducts();
    ProductDTO getProduct(String id);
    ProductDTO updateProduct(ProductDTO productDTO);
    void deleteProduct(String id);
}
```
#### ProductServiceImpl
```java=10
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CatalogMappers catalogMappers;

    @Override
    public ProductDTO save(ProductDTO productDTO){
      Product product = catalogMappers.fromProdcutDTO(productDTO);
      product.setId(UUID.randomUUID().toString());
      Product savedProduct = productRepository.save(product);
      return catalogMappers.fromProduct(savedProduct);
    }

    @Override
    public List<ProductDTO> lisProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS =
                products.stream().map(p->catalogMappers.fromProduct(p))
                        .collect(Collectors.toList());
        return productDTOS;
    }

    @Override
    public ProductDTO getProduct(String id) {
        Product product = productRepository.findById(id).
                orElseThrow(()->new RuntimeException("Product not found"));
        return catalogMappers.fromProduct(product);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product = catalogMappers.fromProdcutDTO(productDTO);
        Product savedProduct = productRepository.save(product);
        return catalogMappers.fromProduct(savedProduct);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
```
### Routes
```java=10
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
```
### Resultat :
![image](https://user-images.githubusercontent.com/84138772/168620819-21314784-4795-4034-a092-a23e80693196.png)
