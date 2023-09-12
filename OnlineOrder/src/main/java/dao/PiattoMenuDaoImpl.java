package dao;

import com.example.OnlineOrder.entity.Ordine;
import com.example.OnlineOrder.entity.PiattoMenu;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PiattoMenuDaoImpl implements PiattoMenuDao{

    private EntityManager entityManager;
    @Autowired
    public PiattoMenuDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(PiattoMenu paittoMenu) {
        entityManager.persist(paittoMenu);
    }

    @Override
    public void update(PiattoMenu piattoMenu) {
        entityManager.merge(piattoMenu);
    }


}
