package org.ceres.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class
 */
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Double cost;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @ManyToMany
    @JoinTable(name = "Categ")
    private List<Category> categories = new ArrayList<>();


    public Expense() {
    }

    public Expense(String title, String description, Double cost) {
        this.title = title;
        this.description = description;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        if (title != null ? !title.equals(expense.title) : expense.title != null) return false;
        if (description != null ? !description.equals(expense.description) : expense.description != null) return false;
        return cost != null ? cost.equals(expense.cost) : expense.cost == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }

    public void addCategory(Category category) {
        if(!categories.contains(category)){
            categories.add(category);
            category.addExpemse(this);
        }
    }

    public Expense addUser(User user) {
        if(user==null){
            throw new IllegalArgumentException("User cant be null, user = "+ user);
        }
        if(this.user ==null){
            this.user = user;
            return this;
        }

        if(!user.equals(this.user)){ // Todo should be it saved id db for creating id
            Expense expense = new Expense(title, description, cost);
            expense.setCategories(new ArrayList<>(categories));

        }
        return this;
    }
}
