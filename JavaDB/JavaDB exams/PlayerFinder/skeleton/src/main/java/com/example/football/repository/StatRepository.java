package com.example.football.repository;

import com.example.football.models.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long> {

    @Query(value = "SELECT * FROM stats WHERE shooting = ?1 AND passing = ?2 AND endurance = ?3", nativeQuery = true)
    Optional<Stat> findByStats(float shooting, float passing, float endurance);
}
