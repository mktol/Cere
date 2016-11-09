package org.ceres.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test
 */
public class CategoryTest {
    private Category category;
    Expense expense;
    @Before
    public void init(){
        category = new Category();
        category.setName("clothes");

        expense = new Expense("mikd", "bla", 33.0);
    }
    @Test
    public void addExpenseTest() throws Exception {
        category.addExpemse(expense);
        assertEquals(1, category.getExpenses().size());
        assertEquals(1, expense.getCategories().size());
    }

}