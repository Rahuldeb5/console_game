public class WaterDrinker extends Adventurer {
    private int drinkingCapacity, drinkingCapacityMax;
    private String preferredWater;

    public WaterDrinker(String name, int hp, String waterType) {
      super(name, hp);
      drinkingCapacityMax = 100;
      drinkingCapacity = drinkingCapacityMax / 2;
      this.preferredWater = waterType;
    }
    public WaterDrinker(String name, int hp) {
        this(name, hp, "default");
    }
    public WaterDrinker(String name) {
        this(name, 100);
    }
    public WaterDrinker() {
        this("Water chugger");
    }

    public String getSpecialName() {
      return("Drinking level");
    }
    public int getSpecial() {
      return drinkingCapacity;
    }
    public void setSpecial(int n) {
      drinkingCapacity += n;
    }
    public int getSpecialMax() {
      return this.drinkingCapacityMax;
    }

    public String attack(Adventurer other) {
      int damage = (int) (Math.random() * 10) + 5;
      other.applyDamage(damage);
      this.setSpecial(damage);
      if(other.getHP()<=0) {
        return("Killed " + other.getName() + " by spitting all over them");
      }
      else{
        return("Did " + damage + " damage to " + other.getName() + " by spitting over them.");
      }
    }

    public String specialAttack(Adventurer other) {
      if(getSpecial() >= 25 && (getSpecial() <= getSpecialMax())) {
        setSpecial(getSpecial()-25);
        int damage = (int)(Math.random()*10+Math.random()*10)+5;
        other.applyDamage(damage);
        return this.getName() + " used their " + preferredWater + " skills to attack " + other.getName() + " dealing " + damage + " points of damage.";
      } else {
        return "Not enough water to use the special attack. Instead "+ attack(other);
      }
    }
    
    public String support(Adventurer other) {
      int heal = (int) (Math.random() * 10) + 5;
      other.setHP(other.getHP()+heal);
      return("Sipped on " + other.getName() + " and healed by " + heal);
    }
    public String support() {
      int heal = (int) (Math.random() * 10) + 5;
      this.setHP(this.getHP()+heal);
      return("Guzzled and healed by " + heal);
    }
}

