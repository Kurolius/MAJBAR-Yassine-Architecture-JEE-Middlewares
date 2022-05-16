package ma.enset.ecom.service;

import ma.enset.ecom.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO save(ProductDTO productDTO);
    List<ProductDTO> lisProducts();
    ProductDTO getProduct(String id);
    ProductDTO updateProduct(ProductDTO productDTO);
    void deleteProduct(String id);
}
