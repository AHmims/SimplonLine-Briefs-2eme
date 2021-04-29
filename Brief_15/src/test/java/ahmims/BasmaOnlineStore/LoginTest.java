package ahmims.BasmaOnlineStore;

import ahmims.BasmaOnlineStore.dto.UserAuthInputData;
import ahmims.BasmaOnlineStore.model.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void loginRoute_1_422() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        //
        UserAuthInputData userAuthInputData = new UserAuthInputData("test", "test");
        //
        this.mockMvc.perform(post("/auth/login").contentType(APPLICATION_JSON).content(ow.writeValueAsString(userAuthInputData))).andDo(print()).andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void loginRoute_2_400() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        //
        this.mockMvc.perform(post("/auth/login").contentType(APPLICATION_JSON).content(ow.writeValueAsString(null))).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void loginRoute_3_422() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        //
        this.mockMvc.perform(post("/auth/login").contentType(APPLICATION_JSON).content(ow.writeValueAsString(new Role()))).andDo(print()).andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void loginRoute_4_200() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        UserAuthInputData userAuthInputData = new UserAuthInputData("email99@test.com", "123456789");
        //
        this.mockMvc.perform(post("/auth/login").contentType(APPLICATION_JSON).content(ow.writeValueAsString(userAuthInputData))).andDo(print()).andExpect(status().isOk());
    }
}
