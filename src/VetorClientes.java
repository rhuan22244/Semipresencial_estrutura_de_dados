public class VetorClientes {
    private Cliente[] clientes;
    private int tamanho;

    public VetorClientes(int capacidade) {
        this.clientes = new Cliente[capacidade];
        this.tamanho = 0;
    }

    public boolean adicionar(Cliente cliente) {
        if (tamanho < clientes.length) {
            clientes[tamanho] = cliente;
            tamanho++;
            return true;
        } else {
            System.out.println("Vetor cheio,não é possivel adicionar mais clientes.");
            return false;
        }
    }

    public boolean remover(int posicao) {
        if (posicao >= 0 && posicao < tamanho) {
            for (int i = posicao; i < tamanho - 1; i++) {
                clientes[i] = clientes[i + 1];
            }
            clientes[tamanho - 1] = null;
            tamanho--;
            return true;
        }
        return false;
    }

    public Cliente buscarPorNome(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (clientes[i].getNome().equalsIgnoreCase(nome)) {
                return clientes[i];
            }
        }
        return null;
    }

    public VetorClientes filtrarPorDominioEmail(String dominio) {
        VetorClientes filtrados = new VetorClientes(tamanho);
        for (int i = 0; i < tamanho; i++) {
            if (clientes[i].getEmail().endsWith(dominio)){
                filtrados.adicionar(clientes[i]);
            }
        }
        return filtrados;
    }

    public void listarClientes() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(clientes[i]);
        }
    }

    public boolean alterar(int posicao, Cliente cliente) {
        if (posicao >= 0 && posicao < tamanho) {
            clientes[posicao] = cliente;
            return true;
        }
        return false;
    }

    public boolean inserir(int posicao, Cliente cliente) {
        if (posicao >= 0 && posicao <= tamanho && tamanho < clientes.length) {
            for (int i = tamanho; i > posicao; i--) {
                clientes[i] = clientes[i - 1];
            }
            clientes[posicao] = cliente;
            tamanho++;
            return true;
        }
        System.out.println("Erro ao inserir cliente");
        return false;
    }

}
