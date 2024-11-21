package com.project.SMS.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToMany(mappedBy = "classes")
    private Set<StudentInfo> students;

    @OneToMany(mappedBy = "motherClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Announcement> announcements; // Updated mappedBy to match Announcement
}

