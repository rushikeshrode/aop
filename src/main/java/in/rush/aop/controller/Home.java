package in.rush.aop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("home")
public class Home {

    @RequestMapping(method = RequestMethod.GET, path = "health")
    public Map<String, String> health(){
        Map<String, String> response = new HashMap<>();
        response.put("Health", "Good");
        response.put("Status", "200OK");
        response.put("Message", "Application Running Fine ::");
        return response;
    }

}
