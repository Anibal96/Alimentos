
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
	//Porcentaje de proteinas
	private float porcentajeDeProteinas;
	//Porcentaje de carboHidratos
	private float porcentajeDeCarboHidratos;
	//Porcentaje de grasas
	private float porcentajeDeGrasas;
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
		porcentajeDeProteinas = 0;
		porcentajeDeCarboHidratos = 0;
		porcentajeDeGrasas = 0;
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
		float totalGramos = proteinasDelUsuario + carboHidratosDelUsuario + grasasDelUsuario;
		porcentajeDeProteinas = (totalGramos * proteinasDelUsuario)/100;
		porcentajeDeCarboHidratos = (totalGramos * carboHidratosDelUsuario)/100;
		porcentajeDeGrasas = (totalGramos * grasasDelUsuario)/100;
    }
    
    /**
     * Método que muestra los datos del usuario por pantalla.
     */
    public void mostrarDatos()
    {
        System.out.println("Nombre:                                    " + nombre);
        System.out.println("Gramos totales de proteinas ingeridos:     " + proteinasDelUsuario + " ( " + porcentajeDeProteinas + "% )");
        System.out.println("Gramos totales de carbohidratos ingeridos: " + carboHidratosDelUsuario + " ( " + porcentajeDeCarboHidratos + "% )");
        System.out.println("Gramos totales de grasas ingeridos:        " + grasasDelUsuario + " ( " + porcentajeDeGrasas + "% )");
        System.out.println("Calorias totales ingeridas:                " + caloriasTotalesDelUsuario);
    }
}