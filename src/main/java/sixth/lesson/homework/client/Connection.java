package sixth.lesson.homework.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

public class Connection {

    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public Connection() {
    }

    public String getResponse(SocketAddress socketAddress, String request) {
        String response = null;
        try {
            socket = new Socket();
            socket.connect(socketAddress);
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream.write(request.getBytes(StandardCharsets.UTF_8));
            Thread.sleep(2_000);
            byte[] responseBytes = new byte[dataInputStream.available()];
            dataInputStream.read(responseBytes);
            response = new String(responseBytes);
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            try {
                dataInputStream.close();
                dataOutputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return response;
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
