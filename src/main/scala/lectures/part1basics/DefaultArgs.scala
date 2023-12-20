package lectures.part1basics

object DefaultArgs extends App {
  // Practice
  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1280): Unit = println(s"Saving $width x $height picture in $format format")

  savePicture(height = 400, width = 800, format = "bmp")
}
