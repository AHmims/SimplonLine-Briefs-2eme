package beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SocketMessage {
    private String channel;
    private String namespace;
    private String content;
    private String type;
    //
    private SocketMessage(String channel,String namespace,String content){
        this.channel = channel;
        this.namespace = namespace;
        this.content = content;
        this.type = "text";
    }

    public SocketMessage(String channel, String namespace, String content, String type) {
        this.channel = channel;
        this.namespace = namespace;
        this.content = content;
        this.type = type;
    }

    public SocketMessage(String object){
        String [] items = object.split(":#:");
        List<String> list = Arrays.asList(items);
        //
        System.out.println(object);
        System.out.println(list.size());
        //
        this.channel = list.get(0).trim();
        this.namespace = list.get(1).trim();
        this.content = list.get(2).trim();
        this.type = list.get(3).trim();
    }
    //

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
