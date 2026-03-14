package com.TicketToGo.TicketToGo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TicketToGo.TicketToGo.model.Chamado;
import com.TicketToGo.TicketToGo.repository.ChamadoRepository;

@Service
public class ChamadoService {
    
    @Autowired
    private ChamadoRepository chamadoRepository;
    
    public List<Chamado> listarTodos() {
        return chamadoRepository.findAll();
    }
    
    public Optional<Chamado> buscarPorId(Long id) {
        return chamadoRepository.findById(id);
    }
    
    public Chamado salvar(Chamado chamado) {
        return chamadoRepository.save(chamado);
    }
    
    public Chamado atualizarStatus(Long id, String novoStatus) {
        Optional<Chamado> chamadoOpt = chamadoRepository.findById(id);
        if (chamadoOpt.isPresent()) {
            Chamado chamado = chamadoOpt.get();
            chamado.setStatus(novoStatus);
            return chamadoRepository.save(chamado);
        }
        return null;
    }
    
    public void deletar(Long id) {
        chamadoRepository.deleteById(id);
    }
    
    public List<Chamado> buscarPorStatus(String status) {
        return chamadoRepository.findByStatus(status);
    }
}