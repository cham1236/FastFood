package src.br.ufrpe.fastFood.interfaces;

import java.util.List;

import src.br.ufrpe.fastFood.beans.Venda;
import src.br.ufrpe.fastFood.exceptions.ONFException;

public interface RepositorioVendaInterface {
	
	
	void cadastrarVenda(Venda v);
	
	Venda buscarVenda(String idVenda) throws ONFException;
	
	void removerVenda(String idVenda) throws ONFException;
	
	List<Venda> listarVendas();
	
	int procurarIndiceV(String idVenda);
	
	void save();
	
	
	

}
