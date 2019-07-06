package commerce.Entity;

import java.io.Serializable;
import javax.persistence.*;

import accounting.Entity.Buyfact;
import accounting.Entity.Sellfact;
import store.Entity.Good;


/**
 * The persistent class for the barcode database table.
 * 
 */
@Entity
@NamedQuery(name="Barcode.findAll", query="SELECT b FROM Barcode b")
public class Barcode implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	//bi-directional many-to-one association to Buyfact
	@ManyToOne
	@JoinColumn(name="buyfactfk")
	private Buyfact buyfact;

	//bi-directional many-to-one association to Good
	@ManyToOne
	@JoinColumn(name="goodsfk")
	private Good good;

	//bi-directional many-to-one association to Returninfo
	@ManyToOne
	@JoinColumn(name="returninfofk")
	private Returninfo returninfo;

	//bi-directional many-to-one association to Sellfact
	@ManyToOne
	@JoinColumn(name="sellfactfk")
	private Sellfact sellfact;

	public Barcode() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Buyfact getBuyfact() {
		return this.buyfact;
	}

	public void setBuyfact(Buyfact buyfact) {
		this.buyfact = buyfact;
	}

	public Good getGood() {
		return this.good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public Returninfo getReturninfo() {
		return this.returninfo;
	}

	public void setReturninfo(Returninfo returninfo) {
		this.returninfo = returninfo;
	}

	public Sellfact getSellfact() {
		return this.sellfact;
	}

	public void setSellfact(Sellfact sellfact) {
		this.sellfact = sellfact;
	}

}