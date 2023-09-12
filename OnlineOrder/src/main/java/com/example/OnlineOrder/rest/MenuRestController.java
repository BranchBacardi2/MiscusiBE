package com.example.OnlineOrder.rest;

import com.example.OnlineOrder.dto.MenuUpdateDTO;
import com.example.OnlineOrder.entity.Menu;
import com.example.OnlineOrder.dto.MenuCreateDTO;
import com.example.OnlineOrder.dto.MenuResponseDTO;
import org.springframework.web.bind.annotation.*;
import com.example.OnlineOrder.service.MenuServiceImpl;

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
    MenuResponseDTO UpdateMenu(@RequestBody MenuUpdateDTO updateMenu ){
        return menuService.update(updateMenu);
    }
}
