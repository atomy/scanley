package iogames.scanley;

import iogames.scanley.entity.Server;
import iogames.scanley.entity.callback.EventCallback;

/**
 * Scanley class, main class.
 */
public class Scanley {
    private static final String TAG = Scanley.class.getSimpleName();

    /**
     * Scanner reference.
     */
    private Scanner scanner;

    /**
     * Flag for logging enabled/disabled to stdout.
     */
    public static boolean logEnabled = false;

    /**
     * Construct.
     */
    public Scanley() {
        this.scanner = new Scanner(new ServerPool());
    }

    /**
     * Add given server address and try to open connection.
     *
     * @param ip String ip of server
     * @param port int port of server
     * @param eventCallback callback to, an event is played back once
     */
    public void add(String ip, int port, EventCallback eventCallback) {
        scanner.add(new Server(ip, port), eventCallback);
    }

    /**
     * Log something.
     *
     * @param tag String TAG
     * @param server Server optional server
     * @param log String log message
     */
    public static void log(String tag, Server server, String log) {
        if (!Scanley.logEnabled) {
            return;
        }

        if (null != server) {
            System.out.println(String.format("[%s][%s] %s", tag, server.toString(), log));
        } else {
            System.out.println(String.format("[%s] %s", tag, log));
        }
    }
}
