package repositorio;

import java.util.ArrayList;
import java.util.List;
import modelo.Filme;


public class FilmeRepositorio {

	private List<Filme> filmes = new ArrayList<>();
	
	public void adicionar (Filme filme) {
		filmes.add(filme);
	}
	
	public List<Filme>listar(){
		return filmes;
	}
}
