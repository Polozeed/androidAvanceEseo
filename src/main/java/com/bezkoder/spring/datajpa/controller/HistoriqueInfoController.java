package com.bezkoder.spring.datajpa.controller;



import com.bezkoder.spring.datajpa.model.Client;
import com.bezkoder.spring.datajpa.model.HistoriqueAPI;
import com.bezkoder.spring.datajpa.model.HistoriqueInfo;
import com.bezkoder.spring.datajpa.repository.HistoriqueApiRepository;
import com.bezkoder.spring.datajpa.repository.HistoriqueInfoRepository;
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
@RequestMapping("/historiqueInfo")
public class HistoriqueInfoController {

    // Autorise les service lié au controller
    @Autowired
    HistoriqueInfoRepository historiqueInfoRepository;

    final GsonBuilder builder = new GsonBuilder();
    final Gson gson = builder.create();




    //  Get ==> http://localhost:8083/client/liste
    @GetMapping("/liste")
    public ResponseEntity<String> getAllHistInfo() {
        List<HistoriqueInfo> historique = historiqueInfoRepository.findAll();
        return new ResponseEntity<>(gson.toJson(historique), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getHistWithId(@PathVariable("id") long  id) {
        List<HistoriqueInfo> historique = historiqueInfoRepository.findAllById(Collections.singleton(id));
        return new ResponseEntity<>(gson.toJson(historique), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteHistWithId(@PathVariable("id") long id) {
        try {
            historiqueInfoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteAllClient() {
        try {
            historiqueInfoRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<String> createHist(@RequestBody HistoriqueInfo historiqueInfo) {
        try {
            HistoriqueInfo historiqueInfo1 = historiqueInfoRepository
                    .save(new HistoriqueInfo(historiqueInfo.getId_client(), historiqueInfo.getDateheure(),historiqueInfo.getId_info()));
            return new ResponseEntity<>(gson.toJson(historiqueInfo1), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<HistoriqueInfo> updateHist(@PathVariable("id") long id, @RequestBody HistoriqueInfo historiqueInfo) {
        Optional<HistoriqueInfo> clientData = historiqueInfoRepository.findById(id);

        if (clientData.isPresent()) {
            HistoriqueInfo historiqueInfo1 = clientData.get();
            historiqueInfo1.setId_client(historiqueInfo.getId_client());
            historiqueInfo1.setDateheure(historiqueInfo.getDateheure());
            historiqueInfo1.setId_info(historiqueInfo.getId_info());
            return new ResponseEntity<>(historiqueInfoRepository.save(historiqueInfo1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
