package com.hakaton.us.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {
    private Long id;

    private Calendar startDate;

    private Calendar endDate;

    private String vehicle;

    private String userName;

    private String userSurname;
}
