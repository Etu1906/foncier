package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjoutCarte extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    String idcin = req.getParameter("idcin");
    req.setAttribute("idcin", idcin);
    RequestDispatcher dispatcher = req.getRequestDispatcher("carte.html");
    dispatcher.forward(req, resp);
  }
}
