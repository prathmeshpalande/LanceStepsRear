package com.lance.rear.stepcounter.repository;

import com.lance.rear.stepcounter.model.StepsDateModel;
import com.lance.rear.stepcounter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query(value = "insert into User (uniqueCode, name, sessionKey) values (:uniqueCode, :name, :sessionKey)", nativeQuery = true)
    void signUp(@Param("uniqueCode") Integer uniqueCode, @Param("name") String name, @Param("sessionKey") String sessionKey);

    @Query(value = "select new com.lance.rear.stepcounter.model.User(uniqueCode, name, sessionKey) from User where uniqueCode = :uniqueCode")
    User checkIfUserExists(@Param("uniqueCode") Integer uniqueCode);

    @Modifying
    @Transactional
    @Query(value = "insert into StepHistory (stepId, uniqueCode, steps, timeInMillis) values (NULL, :uniqueCode, :steps, :timeInMillis)", nativeQuery = true)
    int noteSteps(@Param("uniqueCode") Integer uniqueCode, @Param("steps") Integer steps, @Param("timeInMillis") Long timeInMillis);

    @Query(value = "select new com.lance.rear.stepcounter.model.StepsDateModel(steps, timeInMillis) from StepHistory where uniqueCode = :uniqueCode")
    List<StepsDateModel> getStepHistory(@Param("uniqueCode") Integer uniqueCode);

}
