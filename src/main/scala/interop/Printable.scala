package interop

/**
  * Created by jubin on 6/26/2017.
  */
trait Printable {
  def print(s: String)
  def println()
  def println(s:String) { print(s);println()}
}
