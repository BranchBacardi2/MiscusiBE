package com.example.OnlineOrder.dao;

import com.example.OnlineOrder.entity.Menu;

public interface MenuDao  {

    Menu save(Menu menu);

    Menu  findById(int menuId);


}
