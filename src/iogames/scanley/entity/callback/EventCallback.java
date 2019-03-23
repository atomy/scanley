package iogames.scanley.entity.callback;

import iogames.scanley.entity.Server;
import java.io.IOException;

/**
 * Event callbacks, events are executed once.
 */
public interface EventCallback {
    /**
     * Called if socket connect timed out.
     *
     * @param server Server
     */
    void onTimeout(Server server);

    /**
     * Called if socket throws exception and therefore fails to connect.
     *
     * @param server Server
     */
    void onFail(Server server, IOException e);

    /**
     * Called if socket was successfully opened.
     *
     * @param server Server
     */
    void onConnected(Server server);
}
