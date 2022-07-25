package hs.game.snakeback.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SnakeDTO {
    private Long pid;
    private String name;
    private String email;
    private Long topconsum;
    private String password;
    private LocalDateTime regDate;
    private LocalDateTime lastLog;

}
