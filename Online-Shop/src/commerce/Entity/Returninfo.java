package commerce.Entity;

import java.io.Serializable;
import javax.persistence.*;

import AAA.Entity.Aauser;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the returninfo database table.
 * 
 */
@Entity
@NamedQuery(name="Returninfo.findAll", query="SELECT r FROM Returninfo r")
public class Returninfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String description;

	private Long type;

	//bi-directional many-to-one association to Barcode
	@OneToMany(mappedBy="returninfo")
	private List<Barcode> barcodes;

	//bi-directional many-to-one association to Aauser
	@ManyToOne
	@JoinColumn(name="aauserfk")
	private Aauser aauser;

	public Returninfo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getType() {
		return this.type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public List<Barcode> getBarcodes() {
		return this.barcodes;
	}

	public void setBarcodes(List<Barcode> barcodes) {
		this.barcodes = barcodes;
	}

	public Barcode addBarcode(Barcode barcode) {
		getBarcodes().add(barcode);
		barcode.setReturninfo(this);

		return barcode;
	}

	public Barcode removeBarcode(Barcode barcode) {
		getBarcodes().remove(barcode);
		barcode.setReturninfo(null);

		return barcode;
	}

	public Aauser getAauser() {
		return this.aauser;
	}

	public void setAauser(Aauser aauser) {
		this.aauser = aauser;
	}

}