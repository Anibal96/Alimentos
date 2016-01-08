
/**
 * Write a description of class Usuario here.
 * 
 * @author (Anibal) 
 * @version (a version number or a date)
 */
public class Usuario
{
    //Nombre del usuario.
    private String nombre;
    //Cantidad total de proteinas ingeridas por el usuario.
    private float proteinasDelUsuario;
    //Cantidad total de carbo hidratos ingeridas por el usuario.
    private float carboHidratosDelUsuario;
    //Cantidad total de grasas ingeridas por el usuario.
    private float grasasDelUsuario;
    //Cantidad total de calorias ingeridas por el usuario.
    private float caloriasTotalesDelUsuario;
    /**
     * Constructor for objects of class Usuario
     */
    public Usuario(String nombre)
    {
        this.nombre = nombre;
        proteinasDelUsuario = 0;
        carboHidratosDelUsuario = 0;
        grasasDelUsuario = 0;
        caloriasTotalesDelUsuario = 0;
    }
    
    /**
     * Método que permite comer un alimento.
     */
    public void comer (Alimento comida, float cantidad)
    {
        proteinasDelUsuario = proteinasDelUsuario + (((comida.getProteinas())/100)*cantidad);
        carboHidratosDelUsuario = carboHidratosDelUsuario + (((comida.getCarboHidratos())/100)*cantidad);
        grasasDelUsuario = grasasDelUsuario + (((comida.getGrasas())/100)*cantidad);
        caloriasTotalesDelUsuario = (proteinasDelUsuario * 4) + (carboHidratosDelUsuario * 4) 
                                    + (grasasDelUsuario * 9);
    }
    
    /**
     * Método que muestra los datos del usuario por pantalla.
     */
    public void mostrarDatos()
    {
        System.out.println("Nombre:                                    " + nombre);
        System.out.println("Gramos totales de proteinas ingeridos:     " + proteinasDelUsuario);
        System.out.println("Gramos totales de carbohidratos ingeridos: " + carboHidratosDelUsuario);
        System.out.println("Gramos totales de grasas ingeridos:        " + grasasDelUsuario);
        System.out.println("Calorias totales ingeridas:                " + caloriasTotalesDelUsuario);
    }
}