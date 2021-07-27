package br.com.gustavoakira.store.paymentservice.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="payments")
public class PaymentEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String paymentId;
	
	@Column
	private String orderId;
	
}
