package ahmims.scuffed_BAKURA.util;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class Requester<T> {
    private final String url;
    private final String method;
    private final Class<T> type;

    public Requester(String url, String method, Class<T> type) {
        this.url = url;
        this.method = method;
        this.type = type;
    }

    public T sendJsonRequest() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate restTemplate = restTemplateBuilder.build();

        try {
            switch (this.method.toLowerCase()) {
                case "get":
                    return restTemplate.getForObject(url, this.type);
                default:
                    return null;
            }
        }catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }


}
