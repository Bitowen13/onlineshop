package accounting.Entity;

import java.io.Serializable;
import javax.persistence.*;

import AAA.Entity.Aauser;
import commerce.Entity.Barcode;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sellfact database table.
 * 
 */
@Entity
@NamedQuery(name="Sellfact.findAll", query="SELECT s FROM Sellfact s")
public class Sellfact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date factdate;

	private Long off;

	private Long payable;

	//bi-directional many-to-one association to Barcode
	@OneToMany(mappedBy="sellfact")
	private List<Barcode> barcodes;

	//bi-directional many-to-one association to Aauser
	@ManyToOne
	@JoinColumn(name="aauserfk")
	private Aauser aauser;

	//bi-directional many-to-one association to Factsituation
	@ManyToOne
	@JoinColumn(name="factsituation")
	private Factsituation factsituation;

	//bi-directional many-to-one association to Transaction
	@ManyToOne
	@JoinColumn(name="transactionfk")
	private Transaction transaction;

	public Sellfact() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFactdate() {
		return this.factdate;
	}

	public void setFactdate(Date factdate) {
		this.factdate = factdate;
	}

	public Long getOff() {
		return this.off;
	}

	public void setOff(Long off) {
		this.off = off;
	}

	public Long getPayable() {
		return this.payable;
	}

	public void setPayable(Long payable) {
		this.payable = payable;
	}

	public List<Barcode> getBarcodes() {
		return this.barcodes;
	}

	public void setBarcodes(List<Barcode> barcodes) {
		this.barcodes = barcodes;
	}

	public Barcode addBarcode(Barcode barcode) {
		getBarcodes().add(barcode);
		barcode.setSellfact(this);

		return barcode;
	}

	public Barcode removeBarcode(Barcode barcode) {
		getBarcodes().remove(barcode);
		barcode.setSellfact(null);

		return barcode;
	}

	public Aauser getAauser() {
		return this.aauser;
	}

	public void setAauser(Aauser aauser) {
		this.aauser = aauser;
	}

	public Factsituation getFactsituation() {
		return this.factsituation;
	}

	public void setFactsituation(Factsituation factsituation) {
		this.factsituation = factsituation;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}