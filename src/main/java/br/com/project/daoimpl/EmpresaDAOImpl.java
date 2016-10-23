/**
 * 
 */
package br.com.project.daoimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.project.dao.EmpresaDAO;
import br.com.project.modelo.Empresa;
import br.com.project.vo.EmpresaVO;

/**
 * @author Maçana
 *
 */

@Repository
public class EmpresaDAOImpl implements EmpresaDAO{

private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> buscarEmpresasPorFiltro(String estado) {
	
		StringBuilder jpql = new StringBuilder();
		
		jpql.append("FROM Empresa e");
		
		if(estado != null)
			jpql.append(" WHERE e.enderecoEmpresa.uf = ?1");
		
		Query query = entityManager.createQuery(jpql.toString());
		
		if(estado != null)
			query.setParameter(1, estado);
		
		return (List<Empresa>) query.getResultList();
	}
	
	@Override
	public Empresa consultaPorIdt(Integer idtEmpresa){
		try{
			return entityManager.find(Empresa.class, idtEmpresa);
		}catch(NoResultException nre){
			return null;
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> buscarEmpresasPorLatLong(String latitude, String longitude, String raio, String perfil){
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT e.idt_empresa, e.nome_empresa, ee.bairro, ee.complemento_endereco, ee.logradouro, ee.numero, ee.NUM_CEP, ee.latitude, ee.longitude, pe.descricao_perfil,"); 
		sql.append(" ( 3959 *");
		sql.append(" acos( cos( radians(?1) ) * cos( radians( latitude ) ) *");
		sql.append(" cos( radians( longitude ) - radians(?2) ) + sin( radians(?1) ) * sin( radians( latitude ) ) ) ) AS distance");
		sql.append(" FROM endereco_empresa ee");
		sql.append(" inner join empresa e on e.idt_endereco = ee.idt_endereco");
		sql.append(" inner join perfilempresa pe on pe.idt_perfil = e.idt_perfil");
		sql.append(" where pe.idt_perfil = ?4");
		sql.append(" HAVING distance < ?3 ORDER BY distance LIMIT 0, 100");
		
		Query query = entityManager.createNativeQuery(sql.toString());
		
		query.setParameter(1, latitude);
		query.setParameter(2, longitude);
		query.setParameter(3, raio);
		query.setParameter(4, perfil);
		
		List<Object[]> list = query.getResultList();
		/*String idtsEmpresas = new String();
		
		for(Object object : list){
			idtsEmpresas = idtsEmpresas.concat(object.toString().concat(","));	
		}
		idtsEmpresas = idtsEmpresas.substring(0,idtsEmpresas.length() -1);
		 
		return idtsEmpresas;*/
		return list;
	}

	@Override
	public List<Empresa> consultaPorIdts(String idtsEmpresas) {
		try{
			StringBuilder sql = new StringBuilder();
			
			sql.append("FROM Empresa e WHERE e.idtEmpresa in (?1)");
			
			Query query = entityManager.createQuery(sql.toString());
			
			query.setParameter(1, idtsEmpresas);
			
			return (List<Empresa>) query.getResultList();
		}catch(NoResultException nre){
			return null;
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
}
