package ahmims.scuffed_BAKURA;

import ahmims.scuffed_BAKURA.config.SpringApplicationContext;
import ahmims.scuffed_BAKURA.dto.UserResponseData;
import ahmims.scuffed_BAKURA.model.Utilisateur;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScuffedApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScuffedApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        //
        modelMapper.typeMap(Utilisateur.class, UserResponseData.class).addMappings(mapper -> {
            mapper.map(Utilisateur::getNomUtilisateur, UserResponseData::setNom);
            mapper.map(Utilisateur::getEmailUtilisateur, UserResponseData::setEmail);
            mapper.map(Utilisateur::getRole, UserResponseData::setRole);
        });

        return modelMapper;
    }

    @Bean
    public SpringApplicationContext springApplicationContext() {
        return new SpringApplicationContext();
    }
}
