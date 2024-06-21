public class Produto {

    private String nome;
    private double preco;
    private Data dataValidade;

    public Produto(String nome, double preco, Data dataDeValidade){

        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataDeValidade;
    }

    public Produto(String nomeProduto, double preco, String dataValidade) {
        this.nome = nomeProduto;
        this.preco = preco;
    }


    public String getNome(){
        return nome;
    }
    public void setNome (String nome) {
        this.nome =  nome;
    }

    public double getPreco(){
        return preco;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }

    public Data getDataValidade(){
        return dataValidade;
    }
    public void setDataValidade(Data dataValidade){
        this.dataValidade = dataValidade;
    }

    public String toString() {
        return "Produto\n" + "Nome =" + nome + "\nPreço =" + preco + "\nData de Validade =" + dataValidade;
    }


    public boolean estaVencido(Data dataAtual) {
        //Verificando se o produto esta vencido na data atual
        if(dataValidade != null && dataAtual != null) {
            if(dataAtual.getAno() > dataValidade.getAno()) {
                return true;//Ano atual é posterior ao ano da data de validade
            } else if (dataAtual.getAno() == dataValidade.getAno()) {
                if(dataAtual.getMes() > dataValidade.getMes()) {
                    return true;//Mes atual é posterior ao ano da data de validade
                } else if (dataAtual.getMes() == dataValidade.getMes()) {
                    if(dataAtual.getDia() > dataValidade.getDia()) {
                        return true;//Dia atual é posterior ao ano da data de validade
                    }
                }
            }
        }
        return false;
    }
}
