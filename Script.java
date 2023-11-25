public interface SistemaArquivos {
    void mostrar();
}

public class SistemaArquivosCompleto implements SistemaArquivos {
    private String conteudo;

    public SistemaArquivosCompleto(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public void mostrar() {
        System.out.println("Visualizando o conteúdo do sistema de arquivos...");
    }

    public void imprimirConteudoCompleto(String conteudo) {
        System.out.println("Imprimindo conteúdo completo do sistema de arquivos...");
    }
}

public class ProxySistemaArquivos implements SistemaArquivos {
    private SistemaArquivosCompleto sistemaCompleto;
    private String conteudo;

    public ProxySistemaArquivos(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public void mostrar() {
        if (sistemaCompleto == null) {
            sistemaCompleto = new SistemaArquivosCompleto(conteudo);
        }
        sistemaCompleto.mostrar();
    }
}

public class Main {
    public static void main(String[] args) {
        SistemaArquivos sistema = new ProxySistemaArquivos("Diretório Principal");
        
        // Carregará o conteúdo para impressão
        ((SistemaArquivosCompleto) sistema).imprimirConteudoCompleto("Conteúdo do Diretório Principal");
        System.out.println("");
        
        // Apenas mostrará na tela
        sistema.mostrar();
    }
}
