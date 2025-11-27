package com.yago.sistemaGerenciamentoTickets.repositories;

import com.yago.sistemaGerenciamentoTickets.entities.User;
import com.yago.sistemaGerenciamentoTickets.entities.UserResponseDTO;
import com.yago.sistemaGerenciamentoTickets.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    UserDetails findByMatricula(String matricula);
    List<User> findByRole(UserRole userRole);
}
