package org.ceres.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String name;
    @ManyToMany(mappedBy = "categories")
    List<Expense> expenses = new ArrayList<>();

    public Expense addExpemse(Expense expense){
        if(!expenses.contains(expense)){
            expenses.add(expense);
            expense.addCategory(this);
        }
        return expense;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
