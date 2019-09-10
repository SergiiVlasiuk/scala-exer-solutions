import java.time.{LocalDate, LocalDateTime}

object Gigasecond {
  private val GIGA_SECOND = 1000000000L

  def add(startDate: LocalDate): LocalDateTime = add(startDate.atStartOfDay)

  def add(startDateTime: LocalDateTime): LocalDateTime = startDateTime.plusSeconds(GIGA_SECOND)
}
