package account.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping
@Validated
public class UserController {

    @PostMapping("api/auth/signup")
    public ObjectNode signup(@Valid @RequestBody User user)  {
        if (!user.getEmail().endsWith("@acme.com")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonString = objectMapper.createObjectNode();
        jsonString.put("name", user.getName());
        jsonString.put("lastname", user.getLastname());
        jsonString.put("email", user.getEmail());



        return jsonString;

    }
}
