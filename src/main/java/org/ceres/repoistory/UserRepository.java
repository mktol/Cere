package org.ceres.repoistory;

import org.ceres.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * This class
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
