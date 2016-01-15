import java.util.ArrayList;
public class Usuario
{
    //nombre del usuario
    private String nombreCompleto;
    //proteinas  ingeridas por el usuario
    private float proteinasIngeridas;
    //carbohidratos   ingeridas por el usuario
    private float carbohidratosIngeridos;
    //grasas ingeridas por el usuario
    private float grasasIngeridas;
    //calorias totales ingeridas por el usuario
    private float caloriasIngeridas;
    //nombre del alimento que mas calorias tiene que ha consumido el usuario.
    private String nombreDelAlimentoMasCalorico;
    //calorias del alimento que mas calorias ha aportado hasta ahora
    private float caloriasDelAlimentoMasCalorico;
    //Alimentos consumidos por el usuario.
    private ArrayList<Alimento> alimentos;

    /**
    *Constructor de la clase usuario
    */
    public Usuario (String nombreCompleto)
    {
        this.nombreCompleto = nombreCompleto;   
        proteinasIngeridas = 0;
        carbohidratosIngeridos = 0;
        grasasIngeridas = 0;
        caloriasIngeridas = 0;
        nombreDelAlimentoMasCalorico = null;
        caloriasDelAlimentoMasCalorico = 0;
        alimentos = new ArrayList<Alimento>();
    }
    
    /**
    * Metodo utilizado para dar de comer al usuario
    */
    public void comer(Alimento alimentoQueCome, float gramosDelAlimento)
    {
        proteinasIngeridas = proteinasIngeridas + (alimentoQueCome.getProteinas() / 100 * gramosDelAlimento);
        carbohidratosIngeridos = carbohidratosIngeridos + (alimentoQueCome.getCarbohidratos() / 100 * gramosDelAlimento);
        grasasIngeridas = grasasIngeridas + (alimentoQueCome.getGrasas() / 100 * gramosDelAlimento);
        caloriasIngeridas = caloriasIngeridas + (alimentoQueCome.getCalorias() / 100 * gramosDelAlimento);
        if (caloriasDelAlimentoMasCalorico <= alimentoQueCome.getCalorias()){
            caloriasDelAlimentoMasCalorico = alimentoQueCome.getCalorias();
            nombreDelAlimentoMasCalorico = alimentoQueCome.getNombre();
        }
        alimentos.add(alimentoQueCome);
    }
    
    /**
    * Metodo que muestra la informacion de lo ingerido por el usuario.
    */
    public void muestraDatos()
    {
        float totalNutrientes = (proteinasIngeridas + grasasIngeridas + carbohidratosIngeridos) / 100;
            String datosProteinas = "Gramos totales de proteinas ingeridos:     " + proteinasIngeridas;
            String datosCarbohidratos = "Gramos totales de carbohidratos ingeridos: " +             carbohidratosIngeridos;
            String datosGrasas = "Gramos totales de grasas ingeridos:        " + grasasIngeridas;
            if (proteinasIngeridas > 0) {
                datosProteinas = datosProteinas + " (" + proteinasIngeridas / totalNutrientes + "%)";
            }
            if (carbohidratosIngeridos > 0) {
                datosCarbohidratos = datosCarbohidratos + " (" + carbohidratosIngeridos / totalNutrientes + "%      )";
            }
            if (grasasIngeridas > 0) {
                datosGrasas = datosGrasas + " (" + grasasIngeridas / totalNutrientes + "%)";
            }
            System.out.println("Nombre:                                    " + nombreCompleto);
            System.out.println(datosProteinas);    
            System.out.println(datosCarbohidratos);
            System.out.println(datosGrasas);
            System.out.println("Calorias totales ingeridas:                " + caloriasIngeridas);  
    }
    
    /**
     * Método que devuelve las calorias totales que ha consumido el usuario.
     */
    public float getCaloriasIngeridas()
    {
        return caloriasIngeridas;
    }
    
    /**
     * Método que devuelve el nombre del usuario.
     */
    public String getNombreCompleto()
    {
        return nombreCompleto;
    }
    
    /**
     * Método que compara un usuario con otro.
     */
    public void comparacion (Usuario segundoUsuario)
    {
            if (caloriasIngeridas > segundoUsuario.getCaloriasIngeridas()){
                System.out.println(nombreCompleto + " ha consumido más calorias que " + segundoUsuario.getNombreCompleto() + " ( " + caloriasIngeridas + " frente a " + segundoUsuario.getCaloriasIngeridas() + " ) ");
            }
            else if (caloriasIngeridas < segundoUsuario.getCaloriasIngeridas()){
                System.out.println(segundoUsuario.getNombreCompleto() + " ha consumido más calorias que " + nombreCompleto + " ( " + segundoUsuario.getCaloriasIngeridas() + " frente a " + caloriasIngeridas + " ) ");
            }
            else {
                System.out.println(nombreCompleto + " ha consumido las mismas calorias que " + segundoUsuario.getNombreCompleto() + " ( " + caloriasIngeridas + " igual a " + segundoUsuario.getCaloriasIngeridas() + " ) ");
            } 
    }
    /**
     * Método que muestra por pantalla el nombre del alimento mas calorico.
     */
    public void alimentoMasCaloricoConsumido()
    {
        if (nombreDelAlimentoMasCalorico == null){
            System.out.println("El usuario no a consumido ningun alimento");
        }
        else{
            System.out.println("Alimento más calórico ingerido por este usuario hasta el momento: " + nombreDelAlimentoMasCalorico + " (" + caloriasDelAlimentoMasCalorico + " calorias por cada 100 gramos)");
        }
    }
    /**
     * Método que devuelve los datos del alimento que se encuentra en el indice de esa colección.
     * En caso de que el indice introduccido
     */
    public void muestraDatosDeUnAlimentoConsumido(int index)
    {
        index = index - 1;
        if(index >= 0 && index < alimentos.size()) {
            System.out.println("el alimento comido en la posicion " + (index+1) + " es:");
            alimentos.get(index).muestraDatos();
        }
        else
        {
            System.out.println("El indice introduccido no es correcto.");
        }
    }
    public void numeroDeVecesComido(String nombreAlimento)
    {
        int contador = 0;
		for (Alimento alimentosConsumidos : alimentos)
        {
            if (alimentosConsumidos.getNombre().contains(nombreAlimento))
            {
                contador = contador +1;
            }
        }
        if (contador == 0)
        {
            System.out.println(" El usuario no ha comido ese alimento");
        }
		else if(contador == 1){
			System.out.println("El usuario a comido " + nombreAlimento + " "+ contador + " vez");
		}
		else{
			System.out.println("El usuario a comido " + nombreAlimento + " "+ contador + " veces");
		}
    }
	public void nombreDeLosAlimentosConsumidos()
	{
		for (Alimento alimentosConsumidos : alimentos)
		{
			int contador = 0;
			Alimento alimentoConsumidoActual = alimentosConsumidos;
			for (Alimento alimentosConsumidos1 : alimentos)
			{
				if (alimentoConsumidoActual.getNombre().contains(alimentosConsumidos1.getNombre()))
            	{
                	contador = contador +1;
            	}
			}
			if (contador > 1)
			{
				System.out.println("El alimento " + alimentoConsumidoActual.getNombre() + " lo ha comido " + contador + " veces.");
			}
			else
			{
				System.out.println("El alimento "+ alimentoConsumidoActual.getNombre() +" no se ha consumido mas de 1 vez");
			}
		}
	}
}