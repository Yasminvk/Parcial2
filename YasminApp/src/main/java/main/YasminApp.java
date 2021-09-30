package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Autor;
import entidades.Domicilio;
import entidades.Libro;
import entidades.Localidad;
import entidades.Persona;

public class YasminApp {

	public static void main(String [] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("YasminAppPU");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			/*Persona persona = new Persona("Yasmin", "Vecchetti", 43828911);*/
			
			Persona persona = Persona.builder().nombre("Yasmin").apellido("Vecchetti").dni(43828911).build();
			
			/*Domicilio domicilio1 = new Domicilio("Las Gardenias", 2198);
			persona.setDomicilio(domicilio1); */
			
			Domicilio domicilio = Domicilio.builder().nombre("Las Gardenias").numero(2198).build();
			
			persona.setDomicilio(domicilio);
			
			/*Localidad localidad = new Localidad("Ciudad");
			domicilio1.setLocalidad(localidad);*/
			
			Localidad localidad = Localidad.builder().denominacion("Guaymallen").build(); 
			
			domicilio.setLocalidad(localidad);
			
			
			
			
			/*Libro libro1 = new Libro("Carrie", "terror" , "Stephen King" , 2001, 2000);
			
			persona.getLibros().add(libro1); */
			
			Libro libro = Libro.builder().titulo("Carrie").genero("Terror").autores("Stephen King").fecha(2001).paginas(2000).build();
			
			persona.getLibros().add(libro);
			
			/*Autor autor = new Autor("Stephen", "King", "Biografia");
			
			libro1.getAuthors().add(autor); */
			
			Autor autor = Autor.builder().nombre("Stephen").apellido("King").biografia("biografia").build();
			
			libro.getAuthors().add(autor);
			
			em.persist(persona);
			
			em.flush(); 
			em.getTransaction().commit(); 
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			
		}
		
		em.close(); 
		emf.close(); 
	}
}
