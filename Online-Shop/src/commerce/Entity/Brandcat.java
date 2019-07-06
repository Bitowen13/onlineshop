package commerce.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the brandcat database table.
 * 
 */
@Entity
@NamedQuery(name="Brandcat.findAll", query="SELECT b FROM Brandcat b")
public class Brandcat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	//bi-directional many-to-one association to Brand
	@OneToMany(mappedBy="brandcat")
	private List<Brand> brands;

	public Brandcat() {
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

	public List<Brand> getBrands() {
		return this.brands;
	}

	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}

	public Brand addBrand(Brand brand) {
		getBrands().add(brand);
		brand.setBrandcat(this);

		return brand;
	}

	public Brand removeBrand(Brand brand) {
		getBrands().remove(brand);
		brand.setBrandcat(null);

		return brand;
	}

}