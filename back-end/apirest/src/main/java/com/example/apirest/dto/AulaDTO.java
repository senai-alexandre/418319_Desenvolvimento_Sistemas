package com.example.apirest.dto;

public class AulaDTO {
    private String titulo;
    private String descricao;
    private String professor;

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getProfessor() {
        return professor;
    }

    public String getTitulo() {
        return titulo;
    }

    
    
}
