package com.netspace.websocket;

import android.os.Handler;
import android.util.Log;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class IMWebSocketServer extends WebSocketServer {
    private static final String TAG = "imWebSocketServer";
    public static ArrayList<WebSocket> connections = new ArrayList<>();

    public IMWebSocketServer(int port, Handler handler) throws UnknownHostException {
        super(new InetSocketAddress(port));
        MainActivity.MainHandler mainHandler = (MainActivity.MainHandler) handler;
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        conn.send("Hello");
        connections.add(conn);

        Log.d(TAG, conn.getRemoteSocketAddress().getAddress().getHostAddress() + " entered the room!");
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        Log.d(TAG, conn + " was closed!");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        Log.d(TAG, conn + ": " + message);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();

    }

    @Override
    public void onStart() {
    }
}
