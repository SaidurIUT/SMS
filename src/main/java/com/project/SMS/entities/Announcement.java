package com.project.SMS.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Column(length = 999999)
    private String content;

    private LocalDateTime postedAt;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Class motherClass; // Field name remains the same
}
