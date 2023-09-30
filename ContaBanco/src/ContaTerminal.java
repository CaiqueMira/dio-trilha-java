import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {    
    
    static Scanner scannerInput = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {       
            
        int numero = obterNumeroAgencia();

        String agencia = obterAgencia();
        
        scannerInput.nextLine();

        String nomeCliente = obterNomeCliente();

        double saldo = obterSaldo();
        
        System.out.println(String.format("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo de R$%.2f já está disponível para saque", nomeCliente, agencia, numero, saldo));
    }
    
    public static int obterNumeroAgencia() {
        System.out.println("Por favor, insira o número da Agência");
        try {
            return scannerInput.nextInt();
        } catch(InputMismatchException e) {
            System.err.println("Somente são aceitos valores numéricos para o número da agência. Por favor, insira um valor correto");
            scannerInput.nextLine();        
            return obterNumeroAgencia();
        }
    }
    
    public static String obterAgencia() {
        System.out.println("Informe a Agência");
        return scannerInput.next();
    }
    
    public static String obterNomeCliente() {
        System.out.println("Informe o seu nome");
        return scannerInput.nextLine();        
    }
    
    public static double obterSaldo() {
        System.out.println("Informe o seu saldo");
        try {            
            return scannerInput.nextDouble(); 
        } catch(InputMismatchException e) {
            System.out.println("Somente são aceitos valores numéricos para o saldo. Por favor, insira um valor correto");
            scannerInput.nextLine();
            return obterSaldo();
        }
    }
}
