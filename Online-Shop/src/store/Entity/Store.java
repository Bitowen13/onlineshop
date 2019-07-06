package store.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the store database table.
 * 
 */
@Entity
@NamedQuery(name="Store.findAll", query="SELECT s FROM Store s")
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	//bi-directional many-to-one association to Storepart
	@OneToMany(mappedBy="store")
	private List<Storepart> storeparts;

	public Store() {
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

	public List<Storepart> getStoreparts() {
		return this.storeparts;
	}

	public void setStoreparts(List<Storepart> storeparts) {
		this.storeparts = storeparts;
	}

	public Storepart addStorepart(Storepart storepart) {
		getStoreparts().add(storepart);
		storepart.setStore(this);

		return storepart;
	}

	public Storepart removeStorepart(Storepart storepart) {
		getStoreparts().remove(storepart);
		storepart.setStore(null);

		return storepart;
	}

}