package com.masai.services;

import java.util.List;

import com.masai.entities.Reservation;

public interface ReservationService {
	Reservation createReservation(Reservation reservation);
	
    List<Reservation> getUserReservations(Long userId);
    
    void cancelReservation(Long reservationId);

}
