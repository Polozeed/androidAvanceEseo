package com.bezkoder.spring.datajpa.controller;

import com.bezkoder.spring.datajpa.model.Information;
import com.bezkoder.spring.datajpa.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/information")
public class InformationController {


    // Autorise les service lié au controller
    @Autowired
    InformationRepository informationRepository;

    final GsonBuilder builder = new GsonBuilder();
    final Gson gson = builder.create();


    @GetMapping("/liste")
    public ResponseEntity<String> getAllInfos() {
        List<Information> info = informationRepository.findAll();
        return new ResponseEntity<>(gson.toJson(info), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<String> getInfoWithId(@PathVariable("id") long  id) {
        List<Information> info = informationRepository.findAllById(Collections.singleton(id));
        return new ResponseEntity<>(gson.toJson(info), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteInfoWithId(@PathVariable("id") long id) {
        try {
            informationRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteAllInfos() {
        try {
            informationRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<String> createInfo(@RequestBody Information information) {
        try {
            Information information1 = informationRepository
                    .save(new Information(information.getLuminosite(), information.getNiv_batt(),information.getPression(),
                            information.getTemperature(),information.getLatitude(),information.getLongitude()));
            System.out.println(information.toString());
            return new ResponseEntity<>(gson.toJson(information1), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Information> updateInfo(@PathVariable("id") long id, @RequestBody Information information) {
        Optional<Information> infoData = informationRepository.findById(id);

        if (infoData.isPresent()) {
            Information information1 = infoData.get();
            information1.setLuminosite(information.getLuminosite());
            information1.setNiv_batt(information.getNiv_batt());
            information1.setPression(information.getPression());
            information1.setTemperature(information.getTemperature());
            information1.setLatitude(information.getLatitude());
            information1.setLongitude(information.getLongitude());
            return new ResponseEntity<>(informationRepository.save(information1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
