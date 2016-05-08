/**
 * 
 */
package br.com.project.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Maçana
 *
 */

@Entity
@Table(name="perfilEmpresa")
public class PerfilEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "idt_perfil")
	private Integer idtPerfil;
	
	
	
}
