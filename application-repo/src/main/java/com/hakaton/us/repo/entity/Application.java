package com.hakaton.us.repo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "news")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_date")
    private Calendar startDate;

    @Column(name = "end_date")
    private Calendar endDate;

    @Column(name = "vehicle")
    private String vehicle;

}
