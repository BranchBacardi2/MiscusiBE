package com.example.OnlineOrder.dao;

import com.example.OnlineOrder.entity.Menu;
import com.example.OnlineOrder.entity.Piatti;
import com.example.OnlineOrder.rest.castomExeption.NotFIndExeption;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
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
    @Transactional
    public Menu save(Menu menu) {
       return entityManager.merge(menu);
    }

    @Override
    public Menu findById(int menuId) {
        Menu result;
        try {
            result = entityManager.createQuery("SELECT u from Menu u WHERE u.id = :id", Menu.class).
                    setParameter("id", menuId).getSingleResult();
        } catch (Exception e) {
            throw new NotFIndExeption("Menu","" +menuId );
        }
        return result;
    }


}
