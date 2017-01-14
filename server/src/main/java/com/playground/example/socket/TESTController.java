package com.playground.example.socket;

import com.playground.gameboard.GameBoard;
import com.playground.gameboard.GameBoardFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class TESTController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public GameBoard greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000);
        return GameBoardFactory.get();
    }
}
