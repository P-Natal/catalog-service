package com.natal.catalogservice.repository;

import com.natal.catalogservice.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
    @Query("select t from TypeEntity t where t.name = :typeName")
    TypeEntity findByName(@Param("typeName") String typeName);
}
