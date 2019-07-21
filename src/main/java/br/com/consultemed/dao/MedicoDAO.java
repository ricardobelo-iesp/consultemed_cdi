/**
 * 
 */
package br.com.consultemed.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultemed.model.Medico;
import br.com.consultemed.utils.JPAUtils;

/**
 * @author carlosbarbosagomesfilho Classe responável pelo acesso aos dados no
 *         banco.
 */
public class MedicoDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();

	public void salvar(Medico medico) {
		
		this.factory.getTransaction().begin();
		this.factory.persist(medico);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public void remover(Long idContato) {
		
		this.factory.getTransaction().begin();
		this.factory.remove(buscaPorId(idContato));
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public Medico buscaPorId(Long idMedico) {
		this.factory.getTransaction().begin();
		Medico medicoRemover = this.factory.find(Medico.class, idMedico);
		return medicoRemover;
	}
	
	public Medico buscaPorNome(String nome) {
		this.factory.getTransaction().begin();
		Query query = 
				this.factory.createQuery("SELECT c FROM Medico c WHERE c.nome = :nome");
		query.setParameter("nome", nome);
		Medico contato = (Medico) query.getSingleResult();
		return contato;
	}
	
	
	public Medico buscaPorEmail(String email) {
		this.factory.getTransaction().begin();
		Query query = 
				this.factory.createQuery("SELECT c FROM Contato c WHERE c.email = :email" );
		query.setParameter("email", email);
		Medico medico = (Medico) query.getSingleResult();
		return medico;
	}
	
	public void editar(Medico medico) {
		this.factory.getTransaction().begin();
		this.factory.merge(medico);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Medico> contatos(){
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT c FROM Contato c");
		List<Medico> contatos = query.getResultList(); 
		for (Medico contato : contatos) {
			System.out.println(contato.getNome());
		}
		
		this.factory.close();
		return contatos;
	}
}








