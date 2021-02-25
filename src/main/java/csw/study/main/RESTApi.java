package csw.study.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import csw.study.main.models.ListCard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RESTApi {
    @GetMapping("/home")
    public String welcome(){
        return "The server is running well.";
    }

    @PostMapping("/class")
    public int addUser(@RequestBody User user) {
        return user.getId();
    }

    @PostMapping("/kakao")
    public String hello(@RequestBody String pBody) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(pBody, new TypeReference<Map<String,Object>>(){});
        String userRequest = (String) ((Map<String, Object>) map.get("userRequest")).get("utterance");
        return userRequest;
    }

    @PostMapping(value="/today", produces="application/json; charset=UTF-8")
    public String today() {
        ListCard listCard = new ListCard();
        listCard.setTitle("제목");

        return listCard.toString();
    }
}
