package org.zuo.ftpapi.service.ftpService;


import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/websocket")
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();
    private String msg = "connect success";


    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);
        sendAllMessage(msg);
    }
    /**
     * 　　* 关闭调用方法
     *
     */
    @OnClose
    public void onClose() {
        webSockets.remove(this);
    }

    @OnMessage
    public void onMessage(String msg) {

    }

    /**
     * 　　* 消息广播到前台
     * 　　*
     * 　　* @param msg
     *
     */
    public void sendAllMessage(String msg) {
        for (WebSocket webSocket : webSockets) {
            try {
                webSocket.session.getBasicRemote().sendText(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
