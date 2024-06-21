public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (validarData(dia, mes, ano)){
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data invalida. Mudando para 1/1/2000");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }


    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }


    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    public boolean verificaAnoBissexto(){
        return (ano % 4 == 0 && ano % 100 !=0) || (ano % 400 == 0);
    }

    private boolean validarData(int dia, int mes, int ano){
        if (mes < 1 || mes > 12){
            return false;
        }

        int maxDias = 31;

        if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
            maxDias = 29;
        }
        else if (mes == 2) {
            maxDias = 28;
        }
        return dia >= 1 && dia <= maxDias;
    }

}
