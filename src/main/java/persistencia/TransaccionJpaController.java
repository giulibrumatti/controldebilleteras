/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Transaccion;
import logica.Wallet;
import persistencia.exceptions.NonexistentEntityException;

public class TransaccionJpaController implements Serializable {

    public TransaccionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public TransaccionJpaController() {
       emf = Persistence.createEntityManagerFactory("ControlCuenta_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Transaccion transaccion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Wallet wallet = transaccion.getWallet();
            if (wallet != null) {
                wallet = em.getReference(wallet.getClass(), wallet.getId());
                transaccion.setWallet(wallet);
            }
            em.persist(transaccion);
            if (wallet != null) {
                wallet.getListaTransaciones().add(transaccion);
                wallet = em.merge(wallet);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Transaccion transaccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transaccion persistentTransaccion = em.find(Transaccion.class, transaccion.getTransactionId());
            Wallet walletOld = persistentTransaccion.getWallet();
            Wallet walletNew = transaccion.getWallet();
            if (walletNew != null) {
                walletNew = em.getReference(walletNew.getClass(), walletNew.getId());
                transaccion.setWallet(walletNew);
            }
            transaccion = em.merge(transaccion);
            if (walletOld != null && !walletOld.equals(walletNew)) {
                walletOld.getListaTransaciones().remove(transaccion);
                walletOld = em.merge(walletOld);
            }
            if (walletNew != null && !walletNew.equals(walletOld)) {
                walletNew.getListaTransaciones().add(transaccion);
                walletNew = em.merge(walletNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = transaccion.getTransactionId();
                if (findTransaccion(id) == null) {
                    throw new NonexistentEntityException("The transaccion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transaccion transaccion;
            try {
                transaccion = em.getReference(Transaccion.class, id);
                transaccion.getTransactionId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transaccion with id " + id + " no longer exists.", enfe);
            }
            Wallet wallet = transaccion.getWallet();
            if (wallet != null) {
                wallet.getListaTransaciones().remove(transaccion);
                wallet = em.merge(wallet);
            }
            em.remove(transaccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Transaccion> findTransaccionEntities() {
        return findTransaccionEntities(true, -1, -1);
    }

    public List<Transaccion> findTransaccionEntities(int maxResults, int firstResult) {
        return findTransaccionEntities(false, maxResults, firstResult);
    }

    private List<Transaccion> findTransaccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Transaccion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Transaccion findTransaccion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Transaccion.class, id);
        } finally {
            em.close();
        }
    }

    public int getTransaccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Transaccion> rt = cq.from(Transaccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
