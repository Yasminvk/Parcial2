package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity

@Table(name = "libro")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Audited

public class Libro extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "genero")
	private String genero;
	@Column(name = "autor")
	private String autores; 
	@Column(name = "fecha")
	private int fecha;
	@Column(name = "paginas")
	private int paginas;
	
	
	
	@ManyToMany(cascade = {CascadeType.ALL, CascadeType.REFRESH})
	@JoinTable(
			
			name = "libro_autor",
			joinColumns = @JoinColumn(name = "id_libros"),
			inverseJoinColumns = @JoinColumn(name = "author_id")
			)
	
	@Builder.Default
	private List<Autor> authors = new ArrayList<Autor>(); 
	
	
	
	
	
	
}
