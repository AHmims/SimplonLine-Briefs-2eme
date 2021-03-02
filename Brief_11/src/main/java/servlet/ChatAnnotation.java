package servlet;

import beans.SocketMessage;
import dao.MessageDao;
import dao.RendezVousDao;
import model.Message;
import model.RendezVous;
import model.Utilisateur;
import service.UtilisateurSRVC;

import java.util.ArrayList;
import java.util.Date;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/websocket/chat")
public class ChatAnnotation {
    private static final ArrayList<ChatAnnotation> connections = new ArrayList<>();
    //
    private Utilisateur user = null;
    private String namespace;
    private Session session;

    public ChatAnnotation() {
    }

    @OnOpen
    public void start(Session session) {
        this.session = session;
    }

    @OnClose
    public void end() {
        connections.remove(this);
    }

    @OnMessage
    public void incoming(String message) {
        SocketMessage socketMessage = new SocketMessage(message);
        //
        switch (socketMessage.getChannel()) {
            case "auth":
                UtilisateurSRVC utilisateurSRVC = new UtilisateurSRVC();
                user = utilisateurSRVC.getByEmail(socketMessage.getContent());
                namespace = socketMessage.getNamespace();
                //
                if (!connections.contains(this))
                    connections.add(this);
                break;
            case "message":
                RendezVousDao rendezVousDao = new RendezVousDao();
                RendezVous rendezVous = rendezVousDao.get(socketMessage.getNamespace());
                //Save msg in DB
                MessageDao messageDao = new MessageDao();
                boolean insertRes = messageDao.insert(new Message(socketMessage.getContent(), socketMessage.getType(), new Date(), user, rendezVous));
                System.out.println("save message : " + insertRes);
                if (insertRes) {
                    //admin sent the message
                    if (!rendezVous.getUtilisateur().getIdUtilisateur().equals(user.getIdUtilisateur())) {
                        for (ChatAnnotation chatAnnotation : connections) {
                            if (chatAnnotation.user.getRoleUtilisateur() == 0) {
                                for (RendezVous patientRendezvous : chatAnnotation.user.getRendezVous()) {
                                    if (patientRendezvous.getIdRendezVous().equals(socketMessage.getNamespace())) {
                                        emit(chatAnnotation, socketMessage);
                                    }
                                }
                            }
                        }
                    } else {//patient sent the message
                        for (ChatAnnotation chatAnnotation : connections) {
                            if (chatAnnotation.namespace.equals(socketMessage.getNamespace())) {
                                if (chatAnnotation.user.getRoleUtilisateur() == 1) {
                                    //send message
                                    emit(chatAnnotation, socketMessage);
                                }
                            }
                        }
                    }
                }
                break;
            default:
                System.out.println("Error: channel unknown");
        }
    }

    @OnError
    public void onError(Throwable t) throws Throwable {
        System.out.println(t.toString());
        t.printStackTrace();
    }

    //
    //
    //
    private static void emit(ChatAnnotation remote, SocketMessage socketMessage) {
        try {
            String msgObject = String.format("%s:#:%s:#:%s:#:%s", socketMessage.getChannel(), socketMessage.getNamespace(), socketMessage.getContent(), socketMessage.getType());
            remote.session.getBasicRemote().sendText(msgObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}