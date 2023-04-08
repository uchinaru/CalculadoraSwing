package estudos.swing.java.calc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

	private enum TipoComando {
		ZERAR, NUMERO, DIV, MULT, SUB, SOMA, IGUAL, VIRGULA;

	}

	private static final Memoria instancia = new Memoria();
	private final List<MemoriaObservador> observadores = new ArrayList<>();

	private TipoComando ultimaOperacao = null;
	private boolean substituir = false;
	private String textoAtual = "";
	private String textoBuffer = "";

	private Memoria() {

	}

	public static Memoria getInstancia() {
		return instancia;
	}

	public void adicionarObservador(MemoriaObservador m) {
		observadores.add(m);
	}

	public String getTextoAtual() {

		return textoAtual.isEmpty() ? "0" : textoAtual;
	}

	public void processarComando(String valor) {

		TipoComando tipoComando = detectarTipoComando(valor);
		
		if (tipoComando == null) {
			return;
		} else if (tipoComando == TipoComando.ZERAR) {
			textoAtual ="";
			textoBuffer ="";
			substituir = false;
			ultimaOperacao = null;
		} else if (tipoComando == TipoComando.NUMERO || tipoComando == TipoComando.VIRGULA) {
			textoAtual = substituir ? valor : textoAtual + valor;
			substituir = false;
			
		}

		observadores.forEach(o -> o.valorAlterado(getTextoAtual()));

	}

	private TipoComando detectarTipoComando(String valor) {

		if (textoAtual.isEmpty() && textoAtual == "0") {
			return null;
		}

		try {

			Integer.parseInt(valor);
			return TipoComando.NUMERO;

		} catch (NumberFormatException e) {
			if ("AC".equals(valor)) {
				return TipoComando.ZERAR;
			} else if ("/".equals(valor)) {
				return TipoComando.DIV;
			} else if ("*".equals(valor)) {
				return TipoComando.MULT;
			} else if ("+".equals(valor)) {
				return TipoComando.SOMA;
			} else if ("=".equals(valor)) {
				return TipoComando.IGUAL;
			} else if (",".equals(valor) && !textoAtual.contains(",")) {
				return TipoComando.VIRGULA;
			} else if ("-".equals(valor)) {
				return TipoComando.SUB;
			}

		}

		return null;

	}

}
