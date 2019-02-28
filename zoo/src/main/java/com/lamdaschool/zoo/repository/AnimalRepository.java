package com.lamdaschool.zoo.repository;

import com.lamdaschool.zoo.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface AnimalRepository extends JpaRepository<Animal, Long> {
    @Query(value = "SELECT * FROM animal WHERE animaltype = :name", nativeQuery = true)
    Animal findByName(@Param("name") String name);
}

