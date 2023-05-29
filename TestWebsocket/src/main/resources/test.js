class WebsocketClient {
    static stompClient = null
    static connect() {
        console.log("链接websocket")
        //链接SockJS 的endpoint 名称为endpointSang
        var socket = new SockJS('/endpointYC');
        //使用stomp子协议的WebSocket 客户端
        var stompClient = Stomp.over(socket);
        //链接Web Socket的服务端。
        stompClient.connect({}, function (frame) {
            //订阅/topic/message频道，并对收到信息进行处理
            stompClient.subscribe('/user/message', function (response) {
                showResponse(JSON.parse(response.body).responseMessage);
            });
            //订阅/topic/message频道，并对收到信息进行处理
            stompClient.subscribe('/sys/message', function (response) {
                showResponse(JSON.parse(response.body).responseMessage);
            })
        });
    }

    static send(url, data) {
        // stompClient.send("/ws", {}, JSON.stringify({'name': name, 'content': content, 'date': new Date()}));
        stompClient.send("url", {}, JSON.stringify({'name': name, 'content': content, 'date': new Date()}));
        localStorage.setItem(this.tableName, JSON.stringify(this.historyTable));
    }
}
