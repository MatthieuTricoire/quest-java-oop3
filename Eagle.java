public class Eagle extends Bird implements Fly {

  private boolean flying;
  private int altitude;

  public Eagle(String name) {
    super(name);
    this.flying = false;
    this.altitude = 0;
  }

  public int getAltitude() {
    return altitude;
  }

  public boolean isFlying() {
    return flying;
  }

  @Override
  public String sing() {
    return "Screech!";
  }

  /**
   * Smooth landing. Need to at 1m or less to land.
   */
  @Override
  public void land() {
    if (this.flying && this.altitude <= 1) {
      System.out.printf("%s lands on the ground.%n", this.getName());
    } else {
      System.out.printf("%s is too high, it can't land.%n", this.getName());
    }
  }

  /**
   * Take off cap'tain
   */
  @Override
  public void takeOff() {
    if (!this.flying && this.altitude == 0) {
      System.out.printf("%s takes off in the sky.%n", this.getName());
      this.flying = true;
    }
  }

  /**
   * To the moon
   */

  @Override
  public int ascend(int meters) {
    if (this.flying) {
      this.altitude = Math.min(this.altitude + meters, 999);
      System.out.printf("%s flies upwards, altitude : %d%n.", this.getName(), this.getAltitude() + meters);
    }
    return this.altitude;
  }

  @Override
  public int descend(int meters) {
    if (this.flying) {
      this.altitude = Math.max(this.altitude - meters, 0);
      System.out.printf("%s flies upwards, altitude : %s%n.", this.getName(), this.getAltitude());
    }
    return this.altitude;
  }

  @Override
  public void glide() {
    System.out.printf("%s glide.%n", this.getName());
  }
}
