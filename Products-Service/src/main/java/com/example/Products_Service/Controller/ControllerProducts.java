package com.example.Products_Service.Controller;

import com.example.Products_Service.Model.Products;
import com.example.Products_Service.Service.ServiceProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ControllerProducts {

    @Autowired
    ServiceProducts serviproduct;

     @GetMapping("/getallproducts")
    public List<Products> GetAllProducts(){

        return serviproduct.GetallProducts();
     }

     @PostMapping("/SaveProducts")
    public String SaveProducts(@RequestBody Products produ){
         serviproduct.saveProducts(produ);
         return "The Product has been saved successfully";
     }

     @DeleteMapping("/DeleteProduct/{code}")
    public String DeleteProduct(@PathVariable Long code){
         serviproduct.deleteProducts(code);
         return "The product has been deleted successfully";
     }

     @GetMapping("/FindProduct/{code}")
    public Products FindProductById(@PathVariable Long code){
        return serviproduct.findProduct(code);
     }

     @GetMapping("/getproductsbyid/{id_shoppingCart}")
    public List<Products> getproductsbyid (@PathVariable Long id_shoppingCart){
         return serviproduct.getProductsByIdShoppingCart(id_shoppingCart);

     }
}
