package sixth.lesson.homework.client;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;

public class ClientApplication {

    public static void main(String[] args) {

        connection = new Connection();

        request = new Request();

        host = new InetSocketAddress(HOST, PORT);
        method = MethodType.GET;
        body =" ";

        performMethodGet();

        performMethodPost();

        connection.close();
    }

    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private static Connection connection;
    private static Request request;
    private static SocketAddress host;
    private static String pageAddress;
    private static MethodType method;
    private static Map<String, String> headings;
    private static Map<String, String> parameters;
    private static String body;

    private static void performMethodGet() {

        headings = new HashMap<>();
        parameters = new HashMap<>();

        headings.put("HOST", "localhost");

        pageAddress = "/hello";
        parameters.put("name", "exampleClient");
        method = MethodType.GET;
        body = "body";

        String request = ClientApplication.request.buildRequest(pageAddress, method, headings, parameters, body);
        System.out.println(request);

        String response = connection.getResponse(host, request);
        System.out.println(response);
    }

    private static void performMethodPost() {

        headings = new HashMap<>();
        parameters = new HashMap<>();

        headings.put("HOST", "localhost");

        pageAddress = "/hello";
        parameters.put("userName", "exampleClient");
        parameters.put("password", "pass");
        method = MethodType.POST;
        body = " ";

        String request = ClientApplication.request.buildRequest(pageAddress, method, headings, parameters, body);
        System.out.println(request);

        String response = connection.getResponse(host, request);
        System.out.println(response);

    }
}
