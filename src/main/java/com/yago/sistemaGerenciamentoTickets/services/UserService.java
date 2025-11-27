package com.yago.sistemaGerenciamentoTickets.services;

import com.yago.sistemaGerenciamentoTickets.entities.User;
import com.yago.sistemaGerenciamentoTickets.entities.UserResponseDTO;
import com.yago.sistemaGerenciamentoTickets.entities.UserRole;
import com.yago.sistemaGerenciamentoTickets.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<UserResponseDTO> retornarAnalistas(){

        return this.userRepository.findByRole(UserRole.ANALISTA).stream().map(UserResponseDTO::new).toList();

    }

    public List<UserResponseDTO> retornarTodos(){
        List<UserResponseDTO> lista = this.userRepository.findAll().stream().map(UserResponseDTO::new).toList();

        return lista;
    }
}
