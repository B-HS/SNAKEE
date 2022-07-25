package hs.game.snakeback.Service;

import hs.game.snakeback.DTO.SnakeDTO;
import hs.game.snakeback.Entity.Snake;

public interface SnakeService {
    String register(SnakeDTO dto);
    // String login(SnakeDTO dto);

    // void valiPid(SnakeDTO dto);

    // void rankEntries(SnakeDTO dto);

    default Snake dtoToEntity(SnakeDTO dto) {
        Snake entity = Snake.builder().pid(dto.getPid()).name(dto.getName()).email(dto.getEmail())
                .topconsum(dto.getTopconsum()).build();
        return entity;
    }

    default SnakeDTO entityToDTO(Snake entity) {
        SnakeDTO dto = SnakeDTO.builder().pid(entity.getPid()).name(entity.getName()).email(entity.getEmail())
                .topconsum(entity.getTopconsum()).lastLog(entity.getLastLog()).build();
        return dto;

    }
}
