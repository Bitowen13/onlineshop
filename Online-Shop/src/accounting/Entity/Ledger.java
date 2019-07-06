package accounting.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ledger database table.
 * 
 */
@Entity
@NamedQuery(name="Ledger.findAll", query="SELECT l FROM Ledger l")
public class Ledger implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Temporal(TemporalType.DATE)
	private Date edate;

	private Long income;

	@Temporal(TemporalType.DATE)
	private Date sdate;

	//bi-directional many-to-one association to Moein
	@OneToMany(mappedBy="ledger")
	private List<Moein> moeins;

	public Ledger() {
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

	public Long getIncome() {
		return this.income;
	}

	public void setIncome(Long income) {
		this.income = income;
	}

	public Date getSdate() {
		return this.sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public List<Moein> getMoeins() {
		return this.moeins;
	}

	public void setMoeins(List<Moein> moeins) {
		this.moeins = moeins;
	}

	public Moein addMoein(Moein moein) {
		getMoeins().add(moein);
		moein.setLedger(this);

		return moein;
	}

	public Moein removeMoein(Moein moein) {
		getMoeins().remove(moein);
		moein.setLedger(null);

		return moein;
	}

}