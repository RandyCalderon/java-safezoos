package com.lamdaschool.zoo.repository;

import com.lamdaschool.zoo.model.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZooRepository extends JpaRepository<Zoo, Long> {
}
