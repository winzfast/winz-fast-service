package com.test.winzfast.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author ADMIN
 */
@Data
public class BookingDTO {
    private Long id;
    private LocalDate bookingDate;
    private Date viewDate;
    private String comment;
}
