package commerce.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fieldcat database table.
 * 
 */
@Entity
@NamedQuery(name="Fieldcat.findAll", query="SELECT f FROM Fieldcat f")
public class Fieldcat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Long priority;

	//bi-directional many-to-one association to Field
	@OneToMany(mappedBy="fieldcat")
	private List<Field> fields;

	//bi-directional many-to-one association to Subbranch
	@ManyToOne
	@JoinColumn(name="subbranchfk")
	private Subbranch subbranch;

	public Fieldcat() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPriority() {
		return this.priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public List<Field> getFields() {
		return this.fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public Field addField(Field field) {
		getFields().add(field);
		field.setFieldcat(this);

		return field;
	}

	public Field removeField(Field field) {
		getFields().remove(field);
		field.setFieldcat(null);

		return field;
	}

	public Subbranch getSubbranch() {
		return this.subbranch;
	}

	public void setSubbranch(Subbranch subbranch) {
		this.subbranch = subbranch;
	}

}