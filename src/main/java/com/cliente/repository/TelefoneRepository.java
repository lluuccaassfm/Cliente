package com.cliente.repository;

import com.cliente.domain.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
