package com.example.rapidoscar_backend.service;

import com.example.rapidoscar_backend.entity.Categories;
import com.example.rapidoscar_backend.entity.Images;
import com.example.rapidoscar_backend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class ServiceImage implements InterfaceImage{
    @Autowired
    ImageRepository imageRepository;

    private final Path root = Paths.get("uploads");

    @Override
    public Images save(MultipartFile images) throws IOException {
        String fileName = StringUtils.cleanPath(images.getOriginalFilename());
        String type = images.getContentType();
        Images img = new Images(images.getBytes(),fileName,type);
        return imageRepository.save(img);
    }

    @Override
    public Images getImages(Integer id) {
        return imageRepository.findById(id).get();
    }

    @Override
    public Stream<Images> getAllImages() {
        return imageRepository.findAll().stream();
    }

}
