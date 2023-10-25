package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class FoncierServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    response.setContentType("text/html");
    java.io.PrintWriter out = response.getWriter();
    try {
      String jsonData = request
        .getReader()
        .lines()
        .collect(java.util.stream.Collectors.joining());
      System.out.println("Données JSON reçues : " + jsonData);
      out.print(jsonData);
      sendRequest(jsonData);
    } catch (Exception e) {
      e.printStackTrace();
      out.print("erreur" + e);
    }
  }

  protected void sendRequest(String jsonData) throws Exception {
    String serviceUrl = "http://127.0.0.1:8080/foncier/appli/propriete";
    URL url = new URL(serviceUrl);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Content-Type", "application/json");
    connection.setDoOutput(true);
    try (OutputStream os = connection.getOutputStream()) {
      byte[] input = jsonData.getBytes(StandardCharsets.UTF_8);
      os.write(input, 0, input.length);
    }
    connection.disconnect();
  }
}
