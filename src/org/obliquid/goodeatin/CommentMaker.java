package org.obliquid.goodeatin;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CommentMaker extends HttpServlet {

        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                EntityManager em = EMF.get().createEntityManager();
                EntityTransaction tx = em.getTransaction();
                try {
                        tx.begin();
                        Restaurant r = em.find(Restaurant.class,
                                        Long.parseLong(req.getParameter("restaurantId")));
                        if (r != null) {
                                Comment c = new Comment();
                                c.setCommentText(req.getParameter("comment"));
                                r.getComments().add(c); //this is really bad style
                                em.persist(r);
                        }
                        tx.commit();
                } finally {
                        if (tx.isActive()) {
                                tx.rollback();
                        }
                }
                resp.sendRedirect("/goodEatin");
        }

}
