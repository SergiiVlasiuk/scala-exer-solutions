import java.util.concurrent.atomic.AtomicInteger

case class BankAccount3() {
  var totalBalance:Option[AtomicInteger] = Some(new AtomicInteger(0))

  def getBalance:Option[Int] =
    totalBalance map (_.get())

  def incrementBalance(amount:Int):Option[Int] =
    totalBalance map (_.addAndGet(amount))

  def closeAccount() = totalBalance = None
}

object Bank3 {
  def openAccount(): BankAccount3 = BankAccount3()
}