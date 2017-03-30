package com.anselmopfeifer.repository;

import com.anselmopfeifer.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by anselmo on 02/01/17.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
