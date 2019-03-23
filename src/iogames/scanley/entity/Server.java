package iogames.scanley.entity;

/**
 * Class Server.
 */
public class Server {
    /**
     * Port of server.
     */
    private int port;

    /**
     * Ipv4 string of server.
     */
    private String ip;

    /**
     * Construct.
     *
     * @param ip String ipv4 of server
     * @param port int port of server
     */
    public Server(String ip, int port) {
        this.port = port;
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Convert to string and output e.g. 127.0.0.1:27015
     *
     * @return String
     */
    public String toString() {
        return String.format("%s:%d", this.ip, this.port);
    }
}
