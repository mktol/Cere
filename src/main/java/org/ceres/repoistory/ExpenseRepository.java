package org.ceres.repoistory;

import org.ceres.entity.Expense;
import org.springframework.data.repository.CrudRepository;

/**
 * This class
 */
public interface ExpenseRepository extends CrudRepository<Expense, Long> {

}
