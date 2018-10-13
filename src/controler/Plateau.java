package controler;

public class Plateau {

	//Tableau de 11 cases sur 19


	private static final Plateau instance = new Plateau();


	 private Plateau(){}

	  public static Plateau getInstance(String lvl){

	          return instance;
	      }




}

