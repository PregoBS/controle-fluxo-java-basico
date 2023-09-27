import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    public static void main(String args[])
    {   
        Scanner terminal = new Scanner(System.in);
        
        System.out.println("Digite o primeiro parâmetro: (número inteiro)");
        int parametroUm = pedirParametro(terminal);
        
        System.out.println("Digite o segundo parâmetro: (número inteiro)");
        int parametroDois = pedirParametro(terminal);

        terminal.close();

		try {
			contar(parametroUm, parametroDois);
		} catch (ParametrosInvalidosException exception) {
			System.out.println("O segundo parâmetro deve ser maior que o primeiro");
		}
		
	}

    private static int pedirParametro(Scanner terminal) {
        int parametro;
        while (true) {
            try {
                parametro = terminal.nextInt();
                break;
            } catch (InputMismatchException exception) {
                System.out.println("Por favor, digite um número inteiro");
                terminal.nextLine();
                continue;
            }
        }
        return parametro;
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroDois <= parametroUm) throw new ParametrosInvalidosException();

        int contagem = parametroDois - parametroUm;
        for (int i=0; i<contagem; i++) {
            System.out.println("Imprimindo o número " + (parametroUm + i));
        }
    }
}