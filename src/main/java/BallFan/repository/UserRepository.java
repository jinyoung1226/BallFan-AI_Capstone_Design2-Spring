package BallFan.repository;

import BallFan.entity.Team;
import BallFan.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);

    List<User> findByTeam(Team team);

    Boolean existsByEmail(String email);
}