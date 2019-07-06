package store.Entity;

import java.io.Serializable;
import javax.persistence.*;

import commerce.Entity.Barcode;
import commerce.Entity.Goodsinfo;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the goods database table.
 * 
 */
@Entity
@Table(name = "goods")
@NamedQuery(name = "Good.findAll", query = "SELECT g FROM Good g")
public class Good implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date expdate;

	private Long price;

	@Temporal(TemporalType.DATE)
	private Date pruddate;

	// bi-directional many-to-one association to Barcode
	@OneToMany(mappedBy = "good")
	private List<Barcode> barcodes;

	// bi-directional many-to-one association to Goodsinfo
	@ManyToOne
	@JoinColumn(name = "goodsinfofk")
	private Goodsinfo goodsinfo;

	// bi-directional many-to-one association to Storepart
	@ManyToOne
	@JoinColumn(name = "storepartfk")
	private Storepart storepart;

	public Good() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getExpdate() {
		return this.expdate;
	}

	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Date getPruddate() {
		return this.pruddate;
	}

	public void setPruddate(Date pruddate) {
		this.pruddate = pruddate;
	}

	public List<Barcode> getBarcodes() {
		return this.barcodes;
	}

	public void setBarcodes(List<Barcode> barcodes) {
		this.barcodes = barcodes;
	}

	public Barcode addBarcode(Barcode barcode) {
		getBarcodes().add(barcode);
		barcode.setGood(this);

		return barcode;
	}

	public Barcode removeBarcode(Barcode barcode) {
		getBarcodes().remove(barcode);
		barcode.setGood(null);

		return barcode;
	}

	public Goodsinfo getGoodsinfo() {
		return this.goodsinfo;
	}

	public void setGoodsinfo(Goodsinfo goodsinfo) {
		this.goodsinfo = goodsinfo;
	}

	public Storepart getStorepart() {
		return this.storepart;
	}

	public void setStorepart(Storepart storepart) {
		this.storepart = storepart;
	}

}