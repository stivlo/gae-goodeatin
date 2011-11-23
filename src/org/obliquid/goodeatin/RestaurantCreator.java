package org.obliquid.goodeatin;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Save the list of Restaurants into the data store. Every top level entity has
 * to be saved in its own transaction.
 */
public class RestaurantCreator extends HttpServlet {

        private static final long serialVersionUID = 1L;

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                EntityManager em = EMF.get().createEntityManager();
                try {
                        EntityTransaction tx = em.getTransaction();
                        tx.begin();
                        Restaurant r = new Restaurant();
                        r.setName("Brett's House");
                        r.setDescription("Great food, pretty good company... sometimes.");
                        r.setAddress("123 South St.");
                        r.setDateAdded(new Date());
                        em.persist(r);
                        tx.commit();

                        tx = em.getTransaction();
                        tx.begin();
                        r = new Restaurant();
                        r.setName("Bob's BBQ");
                        r.setDescription("This place rocks!");
                        r.setAddress("12 Diamond St.");
                        r.setDateAdded(new Date());
                        em.persist(r);
                        tx.commit();

                        tx = em.getTransaction();
                        tx.begin();
                        r = new Restaurant();
                        r.setName("Potato House");
                        r.setDescription("This place has the biggest potatoes I've ever seen. Seriously.");
                        r.setAddress("8 Tropical St.");
                        r.setDateAdded(new Date());
                        em.persist(r);
                        tx.commit();
                } finally {
                        em.close();
                }
                response.getWriter().print("<b>Done...</b>");
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                        throws ServletException, IOException {
                EntityManager em = EMF.get().createEntityManager();
                try {
                        Restaurant r = new Restaurant();
                        r.setName(req.getParameter("name"));
                        r.setDescription(req.getParameter("description"));
                        r.setAddress(req.getParameter("address"));
                        r.setDateAdded(new Date());
                        em.persist(r);
                        resp.sendRedirect("goodEatin");
                } finally {
                        em.close();
                }
        }

}
