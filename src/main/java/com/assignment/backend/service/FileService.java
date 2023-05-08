package com.assignment.backend.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FileService {
    private String uploadPath = System.getProperty("user.dir");
    private final Path profile = Paths.get(uploadPath + "/profilePictures");
    private final Path validation = Paths.get(uploadPath + "/validationDocs");

    public void storeProfile(MultipartFile file) {
        try {
            Path destinationFile = this.profile.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
        }
        System.out.println(" saved successfully");
    }

    public Resource loadProfileResource(String filename) {
        try {
            Path file = loadProfile(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
        } catch (MalformedURLException e) {
            System.out.println("error");
        }
        return null;
    }

    public Resource loadValidationResource(String filename) {
        try {
            Path file = loadValidation(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
        } catch (MalformedURLException e) {
            System.out.println("error");
        }
        return null;
    }

    public void storeValidation(MultipartFile file) {
        try {
            Path destinationFile = this.validation.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
        }
        System.out.println(" saved successfully");
    }

    public Path loadProfile(String filename) {
        return profile.resolve(filename);
    }

    public Path loadValidation(String filename) {
        return validation.resolve(filename);
    }


}