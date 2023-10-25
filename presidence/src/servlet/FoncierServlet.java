package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FoncierServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        try {
            String jsonData = request.getReader().lines().collect(java.util.stream.Collectors.joining());
            System.out.println("Données JSON reçues : " + jsonData);
            out.print(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
            out.print("erreur" + e);
        }
    }

}
