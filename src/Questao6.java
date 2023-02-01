import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class Questao6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a data da sua vacinação abaixo: ");
        System.out.println("Digite o ano da vacina: ");
        int anoVacina = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite o mês da vacina: ");
        int mesVacina = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite o dia da vacina: ");
        int diaVacina = scan.nextInt();
        scan.nextLine();

        LocalDate dataVacina = LocalDate.of(anoVacina,mesVacina,diaVacina);

        LocalDate dataProxVacina;
        int proximasDoses = 3;

        for(int i = 1; i <= proximasDoses; i++) {
            dataProxVacina = dataVacina.plusMonths(3*i);
            if (dataProxVacina.getDayOfWeek() == DayOfWeek.SATURDAY){
                dataProxVacina = dataProxVacina.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
            }
            if (dataProxVacina.getDayOfWeek() == DayOfWeek.SUNDAY){
                dataProxVacina = dataProxVacina.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            }
            System.out.println("Dose "+i+" - Data: "+dataProxVacina);
        }

    }

}
