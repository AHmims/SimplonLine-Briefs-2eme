const __WEBSOCKET_URL = `ws://${window.location.host}/websocket/chat`;
let chatNode = {
    socket: null,
    init: () => {
        chatNode.link(__WEBSOCKET_URL);
    },
    link: host => {
        chatNode.socket = new WebSocket(host);
        //
        chatNode.socket.onopen = () => {
            console.log("socket on");
        }
        //
        chatNode.socket.onmessage = msg => {
            console.log(msg);
        }
        //
        chatNode.socket.onclose = () => {
            console.log("socket off");
        }
    },
    send: msg => {
        chatNode.socket.send(msg);
    }
};
//
//
// 
// 
chatNode.init();