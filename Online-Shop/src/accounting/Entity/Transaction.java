package accounting.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t"),
	@NamedQuery(name="Transaction.selectsum",query="SELECT SUM(t.total) FROM Transaction t")
	
})

public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Long reciptnum;

	private Long total;

	@Temporal(TemporalType.DATE)
	private Date transdate;

	//bi-directional many-to-one association to Buyfact
	@OneToMany(mappedBy="transaction")
	private List<Buyfact> buyfacts;

	//bi-directional many-to-one association to Sellfact
	@OneToMany(mappedBy="transaction")
	private List<Sellfact> sellfacts;

	//bi-directional many-to-one association to Moein
	@ManyToOne
	@JoinColumn(name="moeinfk")
	private Moein moein;

	public Transaction() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getReciptnum() {
		return this.reciptnum;
	}

	public void setReciptnum(Long reciptnum) {
		this.reciptnum = reciptnum;
	}

	public Long getTotal() {
		return this.total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Date getTransdate() {
		return this.transdate;
	}

	public void setTransdate(Date transdate) {
		this.transdate = transdate;
	}

	public List<Buyfact> getBuyfacts() {
		return this.buyfacts;
	}

	public void setBuyfacts(List<Buyfact> buyfacts) {
		this.buyfacts = buyfacts;
	}

	public Buyfact addBuyfact(Buyfact buyfact) {
		getBuyfacts().add(buyfact);
		buyfact.setTransaction(this);

		return buyfact;
	}

	public Buyfact removeBuyfact(Buyfact buyfact) {
		getBuyfacts().remove(buyfact);
		buyfact.setTransaction(null);

		return buyfact;
	}

	public List<Sellfact> getSellfacts() {
		return this.sellfacts;
	}

	public void setSellfacts(List<Sellfact> sellfacts) {
		this.sellfacts = sellfacts;
	}

	public Sellfact addSellfact(Sellfact sellfact) {
		getSellfacts().add(sellfact);
		sellfact.setTransaction(this);

		return sellfact;
	}

	public Sellfact removeSellfact(Sellfact sellfact) {
		getSellfacts().remove(sellfact);
		sellfact.setTransaction(null);

		return sellfact;
	}

	public Moein getMoein() {
		return this.moein;
	}

	public void setMoein(Moein moein) {
		this.moein = moein;
	}

}
