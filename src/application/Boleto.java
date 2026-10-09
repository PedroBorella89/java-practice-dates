package application;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Boleto {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate hoje = LocalDate.now();

        System.out.print("Digite o valor do boleto: ");
        double valor = sc.nextDouble();
        sc.nextLine();
        System.out.print("Digite a data da compra: ");
        LocalDate data = LocalDate.parse(sc.nextLine(), dtf);
        System.out.print("Digite o prazo de pagamento: ");
        int prazo = sc.nextInt();
        sc.nextLine();
        LocalDate vencimento = data.plusDays(prazo);

        String status;
        if (vencimento.isAfter(hoje)) {
            status = "EM ABERTO";
        }
        else if (vencimento.isBefore(hoje)) {
            status = "VENCIDO";
        }
        else {
            status = "VENCE HOJE";
        }

        long days = ChronoUnit.DAYS.between(hoje, vencimento);

        String message;
        if (days > 0) {
            message = "Faltam " + days + " dias para o vencimento"; 
        }
        else if (days < 0) {
            message = "O boleto está vencido há " + Math.abs(days) + " dias";
        }
        else {
            message = "O boleto vence hoje";
        }

        System.out.println();
        System.out.println("===== BOLETO =====");
        System.out.println();
        System.out.println("Data de lançamento: " + hoje.format(dtf));
        System.out.println("Valor: " + String.format("R$ %.2f", valor));
        System.out.println("Data da compra: " + data.format(dtf));
        System.out.println("Vencimento: " + vencimento.format(dtf));
        System.out.println();
        System.out.println("STATUS DO BOLETO: " + status);
        System.out.println(message);

        sc.close();
        
    }
    
}
