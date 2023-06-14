package com.masai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.ReservationException;
import com.masai.entities.Reservation;
import com.masai.enums.ReservationStatus;
import com.masai.repositories.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationRepository rp;

	@Override
	public Reservation createReservation(Reservation reservation) {
		
		return rp.save(reservation);
	}

	@Override
	public List<Reservation> getUserReservations(Long userId) {
		
		return rp.findByUserId(userId);
	}

	@Override
	public void cancelReservation(Long reservationId) {
		Reservation reservation = rp.findById(reservationId).orElseThrow(() -> new ReservationException("Reservation has not been found :("));

        reservation.setStatus(ReservationStatus.Cancelled);
        rp.save(reservation);
		
	}
	
	

}
