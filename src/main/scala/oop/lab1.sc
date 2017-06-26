

object lab1 {

  class Time(h: Int, m: Int) {

    private var minutesSinceMidnight = h * 60 + m

    def hours = minutesSinceMidnight / 60

    def minutes = minutesSinceMidnight % 60

    /*
    In scala, a getter and setter will be implicitly defined for all non-private var in a object.
      The getter name is same as the variable name and _= is added for setter name
      minutes is a function and to define its setter we use _
     */
    def minutes_=(newValue: Int): Unit = {
      if (newValue < 0 || newValue > 60) throw new IllegalArgumentException("number of minutes exceeded")
      minutesSinceMidnight = hours * 60 + newValue
    }

    def this(h: Int) {
      this(h, 0)
    }

    if (h < 0 || h >= 24 || m < 0 || m > 60) throw new IllegalArgumentException("Time out of range")

    def before(other: Time) = minutesSinceMidnight <= other.minutesSinceMidnight

    def <(other: Time) = this - other < 0
    def -(other: Time)= hours * 60 + minutes - other.hours * 60 - other.minutes

    override def toString: String = f"(${hours}:${minutes}%02d)"
  }

  object Time{
    def apply(h: Int, m: Int): Time = new Time(h, m)
    def apply(h: Int): Time = new Time(h)
  }

  val morning = Time(4, 0)
  val afternoon = Time(12, 5)
  morning.before(afternoon)
  afternoon.before(morning)
  // val crazy = new Time(-2, 101)

  val noon = Time(12)

  noon.hours
  noon.minutes = 30 // defined by def minutes_
  noon.minutes // defined by def minutes

  morning - noon

  morning < noon

}

