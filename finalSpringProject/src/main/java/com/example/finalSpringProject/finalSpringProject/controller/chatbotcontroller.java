package  com.example.finalSpringProject.finalSpringProject.controller;
import com.example.finalSpringProject.finalSpringProject.service.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class chatbotcontroller {

    @Autowired
    private ChatbotService chatbotService;

    @PostMapping("/message")
    public String sendMessage(@RequestBody String message) {
        return chatbotService.getResponse(message);
    }
}


