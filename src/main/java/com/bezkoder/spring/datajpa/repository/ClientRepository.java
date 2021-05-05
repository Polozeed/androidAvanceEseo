package com.bezkoder.spring.datajpa.repository;


import com.bezkoder.spring.datajpa.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {



}
