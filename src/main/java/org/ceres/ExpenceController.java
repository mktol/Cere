package org.ceres;

import org.ceres.entity.Expense;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class
 */
@RestController
public class ExpenceController {

    @RequestMapping("/expense")
    public Expense getExpense(){
        return new Expense("food", "descrption of food", 33.03);
    }
}
