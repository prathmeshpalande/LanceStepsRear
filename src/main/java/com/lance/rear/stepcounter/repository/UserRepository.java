package com.lance.rear.stepcounter.repository;

import com.lance.rear.stepcounter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query(value = "insert into User values (:uniqueCode, :name, :steps)", nativeQuery = true)
    void signUp(@Param("uniqueCode") Integer uniqueCode, @Param("name") String name, @Param("steps") Integer steps);
}
