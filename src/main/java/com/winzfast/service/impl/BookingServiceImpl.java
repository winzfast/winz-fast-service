package com.winzfast.service.impl;


import com.winzfast.dto.BookingDTO;
import com.winzfast.model.Booking;
import com.winzfast.model.Product;
import com.winzfast.model.User;
import com.winzfast.repository.BookingRepository;
import com.winzfast.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ADMIN
 */
@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public void createBooking(BookingDTO bookingDTO, User user, Product product) {
        Booking booking = new Booking();
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setViewDate(bookingDTO.getViewDate());
        booking.setComment(bookingDTO.getComment());
        booking.setUser(user);
        booking.setProduct(product);

        bookingRepository.save(booking);
    }

    @Override
    public List<BookingDTO> getOwnBookings(User user) {
        List<Booking> ownBooking = bookingRepository.findByUser(user);

        return ownBooking.stream()
                .map(this::convertToBookingDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingDTO> getProductBookings(Product product) {
        List<Booking> productBooking = bookingRepository.findByProduct(product);

        return productBooking.stream()
                .map(this::convertToBookingDTO)
                .collect(Collectors.toList());
    }

    private BookingDTO convertToBookingDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setViewDate(booking.getViewDate());
        bookingDTO.setComment(booking.getComment());
        return bookingDTO;
    }
}
