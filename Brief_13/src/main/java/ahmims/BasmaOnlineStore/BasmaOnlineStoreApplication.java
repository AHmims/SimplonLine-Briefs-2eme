package ahmims.BasmaOnlineStore;

import ahmims.BasmaOnlineStore.dto.UserResponseData;
import ahmims.BasmaOnlineStore.model.Utilisateur;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@Import(Config.class)
public class BasmaOnlineStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(BasmaOnlineStoreApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        //
        modelMapper.typeMap(Utilisateur.class, UserResponseData.class).addMappings(mapper -> {
            mapper.map(Utilisateur::getNomUtilisateur, UserResponseData::setNom);
            mapper.map(Utilisateur::getPrenomUtilisateur, UserResponseData::setPrenom);
            mapper.map(Utilisateur::getEmailUtilisateur, UserResponseData::setEmail);
            mapper.map(Utilisateur::getRole, UserResponseData::setRole);
        });

        return modelMapper;
    }
}
