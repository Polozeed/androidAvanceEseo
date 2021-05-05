package com.bezkoder.spring.datajpa.controller;


import com.bezkoder.spring.datajpa.dto.clientDto;
import com.bezkoder.spring.datajpa.model.Client;
import com.bezkoder.spring.datajpa.model.Tutorial;
import com.bezkoder.spring.datajpa.repository.ClientRepository;
import com.bezkoder.spring.datajpa.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/client")
public class ClientController {

    // Autorise les service lié au controller
    @Autowired
    ClientRepository clientRepository;

    final GsonBuilder builder = new GsonBuilder();
    final Gson gson = builder.create();




    //  Get ==> http://localhost:8083/client/liste
    @GetMapping("/liste")
    public ResponseEntity<String> getAllCLient() {
        List<Client> client = clientRepository.findAll();
        return new ResponseEntity<>(gson.toJson(client), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getClientWithId(@PathVariable("id") long  id) {
        List<Client> client = clientRepository.findAllById(Collections.singleton(id));
        return new ResponseEntity<>(gson.toJson(client), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteClientWithId(@PathVariable("id") long id) {
        try {
            clientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteAllClient() {
        try {
            clientRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<String> createClient(@RequestBody Client client) {
        try {
            Client client1 = clientRepository
                    .save(new Client(client.getLogin(), client.getMdp(),client.getToken()));
            System.out.println(client.toString());
            return new ResponseEntity<>(gson.toJson(client1), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") long id, @RequestBody Client client) {
        Optional<Client> clientData = clientRepository.findById(id);

        if (clientData.isPresent()) {
            Client client1 = clientData.get();
            client1.setLogin(client.getLogin());
            client1.setMdp(client.getMdp());
            client1.setToken(client.getToken());
            return new ResponseEntity<>(clientRepository.save(client1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
