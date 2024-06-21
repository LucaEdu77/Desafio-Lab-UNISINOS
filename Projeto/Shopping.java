import java.text.Collator;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int quantidadeMaximaLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidadeMaximaLojas];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    public boolean insereLoja(Loja novaLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = novaLoja;
                return true;
            }
        }
        return false; // Retorna falso se não houver lugar no array
    }

    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equals(nomeLoja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false; // Retorna falso se a loja não for encontrada
    }

    public int quantidadeLojasPorTipo(String tipoLoja) {
        int quantidade = 0;
        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);

        for (Loja loja : lojas) {
            if (collator.compare(loja.getClass().getSimpleName(), tipoLoja) == 0) {
                quantidade++;
            }
        }
        if (quantidade == 0 && !(tipoLoja.equalsIgnoreCase("Cosmético") || tipoLoja.equalsIgnoreCase("Vestuário") || tipoLoja.equalsIgnoreCase("Bijuteria") || tipoLoja.equalsIgnoreCase("Alimentação") || tipoLoja.equalsIgnoreCase("Informática"))) {
            return -1;
        }
        return quantidade;
    }

    public Informatica lojaSeguroMaisCaro() {
        Informatica lojaMaisCara = null;
        double maiorValorSeguro = 0;
        for (Loja loja : lojas) {
            if (loja != null && loja instanceof Informatica) {
                Informatica informatica = (Informatica) loja;
                if (informatica.getSeguroEletronicos() > maiorValorSeguro) {
                    maiorValorSeguro = informatica.getSeguroEletronicos();
                    lojaMaisCara = informatica;
                }
            }
        }
        return lojaMaisCara;
    }

    public String toString() {
        return "Shopping: " + nome + "\nEndereço: " + endereco + "\nQuantidade de Lojas: " + lojas.length;
    }
}
