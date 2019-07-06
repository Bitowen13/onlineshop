package commerce.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fieldval database table.
 * 
 */
@Entity
@NamedQuery(name="Fieldval.findAll", query="SELECT f FROM Fieldval f")
public class Fieldval implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String value1;

	private Long value2;

	//bi-directional many-to-one association to Chooseval
	@ManyToOne
	@JoinColumn(name="choosevalfk")
	private Chooseval chooseval;

	//bi-directional many-to-one association to Field
	@ManyToOne
	@JoinColumn(name="fieldfk")
	private Field field;

	//bi-directional many-to-one association to Goodsinfo
	@ManyToOne
	@JoinColumn(name="goodsinfofk")
	private Goodsinfo goodsinfo;

	public Fieldval() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue1() {
		return this.value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public Long getValue2() {
		return this.value2;
	}

	public void setValue2(Long value2) {
		this.value2 = value2;
	}

	public Chooseval getChooseval() {
		return this.chooseval;
	}

	public void setChooseval(Chooseval chooseval) {
		this.chooseval = chooseval;
	}

	public Field getField() {
		return this.field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Goodsinfo getGoodsinfo() {
		return this.goodsinfo;
	}

	public void setGoodsinfo(Goodsinfo goodsinfo) {
		this.goodsinfo = goodsinfo;
	}

}