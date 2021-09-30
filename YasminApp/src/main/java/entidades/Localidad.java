package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Table(name = "localidad")

@NoArgsConstructor
@AllArgsConstructor
@Getter 

@Setter
@Builder 
@Audited

public class Localidad extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "denominacion")
	private String denominacion;
	
	
	
	
	
	
	
	
	
}


