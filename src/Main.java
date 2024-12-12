import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numeroAleatorio = new Random().nextInt(10);
        int tentativas = 5;
        int contador = 5;

        System.out.println("--------Bem vindo(a) ao jogo de adivinhação!--------");
        System.out.println("Você terá 5 tentativas de adivinhar o número sorteado.");

        for (int i = 0; i < tentativas; i++) {
            System.out.println("Dê seu palpite: ");
            int numero = input.nextInt();

            if (numero > 10) {
                System.out.println("O número digitado não pode ser maior que 10!");
            } else {
                if (numero == numeroAleatorio) {
                    System.out.println("--------VOCÊ ACERTOU!!--------");
                    System.out.println("O número era " + numeroAleatorio);
                    break;
                } else {
                    contador--;
                    System.out.println("Você tem mais " + contador + " chances para acertar");

                    if (numero > numeroAleatorio) {
                        System.out.println("O número digitado é maior que o número sorteado");
                    } else {
                        System.out.println("O número digitado é menor que o número sorteado");
                    }

                    if (contador == 0) {
                        System.out.println("--------VOCÊ PERDEU--------");
                        System.out.println("Acabaram as tentativas!");
                        System.out.println("O número era " + numeroAleatorio);
                        break;
                    }
                }
            }
        }
    }
}