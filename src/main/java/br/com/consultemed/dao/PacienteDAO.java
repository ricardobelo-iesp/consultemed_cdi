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

import br.com.consultemed.model.Paciente;
import br.com.consultemed.utils.JPAUtils;

/**
 * @author carlosbarbosagomesfilho Classe responável pelo acesso aos dados no
 *         banco.
 */
public class PacienteDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();

	public void salvar(Paciente paciente) {
		
		this.factory.getTransaction().begin();
		this.factory.persist(paciente);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public void remover(Long idPaciente) {
		
		this.factory.getTransaction().begin();
		this.factory.remove(buscaPorId(idPaciente));
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public Paciente buscaPorId(Long idPaciente) {
		this.factory.getTransaction().begin();
		Paciente pacienteRemover = this.factory.find(Paciente.class, idPaciente);
		return pacienteRemover;
	}
	
	public Paciente buscaPorNome(String nome) {
		this.factory.getTransaction().begin();
		Query query = 
				this.factory.createQuery("SELECT c FROM Paciente c WHERE c.nome = :nome");
		query.setParameter("nome", nome);
		Paciente paciente = (Paciente) query.getSingleResult();
		return paciente;
	}
	
	
	public Paciente buscaPorEmail(String email) {
		this.factory.getTransaction().begin();
		Query query = 
				this.factory.createQuery("SELECT c FROM Paciente c WHERE c.email = :email" );
		query.setParameter("email", email);
		Paciente paciente = (Paciente) query.getSingleResult();
		return paciente;
	}
	
	public void editar(Paciente paciente) {
		this.factory.getTransaction().begin();
		this.factory.merge(paciente);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Paciente> pacientes(){
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT c FROM Paciente c");
		List<Paciente> pacientes = query.getResultList(); 
		for (Paciente paciente : pacientes) {
			System.out.println(paciente.getNome());
		}
		
		this.factory.close();
		return pacientes;
	}
}








