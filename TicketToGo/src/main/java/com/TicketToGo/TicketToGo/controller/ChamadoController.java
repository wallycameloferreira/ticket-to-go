package com.TicketToGo.TicketToGo.controller;

import com.TicketToGo.TicketToGo.model.Chamado;
import com.TicketToGo.TicketToGo.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/chamados")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChamadoController {
    
    @Autowired
    private ChamadoService chamadoService;
    
    @GetMapping
    public ResponseEntity<List<Chamado>> listarTodos() {
        try {
            List<Chamado> chamados = chamadoService.listarTodos();
            return new ResponseEntity<>(chamados, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Chamado> buscarPorId(@PathVariable Long id) {
        return chamadoService.buscarPorId(id)
                .map(chamado -> new ResponseEntity<>(chamado, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping
    public ResponseEntity<Chamado> criar(@RequestBody Chamado chamado) {
        try {
            if (chamado.getStatus() == null || chamado.getStatus().isEmpty()) {
                chamado.setStatus("recebido");
            }
            Chamado novoChamado = chamadoService.salvar(chamado);
            return new ResponseEntity<>(novoChamado, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<Chamado> atualizarStatus(@PathVariable Long id, @RequestBody Map<String, String> request) {
        try {
            String novoStatus = request.get("status");
            if (novoStatus == null || novoStatus.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            
            Chamado chamadoAtualizado = chamadoService.atualizarStatus(id, novoStatus);
            if (chamadoAtualizado != null) {
                return new ResponseEntity<>(chamadoAtualizado, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}