package principal;

import java.io.IOException;
import servico.BuscarFilme;
import modelo.Filme;
import java.util.Scanner;
import repositorio.FilmeRepositorio;

public class Principal {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		BuscarFilme buscar = new BuscarFilme();

		FilmeRepositorio repositorio = new FilmeRepositorio();
		int opcao = 0;

		while (opcao != 3) {
			System.out.println("\nMENU");
			System.out.println("1- Buscar filme");
			System.out.println("2- Historico de filmes pesquisados");
			System.out.println("3- Sair");
			System.out.println("Escolha uma opcao: ");

			opcao = scanner.nextInt();
			scanner.nextLine();

			if (opcao == 1) {
				System.out.println("\nDigite o nome do filme: ");

				String nomeFilme = scanner.nextLine();
				Filme filme = buscar.buscar(nomeFilme);

				if (filme.getResponse().equalsIgnoreCase("False")) {
					System.out.println("Filme nao encontrado");
					System.out.println("Causa: " + filme.getError());

				} else {
					System.out.println("\n Filme encontrado! ");
					System.out.println("Título: " + filme.getTitle());
					System.out.println("Ano: " + filme.getYear());
					System.out.println("Gênero: " + filme.getGenre());
					System.out.println("Diretor: " + filme.getDirector());
					System.out.println("Sinopse: " + filme.getPlot());

					repositorio.adicionar(filme);
				}
			} else if (opcao == 2) {
				System.out.println("Historico de filmes pesquisados: ");
				if (repositorio.listar().isEmpty()) {
					System.out.println("Nenhum filme pesquisado");
				} else {
					for (Filme filme : repositorio.listar()) {
						System.out.println("- " + filme.getTitle() + "(" + filme.getYear() + ")");
					}
				}
			}

			else if (opcao == 3) {
				System.out.println("\nPrograma encerrado");
			} else {
				System.out.println("\nOpcao invalida");
			}
		}

		scanner.close();
	}
}
