package com.example.OnlineOrder.service;

import com.example.OnlineOrder.dto.MenuCreateDTO;
import com.example.OnlineOrder.dto.MenuResponseDTO;
import com.example.OnlineOrder.dto.MenuUpdateDTO;

public interface MenuService {
    MenuResponseDTO create(MenuCreateDTO menuInput);
    MenuResponseDTO update(MenuUpdateDTO menuInput);

}
