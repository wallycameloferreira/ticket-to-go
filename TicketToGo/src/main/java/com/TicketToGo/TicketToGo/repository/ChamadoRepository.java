package com.TicketToGo.TicketToGo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TicketToGo.TicketToGo.model.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
    List<Chamado> findByStatus(String status);
    List<Chamado> findBySolicitanteContainingIgnoreCase(String solicitante);
}