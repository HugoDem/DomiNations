
public class Domino {
	public Integer nbCouronne1;
	public String type1;
	public Integer nbCouronne2;
	public String type2;
	public Integer numeroDomino;
	public int[] position;  //Décomposée en posType1 et posType2 {{posType1},{posType2}} 

	public Domino(Integer nbCouronne1, String type1, Integer nbCouronne2, String type2, Integer numeroDomino) {
		this.nbCouronne1 = nbCouronne1;
		this.type1 = type1;
		this.nbCouronne2 = nbCouronne2;
		this.type2 = type2;
		this.numeroDomino = numeroDomino;
	}

	public void placer(int[] position) {
		this.position = position;
	}
}
