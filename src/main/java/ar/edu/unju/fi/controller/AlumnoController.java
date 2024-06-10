package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoAlumnos;
import ar.edu.unju.fi.model.Alumno;

@Controller
public class AlumnoController {

	@Autowired
	Alumno nuevoAlumno = new Alumno();

	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		ModelAndView modelView = new ModelAndView("formAlumno");
		modelView.addObject("nuevoAlumno", nuevoAlumno);
		modelView.addObject("band", false);
		return modelView;
	}

	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoParaGuardar) {

		// guardar
		ListadoAlumnos.agregarAlumno(alumnoParaGuardar);

		// mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());

		return modelView;
	}

	@GetMapping("/borrarAlumno/{codigo}")
	public ModelAndView deleteAlumnoDelListado(@PathVariable(name = "codigo") String codigo) {
		// borrar
		ListadoAlumnos.eliminarAlumno(codigo);

		// mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());

		return modelView;
	}

	@GetMapping("/modificarAlumno/{dni}")
	public ModelAndView editAlumno(@PathVariable(name = "dni") String dni) {
		// buscar
		Alumno alumnoParaModificar = ListadoAlumnos.buscarAlumnoPorDni(dni);
		// mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formAlumno");
		modelView.addObject("nuevoAlumno", alumnoParaModificar);
		modelView.addObject("band", true);
		return modelView;
	}

	@PostMapping("/modificarAlumno")
	public ModelAndView updateAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoModificado) {

		// guardar
		ListadoAlumnos.modificarAlumno(alumnoModificado);

		// mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());

		return modelView;
	}
	
	@GetMapping("/alumnos")
	public ModelAndView showAlumnos() {
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());
		return modelView;		
	}
}
