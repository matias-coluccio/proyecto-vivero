package Enum;

public enum TipoDeArticulo {
    Agroquimico(1),
    Maceta(2),
    Planta(3),
    Tierra(4),
    Herramienta(5);

    private int value;

    private TipoDeArticulo(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
