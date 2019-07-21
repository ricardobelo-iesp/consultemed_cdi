/**
 * 
 */
package br.com.consultemed.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author carlosbarbosagomesfilho
 *
 */
@SuppressWarnings("serial")
@NamedQueries({
	@NamedQuery(name = "Medico.findAllCount", query = "SELECT COUNT(c) FROM Medico c"),
	@NamedQuery(name="Medico.findAll", query="SELECT c FROM Medico c")
})
@Entity
@Table(name="TB_MEDICOS")
public class Medico extends AbstractEntity<Long> {

	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	public Medico() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
