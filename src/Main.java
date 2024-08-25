public class Main {
    public static void main(String[] args) {
        VetorClientes vetor = new VetorClientes(20);

        // Inserindo 30 clientes, sendo que o vetor suporta apenas 20
        for (int i = 1; i <= 30; i++) {
            Cliente cliente = new Cliente("Cliente" + i, "12345" + i, "cliente" + i + "@exemplo.com");
            if (!vetor.adicionar(cliente)) {
                System.out.println("Não foi possível adicionar o Cliente" + i + " (vetor cheio).");
            }
        }

        // Listando todos os clientes
        System.out.println("Clientes armazenados:");
        vetor.listarClientes();

        // Alterando um cliente na posição 5
        Cliente clienteAlterado = new Cliente("ClienteAlterado", "9999999", "alterado@exemplo.com");
        vetor.alterar(5, clienteAlterado);

        // Removendo o cliente na posição 2
        vetor.remover(2);

        // Inserindo cliente na posição 3
        Cliente clienteInserido = new Cliente("ClienteInserido", "88888888", "inserido@exemplo.com");
        vetor.inserir(3, clienteInserido);

        // Listando clientes após alteração, exclusão e inserção
        System.out.println("\nClientes após alterações:");
        vetor.listarClientes();

        // Buscando cliente por nome
        String nomeBusca = "ClienteAlterado";
        Cliente clienteBuscado = vetor.buscarPorNome(nomeBusca);
        System.out.println("\nResultado da busca por nome (" + nomeBusca + "): " + clienteBuscado);

        // Filtrando clientes por domínio de email
        String dominio = "@exemplo.com";
        VetorClientes clientesFiltrados = vetor.filtrarPorDominioEmail(dominio);
        System.out.println("\nClientes com email que termina em " + dominio + ":");
        clientesFiltrados.listarClientes();
    }
}
