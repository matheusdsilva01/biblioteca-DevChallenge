package com.matheuss.biblioteca.model;


import javax.persistence.*;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "obra_id")
    private Obra obras;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Obra getObras() {
        return obras;
    }

    public void setObras(Obra obras) {
        this.obras = obras;
    }
}
