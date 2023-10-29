package org.example;

public class PerecheNumere {

    private int _variabila1;
    private int _variabila2;

    public PerecheNumere(int variabila1,int variabila2){
        this._variabila1 = variabila1;
        this._variabila2 = variabila2;
    }
    public PerecheNumere(){
    }


    //getters
    public int getVariabila1(){
        return this._variabila1;
    }
    public int get_variabila2(){
        return this._variabila2;
    }

    //setters
    public void setVariabila1(int variabila1){
        this._variabila1 = variabila1;
    }

    public void setVariabila2(int variabila2){
        this._variabila2 = variabila2;
    }

    public boolean checkIfNumbersAreFibonacciGroup(){
        if(this._variabila2 == 1 && this._variabila1 == 1)
            return true;

        long a = 1, b = 1;

        while (true) {
            long next = a + b;

            if (next == this._variabila1 && b == this._variabila2) {
                return true;
            } else if (next == this._variabila2 && b == this._variabila1) {
                return true;
            } else if (next > Math.max(this._variabila2, this._variabila1)) {
                break;
            }
            a = b;
            b = next;
        }
        return false;

    }

    public int cmmdc() {
        while (this._variabila2 != 0) {
            int temp = this._variabila2;
            _variabila2 = _variabila1 % _variabila2;
            _variabila1 = temp;
        }
        return Math.abs(_variabila1);
    }

    public  boolean sumaCifrelorEgala() {
        return (sumaCifrelor(this._variabila1) == sumaCifrelor(this._variabila2));
    }

    public  int sumaCifrelor(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public boolean nrCifrelorPareEgala(){
        return (nrCifrePare(this._variabila1) == nrCifrePare(this._variabila2));
    }
    public int nrCifrePare(int num){
        int nr = 0;
        while(num!=0){
            int cifra = num % 10;
            if(cifra % 2 ==0)
                nr++;
            num/= 10;
        }
        return nr;
    }

}
