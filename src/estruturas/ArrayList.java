package estruturas;

/**
 * Cria uma array, na qual insere objetos
 * 
 * @author Luiz Felipe Souza
 *
 */
public class ArrayList {

	private static Object[] array = new Object[1];
	
	/**
	 * Adiciona um novo objeto à lista
	 * 
	 * @param object Item a ser adicionado na lista
	 */
	public void adicionar(Object object) {
		if (array[0] == null) {
			array[0] = object;
		}

		else {
			int tamanho = array.length + 1;
			Object[] aux = new Object[tamanho];
			aux[tamanho - 1] = object;
			for (int i = 0; i < tamanho - 1; i++) {
				aux[i] = array[i];
			}
			ArrayList.array = aux;
		}
	}

}
