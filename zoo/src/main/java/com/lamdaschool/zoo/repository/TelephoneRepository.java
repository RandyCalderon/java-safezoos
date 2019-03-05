package com.lamdaschool.zoo.repository;

import com.lamdaschool.zoo.model.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelephoneRepository extends JpaRepository<Telephone, Long> {
}
