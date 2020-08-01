package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Alumno;
import model.Curso;
import service.AlumnosService;
import service.CursosService;

public class ManipularCursos {
	public static Scanner scan = new Scanner(System.in);
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static CursosService service = new CursosService();
	
	public static void main(String[] args) {
		//altaCurso();
		//verTodosLosCursos();
		//System.out.println("Total numero de cursos: " + service.totalCursos());
		AlumnosService aService = new AlumnosService();
		List<Alumno> alumnos = aService.matriculadosCursoDado("java");
		alumnos.forEach(a -> System.out.println(a.getNombre()));
	}
	
	private static void altaCurso() {
		System.out.println("Introduce nombre del curso:");
		String nombre = scan.nextLine();
		System.out.println("Introduce duracion del curso:");
		int duracion = Integer.parseInt(scan.nextLine());
		System.out.println("Introduce fecha inicio del curso en formato año-mes-dia:");
		String fecha = scan.nextLine();
		
		Date fechaInicio = null;
		try {
			fechaInicio = sdf.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(service.altaCurso(new Curso(0, nombre, duracion, fechaInicio))) {
			System.out.println("Curso añadido");
		} else {
			System.out.println("Error...");
		}
	}
	
	public static void verTodosLosCursos() {
		List<Curso> lista = service.recuperarCursos();
		lista.forEach(c -> System.out.println("Nombre del curso: " + c.getDenominacion() + ", duracion: " + c.getDuracion() + " horas, "
				+ "fecha inicio del curso: " + sdf.format(c.getFechaInicio())));
	}

}
