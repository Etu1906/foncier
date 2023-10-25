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

@WebServlet("/carte_ajout")
public class CarteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void deGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            String adresse = request.getParameter("adresse");
            String idcin = request.getParameter("idcin");
            String description = request.getParameter("descrption");
            String coordonne = (String) session.getAttribute("coordonnee");

            out.println(coordonne);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
