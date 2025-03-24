package BallFan.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "home_team")
    private Team homeTeam;

    @Enumerated(EnumType.STRING)
    @Column(name = "away_team")
    private Team awayTeam;

    @Column(name = "ticket_date")
    private LocalDate ticketDate;

    @Column(name = "seat")
    private String seat;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "is_win")
    private boolean isWin;

    @Column(name = "has_review")
    private boolean hasReview;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_result_id")
    private GameResult gameResult;
}
