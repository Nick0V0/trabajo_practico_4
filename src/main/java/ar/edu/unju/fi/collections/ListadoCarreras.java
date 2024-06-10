package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Carrera;

public class ListadoCarreras {
	public static List<Carrera> carreras = new ArrayList<Carrera>();

	public static List<Carrera> listarCarreras() {
		List<Carrera> aux = new ArrayList<Carrera>();
		for (int i = 0; i < carreras.size(); i++) {
			if (carreras.get(i).getEstado()) {
				aux.add(carreras.get(i));
			}
		}
		return aux;
	}

	public static Carrera buscarCarreraPorCodigo(String codigo) {
		for (Carrera c : carreras) {
			if (c.getCodigo().equals(codigo) && c.getEstado()) {
				return c;
			}
		}
		return null;
	}

	public static void agregarCarrera(Carrera carrera) {
		carrera.setEstado(true);
		carreras.add(carrera);
	}

	public static void modificarCarrera(Carrera carreraModificada) {
		for (int i = 0; i < carreras.size(); i++) {
			Carrera carrera = carreras.get(i);
			if (carrera.getCodigo().equals(carreraModificada.getCodigo()) && carrera.getEstado()) {
				carreraModificada.setEstado(true);
				carreras.set(i, carreraModificada);
				break;
			}
		}
	}

	public static void eliminarCarrera(String codigo) {
		for (int i = 0; i < carreras.size(); i++) {
			Carrera carrera = carreras.get(i);
			if (carrera.getCodigo().equals(codigo) && carrera.getEstado()) {
				carrera.setEstado(false);
				break;
			}
		}
	}
}