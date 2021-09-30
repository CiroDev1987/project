package resouces;

import entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@RestController /*Para reconhecer que é um recurso*/
@RequestMapping(value = "/categories") /*define o caminho*/
public class CategoryResorces {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = categoryRepository.findAll();
        list.add(new Category(1L, "Eletronics"));
        list.add(new Category(2L, "books"));
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category > findById(@PathVariable Long id) {
        Category category = categoryRepository.findById(id);
        return ResponseEntity.ok().body(category);
    }
}
