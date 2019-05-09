package Mysql_Codes;

import javax.persistence.*;

public class run_DB {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("Backend_Demo");

    public static void main(String[] args) {

        addCustomer(999,3639);
        getCustomer(1);
        ENTITY_MANAGER_FACTORY.close();
    }

    public static void addCustomer(int id, int col) {
        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction et = null;

        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();

            // Create and set values for new customer
            Table1 table1 = new Table1();
            table1.setCol(col);
            table1.setId(id);

            // Save the customer object
            em.persist(table1);
            et.commit();
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }

    public static void getCustomer(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        // the lowercase c refers to the object
        // :custID is a parameterized query thats value is set below
        String query = "SELECT c FROM Table1 c WHERE c.id = :id";

        // Issue the query and get a matching Customer
        TypedQuery<Table1> tb = em.createQuery(query, Table1.class);
        tb.setParameter("id", id);

        Table1 tab = null;
        try {
            // Get matching customer object and output
            tab = tb.getSingleResult();
            System.out.println(tab.getId() + " " + tab.getCol());
        }
        catch(NoResultException ex) {
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
    }

}
