package com.example.OnlineOrder.dao;

import com.example.OnlineOrder.entity.Menu;
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




}
