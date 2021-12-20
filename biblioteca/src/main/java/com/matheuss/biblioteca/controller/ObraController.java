package com.matheuss.biblioteca.controller;

import com.matheuss.biblioteca.model.Obra;
import com.matheuss.biblioteca.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obra")
public class ObraController {

    private ObraRepository obraRepository;

    @Autowired
    public ObraController(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    @GetMapping
    public ResponseEntity<List<Obra>> listarTodasAsObras(){
        return ResponseEntity.ok(obraRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Obra> postObra(@RequestBody Obra obra){
        return ResponseEntity.ok(obraRepository.save(obra));
    }
}
