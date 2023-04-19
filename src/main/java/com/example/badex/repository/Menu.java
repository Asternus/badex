package com.example.badex.repository;

import com.example.badex.entity.MenuItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Menu {

   private List<MenuItem> menuItems = new ArrayList<>();

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    {
        menuItems.add(new MenuItem("/badex_war_exploded/form", "Додати студента JSON"));
        menuItems.add(new MenuItem("/badex_war_exploded/", "Головна"));
        menuItems.add(new MenuItem("/badex_war_exploded/all-students", "Усі студенти"));
        menuItems.add(new MenuItem("/badex_war_exploded/categories", "Приклад джейсону"));
    }

}
