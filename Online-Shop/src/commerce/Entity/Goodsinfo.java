package commerce.Entity;

import java.io.Serializable;
import javax.persistence.*;

import store.Entity.Good;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the goodsinfo database table.
 * 
 */
@Entity

@NamedQueries({ @NamedQuery(name = "Goodsinfo.findAll", query = "SELECT g FROM Goodsinfo g"),
		@NamedQuery(name = "Goodsinfo.setDefualt", query = "SELECT g FROM Goodsinfo g WHERE (g.id=:id)")

})

public class Goodsinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date buydate;

	private String description;

	private Long maxstock;

	private Long minstock;

	private String name;

	private Long num;

	// bi-directional many-to-one association to Fieldval
	@OneToMany(mappedBy = "goodsinfo")
	private List<Fieldval> fieldvals;

	// bi-directional many-to-one association to Good
	@OneToMany(mappedBy = "goodsinfo")
	private List<Good> goods;

	// bi-directional many-to-one association to Brand
	@ManyToOne
	@JoinColumn(name = "brandfk")
	private Brand brand;

	// bi-directional many-to-one association to Subbranch
	@ManyToOne
	@JoinColumn(name = "subbranchfk")
	private Subbranch subbranch;

	// bi-directional many-to-one association to Off
	@OneToMany(mappedBy = "goodsinfo")
	private List<Off> offs;

	public Goodsinfo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBuydate() {
		return this.buydate;
	}

	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getMaxstock() {
		return this.maxstock;
	}

	public void setMaxstock(Long maxstock) {
		this.maxstock = maxstock;
	}

	public Long getMinstock() {
		return this.minstock;
	}

	public void setMinstock(Long minstock) {
		this.minstock = minstock;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNum() {
		return this.num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public List<Fieldval> getFieldvals() {
		return this.fieldvals;
	}

	public void setFieldvals(List<Fieldval> fieldvals) {
		this.fieldvals = fieldvals;
	}

	public Fieldval addFieldval(Fieldval fieldval) {
		getFieldvals().add(fieldval);
		fieldval.setGoodsinfo(this);

		return fieldval;
	}

	public Fieldval removeFieldval(Fieldval fieldval) {
		getFieldvals().remove(fieldval);
		fieldval.setGoodsinfo(null);

		return fieldval;
	}

	public List<Good> getGoods() {
		return this.goods;
	}

	public void setGoods(List<Good> goods) {
		this.goods = goods;
	}

	public Good addGood(Good good) {
		getGoods().add(good);
		good.setGoodsinfo(this);

		return good;
	}

	public Good removeGood(Good good) {
		getGoods().remove(good);
		good.setGoodsinfo(null);

		return good;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Subbranch getSubbranch() {
		return this.subbranch;
	}

	public void setSubbranch(Subbranch subbranch) {
		this.subbranch = subbranch;
	}

	public List<Off> getOffs() {
		return this.offs;
	}

	public void setOffs(List<Off> offs) {
		this.offs = offs;
	}

	public Off addOff(Off off) {
		getOffs().add(off);
		off.setGoodsinfo(this);

		return off;
	}

	public Off removeOff(Off off) {
		getOffs().remove(off);
		off.setGoodsinfo(null);

		return off;
	}

}