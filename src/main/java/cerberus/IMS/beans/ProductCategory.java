package cerberus.IMS.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="IMS_PRODUCT_CATEOGRY")
public class ProductCategory {
	
	//----------------------------------
	// Attributes
	@Id
	@Column(name="CATEGORY_ID", nullable=false, unique=true)
	private int categoryId;
	
	@Column(name="CATEGORY_DESCRIPTION", length=50, nullable=false)
	private String categoryDescription;
	
	//----------------------------------
	// Relationship Mapping
	@ManyToMany
	@JoinTable(name="PRODUCT_CATEGORIES", 
		joinColumns=@JoinColumn(name="PRODUCT_UPC"), 
		inverseJoinColumns=@JoinColumn(name="CATEGORY_ID"))
	private Set<Product> products;
	
	//----------------------------------
	// Accessors
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	//----------------------------------
	// Constructors
	public ProductCategory(){
		super();
	}
	public ProductCategory(int categoryId, String categoryDescription) {
		this();
		this.categoryId = categoryId;
		this.categoryDescription = categoryDescription;
	}	
}
