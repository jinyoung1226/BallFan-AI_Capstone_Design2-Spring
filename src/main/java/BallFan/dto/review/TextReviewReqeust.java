package BallFan.dto.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextReviewReqeust {
    private Long review_id;
    private String review;
    private String stadium;
}
