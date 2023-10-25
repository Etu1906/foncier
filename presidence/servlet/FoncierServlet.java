package servlet;

import java.io.IOException;
import java.lang.reflect.Type;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebServlet("/foncier")
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
            HttpSession session = request.getSession();
            session.setAttribute("coordonnee", jsonData);
        } catch (Exception e) {
            e.printStackTrace();
            out.print("erreur" + e);
        }
    }

}
