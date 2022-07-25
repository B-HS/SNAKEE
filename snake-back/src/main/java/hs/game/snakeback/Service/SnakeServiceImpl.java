package hs.game.snakeback.Service;

import org.springframework.stereotype.Service;

import hs.game.snakeback.DTO.SnakeDTO;
import hs.game.snakeback.Entity.Snake;
import hs.game.snakeback.Repository.SnakeRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SnakeServiceImpl implements SnakeService {
    private final SnakeRepository repo;

    @Override
    public String register(SnakeDTO dto) {
        Snake result = dtoToEntity(dto);
        repo.save(result);
        return result.getName();
    }
}
