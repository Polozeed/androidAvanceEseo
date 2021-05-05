package com.bezkoder.spring.datajpa.controller;


import com.bezkoder.spring.datajpa.model.Client;
import com.bezkoder.spring.datajpa.model.HistoriqueAPI;
import com.bezkoder.spring.datajpa.repository.HistoriqueApiRepository;
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
@RequestMapping("/historiqueAPI")
public class HistoriqueAPIController {

    // Autorise les service lié au controller
    @Autowired
    HistoriqueApiRepository historiqueApiRepository;

    final GsonBuilder builder = new GsonBuilder();
    final Gson gson = builder.create();




    //  Get ==> http://localhost:8083/client/liste
    @GetMapping("/liste")
    public ResponseEntity<String> getAllHist() {
        List<HistoriqueAPI> historique = historiqueApiRepository.findAll();
        return new ResponseEntity<>(gson.toJson(historique), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getHisttWithId(@PathVariable("id") long  id) {
        List<HistoriqueAPI> historique = historiqueApiRepository.findAllById(Collections.singleton(id));
        return new ResponseEntity<>(gson.toJson(historique), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteHistWithId(@PathVariable("id") long id) {
        try {
            historiqueApiRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteAllClient() {
        try {
            historiqueApiRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<String> createHist(@RequestBody HistoriqueAPI historiqueAPI) {
        try {
            HistoriqueAPI historiqueAPI1 = historiqueApiRepository
                    .save(new HistoriqueAPI(historiqueAPI.getId_client(), historiqueAPI.getDateheure(),historiqueAPI.getId_info(),historiqueAPI.getType_comm()));
            System.out.println(historiqueAPI.toString());
            return new ResponseEntity<>(gson.toJson(historiqueAPI1), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<HistoriqueAPI> updateHist(@PathVariable("id") long id, @RequestBody HistoriqueAPI historiqueAPI) {
        Optional<HistoriqueAPI> clientData = historiqueApiRepository.findById(id);

        if (clientData.isPresent()) {
            HistoriqueAPI historiqueAPI1 = clientData.get();
            historiqueAPI1.setId_client(historiqueAPI.getId_client());
            historiqueAPI1.setDateheure(historiqueAPI.getDateheure());
            historiqueAPI1.setId_info(historiqueAPI.getId_info());
            historiqueAPI1.setType_comm(historiqueAPI.getType_comm());
            return new ResponseEntity<>(historiqueApiRepository.save(historiqueAPI1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
