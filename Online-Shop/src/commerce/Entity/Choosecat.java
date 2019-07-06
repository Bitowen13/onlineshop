package commerce.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the choosecat database table.
 * 
 */
@Entity
@NamedQuery(name="Choosecat.findAll", query="SELECT c FROM Choosecat c")
public class Choosecat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	//bi-directional many-to-one association to Chooseval
	@OneToMany(mappedBy="choosecat")
	private List<Chooseval> choosevals;

	//bi-directional many-to-one association to Field
	@OneToMany(mappedBy="choosecatBean")
	private List<Field> fields;

	public Choosecat() {
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

	public List<Chooseval> getChoosevals() {
		return this.choosevals;
	}

	public void setChoosevals(List<Chooseval> choosevals) {
		this.choosevals = choosevals;
	}

	public Chooseval addChooseval(Chooseval chooseval) {
		getChoosevals().add(chooseval);
		chooseval.setChoosecat(this);

		return chooseval;
	}

	public Chooseval removeChooseval(Chooseval chooseval) {
		getChoosevals().remove(chooseval);
		chooseval.setChoosecat(null);

		return chooseval;
	}

	public List<Field> getFields() {
		return this.fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public Field addField(Field field) {
		getFields().add(field);
		field.setChoosecatBean(this);

		return field;
	}

	public Field removeField(Field field) {
		getFields().remove(field);
		field.setChoosecatBean(null);

		return field;
	}

}