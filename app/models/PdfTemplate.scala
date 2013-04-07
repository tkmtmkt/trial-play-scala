package models

import com.itextpdf.text._
import com.itextpdf.text.pdf._

import java.io._

object PdfTemplate
{
  def getPdf = {
    val byteout = new ByteArrayOutputStream
    val reader = new PdfReader("report.pdf")
    val stamper = new PdfStamper(reader, byteout)

    val form = stamper.getAcroFields

    //form.setField("", "")

    stamper.setFormFlattening(true)

    stamper.close

    byteout
  }
}
