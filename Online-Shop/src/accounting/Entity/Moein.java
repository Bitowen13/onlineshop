package accounting.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the moein database table.
 * 
 */
@Entity
@NamedQuery(name="Moein.findAll", query="SELECT m FROM Moein m")
public class Moein implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Temporal(TemporalType.DATE)
	private Date edate;

	@Temporal(TemporalType.DATE)
	private Date sdate;

	private Long total;

	//bi-directional many-to-one association to Ledger
	@ManyToOne
	@JoinColumn(name="ledgerfk")
	private Ledger ledger;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="moein")
	private List<Transaction> transactions;

	public Moein() {
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

	public Date getEdate() {
		return this.edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public Date getSdate() {
		return this.sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Long getTotal() {
		return this.total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Ledger getLedger() {
		return this.ledger;
	}

	public void setLedger(Ledger ledger) {
		this.ledger = ledger;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setMoein(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setMoein(null);

		return transaction;
	}

}