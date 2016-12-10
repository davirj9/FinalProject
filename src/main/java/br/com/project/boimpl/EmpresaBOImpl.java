/**
 * 
 */
package br.com.project.boimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.project.bo.EmpresaBO;
import br.com.project.dao.EmpresaDAO;
import br.com.project.dao.EnderecoEmpresaDAO;
import br.com.project.dao.UsuarioDAO;
import br.com.project.modelo.Empresa;
import br.com.project.modelo.Usuario;
import br.com.project.vo.EmpresaVO;
import br.com.project.vo.EmpresaVO2;

/**
 * @author Maçana
 *
 */
@Service
public class EmpresaBOImpl implements EmpresaBO{
	
	@Autowired
	private EmpresaDAO empresaDAO;
	
	@Autowired
	private EnderecoEmpresaDAO enderecoEmpresaDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public Collection<EmpresaVO2> buscaEmpresasLatLong(String latitude, String longitude, String raio, String perfil){
		
		Collection<EmpresaVO2> empresas2 = new ArrayList<EmpresaVO2>(); 
		
		empresas2 = adicionarDadosEmpresas(empresaDAO.buscarEmpresasPorLatLong(latitude, longitude, raio, perfil));
		
		return empresas2;
	}
	
	@Override
	public Collection<EmpresaVO2> adicionarDadosEmpresas(List<Object[]> list){
		
		Collection<EmpresaVO2> empresas = new ArrayList<>();
		
		for(Object[] obj : list){
			EmpresaVO2 empresa = new EmpresaVO2();
			Object[] objUnit = (Object[]) obj;
			
			empresa.setIdtEmpresa((Integer) objUnit[0]);
			empresa.setNomeEmpresa((String) objUnit[1]);
			empresa.setBairro((String) objUnit[2]);
			empresa.setComplemento_endereco((String) objUnit[3]);
			empresa.setDescricao_logradouro((String) objUnit[4]);
			empresa.setNumero((String) objUnit[5]);
			empresa.setNumCep((String) objUnit[6]);
			empresa.setLatitude((String) objUnit[7]);
			empresa.setLongitude((String) objUnit[8]);
			empresa.setDescricaoPerfil((String) objUnit[9]);
			empresa.setDistancia((Double) objUnit[10]);
			
			empresas.add(empresa);
		}
		
		return empresas;
	}
	
	@Override
	public Collection<Empresa> buscaEmpresas(String estado){
		return empresaDAO.buscarEmpresasPorFiltro(estado);		
	}
	
	@Override
	public String getEstado(String latitude, String longitude) throws JSONException, Exception{
		
		String estado = null;
		JSONObject jsonObject = new JSONObject(
				readUrl("https://maps.google.com/maps/api/geocode/json?address="+latitude+","+longitude));

		if ("OK".equalsIgnoreCase(jsonObject.getString("status"))) {
			for (int i = 1; i < ((JSONArray) jsonObject.get("results")).length() - 2; i++) {

				JSONArray addrComp = ((JSONArray) jsonObject.get("results")).getJSONObject(i)
						.getJSONArray("address_components");
				for (int j = 0; j < addrComp.length(); j++) {
					String adminArea = ((JSONArray) ((JSONObject) addrComp.get(j)).get("types")).getString(0);
					if (adminArea.compareTo("administrative_area_level_1") == 0) {
						estado = ((JSONObject) addrComp.get(j)).getString("short_name");
						break;
					}
				}
			}
		}
		return estado;
	}

	@Override
	public String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}
	
	@Override
	@Transactional
	public EmpresaVO adicionaEditaEmpresa(EmpresaVO empresaVO) throws Exception{
		
		empresaVO.setIdtEnderecoEmpresa(enderecoEmpresaDAO.idtEndereco());
		empresaVO.setIdtEmpresa(empresaDAO.idtEmpresa());
		
		enderecoEmpresaDAO.inserir(empresaVO);
		empresaDAO.inserir(empresaVO);
		
		return empresaVO;
	}
	
	@Override
	public List<Empresa> retornaEmpresasPorUsuario(Usuario usuario){
		
		return empresaDAO.retornaEmpresasPorUsuario(usuario);
	}

	@Override
	@Transactional
	public void excluirEmpresa(String idtEmpresa) {
		Empresa empresa = empresaDAO.consultaPorIdt(Integer.parseInt(idtEmpresa));
		empresaDAO.excluirEmpresa(empresa);
	}
}
