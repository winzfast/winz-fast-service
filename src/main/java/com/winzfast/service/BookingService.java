package com.winzfast.service;


import com.winzfast.dto.BookingDTO;
import com.winzfast.entity.Product;
import com.winzfast.entity.User;

import java.util.List;

/**
 * @author ADMIN
 */
public interface BookingService {

    void createBooking(BookingDTO bookingDTO, User user, Product product);
    List<BookingDTO> getOwnBookings(User user);
    List<BookingDTO> getProductBookings(Product product);
}
