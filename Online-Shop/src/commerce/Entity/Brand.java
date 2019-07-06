package commerce.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the brand database table.
 * 
 */
@Entity
@NamedQuery(name="Brand.findAll", query="SELECT b FROM Brand b")
public class Brand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	//bi-directional many-to-one association to Brandcat
	@ManyToOne
	@JoinColumn(name="brandcatfk")
	private Brandcat brandcat;

	//bi-directional many-to-one association to Country
	/*@ManyToOne
	@JoinColumn(name="countryfk")
	private Country country;
*/
	//bi-directional many-to-one association to Goodsinfo
	@OneToMany(mappedBy="brand")
	private List<Goodsinfo> goodsinfos;

	public Brand() {
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

	public Brandcat getBrandcat() {
		return this.brandcat;
	}

	public void setBrandcat(Brandcat brandcat) {
		this.brandcat = brandcat;
	}

	/*public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}*/

	public List<Goodsinfo> getGoodsinfos() {
		return this.goodsinfos;
	}

	public void setGoodsinfos(List<Goodsinfo> goodsinfos) {
		this.goodsinfos = goodsinfos;
	}

	public Goodsinfo addGoodsinfo(Goodsinfo goodsinfo) {
		getGoodsinfos().add(goodsinfo);
		goodsinfo.setBrand(this);

		return goodsinfo;
	}

	public Goodsinfo removeGoodsinfo(Goodsinfo goodsinfo) {
		getGoodsinfos().remove(goodsinfo);
		goodsinfo.setBrand(null);

		return goodsinfo;
	}

}