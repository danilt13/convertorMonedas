package convertorClase;

public class Principal {
    public static void main(String[] args) {
        ConvertidorMonedas convertidor = new ConvertidorMonedas();
        Menu menu = new Menu(convertidor);
        menu.iniciar();
    }
}

