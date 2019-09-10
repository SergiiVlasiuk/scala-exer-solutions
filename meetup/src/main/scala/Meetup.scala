import java.time.temporal.TemporalAdjusters.{dayOfWeekInMonth, lastInMonth, next}
import java.time.{DayOfWeek, LocalDate}

import Schedule.{Last, Schedule, Teenth}

case class Meetup(month: Int, year: Int) {
  private val firstDayInMonth = LocalDate.of(year, month, 1)

  def day(dayOfWeek: DayOfWeek, schedule: Schedule): LocalDate = schedule match {
    case Teenth => firstDayInMonth.withDayOfMonth(12).`with`(next(dayOfWeek))
    case Last => firstDayInMonth.`with`(lastInMonth(dayOfWeek))
    case _ => firstDayInMonth.`with`(dayOfWeekInMonth(schedule.id, dayOfWeek))
    // using of `case _ => ` makes next part is redundant
    //    case First => firstDayInMonth.`with`(nextOrSame(dayOfWeek))
    //    case Second => firstDayInMonth.withDayOfMonth(7).`with`(next(dayOfWeek))
    //    case Third => firstDayInMonth.`with`(dayOfWeekInMonth(3, dayOfWeek))
    //    case Fourth => firstDayInMonth.withDayOfMonth(21).`with`(next(dayOfWeek))
  }
}

object Schedule extends Enumeration {
  type Schedule = Value
  val Teenth, First, Second, Third, Fourth, Last = Value
}

object Meetup {
  val Mon = DayOfWeek.MONDAY
  val Tue = DayOfWeek.TUESDAY
  val Wed = DayOfWeek.WEDNESDAY
  val Thu = DayOfWeek.THURSDAY
  val Fri = DayOfWeek.FRIDAY
  val Sat = DayOfWeek.SATURDAY
  val Sun = DayOfWeek.SUNDAY
}
