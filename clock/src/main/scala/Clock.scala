case class Clock(val hour: Int, val minute: Int) {
  def +(c: Clock) = Clock(this.hour + c.hour, this.minute + c.minute)

  def -(c: Clock) = Clock(this.hour - c.hour, this.minute - c.minute)
}

object Clock {
  private def wrapAround(value: Double, wrap: Int): Int = {
    if (value >= 0) Math.floor(value % wrap).toInt
    else Math.floor(wrap + (value % wrap)).toInt
  }

  def apply(hour: Int, minute: Int): Clock = new Clock(wrapAround(hour + (minute / 60.0), 24), wrapAround(minute, 60))

  def apply(minute: Int): Clock = apply(0, minute)
}
