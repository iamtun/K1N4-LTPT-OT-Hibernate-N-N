package entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class OrderProductId {
	private int order;
	private int product;

	public OrderProductId(int order, int product) {
		super();
		this.order = order;
		this.product = product;
	}

	public OrderProductId() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + order;
		result = prime * result + product;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderProductId other = (OrderProductId) obj;
		if (order != other.order)
			return false;
		if (product != other.product)
			return false;
		return true;
	}

}
