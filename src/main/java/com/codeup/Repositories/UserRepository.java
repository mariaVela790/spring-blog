package com.codeup.Repositories;

import com.codeup.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long > {
}
