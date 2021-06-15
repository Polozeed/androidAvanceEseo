package com.bezkoder.spring.datajpa.controller;


import com.bezkoder.spring.datajpa.dto.DBFileStorageService;
import com.bezkoder.spring.datajpa.model.DBFile;
import com.bezkoder.spring.datajpa.model.HistoriqueInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ImageController {

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    private DBFileStorageService dbFileStorageService;

    final GsonBuilder builder = new GsonBuilder();
    final Gson gson = builder.create();

    @PostMapping("/uploadFile")
    public  ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        DBFile dbFile = dbFileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId())
                .toUriString();

        return new ResponseEntity<>(gson.toJson(fileDownloadUri), HttpStatus.OK);
    }

    @PostMapping("/uploadMultipleFiles")
    public ResponseEntity<String>  uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        Object arr = Arrays.asList(files)
                .stream()
                .map(file -> {
                    try {
                        return uploadFile(file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(gson.toJson(arr), HttpStatus.OK);


    }

    @GetMapping("/downloadImage/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        // Load file from database

        DBFile dbFile = dbFileStorageService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }

}

