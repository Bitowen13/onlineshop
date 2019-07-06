package commerce.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subbranch database table.
 * 
 */
@Entity
@NamedQuery(name="Subbranch.findAll", query="SELECT s FROM Subbranch s")
public class Subbranch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	//bi-directional many-to-one association to Fieldcat
	@OneToMany(mappedBy="subbranch")
	private List<Fieldcat> fieldcats;

	//bi-directional many-to-one association to Goodsinfo
	@OneToMany(mappedBy="subbranch")
	private List<Goodsinfo> goodsinfos;

	//bi-directional many-to-one association to Mainbranch
	@ManyToOne
	@JoinColumn(name="mainbranchfk")
	private Mainbranch mainbranch;

	public Subbranch() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Fieldcat> getFieldcats() {
		return this.fieldcats;
	}

	public void setFieldcats(List<Fieldcat> fieldcats) {
		this.fieldcats = fieldcats;
	}

	public Fieldcat addFieldcat(Fieldcat fieldcat) {
		getFieldcats().add(fieldcat);
		fieldcat.setSubbranch(this);

		return fieldcat;
	}

	public Fieldcat removeFieldcat(Fieldcat fieldcat) {
		getFieldcats().remove(fieldcat);
		fieldcat.setSubbranch(null);

		return fieldcat;
	}

	public List<Goodsinfo> getGoodsinfos() {
		return this.goodsinfos;
	}

	public void setGoodsinfos(List<Goodsinfo> goodsinfos) {
		this.goodsinfos = goodsinfos;
	}

	public Goodsinfo addGoodsinfo(Goodsinfo goodsinfo) {
		getGoodsinfos().add(goodsinfo);
		goodsinfo.setSubbranch(this);

		return goodsinfo;
	}

	public Goodsinfo removeGoodsinfo(Goodsinfo goodsinfo) {
		getGoodsinfos().remove(goodsinfo);
		goodsinfo.setSubbranch(null);

		return goodsinfo;
	}

	public Mainbranch getMainbranch() {
		return this.mainbranch;
	}

	public void setMainbranch(Mainbranch mainbranch) {
		this.mainbranch = mainbranch;
	}

}