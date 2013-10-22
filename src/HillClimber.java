import java.util.Random;


public class HillClimber {
	
	int n = 5 + 1;
	int [] rules = new int[n * n * n];
	Initialization init;
	Automata automate;
	
	public HillClimber()
	{
		Random generator = new Random();
		init = new Initialization();
		automate = new Automata(20);

		try {

			for(int i=0;i<216;i++)
			{		
				rules[i] = generator.nextInt(4);
			} 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void iterer(int nb_iterations, int [] regles)
	{
		Random generator = new Random();
		
		int [] anciennes_regles;
		
		int regle_a_changer = 0;
		int fit = 0;
		
		
		for (int i = 1; i > 0; i=1) {
			init.init(regles);
			anciennes_regles = copier_tableau(regles);
			regle_a_changer = generator.nextInt(regles.length);
			regles[regle_a_changer] = generator.nextInt(4);
			
			if(automate.f(regles, 20) > fit)
			{
				fit = automate.f(regles, 20);
				System.out.println("Nouvelle performance : " + fit);
			}
			else
			{
				regles = copier_tableau(anciennes_regles);
				//System.out.println("BAD : " + automate.f(regles, 20));
			}
		}
		System.out.println("Fin");
		
	}
	
	public int[] copier_tableau(int[] tableau_a_copier)
	{
		int[] result = new int[tableau_a_copier.length];
		
		for (int i = 0; i < tableau_a_copier.length; i++) {
			result[i] = tableau_a_copier[i];	
		}
		
		return result;
	}

}
