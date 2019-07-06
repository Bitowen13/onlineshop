package commerce.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the chooseval database table.
 * 
 */
@Entity
@NamedQuery(name="Chooseval.findAll", query="SELECT c FROM Chooseval c")
public class Chooseval implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	//bi-directional many-to-one association to Choosecat
	@ManyToOne
	@JoinColumn(name="choosecatfk")
	private Choosecat choosecat;

	//bi-directional many-to-one association to Fieldval
	@OneToMany(mappedBy="chooseval")
	private List<Fieldval> fieldvals;

	public Chooseval() {
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

	public Choosecat getChoosecat() {
		return this.choosecat;
	}

	public void setChoosecat(Choosecat choosecat) {
		this.choosecat = choosecat;
	}

	public List<Fieldval> getFieldvals() {
		return this.fieldvals;
	}

	public void setFieldvals(List<Fieldval> fieldvals) {
		this.fieldvals = fieldvals;
	}

	public Fieldval addFieldval(Fieldval fieldval) {
		getFieldvals().add(fieldval);
		fieldval.setChooseval(this);

		return fieldval;
	}

	public Fieldval removeFieldval(Fieldval fieldval) {
		getFieldvals().remove(fieldval);
		fieldval.setChooseval(null);

		return fieldval;
	}

}