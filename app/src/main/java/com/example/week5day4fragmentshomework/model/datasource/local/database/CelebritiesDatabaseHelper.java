package com.example.week5day4fragmentshomework.model.datasource.local.database;

import com.example.week5day4fragmentshomework.model.celebrity.Celebrity;

import java.util.ArrayList;
import java.util.List;

public class CelebritiesDatabaseHelper {
    private List<Celebrity> celebrities;

    public CelebritiesDatabaseHelper() {
        celebrities = new ArrayList<>();
        populateCelebrities();
    }

    private void populateCelebrities() {
        celebrities.add(new Celebrity("Millie", "Brown", 15, "British", "Stranger Things", "https://i.imgur.com/twAFWwZ.jpg"));
        celebrities.add(new Celebrity("David", "Harbour", 44, "American", "Stranger Things", "https://i.imgur.com/P3CQwes.jpg"));
        celebrities.add(new Celebrity("Gaten", "Matarazzo", 16, "American", "Stranger Things", "https://i.imgur.com/w66oN0o.jpg"));
        celebrities.add(new Celebrity("Finn", "Wolfhard", 16, "Canadian", "Stranger Things", "https://i.imgur.com/22v9v5A.jpg"));
        celebrities.add(new Celebrity("Noah", "Schnapp", 14, "American", "Stranger Things", "https://i.imgur.com/vRI8St2.jpg"));
        celebrities.add(new Celebrity("Caleb", "McLaughlin", 17, "American", "Stranger Things", "https://i.imgur.com/ruQ0Q8D.jpg"));
        celebrities.add(new Celebrity("Joe", "Keery", 27, "American", "Stranger Things", "https://i.imgur.com/hJeA9fL.jpg"));
        celebrities.add(new Celebrity("Sadie", "Sink", 17, "American", "Stranger Things", "https://i.imgur.com/fzKt86Q.jpg"));

        celebrities.add(new Celebrity("Emilia", "Clarke", 32, "British", "Game of Thrones", "https://i.imgur.com/HynQP07.jpg"));
        celebrities.add(new Celebrity("Maisie", "Williams", 22, "British", "Game of Thrones", "https://i.imgur.com/w0hkvWT.jpg"));
        celebrities.add(new Celebrity("Sophie", "Turner", 23, "British", "Game of Thrones", "https://i.imgur.com/B7FMl10.jpg"));
        celebrities.add(new Celebrity("Kit", "Harington", 32, "British", "Game of Thrones", "https://i.imgur.com/IEfdxBD.jpg"));
        celebrities.add(new Celebrity("Peter", "Dinklage", 50, "American", "Game of Thrones", "https://i.imgur.com/uYaZLBC.jpg"));
    }

    public List<Celebrity> getCelebrities() {
        return celebrities;
    }
}
