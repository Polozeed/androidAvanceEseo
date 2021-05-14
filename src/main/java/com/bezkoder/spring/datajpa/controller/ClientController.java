package com.bezkoder.spring.datajpa.controller;


import com.bezkoder.spring.datajpa.dto.clientDto;
import com.bezkoder.spring.datajpa.model.Client;
import com.bezkoder.spring.datajpa.repository.ClientRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;



import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@RestController
@CrossOrigin
@RequestMapping("/client")
public class ClientController {

    // Autorise les service lié au controller
    @Autowired
    ClientRepository clientRepository;

    final GsonBuilder builder = new GsonBuilder();
    final Gson gson = builder.create();


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
            System.out.println("Delete Client :" + id);
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
            return new ResponseEntity<>(clientRepository.save(client1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*@PostMapping("/c")
    public ResponseEntity<String> connexion(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        try {
            Client clientconnexion = clientRepository.findByLogin(username);
            System.out.println(gson.toJson(clientconnexion));
            System.out.println(gson.toJson("666666666666666666666666666666666666"));
            System.out.println(gson.toJson(username));
            System.out.println(gson.toJson(pwd));
            if ((clientconnexion.getLogin()== username)&&(clientconnexion.getMdp() == pwd))
            {
                return new ResponseEntity<>(gson.toJson(clientconnexion), HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>(gson.toJson("Error Username or pwd "), HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     */
    @PostMapping("/connexion")
    public ResponseEntity<String> connexionClient(@RequestBody clientDto clientdto) {
        try {
            List<Client> client = clientRepository.findAllByLogin(clientdto.getLogin());
            if ((client.get(0).getLogin().equalsIgnoreCase(clientdto.getLogin()))&&(client.get(0).getMdp().equalsIgnoreCase(clientdto.getMdp())))
            {
                String token = getJWTToken(clientdto.getLogin());
                client.get(0).setToken(token);
                Client clientReturn = clientRepository.save(client.get(0));
                System.out.println(clientReturn.toString());
                return new ResponseEntity<>(gson.toJson(clientReturn), HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>(gson.toJson("Error Username or pwd "), HttpStatus.CREATED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/inscription")
    public ResponseEntity<String> loginClient(@RequestBody clientDto client) {
        try {

            Client user = new Client();
            user.setLogin(client.getLogin());
            String token = getJWTToken(user.getLogin());
            user.setMdp(client.getMdp());
            user.setToken(token);
            Client client1 = clientRepository
                    .save(user);
            return new ResponseEntity<>(gson.toJson(client1), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

}
