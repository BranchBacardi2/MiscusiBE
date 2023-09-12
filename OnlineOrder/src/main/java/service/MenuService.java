package service;

import dto.MenuCreateDTO;
import dto.MenuResponseDTO;

import java.awt.*;

public interface MenuService {
    MenuResponseDTO create(MenuCreateDTO menuInput);
    MenuCreateDTO update(MenuCreateDTO menuInput);

}
