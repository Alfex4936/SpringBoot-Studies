package csw.study.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        return user.getID();
    }

    @PostMapping("/kakao")
    public Object hello(@RequestBody String pBody) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(pBody, new TypeReference<Map<String,Object>>(){});
        Map<String, Object> newa = ((Map<String, Object>) map.get("userRequest"));
        return newa.get("utterance");
    }
}
