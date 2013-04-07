package models

import com.itextpdf.text._
import com.itextpdf.text.pdf._

import com.mongodb.casbah.Imports._

import java.io._

object TestDocument
{
  def getPdf = {
    val byteout = new ByteArrayOutputStream
    val doc = new Document(PageSize.A4, 20, 20, 25, 15)
    val writer = PdfWriter.getInstance(doc, byteout)
    doc.open

    val anchorTarget = new Anchor("First page of the document.")
    anchorTarget.setName("BackToTop")

    val paragraph1 = new Paragraph
    paragraph1.add(anchorTarget)
    doc.add(paragraph1)

    doc.add(new Paragraph("Some more text on the first page with different color and font type.",
      FontFactory.getFont(FontFactory.COURIER ,14, Font.BOLD, new CMYKColor(0, 255, 0, 0))))

    doc.close

    byteout
  }
}
