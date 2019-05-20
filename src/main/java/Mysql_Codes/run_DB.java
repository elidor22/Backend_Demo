package Mysql_Codes;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.*;


public class run_DB {
    private static SessionFactory factory;
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("Backend_Demo");

    public static void main(String[] args) {
       addCustomer("THe painkiller","great");

    }

    public static void addCustomer(String myid, String stringcol) {
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
            table1.setName(stringcol);
            table1.setEmail(myid);
            //table1.setCol(99988989);

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

    public static void getId(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        // the lowercase c refers to the object
        // :custID is a parameterized query that's value is set below
        String query = "FROM Table1 T WHERE T.email = :id";

        // Issue the query and get a matching Customer
        TypedQuery<Table1> tb = em.createQuery(query, Table1.class);
        tb.setParameter("id", id);
        Table1 tab;
        try {
            // Get matching customer object and output
            tab = tb.getSingleResult();
            System.err.println("Kjo o tab parti"+tab.getEmail() + " " );
        }
        catch(NoResultException ex) {
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
    }

    public static void deleteCustomer(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Table1 table1 = null;

        try {
            et = em.getTransaction();
            et.begin();
            table1 = em.find(Table1.class, id);
            em.remove(table1);
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

    public static void changeid(int id, String number) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        Table1 table1 = null;

        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();

            // Find customer and make changes
            table1 = em.find(Table1.class,id);
            table1.setEmail(number);

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
    public void updateEmployee(Integer idd, String id ){
         Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Table1 employee = (Table1)session.get(Table1.class, idd);
            employee.setEmail( id );
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

