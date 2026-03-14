package com.TicketToGo.TicketToGo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chamados")
public class Chamado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String solicitante;
    
    @Column(nullable = false, length = 50)
    private String categoria;
    
    @Column(nullable = false, length = 150)
    private String titulo;
    
    @Column(nullable = false, length = 500)
    private String descricao;
    
    @Column(nullable = false, length = 20)
    private String status;
    
    @Column(name = "data_abertura", nullable = false)
    private LocalDateTime dataAbertura;
    
    @Column(name = "criado_em")
    private Long criadoEm;
    
    public Chamado() {
        this.dataAbertura = LocalDateTime.now();
        this.criadoEm = System.currentTimeMillis();
    }
    
    public Chamado(String solicitante, String categoria, String titulo, String descricao, String status) {
        this.solicitante = solicitante;
        this.categoria = categoria;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.dataAbertura = LocalDateTime.now();
        this.criadoEm = System.currentTimeMillis();
    }
    
    public String getDataAberturaFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return this.dataAbertura.format(formatter);
    }
    
    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getSolicitante() { return solicitante; }
    public void setSolicitante(String solicitante) { this.solicitante = solicitante; }
    
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public LocalDateTime getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(LocalDateTime dataAbertura) { this.dataAbertura = dataAbertura; }
    
    public Long getCriadoEm() { return criadoEm; }
    public void setCriadoEm(Long criadoEm) { this.criadoEm = criadoEm; }
}