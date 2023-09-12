package rest;

import com.example.OnlineOrder.entity.Menu;
import dto.MenuCreateDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuRest {

    @PostMapping("/menu")
    Menu newMenu(@RequestBody MenuCreateDTO newMenu) {
        return MenuService.create(newMenu);
    }


    @PutMapping("/menu/{id}")
    Menu UpdateMenu(@RequestBody MenuCreateDTO updateMenu, @PathVariable int id){
        return MenuService.update(updateMenu);
    }
}
