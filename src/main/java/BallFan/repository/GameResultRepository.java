package BallFan.repository;

import BallFan.entity.GameResult;
import BallFan.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface GameResultRepository extends JpaRepository<GameResult, Long> {

    Optional<GameResult> findByAwayTeamAndGameDate(Team awayTeam, LocalDate gameDate);

}
