import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    static Scanner terminal = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Digite o primeiro parâmetro");
		int parametroUm = obterParametro();
		System.out.println("Digite o segundo parâmetro");
		int parametroDois = obterParametro();
		
		try {
			contar(parametroUm, parametroDois);
		
		}catch (ParametrosInvalidosException exception) {
            System.out.println("O segundo parâmetro precisa ser maior do que o primeiro parâmetro. Por favor, insira novamente valores adequados");
            main(args);
		}
		
	}

    static int obterParametro() {
        try {
            return terminal.nextInt();
        } catch (InputMismatchException exception) {
            terminal.nextLine();
            System.out.println("Somente são aceitos valores numéricos e inteiros como parâmetro. Por favor, insira um valor adequado");
            return obterParametro();
        }
    }

	static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException();
        }
		
		int contagem = parametroDois - parametroUm;
		for (int indice = 1; indice <= contagem; indice++) {
            System.out.println("Imprimindo o número " + indice);
        }
	}
}