package commerce.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the field database table.
 * 
 */
@Entity
@NamedQuery(name="Field.findAll", query="SELECT f FROM Field f")
public class Field implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Boolean canempty;

	private String defaultval;

	private String name;

	private Long priority;

	//bi-directional many-to-one association to Choosecat
	@ManyToOne
	@JoinColumn(name="choosecat")
	private Choosecat choosecatBean;

	//bi-directional many-to-one association to Fieldcat
	@ManyToOne
	@JoinColumn(name="fieldcatfk")
	private Fieldcat fieldcat;

	//bi-directional many-to-one association to Fieldtype
	@ManyToOne
	@JoinColumn(name="fieldtypefk")
	private Fieldtype fieldtype;

	//bi-directional many-to-one association to Fieldval
	@OneToMany(mappedBy="field")
	private List<Fieldval> fieldvals;

	public Field() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getCanempty() {
		return this.canempty;
	}

	public void setCanempty(Boolean canempty) {
		this.canempty = canempty;
	}

	public String getDefaultval() {
		return this.defaultval;
	}

	public void setDefaultval(String defaultval) {
		this.defaultval = defaultval;
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

	public Choosecat getChoosecatBean() {
		return this.choosecatBean;
	}

	public void setChoosecatBean(Choosecat choosecatBean) {
		this.choosecatBean = choosecatBean;
	}

	public Fieldcat getFieldcat() {
		return this.fieldcat;
	}

	public void setFieldcat(Fieldcat fieldcat) {
		this.fieldcat = fieldcat;
	}

	public Fieldtype getFieldtype() {
		return this.fieldtype;
	}

	public void setFieldtype(Fieldtype fieldtype) {
		this.fieldtype = fieldtype;
	}

	public List<Fieldval> getFieldvals() {
		return this.fieldvals;
	}

	public void setFieldvals(List<Fieldval> fieldvals) {
		this.fieldvals = fieldvals;
	}

	public Fieldval addFieldval(Fieldval fieldval) {
		getFieldvals().add(fieldval);
		fieldval.setField(this);

		return fieldval;
	}

	public Fieldval removeFieldval(Fieldval fieldval) {
		getFieldvals().remove(fieldval);
		fieldval.setField(null);

		return fieldval;
	}

}