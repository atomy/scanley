package iogames.scanley;

import iogames.scanley.entity.Server;
import iogames.scanley.entity.callback.EventCallback;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Class ServerHandler.
 */
public class ServerHandler extends Thread {
    private static final String TAG = ServerHandler.class.getSimpleName();
    private static final long TIMEOUT_DELAY_MS = 5000;
    private static final int SOCKET_CONNECT_TIMEOUT_MS = 20 * 1000;

    /**
     * Thread enabled switch.
     */
    private volatile boolean enabled = true;

    private Server server;

    private EventCallback eventCallback;

    /**
     * Loop delay of service, in ms.
     */
    private static final long SERVICE_LOOP_DELAY = 500;

    /**
     * Construct the handler.
     *
     * @param server Server
     * @param eventCallback EventCallback
     */
    public ServerHandler(Server server, EventCallback eventCallback) {
        this.server = server;
        this.eventCallback = eventCallback;
    }

    /**
     * Run loop.
     */
    @Override
    public void run() {
        final long abortTime = System.currentTimeMillis() + TIMEOUT_DELAY_MS;
        setName(this.getClass().getSimpleName());

        while (enabled) {
            if (System.currentTimeMillis() > abortTime) {
                Scanley.log(TAG, server, "Thread timed out!");
                eventCallback.onTimeout(this.server);
                return;
            }

            if (exec()) {
                eventCallback.onConnected(this.server);
                return;
            }

            try {
                sleep(SERVICE_LOOP_DELAY);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        Scanley.log(TAG, server, "Thread exited!");
    }

    /**
     * Execute.
     *
     * @return boolean
     */
    public boolean exec() {
        Scanley.log(TAG, server, "Server-Handler exec()");
        Socket socket = null;

        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(this.server.getIp(), this.server.getPort()), SOCKET_CONNECT_TIMEOUT_MS);
        } catch (IOException e) {
            enabled = false;
            eventCallback.onFail(server, e);
        }

        return socket.isConnected();
    }
}
