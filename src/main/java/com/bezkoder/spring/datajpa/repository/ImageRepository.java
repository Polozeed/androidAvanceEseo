package com.bezkoder.spring.datajpa.repository;


import com.bezkoder.spring.datajpa.model.DBFile;

import com.bezkoder.spring.datajpa.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImageRepository extends JpaRepository<DBFile,String>{

}
