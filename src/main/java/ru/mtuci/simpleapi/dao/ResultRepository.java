package ru.mtuci.simpleapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mtuci.simpleapi.model.Result;

import javax.transaction.Transactional;

//@Transactional(readOnly = true)
public interface ResultRepository extends JpaRepository<Result, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Result r WHERE r.id =:id")
    void delete(@Param("id") Long id);
}
