package commerce.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mainbranch database table.
 * 
 */
@Entity
@NamedQuery(name="Mainbranch.findAll", query="SELECT m FROM Mainbranch m")
public class Mainbranch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	//bi-directional many-to-one association to Shop
	@ManyToOne
	@JoinColumn(name="shopfk")
	private Shop shop;

	//bi-directional many-to-one association to Subbranch
	@OneToMany(mappedBy="mainbranch")
	private List<Subbranch> subbranches;

	public Mainbranch() {
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

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Subbranch> getSubbranches() {
		return this.subbranches;
	}

	public void setSubbranches(List<Subbranch> subbranches) {
		this.subbranches = subbranches;
	}

	public Subbranch addSubbranch(Subbranch subbranch) {
		getSubbranches().add(subbranch);
		subbranch.setMainbranch(this);

		return subbranch;
	}

	public Subbranch removeSubbranch(Subbranch subbranch) {
		getSubbranches().remove(subbranch);
		subbranch.setMainbranch(null);

		return subbranch;
	}

}