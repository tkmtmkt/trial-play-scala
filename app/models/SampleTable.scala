package models

import com.itextpdf.text._
import com.itextpdf.text.pdf._

import java.io._

object SampleTable
{
  def mm2pixel(mm : Float) = { mm / 24.4f * 72.0f }

  def getPdf = {
    val byteout = new ByteArrayOutputStream
    val doc = new Document(PageSize.A4, mm2pixel(20), mm2pixel(20), mm2pixel(25), mm2pixel(15))
    val writer = PdfWriter.getInstance(doc, byteout)

    doc.addAuthor("高松 誠")
    doc.addSubject("PDF文書作成の勉強")

    //val header = new HeaderFooter(
    doc.open

    doc.add(new Paragraph(""))

    val table = new PdfPTable(3)
    table.setTotalWidth(mm2pixel(170f))
    table.setWidths(Array (3f, 1f, 1f))

    // １行目
    val col11 = new PdfPCell(new Paragraph(""))
    col11.setMinimumHeight(mm2pixel(6f))
    val col12 = new PdfPCell(new Paragraph("確　　　　認", Fonts.m10))
    col12.setColspan(2)
    col12.setHorizontalAlignment(Element.ALIGN_CENTER)
    table.addCell(col11)
    table.addCell(col12)

    // ２行目
    val col21 = new PdfPCell(new Paragraph("別記様式第４（第１１条関係）\n（部外者用）", Fonts.m10))
    col21.setVerticalAlignment(Element.ALIGN_BOTTOM)
    col21.setMinimumHeight(mm2pixel(16f))
    val col22 = new PdfPCell(new Paragraph(""))
    val col23 = new PdfPCell(new Paragraph("(TEL)", Fonts.m10))
    col23.setVerticalAlignment(Element.ALIGN_BOTTOM)
    table.addCell(col21)
    table.addCell(col22)
    table.addCell(col23)

    // ３行目
    val col31 = new PdfPCell(new Paragraph(""))
    col31.setColspan(3)
    col31.setMinimumHeight(mm2pixel(180f))
    table.addCell(col31)

    doc.add(table)

    doc.close
    byteout
  }
}
