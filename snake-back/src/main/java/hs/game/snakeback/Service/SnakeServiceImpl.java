package hs.game.snakeback.Service;

import hs.game.snakeback.Repository.SnakeRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SnakeServiceImpl implements SnakeService {
    private final SnakeRepository repo;

}
