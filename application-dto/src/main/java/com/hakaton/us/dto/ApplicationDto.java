package com.hakaton.us.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {
    private Long id;

    private Date startDate;

    private Date endDate;

    private String vehicle;

    private String userName;

    private String userSurname;

}
