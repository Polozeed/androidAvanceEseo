package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.HistoriqueAPI;
import com.bezkoder.spring.datajpa.model.HistoriqueInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HistoriqueInfoRepository extends JpaRepository<HistoriqueInfo, Long> {

}