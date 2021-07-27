package br.com.gustavoakira.store.paymentservice.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import br.com.gustavoakira.store.core.command.ProccessPaymentCommand;
import br.com.gustavoakira.store.core.events.PaymentProcessedEvent;

@Aggregate
public class PaymentAggregate {
	@AggregateIdentifier
	private String paymentId;
	
	private String orderId;
	
	public PaymentAggregate() {}
	
	@CommandHandler
	public PaymentAggregate(ProccessPaymentCommand command ) {
		if(command.getOrderId() == null) {
			throw new IllegalArgumentException();
		}
		
		if(command.getPaymentId() == null) {
			throw new IllegalArgumentException();
		}
		
		if(command.getPaymentDetails() == null) {
			throw new IllegalArgumentException();
		}
		
		AggregateLifecycle.apply(new PaymentProcessedEvent(command.getOrderId(),command.getPaymentId()));
	}
	
	@EventSourcingHandler
	protected void on(PaymentProcessedEvent event) {
		this.paymentId = event.getPaymentId();
		this.orderId = event.getOrderId();
	}
}
