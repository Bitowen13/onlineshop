package store.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the storepart database table.
 * 
 */
@Entity
@NamedQueries({

		@NamedQuery(name = "Storepart.findAll", query = "SELECT s FROM Storepart s"),
		@NamedQuery(name = "Storepart.find", query = "SELECT s FROM Storepart s WHERE (s.store.id=:Storeid)") })

public class Storepart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String type;

	// bi-directional many-to-one association to Good
	@OneToMany(mappedBy = "storepart")
	private List<Good> goods;

	// bi-directional many-to-one association to Store
	@ManyToOne
	@JoinColumn(name = "storefk")
	private Store store;

	/*
	 * //bi-directional many-to-one association to Storepartsituation
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="storepartsituationfk") private Storepartsituation
	 * storepartsituation;
	 */
	public Storepart() {
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Good> getGoods() {
		return this.goods;
	}

	public void setGoods(List<Good> goods) {
		this.goods = goods;
	}

	public Good addGood(Good good) {
		getGoods().add(good);
		good.setStorepart(this);

		return good;
	}

	public Good removeGood(Good good) {
		getGoods().remove(good);
		good.setStorepart(null);

		return good;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	/*
	 * public Storepartsituation getStorepartsituation() { return
	 * this.storepartsituation; }
	 * 
	 * public void setStorepartsituation(Storepartsituation storepartsituation) {
	 * this.storepartsituation = storepartsituation; }
	 */
}