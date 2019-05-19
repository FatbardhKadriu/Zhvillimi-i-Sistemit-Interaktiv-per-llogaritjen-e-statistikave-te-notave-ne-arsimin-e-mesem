package p1;

public class Kredia
{
	private double shkallaInteresitVjetor;
	private int numriViteve;
	private double shumaKredise;

	public Kredia(double shkallaInteresit, int numri, double shuma)
	{
		this.shkallaInteresitVjetor = shkallaInteresit;
		this.numriViteve = numri;
		this.shumaKredise = shuma;
	}

	public double getShkallaInteresitVjetor()
	{
		return shkallaInteresitVjetor;
	}

	public void setShkallaInteresitVjetor(double shkallaInteresit)
	{
		this.shkallaInteresitVjetor = shkallaInteresit;
	}

	public int getNumriViteve()
	{
		return numriViteve;
	}

	public void setNumriViteve(int numri)
	{
		this.numriViteve = numri;
	}

	public double getShumaKredise()
	{
		return shumaKredise;
	}

	public void setShumaKredise(double shuma)
	{
		this.shumaKredise = shuma;
	}

	public double getPagesaMujore()
	{
		double shkallaInteresitMujor = shkallaInteresitVjetor / 1200;
		double pagesaMujore = shumaKredise * shkallaInteresitMujor
				/ (1 - (1 / Math.pow(1 + shkallaInteresitMujor, numriViteve * 12)));
		return pagesaMujore;
	}

	public double getPagesaTotale()
	{
		double pagesaTotale = getPagesaMujore() * numriViteve * 12;
		return pagesaTotale;
	}
}