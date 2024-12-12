import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int limite = 0;
        int tentativas = 5;
        int contador = 5;
        int pontos = 0;
        ArrayList<Integer> numerosAcertados = new ArrayList<>();
        ArrayList<Integer> numerosErrados = new ArrayList<>();

        System.out.println("--------Bem vindo(a) ao jogo de adivinhação!--------");
        System.out.println("Escolha sua dificuldade do jogo:");
        System.out.println("Escreva 1 para Fácil:");
        System.out.println("Escreva 2 para Médio: ");
        System.out.println("Escreva 3 para Difícil: ");
        int dificuldade = input.nextInt();

        if (dificuldade == 1) {
            limite = 10;
        } else {
            if (dificuldade == 2) {
                limite = 50;
            } else {
                if (dificuldade == 3) {
                    limite = 100;
                } else {
                    System.out.println("Dificuldade inválida! Escolha um dos 3 números apresentados!");
                }
            }
        }

        int numeroAleatorio = new Random().nextInt(limite) + 1;

        System.out.println("Você terá 5 tentativas de adivinhar o número sorteado.");

        for (int i = 0; i < tentativas; i++) {
            System.out.println("Dê seu palpite: ");
            int numero = input.nextInt();

            if (numero > limite || numero < 1) {
                System.out.println("O número digitado deve ser entre 1 e " + limite + "!");
            } else {
                if (numero == numeroAleatorio) {
                    System.out.println("--------VOCÊ ACERTOU!!--------");
                    System.out.println("O número era " + numeroAleatorio);
                    pontos += 100;
                    numerosAcertados.add(numero);
                    break;
                } else {
                    numerosErrados.add(numero);
                    contador--;
                    System.out.println("Você tem mais " + contador + " chances para acertar");

                    if (numero > numeroAleatorio) {
                        System.out.println("O número digitado é maior que o número sorteado");
                    } else {
                        if (numero == numeroAleatorio - 1) {
                            System.out.println("Quase lá! Você estava a 1 número de distância do número sorteado. Você ganhou 5 pontos");
                            pontos = pontos + 5;
                        } else {
                            System.out.println("O número digitado é menor que o número sorteado");
                        }
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
        System.out.println("--------RESULTADO FINAL--------");
        System.out.println("Pontos: " + pontos);
        System.out.println("Números acertados: " + numerosAcertados);
        System.out.println("Números errados: " + numerosErrados);
    }
}