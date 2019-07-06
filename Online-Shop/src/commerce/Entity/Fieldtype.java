package commerce.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fieldtype database table.
 * 
 */
@Entity
@NamedQuery(name="Fieldtype.findAll", query="SELECT f FROM Fieldtype f")
public class Fieldtype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	//bi-directional many-to-one association to Field
	@OneToMany(mappedBy="fieldtype")
	private List<Field> fields;

	public Fieldtype() {
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

	public List<Field> getFields() {
		return this.fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public Field addField(Field field) {
		getFields().add(field);
		field.setFieldtype(this);

		return field;
	}

	public Field removeField(Field field) {
		getFields().remove(field);
		field.setFieldtype(null);

		return field;
	}

}