import java.time.temporal.TemporalAdjusters.{dayOfWeekInMonth, lastInMonth, nextOrSame}
import java.time.{DayOfWeek, LocalDate}

import Schedule.Schedule

case class Meetup2(month: Int, year: Int) {

  private val startOfMonth = LocalDate.of(year, month, 1)

  def day(dayOfWeek: DayOfWeek, schedule: Schedule): LocalDate =
    schedule match {
      case Schedule.Teenth => startOfMonth
        .withDayOfMonth(13)
        .`with`(nextOrSame(dayOfWeek))
      case Schedule.Last => startOfMonth
        .`with`(lastInMonth(dayOfWeek))
      case _ => startOfMonth
        .`with`(dayOfWeekInMonth(schedule.id, dayOfWeek))
    }

}
