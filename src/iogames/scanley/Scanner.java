package iogames.scanley;

import iogames.scanley.entity.Server;
import iogames.scanley.entity.callback.EventCallback;

/**
 * Scanner class, organizing port-scanning etc.
 */
public class Scanner {
    private static final String TAG = Scanner.class.getSimpleName();

    /**
     * Pool of all servers.
     */
    private final ServerPool serverPool;

    /**
     * Constructor.
     *
     * @param serverPool ServerPool
     */
    public Scanner(ServerPool serverPool) {
        this.serverPool = serverPool;
    }

    /**
     * Add new server including their callback.
     *
     * @param server Server
     * @param eventCallback EventCallback
     */
    public void add(Server server, EventCallback eventCallback) {
        ServerHandler serverHandler = new ServerHandler(server, eventCallback);
        serverHandler.start();

        Scanley.log(TAG, server, "Added server");
        this.serverPool.add(new ServerHandler(server, eventCallback));
    }
}
