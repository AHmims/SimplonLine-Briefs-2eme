window.onload = () => {
    const __WEBSOCKET_URL = `ws://${window.location.host}/websocket/chat`;
    const __SEPARATOR = ":#:";

    let chatNode = {
        socket: null,
        init: () => {
            chatNode.link(__WEBSOCKET_URL);
            //
            document.getElementById('msg_send').addEventListener('click', () => {
                sendMsg();
            });
            //
            document.getElementById('msg_input').addEventListener('keyup', e => {
                if (e.key == "Enter") sendMsg();
            });
        },
        link: host => {
            chatNode.socket = new WebSocket(host);
            //
            chatNode.socket.onopen = () => {
                console.log("socket on");
                chatNode.send({
                    channel: "auth",
                    id: window.location.pathname.split("/")[2],
                    content: document.getElementById('rootElement').dataset.email,
                    type: "empty"
                });
            }
            //
            chatNode.socket.onmessage = msg => {
                console.log(msg);
                msg = msg.data.split(__SEPARATOR);
                msgObject = {
                    channel: msg[0],
                    id: msg[1],
                    content: msg[2],
                    type: msg[3]
                }
                //
                if (msgObject.channel == 'message') {
                    createMsgBubble(msgObject, 'remote');
                }
            }
            //
            chatNode.socket.onclose = () => {
                console.log("socket off");
            }
        },
        send: msg => {
            //msg format => channel:|:idrendezVous:|:content:|:type
            msg = Object.values(msg).join(__SEPARATOR);
            chatNode.socket.send(msg);
        }
    };
    //
    //
    const setupMsg = () => {
        const msg = document.getElementById('msg_input').value;
        try {
            if (msg != "") {
                return {
                    channel: "message",
                    id: window.location.pathname.split("/")[2],
                    content: msg,
                    type: "text"
                }
            } else throw "fatal";
        } catch (error) {
            console.log("Message can't be empty");
            return null;
        }
    }
    const sendMsg = () => {
        const msgObject = setupMsg();
        document.getElementById('msg_input').value = "";
        if (msgObject != null) {
            chatNode.send(msgObject);
            createMsgBubble(msgObject, 'host');
        }
    }
    // 
    // 
    chatNode.init();
    scrollDown();
}
//
function createMsgBubble(msg, type) {
    let container = document.createElement('div');
    container.setAttribute('class', type == 'host' ? 'msg-host-container' : 'msg-remote-container');
    //
    let txt = document.createElement('span');
    txt.setAttribute('class', type == 'host' ? 'msg-host-text' : 'msg-remote-text');
    txt.innerText = msg.content;
    //
    container.appendChild(txt);
    document.getElementById('msg_container').appendChild(container);
    scrollDown();
}
//
function scrollDown() {
    let cont = document.getElementById('msg_container');
    cont.scrollTo(0, cont.scrollHeight);
}