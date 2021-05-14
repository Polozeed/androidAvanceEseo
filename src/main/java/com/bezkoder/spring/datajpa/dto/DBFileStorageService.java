package com.bezkoder.spring.datajpa.dto;

import com.bezkoder.spring.datajpa.model.DBFile;
import com.bezkoder.spring.datajpa.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

    @Service
    public class DBFileStorageService {

        @Autowired
        private ImageRepository dbFileRepository;

        public DBFile storeFile(MultipartFile file) throws Exception {
            // Normalize file name
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            try {
                // Check if the file's name contains invalid characters
                if(fileName.contains("..")) {
                    throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
                }

                DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());
                return  dbFileRepository.save(dbFile);
            } catch (IOException ex) {
                throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public DBFile getFile(String fileId) throws Exception {
            return dbFileRepository.findById(fileId)
                    .orElseThrow(() -> new Exception("File not found with id " + fileId));
        }
    }

