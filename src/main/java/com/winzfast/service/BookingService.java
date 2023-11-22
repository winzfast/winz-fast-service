package com.winzfast.service;


import com.winzfast.dto.BookingDTO;
import com.winzfast.model.Product;
import com.winzfast.model.User;

import java.util.List;

/**
 * @author ADMIN
 */
public interface BookingService {

    void createBooking(BookingDTO bookingDTO, User user, Product product);
    List<BookingDTO> getOwnBookings(User user);
    List<BookingDTO> getProductBookings(Product product);
}
