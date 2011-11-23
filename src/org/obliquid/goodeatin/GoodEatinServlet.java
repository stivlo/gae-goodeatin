package org.obliquid.goodeatin;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class GoodEatinServlet extends HttpServlet {

        private static Logger logger = Logger.getLogger(GoodEatinServlet.class.getName());

        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,
                        ServletException {

                // req.setAttribute("restaurants", restList);
                logger.fine("Restaurants: " + req.getAttribute("restaurants"));

                RequestDispatcher view = req.getRequestDispatcher("WEB-INF/jsp/listView.jsp");
                view.forward(req, resp);
        }

}
