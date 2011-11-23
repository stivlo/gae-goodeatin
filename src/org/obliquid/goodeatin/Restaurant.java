package org.obliquid.goodeatin;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Restaurant {

        private Key id;

        private String name;

        private String description;

        private Date dateAdded;

        private String address;

        /**
         * @return the id
         */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Key getId() {
                return id;
        }

        /**
         * @param id
         *                the id to set
         */
        public void setId(Key id) {
                this.id = id;
        }

        /**
         * @return the name
         */
        public String getName() {
                return name;
        }

        /**
         * @param name
         *                the name to set
         */
        public void setName(String name) {
                this.name = name;
        }

        /**
         * @return the description
         */
        public String getDescription() {
                return description;
        }

        /**
         * @param description
         *                the description to set
         */
        public void setDescription(String description) {
                this.description = description;
        }

        /**
         * @return the dateAdded
         */
        public Date getDateAdded() {
                return dateAdded;
        }

        /**
         * @param dateAdded
         *                the dateAdded to set
         */
        public void setDateAdded(Date dateAdded) {
                this.dateAdded = dateAdded;
        }

        /**
         * @return the address
         */
        public String getAddress() {
                return address;
        }

        /**
         * @param address
         *                the address to set
         */
        public void setAddress(String address) {
                this.address = address;
        }

        @Override
        public String toString() {
                return getName();
        }

}
