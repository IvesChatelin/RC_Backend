package com.example.rapidoscar_backend.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseImage {
    private String nom;
    private String url;
    private String type;
    private long size;

}
