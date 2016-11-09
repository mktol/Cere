package org.ceres.repoistory;

import org.ceres.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * This class
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
