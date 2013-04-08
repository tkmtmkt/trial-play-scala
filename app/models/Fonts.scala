package models

import com.itextpdf.text._
import com.itextpdf.text.pdf._

object Fonts {
  lazy val x = FontFactory.getFont(FontFactory.COURIER ,14, Font.BOLD, new CMYKColor(0, 255, 0, 0))

  //(ゴシック15pt(太字)
  lazy val header =
    new Font(BaseFont.createFont("HeiseiKakuGo-W5", "UniJIS-UCS2-H", BaseFont.NOT_EMBEDDED), 15, Font.BOLD)

  //ゴシック11pt
  lazy val g11 =
    new Font(BaseFont.createFont("HeiseiKakuGo-W5", "UniJIS-UCS2-H", BaseFont.NOT_EMBEDDED), 11)

  //ゴシック10pt
  lazy val g10 =
    new Font(BaseFont.createFont("HeiseiKakuGo-W5", "UniJIS-UCS2-H", BaseFont.NOT_EMBEDDED), 10)

  //明朝10pt
  lazy val m10 =
    new Font(BaseFont.createFont("HeiseiMin-W3", "UniJIS-UCS2-HW-H", BaseFont.NOT_EMBEDDED), 10)

  //ゴシック11pt(下線あり)
  lazy val underline_11 =
    new Font(BaseFont.createFont("HeiseiKakuGo-W5", "UniJIS-UCS2-H", BaseFont.NOT_EMBEDDED), 11, Font.UNDERLINE)

  //ゴシック11pt(赤)
  lazy val red_11 =
    new Font(BaseFont.createFont("HeiseiKakuGo-W5", "UniJIS-UCS2-H", BaseFont.NOT_EMBEDDED), 11, Font.NORMAL, BaseColor.RED)
}
