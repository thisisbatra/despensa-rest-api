package dev.nmarulo.depensaapp.app.products;

import dev.nmarulo.depensaapp.app.products.classes.FindAllProductRes;
import dev.nmarulo.depensaapp.app.products.classes.SaveShoppingListProductReq;
import dev.nmarulo.depensaapp.app.products.classes.SaveShoppingListProductRes;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Getter
public class ProductController {
    
    private final ProductService service;
    
    @GetMapping
    public ResponseEntity<FindAllProductRes> findAll(@RequestParam(value = "exclude_shopping_list_id",
                                                                   required = false) Integer excludeShoppingListId) {
        return ResponseEntity.ok(this.service.findAll(excludeShoppingListId));
    }
    
    @PostMapping("/shopping-list")
    public ResponseEntity<SaveShoppingListProductRes> saveShoppingList(@RequestBody SaveShoppingListProductReq request) {
        return ResponseEntity.ok(this.service.saveShoppingList(request));
    }
    
}
