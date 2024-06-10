package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Alumno;

public class ListadoAlumnos {
	public static List<Alumno> alumnos = new ArrayList<Alumno>();

	public static List<Alumno> listarAlumnos() {
		List<Alumno> aux = new ArrayList<Alumno>();
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getEstado()) {
				aux.add(alumnos.get(i));
			}
		}
		return aux;
	}

	public static Alumno buscarAlumnoPorDni(String dni) {
		for (Alumno alumno : alumnos) {
			if (alumno.getDni().equals(dni) && alumno.getEstado()) {
				return alumno;
			}
		}
		return null;
	}

	public static void agregarAlumno(Alumno alumno) {
		alumno.setEstado(true);
		alumnos.add(alumno);
	}

	public static void modificarAlumno(Alumno alumnoModificado) {
		for (int i = 0; i < alumnos.size(); i++) {
			Alumno alumno = alumnos.get(i);
			if (alumno.getDni().equals(alumnoModificado.getDni()) && alumno.getEstado()) {
				alumnoModificado.setEstado(true);;
				alumnos.set(i, alumnoModificado);
				break;
			}
		}
	}

	public static void eliminarAlumno(String DNI) {
		for (int i = 0; i < alumnos.size(); i++) {
			Alumno alumno = alumnos.get(i);
			if (alumno.getDni().equals(DNI) && alumno.getEstado()) {
				alumno.setEstado(false);
				break;
			}
		}
	}
}