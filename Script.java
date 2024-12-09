// Interface que define um método comum para exibição
interface SistemaArquivos {
    void mostrar(); // Método para mostrar o conteúdo
}

// Classe Real que exibe o sistema completo
class SistemaArquivosCompleto implements SistemaArquivos {

    @Override
    public void mostrar() {
        // Exibindo o conteúdo completo do sistema
        System.out.println("Conteudo do sistema completo:");
        System.out.println("- Arquivo1.txt");
        System.out.println("- Arquivo2.txt");
        System.out.println("- Relatorio.pdf");
    }
}

// Classe Proxy que controla o acesso ao SistemaArquivosCompleto
class ProxySistemaArquivos implements SistemaArquivos {
    private SistemaArquivosCompleto sistemaReal;
    private boolean acessoAutorizado;

    // Construtor do proxy para definir a permissão de acesso
    public ProxySistemaArquivos(boolean acessoAutorizado) {
        this.acessoAutorizado = acessoAutorizado;
        this.sistemaReal = new SistemaArquivosCompleto();
    }

    @Override
    public void mostrar() {
        if (acessoAutorizado) {
            // Permissão concedida, exibe o conteúdo completo
            sistemaReal.mostrar();
        } else {
            // Permissão negada, exibe mensagem de erro
            System.out.println("Acesso negado. Voce nao tem permissao.");
        }
    }
}

// Classe Principal que simula a interação com o sistema
public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Simulando permissão do usuário
        System.out.println("Voce tem permissao para acessar o sistema? (sim/nao): ");
        boolean autorizado = scanner.nextLine().equalsIgnoreCase("sim");

        // Criando o proxy com base na permissão
        SistemaArquivos sistema = new ProxySistemaArquivos(autorizado);

        // Exibindo conteúdo com base no acesso
        System.out.println("\nTentando acessar o sistema...");
        sistema.mostrar();

        scanner.close(); // Fechando o scanner
    }
}
