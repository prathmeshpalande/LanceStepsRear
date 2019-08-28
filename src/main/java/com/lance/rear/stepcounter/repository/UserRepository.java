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
    @Query(value = "insert into User (uniqueCode, name, signInCount) values (:uniqueCode, :name, :signInCount)", nativeQuery = true)
    void signUp(@Param("uniqueCode") Integer uniqueCode, @Param("name") String name, @Param("signInCount") Integer signInCount);

    @Query(value = "select new com.lance.rear.stepcounter.model.User(uniqueCode, name, signInCount) from User where uniqueCode = :uniqueCode")
    User checkIfUserExists(@Param("uniqueCode") Integer uniqueCode);

    @Query(value = "select signInCount from User where uniqueCode = :uniqueCode")
    Integer getSignInCount(@Param("uniqueCode") Integer uniqueCode);

    @Modifying
    @Transactional
    @Query(value = "update User set signInCount = :signInCount where uniqueCode = :uniqueCode", nativeQuery = true)
    void updateSignInCount(@Param("uniqueCode") Integer uniqueCode, @Param("signInCount") Integer signInCount);

    @Modifying
    @Transactional
    @Query(value = "insert into StepHistory (stepId, uniqueCode, steps, timeInMillis) values (NULL, :uniqueCode, :steps, :timeInMillis)", nativeQuery = true)
    void noteSteps(@Param("uniqueCode") Integer uniqueCode, @Param("steps") Integer steps, @Param("timeInMillis") Long timeInMillis);

    @Query(value = "select timeInMillis from StepHistory where uniqueCode = :uniqueCode and timeInMillis = :timeInMillis")
    Long areStepsAlreadyNoted(@Param("uniqueCode") Integer uniqueCode, @Param("timeInMillis") Long timeInMillis);

    @Query(value = "select new com.lance.rear.stepcounter.model.StepsDateModel(steps, timeInMillis) from StepHistory where uniqueCode = :uniqueCode")
    List<StepsDateModel> getStepHistory(@Param("uniqueCode") Integer uniqueCode);

}
