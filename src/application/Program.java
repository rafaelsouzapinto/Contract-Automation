package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.services.ContractService;
import model.services.PayPalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato: ");
		
		System.out.print("Numero: ");
		int number = sc.nextInt();
		
		System.out.print("Data (dd/MM/yyyy): ");
		String strDate = sc.next();
		
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		System.out.print("Entre com o numero de parcelas: ");
		int months = sc.nextInt();
	
		
		Contract contract = new Contract(number, LocalDate.parse(strDate, fmt), totalValue);
		ContractService service = new ContractService(new PayPalService());
		service.processContract(contract, months);
		
		
		System.out.println("Parcelas: ");
		for (int i = 0; i < months; i++) {
			System.out.println(contract.getInstallment().get(i));
		}
		
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\temp\\installments.txt", true))) {
			bw.write("-------Parcelas-------");
			bw.newLine();
			for (int i = 0; i < months; i++) {
				String line = contract.getInstallment().get(i).toString();
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error on writing: " + e.getMessage());
		}
		sc.close();
	}
}
