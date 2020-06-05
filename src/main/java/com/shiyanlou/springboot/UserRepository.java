package com.shiyanlou.springboot;

import org.springframework.data.repository.CrudRepository;

/**
 * 继承 CrudRepository
 */
public interface UserRepository extends CrudRepository<User, Integer>{

}