trait SolarPlanet {
  def coefficient(): Double
  def yearSeconds = 31557600 * coefficient()
}
object Earth extends SolarPlanet {
  def coefficient = 1.0
}
object Mercury extends SolarPlanet {
  def coefficient = 0.2408467
}
object Venus extends SolarPlanet {
  def coefficient = 0.61519726
}
object Mars extends SolarPlanet {
  def coefficient = 1.8808158
}
object Jupiter extends SolarPlanet {
  def coefficient = 11.862615
}
object Saturn extends SolarPlanet {
  def coefficient = 29.447498
}
object Uranus extends SolarPlanet {
  def coefficient = 84.016846
}
object Neptune extends SolarPlanet {
  def coefficient = 164.79132
}

object SpaceAge {
  private val onX = (s: Double, p: SolarPlanet) => s / p.yearSeconds

  def onEarth(seconds: Double): Double = onX(seconds, Earth)
  def onMercury(seconds: Double): Double = onX(seconds, Mercury)
  def onVenus(seconds: Double): Double = onX(seconds, Venus)
  def onMars(seconds: Double): Double = onX(seconds, Mars)
  def onJupiter(seconds: Double): Double = onX(seconds, Jupiter)
  def onSaturn(seconds: Double): Double = onX(seconds, Saturn)
  def onUranus(seconds: Double): Double = onX(seconds, Uranus)
  def onNeptune(seconds: Double): Double = onX(seconds, Neptune)
}
