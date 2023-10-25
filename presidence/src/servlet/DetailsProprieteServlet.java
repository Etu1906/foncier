package servlet;

import foncier.Propriete;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailsProprieteServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    try {
      String idp = req.getParameter("idpropriete");
      Propriete p = new Propriete(idp);
      p.complete();
      req.setAttribute("propriete", p);
      RequestDispatcher dispat = req.getRequestDispatcher("details.jsp");
      dispat.forward(req, resp);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
