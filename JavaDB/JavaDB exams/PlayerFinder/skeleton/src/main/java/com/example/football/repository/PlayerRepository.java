package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository  extends JpaRepository<Player, Long> {

    Optional<Player> findByEmail(String email);

    @Query(value = "SELECT * FROM players AS p JOIN stats AS s ON p.stat_id = s.id " +
            "WHERE YEAR(p.birth_date) > ?1 AND YEAR(p.birth_date) < ?2 " +
            "ORDER BY s.shooting DESC, s.passing DESC, s.endurance DESC, p.last_name", nativeQuery = true)
    List<Player> findAllByBirthdateAfterAndBirthdateBefore(int after, int before);

}
