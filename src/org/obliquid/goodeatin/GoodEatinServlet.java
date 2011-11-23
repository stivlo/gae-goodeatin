package org.obliquid.goodeatin;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class GoodEatinServlet extends HttpServlet {

        private static Logger logger = Logger.getLogger(GoodEatinServlet.class.getName());

        @Override
        @SuppressWarnings("unchecked")
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,
                        ServletException {
                List<Restaurant> restList = null;
                EntityManager em = EMF.get().createEntityManager();
                try {
                        Query query = em.createQuery("SELECT r FROM Restaurant r ORDER BY dateAdded DESC");
                        //instead of using setFirstResult(), for paging, figure the key of the last
                        //one and use WHERE, to find keys greater than it.
                        //query.setFirstResult(0);
                        query.setMaxResults(3);
                        restList = query.getResultList();
                        req.setAttribute("restaurants", restList);
                        logger.fine("Restaurants: " + req.getAttribute("restaurants"));
                        RequestDispatcher view = req.getRequestDispatcher("WEB-INF/jsp/listView.jsp");
                        view.forward(req, resp);
                } finally {
                        em.close();
                }
        }

}
