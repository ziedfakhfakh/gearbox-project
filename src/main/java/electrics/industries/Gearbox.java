package electrics.industries;

public class Gearbox {

    private int vitesse = 0;

    public void calculerVitesse(int regimeMoteur) {
        if (vitesse < 0) {
            // do nothing!
        }
        else {
            if (vitesse > 0) {
                if (regimeMoteur > 2000) {
                	vitesse++;
                } else if (regimeMoteur < 500) {
                	vitesse--;
                }
            } if (vitesse > 6) {
            	vitesse--;
            } else if (vitesse < 1) {
            	vitesse++;
            }
        }
    }

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

    
}