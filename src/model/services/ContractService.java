package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;
	
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		super();
		this.onlinePaymentService = onlinePaymentService;
	}


	public OnlinePaymentService getOnlinePaymentService() {
		return onlinePaymentService;
	}
	public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	
	public void processContract(Contract contract, int months) {
		for (int i = 1; i <= months; i++) {
			LocalDate date = contract.getDate().plusMonths(i);
			
			contract.getInstallment().add(new Installment(date, onlinePaymentService.paymentFee(onlinePaymentService.interest(contract.getTotalValue()/months, i))));
		}
	}
}
