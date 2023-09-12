package dao;

import com.example.OnlineOrder.entity.Menu;
import com.example.OnlineOrder.entity.Ordine;
import com.example.OnlineOrder.entity.PiattoMenu;

public interface MenuDao  {

    void save(Menu menu);
    Menu findById(Integer id);

    public void update(Menu menu);

}
