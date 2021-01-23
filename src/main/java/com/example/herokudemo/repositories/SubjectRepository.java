package com.example.herokudemo.repositories;

import com.example.herokudemo.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
