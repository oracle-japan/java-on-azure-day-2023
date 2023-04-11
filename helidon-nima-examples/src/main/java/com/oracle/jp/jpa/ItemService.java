package com.oracle.jp.jpa;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ItemService {
    @PersistenceContext(unitName = "pu1")
    private EntityManager entityManager;

    public Item getItemById(int id) {
        var item = entityManager.find(Item.class, id);
        if (item == null) {
            throw new NotFoundException("Unable to find item with ID " + id);
        }
        return item;
    }

    public List<Item> getAllItem() {
        var items = entityManager.createNamedQuery("getAllItems", Item.class).getResultList();
        if (items == null) {
            throw new NotFoundException("Unable to find item");
        }
        return items;
    }
}
