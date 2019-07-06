package accounting.Entity;

import java.io.Serializable;
import javax.persistence.*;

import AAA.Entity.Aauser;
import commerce.Entity.Barcode;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the buyfact database table.
 * 
 */
@Entity
@NamedQueries({
	
	@NamedQuery(name="Buyfact.findAll", query="SELECT b FROM Buyfact b")
	
})
public class Buyfact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Long coefficient;

	@Temporal(TemporalType.DATE)
	private Date factdate;

	private Long total;

	//bi-directional many-to-one association to Barcode
	@OneToMany(mappedBy="buyfact")
	private List<Barcode> barcodes;

	//bi-directional many-to-one association to Aauser
	@ManyToOne
	@JoinColumn(name="aauserfk")
	private Aauser aauser;

	//bi-directional many-to-one association to Factsituation
	@ManyToOne
	@JoinColumn(name="buyfactsituationfk")
	private Factsituation factsituation;

	//bi-directional many-to-one association to Transaction
	@ManyToOne
	@JoinColumn(name="transactionfk")
	private Transaction transaction;

	public Buyfact() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCoefficient() {
		return this.coefficient;
	}

	public void setCoefficient(Long coefficient) {
		this.coefficient = coefficient;
	}

	public Date getFactdate() {
		return this.factdate;
	}

	public void setFactdate(Date factdate) {
		this.factdate = factdate;
	}

	public Long getTotal() {
		return this.total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<Barcode> getBarcodes() {
		return this.barcodes;
	}

	public void setBarcodes(List<Barcode> barcodes) {
		this.barcodes = barcodes;
	}

	public Barcode addBarcode(Barcode barcode) {
		getBarcodes().add(barcode);
		barcode.setBuyfact(this);

		return barcode;
	}

	public Barcode removeBarcode(Barcode barcode) {
		getBarcodes().remove(barcode);
		barcode.setBuyfact(null);

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