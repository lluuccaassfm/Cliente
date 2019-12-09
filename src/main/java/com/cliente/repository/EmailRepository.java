package com.cliente.repository;

import com.cliente.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmailRepository extends JpaRepository<Email, Long> {

    @Query("SELECT e FROM Email e WHERE e.descricao = :descricao ")
    List<Email> findEmailByDescricao(@Param("descricao") String descricao);
}
