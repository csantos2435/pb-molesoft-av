import java.util.Calendar;
import java.util.Scanner;

public class UsuarioEx09 {

	public static void main(String[] args) {

        String[] usuario = new String[2];
        usuario[0] = "Camilli";

        int[] senha = new int[2];
        senha[0] = 123;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o seu Usuario: ");
        String nomeUsuario = scanner.nextLine();

        System.out.println("Informe a sua Senha: ");
        int senhaUsuario = scanner.nextInt();
        
        Calendar cal = Calendar.getInstance();
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        
       
        if ((usuario[0] == nomeUsuario) || (senha[0] == senhaUsuario)){

            if(hora > 6 && hora < 11.59){
                System.out.println("Bom Dia, voce se logou ao nosso sistema");
                
            }else if(hora > 12 && hora < 17.59){
                System.out.println("Boa Tarde, voce se logou ao nosso sistema");
                
            }else if(hora > 18 && hora < 23.59){
                System.out.println("Boa Noite, voce se logou ao nosso sistema");
                
            }else if(hora > 0 && hora < 5.59){
                System.out.println("Boa Madrugada, voce se logou ao nosso sistema");
            }
        }else {
        	System.out.println("Usuario e/ou senha incorretos");
        }
    }
}
