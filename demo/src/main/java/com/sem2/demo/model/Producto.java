package com.sem2.demo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Producto {

    private String id;
    private String name;
    private String image;
    private String description;
    private int stock;
    private String estado;
}
