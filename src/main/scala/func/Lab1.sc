object sc {
  val zones = java.util.TimeZone.getAvailableIDs
  zones.map(_.split("/"))
    .filter(_.length > 1)
    .map(_ (1))
    .grouped(10)
    .toArray.map(_ (0))

  // writing while control structure
  def While(cond: () => Boolean, body: () => Unit): Unit = {
    if (cond()) {
      body();
      While(cond, body)
    }
  }

  val n = 10
  var i = 1
  var f = 1
  While(() => i < n, () => {
    f *= i; i += 1
  })
  f

  /**
    * doing the same with currying named parameters
    * @param cond
    * @param body
    */
  def While1(cond: Boolean) (body: Unit): Unit = {
    if (cond) {
      body;
      While1(cond) (body)
    }
  }

  While1(i < n)( {f *= i; i += 1})
  f

  //While1(true)(println("..."))


}