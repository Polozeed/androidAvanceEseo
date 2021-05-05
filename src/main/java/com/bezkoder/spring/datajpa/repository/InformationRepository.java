package com.bezkoder.spring.datajpa.repository;


import com.bezkoder.spring.datajpa.model.Client;
import com.bezkoder.spring.datajpa.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information, Long> {



}
