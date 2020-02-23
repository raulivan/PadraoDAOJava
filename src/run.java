import br.com.raulivan.dao.ContatoDAO;
import br.com.raulivan.entidade.Contato;

public class run {

	public static void main(String[] args) {
		
		try {
			
			//Exemplo de uso
			Contato contato = new Contato();
			contato.setNome("Raulivan Rodrigo");
			contato.setTelefone("1234567890");
			
			ContatoDAO dao = new ContatoDAO();
			dao.incluir(contato);
			
			System.out.println("Excecutou com sucesso!");
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
