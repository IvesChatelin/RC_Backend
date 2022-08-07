package com.example.rapidoscar_backend.controller;

import com.example.rapidoscar_backend.entity.Categories;
import com.example.rapidoscar_backend.entity.Images;
import com.example.rapidoscar_backend.payload.ResponseImage;
import com.example.rapidoscar_backend.repository.CategorieRepository;
import com.example.rapidoscar_backend.repository.ImageRepository;
import com.example.rapidoscar_backend.service.ServiceImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("image")
public class ImgController {

    @Autowired
    ServiceImage serviceImage;

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    ImageRepository imageRepository;

    @PostMapping("/uplaod")
    public ResponseEntity<String> uplaodImage(@RequestParam("image") MultipartFile image) {
        try{
            serviceImage.save(image);
            return ResponseEntity.ok().body("image importé avec succes");
        }catch (Exception e){
            return ResponseEntity.ok().body("Erreur");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseImage>> getListImage() {
        List<ResponseImage> images = serviceImage.getAllImages().map(img -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/src/main/resources/images/")
                    .path(img.getNom())
                    .toUriString();
            return new ResponseImage(
                    img.getNom(),
                    fileDownloadUri,
                    img.getType(),
                    img.getImage().length);
        }).collect(Collectors.toList());
        return ResponseEntity.ok().body(images);
    }
    @GetMapping(path = "/get", params = "id")
    public ResponseEntity<byte[]> getImage(@RequestParam() Integer id) {
        Images image = serviceImage.getImages(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getNom() + "\"")
                .body(image.getImage());
    }

}
