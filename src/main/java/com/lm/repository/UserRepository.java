package com.lm.repository;

import com.lm.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Louie on 2017-03-16.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
