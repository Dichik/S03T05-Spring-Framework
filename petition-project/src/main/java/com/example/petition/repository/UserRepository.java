package com.example.petition.repository;

import com.example.petition.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    List<UserEntity> findByEmail(String email);

    @Query("SELECT u FROM users u WHERE u.first_name=?1 AND u.second_name=?2")
    List<UserEntity> findByFirstNameAndSecondName(String firstName, String secondName);

}
