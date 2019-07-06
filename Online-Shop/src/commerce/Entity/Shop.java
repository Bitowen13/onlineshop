package commerce.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the shop database table.
 * 
 */
@Entity
@NamedQuery(name="Shop.findAll", query="SELECT s FROM Shop s")
public class Shop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	//bi-directional many-to-one association to Mainbranch
	@OneToMany(mappedBy="shop")
	private List<Mainbranch> mainbranches;

	public Shop() {
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

	public List<Mainbranch> getMainbranches() {
		return this.mainbranches;
	}

	public void setMainbranches(List<Mainbranch> mainbranches) {
		this.mainbranches = mainbranches;
	}

	public Mainbranch addMainbranch(Mainbranch mainbranch) {
		getMainbranches().add(mainbranch);
		mainbranch.setShop(this);

		return mainbranch;
	}

	public Mainbranch removeMainbranch(Mainbranch mainbranch) {
		getMainbranches().remove(mainbranch);
		mainbranch.setShop(null);

		return mainbranch;
	}

}