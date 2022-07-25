package hs.game.snakeback.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hs.game.snakeback.DTO.SnakeDTO;
import hs.game.snakeback.Service.SnakeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/snake")
@Log4j2
@RequiredArgsConstructor
public class SnakeController {
    
    private final SnakeService service;
    @PostMapping("/register")
    void register(SnakeDTO dto){
        log.info(service.register(dto));
    }
}
