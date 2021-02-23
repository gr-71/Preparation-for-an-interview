package sixth.lesson.homework.client;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private final String HTTP = "HTTP";
    private final String HOST = "localhost";

    public String buildRequest (String address, MethodType method, Map <String, String> headings, Map <String, String> parameters, String body) {
        if (address == null) throw new IllegalArgumentException();
        if (!headings.containsKey("Host")) headings.put("Host", HOST);
        if (headings == null) headings = new HashMap<>();
        if (body == null) body = " ";
        if (method == null) method = MethodType.GET;

        StringBuilder request = new StringBuilder();
        StringBuilder appendParameters = new StringBuilder();

        String stringParameters = " ";

        if (parameters != null && parameters.size() > 0) {
            if (method.equals(MethodType.GET))
                appendParameters.append("?");
            for (String key : parameters.keySet()) {
                appendParameters.append(key).append("=").append(parameters.get(key)).append("&");
            }
            stringParameters = appendParameters.substring(0, appendParameters.toString().length() - 1);
        }

        request.append(method).append(" ").append(address);

        if (method.equals(MethodType.GET)) {
            request.append(stringParameters);
        }

        request.append(" ").append(HTTP).append(System.lineSeparator());

        for (String key : headings.keySet()) {
            request.append(key).append(": ").append(headings.get(key)).append(System.lineSeparator());
        }

        request.append(System.lineSeparator());

        if (method.equals(MethodType.POST)) {
            request.append(stringParameters).append(System.lineSeparator());
        }
        request.append(body);

        return request.toString();

    }
}
