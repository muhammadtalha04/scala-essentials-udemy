package lectures.part2oop

object Enums extends App {
  enum Permissions {
   case READ, WRITE, EXECUTE, NONE

   def openDocument() : Unit = {
     if (this == READ) println("Opening document...")
     else println("Permission denied!")
   }
  }

  val perms = Permissions.NONE

  perms.openDocument()

  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4)
    case WRITE extends PermissionsWithBits(2)
    case EXEC extends PermissionsWithBits(1)
    case NONE extends PermissionsWithBits(0)
  }
  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits =
      PermissionsWithBits.WRITE
  }

  val somePerOrdinal = perms.ordinal
  val allPerms = PermissionsWithBits.values

  println(PermissionsWithBits.WRITE)

  println(somePerOrdinal)
}
