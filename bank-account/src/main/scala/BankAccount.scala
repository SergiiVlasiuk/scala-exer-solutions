case class BankAccount(private var balance: Option[Int] = Some(0)) {
  def incrementBalance(value: Int): Option[Int] = synchronized {
    balance = balance.map(_ + value)
    balance
  }

  def getBalance: Option[Int] = balance

  def closeAccount(): Unit = synchronized {
    balance = None
  }
}

object Bank {
  def openAccount(): BankAccount = BankAccount()
}
