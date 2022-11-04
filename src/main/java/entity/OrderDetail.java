package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@IdClass(OrderProductId.class)
@Table(name = "order_detail")
public class OrderDetail {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	private int quatity;

	public OrderDetail(Order order, Product product, int quatity) {
		super();
		this.order = order;
		this.product = product;
		this.quatity = quatity;
	}

	public OrderDetail() {
		super();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuatity() {
		return quatity;
	}

	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}

	@Override
	public String toString() {
		return "OrderDetail [order=" + order + ", product=" + product + ", quatity=" + quatity + "]";
	}
	
}
