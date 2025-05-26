package com.example.apirest.model;

import jakarta.persistence.*;

@Entity
@Table(name= "tb_usuario")
public class UsuarioModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name= "TX_NOME")
    private String nome;
    
    @Column(name= "TX_SENHA")
    private String senha;
    
    
    

    public Long getId() {
        return id;
    }

   
    public String getSenha() {
        return senha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    
    

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
}
