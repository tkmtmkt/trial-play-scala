package models

import com.itextpdf.text._
import com.itextpdf.text.pdf._

import com.mongodb.casbah.Imports._

import java.io._

object TestDocument
{
  def getPdf = {
    val byteout = new ByteArrayOutputStream
    val doc = new Document(PageSize.A4, 30, 30, 35, 25)
    val writer = PdfWriter.getInstance(doc, byteout)

    doc.addAuthor("高松 誠")
    doc.addSubject("PDF文書作成の勉強")

    //val header = new HeaderFooter(

    doc.open

    val anchorTarget = new Anchor("First page of the document.")
    anchorTarget.setName("BackToTop")

    val paragraph1 = new Paragraph
    paragraph1.add(anchorTarget)
    doc.add(paragraph1)

    doc.add(new Paragraph("Some more text on the first page with different color and font type.", Fonts.x))

    doc.close

    byteout
  }
}
