package org.obliquid.goodeatin;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ReadRestaurantRunner {

        @SuppressWarnings("unchecked")
        public final static void main(final String[] args) {
                List<Restaurant> restList = null;
                EntityManager em = EMF.get().createEntityManager();
                try {
                        Query query = em.createQuery("SELECT r FROM Restaurant r " +
                                        "WHERE name=\"Brett's House\" ORDER BY dateAdded DESC");
                        query.setMaxResults(3);
                        restList = query.getResultList();
                        System.out.println("restList=" + restList);
                } finally {
                        em.close();
                }
        }

}
