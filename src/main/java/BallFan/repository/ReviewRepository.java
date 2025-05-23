package BallFan.repository;

import BallFan.entity.review.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Boolean existsByTicketId(Long ticketId);

    Page<Review> findAllByOrderByCreatedAtDesc(Pageable pageable);
}
