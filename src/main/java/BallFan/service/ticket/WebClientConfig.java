package BallFan.service.ticket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${web.client.review}")
    private String webClientReview;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("http://ballfan-ocr:8000") // 보내는 곳의 URL(필자는 도커 컨테이너로 같은 네트워크로 하기 때문에, 컨테이너 호스트명을 넣으면 됨)
                .defaultHeader("Content-Type", "application/json") // 공통 헤더
                .build();
    }

    @Bean
    public WebClient webClient2() {
        return WebClient.builder()
                .baseUrl(webClientReview)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
}
