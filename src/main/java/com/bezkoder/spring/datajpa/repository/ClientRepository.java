package com.bezkoder.spring.datajpa.repository;


import com.bezkoder.spring.datajpa.model.Client;
import com.bezkoder.spring.datajpa.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client>findAllByLogin(String login);
    Boolean findByLoginAndAndMdp(String login ,String mdp);



}
