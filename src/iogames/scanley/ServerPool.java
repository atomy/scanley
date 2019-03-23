package iogames.scanley;

import java.util.ArrayList;

/**
 * Class ServerPool.
 */
public class ServerPool {
    private ArrayList<ServerHandler> servers = new ArrayList<>();

    public void add(ServerHandler serverHandler) {
        this.servers.add(serverHandler);
    }
}
