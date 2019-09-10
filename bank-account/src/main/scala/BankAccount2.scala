trait BankAccount2 {
  def closeAccount(): Unit

  def getBalance: Option[Int]

  def incrementBalance(increment: Int): Option[Int]
}

protected case class Account() extends BankAccount2 {
  @volatile private var balance: Option[Int] = Some(0)

  override def closeAccount(): Unit = balance = None

  override def getBalance: Option[Int] = balance

  override def incrementBalance(increment: Int): Option[Int] = synchronized {
    balance = balance.map(_ + increment)
    balance
  }
}

object Bank2 {
  def openAccount(): BankAccount2 = Account()
}