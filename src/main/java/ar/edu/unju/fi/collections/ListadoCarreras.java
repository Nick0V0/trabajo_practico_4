package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Carrera;

public class ListadoCarreras {
    @SuppressWarnings("serial")
	public static List<Carrera> carreras = new ArrayList<Carrera>() {
        {
            add(new Carrera("1", "Ingeniería Informática", 5, true));
            add(new Carrera("2", "Licenciatura en Administración", 4, true));
            add(new Carrera("3", "Arquitectura", 6, true));
        }
    };

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