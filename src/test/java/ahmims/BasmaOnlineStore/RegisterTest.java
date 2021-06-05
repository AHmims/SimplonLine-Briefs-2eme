package ahmims.BasmaOnlineStore;

import ahmims.BasmaOnlineStore.dto.UserAuthInputData;
import ahmims.BasmaOnlineStore.dto.UserFormData;
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
public class RegisterTest {
    @Autowired
    private MockMvc mockMvc;

    //
    @Test
    public void registerRoute_1_422() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        //
        UserFormData userFormData = new UserFormData();
        //
        this.mockMvc.perform(post("/auth/signup").contentType(APPLICATION_JSON).content(ow.writeValueAsString(userFormData))).andDo(print()).andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void registerRoute_2_400() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        //
        UserFormData userFormData = new UserFormData("nom", "prenom", "email@test.com", "123456789", null, "BAD_TYPE");
        //
        this.mockMvc.perform(post("/auth/signup").contentType(APPLICATION_JSON).content(ow.writeValueAsString(userFormData))).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void registerRoute_3_422() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        //
        UserFormData userFormData = new UserFormData("nom", "prenom", "BAD_EMAIL", "123456789", null, "Client");
        //
        this.mockMvc.perform(post("/auth/signup").contentType(APPLICATION_JSON).content(ow.writeValueAsString(userFormData))).andDo(print()).andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void registerRoute_4_200() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        //
        UserFormData userFormData = new UserFormData("nom", "prenom", "goood@test.com", "123456789", null, "Client");
        //
        this.mockMvc.perform(post("/auth/signup").contentType(APPLICATION_JSON).content(ow.writeValueAsString(userFormData))).andDo(print()).andExpect(status().isOk()
        );
    }
}
