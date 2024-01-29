package com.gdsc.pikpet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Getter
public class Application {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(nullable = false)
    private int id;

    @Setter @ManyToOne @JoinColumn(name = "userId")
    private UserAccount userAccount;

    @Setter @ManyToOne @JoinColumn(name = "animalId")
    private Animal animal;

    @CreatedDate @Column(nullable = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    @Setter private String contents;
}