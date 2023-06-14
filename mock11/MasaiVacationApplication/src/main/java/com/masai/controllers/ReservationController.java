package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Reservation;
import com.masai.services.ReservationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vacation")
public class ReservationController {
	
	@Autowired
	private ReservationService rs;
	
	@PostMapping("/reservations")
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation reservation) {
        Reservation createdReservation = rs.createReservation(reservation);
        return ResponseEntity.ok(createdReservation);
    }
	

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getUserReservations(@Valid @RequestParam Long userId) {
        List<Reservation> reservations = rs.getUserReservations(userId);
        return ResponseEntity.ok(reservations);
    }

    
    @PostMapping("/reservations/{reservationId}")
    public ResponseEntity<Void> cancelReservation(@Valid @PathVariable Long reservationId) {
        rs.cancelReservation(reservationId);
        return ResponseEntity.ok().build();
    }

}
