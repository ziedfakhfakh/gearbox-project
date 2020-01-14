package electrics.industries;

import static org.junit.Assert.*;
import org.junit.Test;

public class GearboxTest {

	@Test
	public final void gearboxDoitWhenRegimeMoreThanMax() {
		Gearbox gearbox = new Gearbox();
		int regimeMoteurMax = 2000;
		for (int i = 1; i < 6; i++) {
			gearbox.doit(regimeMoteurMax + 1);
		}
		assertEquals(Integer.valueOf(5), Integer.valueOf(gearbox.getS()));
	}

	@Test
	public final void gearboxDoitWhenRegimeLessThanMin() {
		Gearbox gearbox = new Gearbox();
		int regimeMoteurMin = 500;
		for (int i = 1; i < 6; i++) {
			gearbox.doit(regimeMoteurMin - 1);
		}
		assertEquals(Integer.valueOf(1), Integer.valueOf(gearbox.getS()));
	}

	@Test
	public final void gearboxDoitWhenRegimeMinAfterMax() {
		Gearbox gearbox = new Gearbox();
		int regimeMoteurMin = 500;
		int regimeMoteurMax = 2000;
		for (int i = 1; i < 6; i++) {
			gearbox.doit(regimeMoteurMin - 1);
			gearbox.doit(regimeMoteurMax + 1);
		}
		assertEquals(Integer.valueOf(2), Integer.valueOf(gearbox.getS()));
	}

	@Test
	public final void gearboxDoitWhenRegimeMaxAfterMin() {
		Gearbox gearbox = new Gearbox();
		int regimeMoteurMin = 500;
		int regimeMoteurMax = 2000;
		for (int i = 1; i < 6; i++) {
			gearbox.doit(regimeMoteurMax + 1);
			gearbox.doit(regimeMoteurMin - 1);
		}
		assertEquals(Integer.valueOf(1), Integer.valueOf(gearbox.getS()));
	}
}
