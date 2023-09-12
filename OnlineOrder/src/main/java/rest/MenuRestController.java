package rest;

import com.example.OnlineOrder.entity.Menu;
import dto.MenuCreateDTO;
import dto.MenuResponseDTO;
import org.springframework.web.bind.annotation.*;
import rest.castomExeption.NotFIndExeption;
import service.MenuServiceImpl;

@RestController
public class MenuRestController {

      private MenuServiceImpl menuService;

    public MenuRestController(MenuServiceImpl menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/menu")
    MenuResponseDTO createMenu(@RequestBody MenuCreateDTO newMenu) {
        return menuService.create(newMenu);
    }


    @PutMapping("/menu")
    Menu UpdateMenu(@RequestBody MenuCreateDTO updateMenu, @PathVariable int id){
        return null;
    }
}
