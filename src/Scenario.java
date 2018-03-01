public class Scenario {
    private int tick = 0;
    private Grid grid;
    
    Scenario() {
        this.tick();
    }

	public void tick() {
		this.tick++;
	}
}