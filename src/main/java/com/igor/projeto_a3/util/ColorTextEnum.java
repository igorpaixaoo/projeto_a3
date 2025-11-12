package main.java.com.igor.projeto_a3.util;

public enum ColorTextEnum {

    COR_VERDE(){
        @Override
        public String cor() {
            return "\033[0;32m";
        }
    }, COR_VERMELHO(){
        @Override
        public String cor() {
            return "\033[0;31m";
        }
    }, COR_RESET(){
        @Override
        public String cor() {
            return "\u001B[0m";
        }
    };

    public String cor(){
        return "";
    }
}
