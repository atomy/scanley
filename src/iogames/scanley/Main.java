package iogames.scanley;

import iogames.scanley.entity.Server;
import iogames.scanley.entity.callback.EventCallback;

import java.io.IOException;

/**
 * Clain main.
 */
public class Main {
    private static final String TAG = Main.class.getSimpleName();

    public static void main(String[] args) {
        boolean enabled = true;

        Scanley scanley = new Scanley();
        scanley.add("127.0.0.1", 28025, new EventCallback() {
             @Override
            public void onTimeout(Server server) {
                System.out.println("[" + TAG + "][" +  server.toString() + "] onTimeout()");
            }

            @Override
            public void onFail(Server server, IOException e) {
                System.out.println("[" + TAG + "][" +  server.toString() + "] onFail()");
            }

            @Override
            public void onConnected(Server server) {
                System.out.println("[" + TAG + "][" +  server.toString() + "] onConnected()");
            }
        });

        scanley.add("127.0.0.1", 28026, new EventCallback() {
            @Override
            public void onTimeout(Server server) {
                System.out.println("[" + TAG + "][" +  server.toString() + "] onTimeout()");
            }

            @Override
            public void onFail(Server server, IOException e) {
                System.out.println("[" + TAG + "][" +  server.toString() + "] onFail()");
            }

            @Override
            public void onConnected(Server server) {
                System.out.println("[" + TAG + "][" +  server.toString() + "] onConnected()");
            }
        });

        scanley.add("127.0.0.1", 28027, new EventCallback() {
            @Override
            public void onTimeout(Server server) {
                System.out.println("[" + TAG + "][" +  server.toString() + "] onTimeout()");
            }

            @Override
            public void onFail(Server server, IOException e) {
                System.out.println("[" + TAG + "][" +  server.toString() + "] onFail()");
            }

            @Override
            public void onConnected(Server server) {
                System.out.println("[" + TAG + "][" +  server.toString() + "] onConnected()");
            }
        });

        scanley.add("127.0.0.1", 28015, new EventCallback() {
            @Override
            public void onTimeout(Server server) {
                System.out.println("[" + TAG + "][" +  server.toString() + "] onTimeout()");
            }

            @Override
            public void onFail(Server server, IOException e) {
                System.out.println("[" + TAG + "][" +  server.toString() + "] onFail()");
            }

            @Override
            public void onConnected(Server server) {
                System.out.println("[" + TAG + "][" +  server.toString() + "] onConnected()");
            }
        });

        while (enabled) {
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
