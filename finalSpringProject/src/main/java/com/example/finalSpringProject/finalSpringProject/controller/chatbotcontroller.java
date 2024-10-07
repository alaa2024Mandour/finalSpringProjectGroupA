package  com.example.finalSpringProject.finalSpringProject.controller;
import com.example.finalSpringProject.finalSpringProject.service.chatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class chatbotcontroller {

    @Autowired
    private chatbotService chatBotService;

    @PostMapping("/message")
    public String sendMessage(@RequestBody String message) {
        return chatBotService.getResponse(message);
    }
}


