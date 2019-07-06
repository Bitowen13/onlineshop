package accounting.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the factsituation database table.
 * 
 */
@Entity
@NamedQuery(name="Factsituation.findAll", query="SELECT f FROM Factsituation f")
public class Factsituation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String situation;

	//bi-directional many-to-one association to Buyfact
	@OneToMany(mappedBy="factsituation")
	private List<Buyfact> buyfacts;

	//bi-directional many-to-one association to Sellfact
	@OneToMany(mappedBy="factsituation")
	private List<Sellfact> sellfacts;

	public Factsituation() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSituation() {
		return this.situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public List<Buyfact> getBuyfacts() {
		return this.buyfacts;
	}

	public void setBuyfacts(List<Buyfact> buyfacts) {
		this.buyfacts = buyfacts;
	}

	public Buyfact addBuyfact(Buyfact buyfact) {
		getBuyfacts().add(buyfact);
		buyfact.setFactsituation(this);

		return buyfact;
	}

	public Buyfact removeBuyfact(Buyfact buyfact) {
		getBuyfacts().remove(buyfact);
		buyfact.setFactsituation(null);

		return buyfact;
	}

	public List<Sellfact> getSellfacts() {
		return this.sellfacts;
	}

	public void setSellfacts(List<Sellfact> sellfacts) {
		this.sellfacts = sellfacts;
	}

	public Sellfact addSellfact(Sellfact sellfact) {
		getSellfacts().add(sellfact);
		sellfact.setFactsituation(this);

		return sellfact;
	}

	public Sellfact removeSellfact(Sellfact sellfact) {
		getSellfacts().remove(sellfact);
		sellfact.setFactsituation(null);

		return sellfact;
	}

}