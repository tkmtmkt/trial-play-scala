package models

import com.itextpdf.awt.AsianFontMapper._
import com.itextpdf.text._

object Fonts {
  lazy val x = FontFactory.getFont(FontFactory.COURIER ,14, Font.BOLD, BaseColor.MAGENTA)

  //(ゴシック15pt(太字)
  lazy val header = FontFactory.getFont(JapaneseFont_Go, JapaneseEncoding_H, 15, Font.BOLD)

  //ゴシック11pt
  lazy val g11 = FontFactory.getFont(JapaneseFont_Go, JapaneseEncoding_H, 11)

  //ゴシック10pt
  lazy val g10 = FontFactory.getFont(JapaneseFont_Go, JapaneseEncoding_H, 10)

  //明朝10pt
  lazy val m10 = FontFactory.getFont(JapaneseFont_Min, JapaneseEncoding_HW_H, 10)

  //ゴシック11pt(下線あり)
  lazy val underline_11 = FontFactory.getFont(JapaneseFont_Go, JapaneseEncoding_H, 11, Font.UNDERLINE)

  //ゴシック11pt(赤)
  lazy val red_11 = FontFactory.getFont(JapaneseFont_Go, JapaneseEncoding_H, 11, Font.NORMAL, BaseColor.RED)
}
