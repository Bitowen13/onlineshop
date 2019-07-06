package commerce.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the off database table.
 * 
 */
@Entity
@NamedQuery(name="Off.findAll", query="SELECT o FROM Off o")
public class Off implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	private Long offpercent;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	private String status;

	//bi-directional many-to-one association to Goodsinfo
	@ManyToOne
	@JoinColumn(name="goodsinfofk")
	private Goodsinfo goodsinfo;

	public Off() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Long getOffpercent() {
		return this.offpercent;
	}

	public void setOffpercent(Long offpercent) {
		this.offpercent = offpercent;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Goodsinfo getGoodsinfo() {
		return this.goodsinfo;
	}

	public void setGoodsinfo(Goodsinfo goodsinfo) {
		this.goodsinfo = goodsinfo;
	}

}