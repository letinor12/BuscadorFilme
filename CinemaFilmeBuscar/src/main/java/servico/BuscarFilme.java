package servico;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import modelo.Filme;
import com.google.gson.Gson;



public class BuscarFilme {

	private String chaveApi = System.getenv("OMDB_API_KEY");
	public Filme buscar(String nomeFilme) throws IOException {
		
		 String url = "https://www.omdbapi.com/?t="
	                + nomeFilme.replace(" ", "+")
	                + "&apikey="
	                + chaveApi;

	        OkHttpClient client = new OkHttpClient();

	        Request request = new Request.Builder()
	                .url(url)
	                .build();

	        try (Response response = client.newCall(request).execute()) {

	            if (!response.isSuccessful()) {
	                throw new IOException(
	                    "Erro na comunicação com a API: " + response.code()
	                );
	            }

	            String json = response.body().string();

	            Gson gson = new Gson();

	            return gson.fromJson(json, Filme.class);
	        }
	    }
	}
