package retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TesteApi{

	@GET("{cep}/json/")
	Call<Cep> getTime(@Path("cep") String cep);

}
