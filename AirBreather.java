public class AirBreather extends Adventurer {
    private int airIntake, airIntakeMax;
    private String preferredAir;

    public AirBreather(String name, int hp, String airType) {
        super(name, hp);
        airIntakeMax = 100;
        airIntake = airIntakeMax / 2;
        this.preferredAir = airType;
    }
    public AirBreather(String name, int hp) {
        this(name, hp, "default");
    }
    public AirBreather(String name) {
        this(name, 100);
    }
    public AirBreather() {
        this("Air bender");
    }

    public String getSpecialName() {
        return "Air level";
    };

    //accessor methods
    public int getSpecial() {
        return airIntake;
    }

    public void setSpecial(int n) {
        airIntake +=n;
    }

    public int getSpecialMax() {
        return this.airIntakeMax;
    }

    /*
        all adventurers must have a way to attack enemies and
        support their allys
    */
    //hurt or hinder the target adventurer

    public String attack(Adventurer other) {
        int damage = (int) (Math.random() * 10) + 5;
        other.applyDamage(damage);
        this.setSpecial(damage);
        if(other.getHP()<=0) {
          return("Killed " + other.getName() + " by breathing all over them");
        }
        else{
          return("Did " + damage + " damage to " + other.getName() + " by breathing over them.");
        }
      }
  
      public String specialAttack(Adventurer other) {
        if(getSpecial() >= 25 && (getSpecial() <= getSpecialMax())) {
          setSpecial(getSpecial()-25);
          int damage = (int)(Math.random()*10+Math.random()*10)+5;
          other.applyDamage(damage);
          return this.getName() + " used their " + preferredAir + " skills to attack " + other.getName() + " dealing " + damage + " points of damage.";
        } else {
          return "Not enough air to use the special attack. Instead "+ attack(other);
        }
      }
      
      public String support(Adventurer other) {
        int heal = (int) (Math.random() * 10) + 5;
        other.setHP(other.getHP()+heal);
        return("Blew on " + other.getName() + " and healed by " + heal);
      }
      public String support() {
        int heal = (int) (Math.random() * 10) + 5;
        this.setHP(this.getHP()+heal);
        return("Yawned and healed by " + heal);
      }
}