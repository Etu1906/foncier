package servlet;

import java.io.IOException;
import java.lang.reflect.Type;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import foncier.Coordonnees;

@WebServlet("/ajout_coord")
public class AjoutCoordonneeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        try {
            String adresse = request.getParameter("adresse");
            String idcin = request.getParameter("idcin");
            String nb_coord = request.getParameter("nb_coord");
            int nbr = Integer.parseInt( nb_coord );
            List<Coordonnees> l_coordonnees = new ArrayList<Coordonnees>();

            System.out.println( adresse +idcin + nb_coord + nbr  );

            for( int i = 1 ; i<= nbr ; i++ ){
                Coordonnees coordonnees = new Coordonnees();
                coordonnees.setLongitude( request.getParameter("longitude"+i) );
                coordonnees.setLatitude(request.getParameter("latitude"+i)   );
                l_coordonnees.add(coordonnees);
            }

            for (Coordonnees coord: l_coordonnees) {
                System.out.println( coord.getLongitude() +"  " +coord.getLatitude() );
            }



        }catch( Exception e ){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/liste.jsp");
        dispatcher.forward(request, response);

    }

}