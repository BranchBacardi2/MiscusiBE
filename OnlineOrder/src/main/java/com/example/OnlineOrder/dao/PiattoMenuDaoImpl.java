package com.example.OnlineOrder.dao;

import com.example.OnlineOrder.entity.PiattoMenu;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class PiattoMenuDaoImpl implements PiattoMenuDao{

    private EntityManager entityManager;
    @Autowired
    public PiattoMenuDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public List<PiattoMenu> saveAll(List<PiattoMenu> piattiMenu) {
        List<PiattoMenu> result =  new ArrayList<PiattoMenu>();
        for  (Iterator<PiattoMenu> it = piattiMenu.iterator(); it.hasNext();){
            PiattoMenu piattoMenu = it.next();
            PiattoMenu paittoMenu = entityManager.merge(piattoMenu);
            result.add(paittoMenu);
            entityManager.flush();
            entityManager.clear();
        }
        return  result;
    }

}





