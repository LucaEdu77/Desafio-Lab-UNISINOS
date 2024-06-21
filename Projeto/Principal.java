import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = null;
        Produto produto = null;

        Data dataAtual = new Data(20,10,2023);//Data referencia pra verificar se esta vencido.

        int opcao = 0;

        while (opcao != 3) {
            System.out.println("(1) Criar uma loja");
            System.out.println("(2) Criar um produto");
            System.out.println("(3) Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa

            if (opcao == 1) {
                System.out.println("Digite o nome da loja: ");
                String nome = scanner.nextLine();

                System.out.println("Digite a quantidade de funcionários: ");
                int quantidadeFuncionarios = scanner.nextInt();

                scanner.nextLine(); //limpa

                System.out.println("Digite o salário base dos funcionários: ");
                double salarioBaseFuncionario = scanner.nextDouble();

                scanner.nextLine();

                System.out.println("Digite o nome da rua: ");
                String nomeDaRua = scanner.nextLine();

                System.out.println("Digite a cidade: ");
                String cidade = scanner.nextLine();

                System.out.println("Digite o estado: ");
                String estado = scanner.nextLine();

                System.out.println("Digite o país: ");
                String pais = scanner.nextLine();

                System.out.println("Digite o CEP: ");
                String cep = scanner.nextLine();

                System.out.println("Digite o número: ");
                String numero = scanner.nextLine();

                System.out.println("Digite o complemento: ");
                String complemento = scanner.nextLine();

                Endereco endereco = new Endereco(nomeDaRua, cidade, estado, pais, cep, numero, complemento);

                System.out.println("Digite a data de fundação: ");
                String dataFundacaoStr = scanner.nextLine();

                String[] dataParts = dataFundacaoStr.split("/");
                int dia = Integer.parseInt(dataParts[0]);
                int mes = Integer.parseInt(dataParts[1]);
                int ano = Integer.parseInt(dataParts[2]);

                Data dataFundacao = new Data(dia, mes, ano);

                int tamanhoEstoque = scanner.nextInt();

                loja = new Loja(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanhoEstoque);
            } else if (opcao == 2) {
                System.out.println("Digite o nome do produto: ");
                String nomeProduto = scanner.nextLine();

                System.out.println("Digite o preço: ");
                double preco = scanner.nextDouble();

                scanner.nextLine();

                System.out.println("Digite a data de validade: ");
                String dataValidadeStr = scanner.nextLine();

                String[] dataParts = dataValidadeStr.split("/");
                int dia = Integer.parseInt(dataParts[0]);
                int mes = Integer.parseInt(dataParts[1]);
                int ano = Integer.parseInt(dataParts[2]);
                Data dataValidade = new Data(dia, mes, ano);

                produto = new Produto(nomeProduto, preco, dataValidade);

                if(produto != null){
                    boolean vencido = produto.estaVencido(dataAtual);
                    if(vencido){
                        System.out.println("PRODUTO VENCIDO");
                    }
                    else {
                        System.out.println("PRODUTO NÃO VENCIDO");
                    }
                }
            } else if (opcao != 3) {
                System.out.println("Opção inválida");
            }

            if (opcao == 1) {
                System.out.println("Informações da loja: ");
                System.out.println(loja);
            }
            }
        }
    }

