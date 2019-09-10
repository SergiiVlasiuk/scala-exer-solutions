case class BankAccount4(private var balance: Option[Int] = Some(0)) {
  def incrementBalance(value: Int): Option[Int] = synchronized {
    if (isAllowed) {
      balance = balance.map(_ + value)
    }
    balance
  }

  def getBalance: Option[Int] = {
    isAllowed
    balance
  }

  def closeAccount(): Unit = synchronized {
    if (isAllowed) balance = None
  }

  private def isAllowed(): Boolean = {
    if (balance == None) throw AccountOperationException("Account is closed")
    true
  }
}

object Bank4 {
  def openAccount(): BankAccount4 = BankAccount4()
}

case class AccountOperationException(s: String) extends Exception(s) {}
