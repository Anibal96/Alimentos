
/**
 * Write a description of class Alimento here.
 * 
 * @author (Anibal) 
 * @version (a version number or a date)
 */
public class Alimento
{
    //Guarda el nombre del alimento
    private String nombre;
    //Guarda las proteínas del alimento
    private float proteinas;
    //Guarda los carbohidratos del alimento
    private float carbohidratos;
    //Guarda las grasas del alimento
    private float grasas;
    //Guarda las calorias del alimento
    private float calorias;
    /**
     * Constructor for objects of class Alimento
     */
    public Alimento(String nombre, float proteinas, float carbohidratos, float grasas)
    {
        this.nombre = nombre;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
        calorias = (proteinas * 4) + (carbohidratos * 4) + (grasas * 9);
    }

    /**
     * Este Metodo nos muestra los valores de los distintos componentes del alimento.
     */
    public void muestraDatos()
    {
        System.out.println("Nombre: " + nombre);
        System.out.println("Proteinas por cada 100 gramos: " + proteinas);
        System.out.println("Carbohidratos por cada 100 gramos: " + carbohidratos);
        System.out.println("Grasas por cada 100 gramos: " + grasas);
        System.out.println("Calorias: " + calorias);
        String mayoritario = "proteinas";
        float mayor = proteinas;
        if (carbohidratos == mayor) {
            mayoritario = "carbohidratos, proteinas";
        }
        else if (carbohidratos > mayor) {
            mayor = carbohidratos;
            mayoritario = "carbohidratos";
        }
        if (grasas == mayor) {
            mayoritario = "grasas, " + mayoritario;
        }
        else if (grasas > mayor) {
            mayoritario = "grasas";
        }
        System.out.println("Componente/s mayoritario/s: " + mayoritario);
    }
    /**
     * Devuelve las proteinas del alimento.
     */
    public float getProteinas()
    {
        return proteinas;
    }
    /**
     * Devuelve las carbo hidratos del alimento.
     */
    public float getCarboHidratos()
    {
        return carbohidratos;
    }
    /**
     * Devuelve las grasas del alimento.
     */
    public float getGrasas()
    {
        return grasas;
    }
}
