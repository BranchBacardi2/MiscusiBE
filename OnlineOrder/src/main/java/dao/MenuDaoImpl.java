package dao;

import com.example.OnlineOrder.entity.Menu;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDaoImpl implements  MenuDao{
    private EntityManager entityManager;
    @Autowired
    public MenuDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Menu menu) {
        entityManager.persist(menu);
    }

    @Override
    public Menu findById(Integer id) {
        return null;
    }

    @Override
    public void update(Menu menu) {
        entityManager.merge(menu);
    }


}
