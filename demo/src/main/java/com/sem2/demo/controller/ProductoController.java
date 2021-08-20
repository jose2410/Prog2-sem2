package com.sem2.demo.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.sem2.demo.model.Producto;

@RestController
@RequestMapping(value = "api/producto",produces = "application/json")
public class ProductoController {

    private Map<String, Producto> products;

    public ProductoController() {
        products = new HashMap<String, Producto>();
        Producto p = new Producto();
        
        p.setName("celular");
        p.setDescription("gamer");
        p.setStock(100);
        p.setImage("https://ichef.bbci.co.uk/news/640/cpsprodpb/BE54/production/_117842784_lg.jpg");
        String id = UUID.randomUUID().toString();
        p.setId(id);
        p.setEstado("Activo");
        products.put(id, p);
    }


    @GetMapping(value = "/", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,Producto>> listall(){
        return new ResponseEntity<Map<String,Producto>>(products,HttpStatus.OK);
    }

    @PostMapping(value = "/", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> add(@RequestBody Producto p) {
        String id = UUID.randomUUID().toString();
        p.setId(id);
        products.put(p.getId(), p);
        return new ResponseEntity<String>(id,HttpStatus.CREATED);
    }

    @GetMapping(value = "/", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> find(@PathVariable String id) {
        if(products.containsKey(id)){
            Producto p = products.get(id);
            return new ResponseEntity<Producto>(p, HttpStatus.OK);
        }else{
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@RequestBody String id_prod) {
        if(products.containsKey(id_prod)){
            Producto p = products.get(id_prod);
            if(p.getEstado()=="Activo"){
                p.setEstado("Inactivo");
            }
            return new ResponseEntity<String>(id_prod, HttpStatus.OK);
        }else{
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@RequestParam String id_prod) {
        if(products.containsKey(id_prod)){
            products.remove(id_prod);
            return new ResponseEntity<String>("Se eliminó el producto con id: "+id_prod, HttpStatus.OK);
        }else{
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }
}
