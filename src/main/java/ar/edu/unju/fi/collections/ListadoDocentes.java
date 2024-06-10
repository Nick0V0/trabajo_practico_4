package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Docente;

public class ListadoDocentes {
	public static List<Docente> docentes = new ArrayList<Docente>();

	public static List<Docente> listarDocentes() {
		List<Docente> aux = new ArrayList<Docente>();
		for (int i = 0; i < docentes.size(); i++) {
			if (docentes.get(i).getEstado()) {
				aux.add(docentes.get(i));
			}
		}
		return aux;
	}

	public static Docente buscarDocentePorLegajo(String legajo) {
		for (Docente docente : docentes) {
			if (docente.getLegajo().equals(legajo)&&docente.getEstado()) {
				return docente;
			}
		}
		return null;
	}

	public static void agregarDocente(Docente docente) {
		docente.setEstado(true);
		docentes.add(docente);
	}

	public static void modificarDocente(Docente docenteModificado) {
		for (int i = 0; i < docentes.size(); i++) {
			Docente docente = docentes.get(i);
			if (docente.getLegajo().equals(docenteModificado.getLegajo())&&docente.getEstado()) {
				docenteModificado.setEstado(true);
				docentes.set(i, docenteModificado);
				break;
			}
		}
	}

	public static void eliminarDocente(String legajo) {
		for (int i = 0; i < docentes.size(); i++) {
			Docente docente = docentes.get(i);
			if (docente.getLegajo().equals(legajo)&&docente.getEstado()) {
				docente.setEstado(false);
				break;
			}

		}
	}
}