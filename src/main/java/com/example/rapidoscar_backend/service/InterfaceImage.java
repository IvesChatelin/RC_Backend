package com.example.rapidoscar_backend.service;

import com.example.rapidoscar_backend.entity.Categories;
import com.example.rapidoscar_backend.entity.Images;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface InterfaceImage {

    Images save(MultipartFile images) throws IOException;
    Images getImages(Integer id);
    Stream<Images> getAllImages();
}
