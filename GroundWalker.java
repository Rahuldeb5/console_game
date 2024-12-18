public class GroundWalker extends Adventurer {
    private int groundDistance, maxGroundDistance;
    private String preferredGround;

    public GroundWalker(String name, int hp, String groundType) {
      super(name, hp);
      maxGroundDistance = 100;
      groundDistance = maxGroundDistance / 2;
      this.preferredGround = groundType;
    }
    public GroundWalker(String name, int hp) {
      this(name, hp, "default");
    }
    public GroundWalker(String name) {
      this(name, 100);
    }
    public GroundWalker() {
      this("Earth minion");
    }
    public String getSpecialName() {
      return "Distance";
    }
    public int getSpecial() {
      return groundDistance;
    }
    public void setSpecial(int n) {
      groundDistance+=n;
    }
    public int getSpecialMax() {
      return this.maxGroundDistance;
    }
    public String attack(Adventurer other) {
      int damage = (int) (Math.random() * 10) + 5;
      other.applyDamage(damage);
      this.setSpecial(damage);
      if(other.getHP()<=0) {
        return("Killed " + other.getName() + " by walking all over them");
      }
      else{
        return("Did " + damage + " damage to " + other.getName() + " by walking over them.");
      }
    }

    public String specialAttack(Adventurer other) {
      if(getSpecial() >= 25 && (getSpecial() <= getSpecialMax())) {
        setSpecial(getSpecial()-25);
        int damage = (int)(Math.random()*10+Math.random()*10)+5;
        other.applyDamage(damage);
        return this.getName() + " used their " + preferredGround + " skills to attack " + other.getName() + " dealing " + damage + " points of damage.";
      } else {
        return "Not enough distance to use the special attack. Instead "+ attack(other);
      }
    }

    public String support(Adventurer other) {
      int heal = (int) (Math.random() * 10) + 5;
      other.setHP(other.getHP()+heal);
      return("Stomped on " + other.getName() + " and healed by " + heal);
    }
    public String support() {
      int heal = (int) (Math.random() * 10) + 5;
      this.setHP(this.getHP()+heal);
      return("Sat down and healed by " + heal);
    }  
  }
  
