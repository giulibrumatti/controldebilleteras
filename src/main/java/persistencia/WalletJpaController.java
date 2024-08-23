/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Transaccion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Wallet;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Rombo del Tejar
 */
public class WalletJpaController implements Serializable {

    public WalletJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public WalletJpaController() {
       emf = Persistence.createEntityManagerFactory("ControlCuenta_PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Wallet wallet) {
        if (wallet.getListaTransaciones() == null) {
            wallet.setListaTransaciones(new ArrayList<Transaccion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Transaccion> attachedListaTransaciones = new ArrayList<Transaccion>();
            for (Transaccion listaTransacionesTransaccionToAttach : wallet.getListaTransaciones()) {
                listaTransacionesTransaccionToAttach = em.getReference(listaTransacionesTransaccionToAttach.getClass(), listaTransacionesTransaccionToAttach.getTransactionId());
                attachedListaTransaciones.add(listaTransacionesTransaccionToAttach);
            }
            wallet.setListaTransaciones(attachedListaTransaciones);
            em.persist(wallet);
            for (Transaccion listaTransacionesTransaccion : wallet.getListaTransaciones()) {
                Wallet oldWalletOfListaTransacionesTransaccion = listaTransacionesTransaccion.getWallet();
                listaTransacionesTransaccion.setWallet(wallet);
                listaTransacionesTransaccion = em.merge(listaTransacionesTransaccion);
                if (oldWalletOfListaTransacionesTransaccion != null) {
                    oldWalletOfListaTransacionesTransaccion.getListaTransaciones().remove(listaTransacionesTransaccion);
                    oldWalletOfListaTransacionesTransaccion = em.merge(oldWalletOfListaTransacionesTransaccion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Wallet wallet) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Wallet persistentWallet = em.find(Wallet.class, wallet.getId());
            List<Transaccion> listaTransacionesOld = persistentWallet.getListaTransaciones();
            List<Transaccion> listaTransacionesNew = wallet.getListaTransaciones();
            List<Transaccion> attachedListaTransacionesNew = new ArrayList<Transaccion>();
            for (Transaccion listaTransacionesNewTransaccionToAttach : listaTransacionesNew) {
                listaTransacionesNewTransaccionToAttach = em.getReference(listaTransacionesNewTransaccionToAttach.getClass(), listaTransacionesNewTransaccionToAttach.getTransactionId());
                attachedListaTransacionesNew.add(listaTransacionesNewTransaccionToAttach);
            }
            listaTransacionesNew = attachedListaTransacionesNew;
            wallet.setListaTransaciones(listaTransacionesNew);
            wallet = em.merge(wallet);
            for (Transaccion listaTransacionesOldTransaccion : listaTransacionesOld) {
                if (!listaTransacionesNew.contains(listaTransacionesOldTransaccion)) {
                    listaTransacionesOldTransaccion.setWallet(null);
                    listaTransacionesOldTransaccion = em.merge(listaTransacionesOldTransaccion);
                }
            }
            for (Transaccion listaTransacionesNewTransaccion : listaTransacionesNew) {
                if (!listaTransacionesOld.contains(listaTransacionesNewTransaccion)) {
                    Wallet oldWalletOfListaTransacionesNewTransaccion = listaTransacionesNewTransaccion.getWallet();
                    listaTransacionesNewTransaccion.setWallet(wallet);
                    listaTransacionesNewTransaccion = em.merge(listaTransacionesNewTransaccion);
                    if (oldWalletOfListaTransacionesNewTransaccion != null && !oldWalletOfListaTransacionesNewTransaccion.equals(wallet)) {
                        oldWalletOfListaTransacionesNewTransaccion.getListaTransaciones().remove(listaTransacionesNewTransaccion);
                        oldWalletOfListaTransacionesNewTransaccion = em.merge(oldWalletOfListaTransacionesNewTransaccion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = wallet.getId();
                if (findWallet(id) == null) {
                    throw new NonexistentEntityException("The wallet with id " + id + " no longer exists.");
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
            Wallet wallet;
            try {
                wallet = em.getReference(Wallet.class, id);
                wallet.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The wallet with id " + id + " no longer exists.", enfe);
            }
            List<Transaccion> listaTransaciones = wallet.getListaTransaciones();
            for (Transaccion listaTransacionesTransaccion : listaTransaciones) {
                listaTransacionesTransaccion.setWallet(null);
                listaTransacionesTransaccion = em.merge(listaTransacionesTransaccion);
            }
            em.remove(wallet);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Wallet> findWalletEntities() {
        return findWalletEntities(true, -1, -1);
    }

    public List<Wallet> findWalletEntities(int maxResults, int firstResult) {
        return findWalletEntities(false, maxResults, firstResult);
    }

    private List<Wallet> findWalletEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Wallet.class));
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

    public Wallet findWallet(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Wallet.class, id);
        } finally {
            em.close();
        }
    }

    public int getWalletCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Wallet> rt = cq.from(Wallet.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
