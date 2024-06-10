package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Materia;

public class ListadoMaterias {
	public static List<Materia> materias = new ArrayList<Materia>();

	public static List<Materia> listarMaterias() {
		List<Materia> aux = new ArrayList<Materia>();
		for (int i = 0; i < materias.size(); i++) {
			if (materias.get(i).getEstado()) {
				aux.add(materias.get(i));
			}
		}
		return aux;
	}

	public static Materia buscarMateriaPorCodigo(String codigo) {
		for (Materia materia : materias) {
			if (materia.getCodigo().equals(codigo) && materia.getEstado()) {
				return materia;
			}
		}
		return null;
	}

	public static void agregarMateria(Materia materia) {
		materia.setEstado(true);
		materias.add(materia);
	}

	public static void modificarMateria(Materia materiaModificada) {
		for (int i = 0; i < materias.size(); i++) {
			Materia materia = materias.get(i);
			if (materia.getCodigo().equals(materiaModificada) && materia.getEstado()) {
				materiaModificada.setEstado(true);
				materias.set(i, materiaModificada);
				break;
			}
		}
	}

	public static void eliminarMateria(String codigo) {
		for (int i = 0; i < materias.size(); i++) {
			Materia materia = materias.get(i);
			if (materia.getCodigo().equals(codigo) && materia.getEstado()) {
				materia.setEstado(false);
				break;
			}

		}
	}
}