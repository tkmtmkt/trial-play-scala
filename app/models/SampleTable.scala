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

    doc.add(new Paragraph("別記様式第４（第１１条関係）", Fonts.m10))

    val table = new PdfPTable(3)
    table.setTotalWidth(mm2pixel(170f))
    table.setWidths(Array (3, 1, 1))
    table.setLockedWidth(true)
    table.getDefaultCell().setBorderWidth(1f)

    val cellBorder = new PdfPCell()
    cellBorder.setBorderWidth(1f)
    val cellNoBorder = new PdfPCell()
    cellNoBorder.setBorderWidth(0f)

    // １行目
    val col11 = new PdfPCell(cellNoBorder)
    val col12 = new PdfPCell(cellBorder)
    col11.setFixedHeight(mm2pixel(6f))
    col12.setColspan(2)
    col12.setPhrase(new Paragraph("確　　　　認", Fonts.m10))
    col12.setHorizontalAlignment(Element.ALIGN_CENTER)
    table.addCell(col11)
    table.addCell(col12)

    // ２行目
    val col21 = new PdfPCell(cellNoBorder)
    val col22 = new PdfPCell(cellBorder)
    val col23 = new PdfPCell(cellBorder)
    col21.setFixedHeight(mm2pixel(16f))
    col21.setPhrase(new Paragraph("（部外者用）", Fonts.m10))
    col21.setVerticalAlignment(Element.ALIGN_BOTTOM)
    col23.setPhrase(new Paragraph("(TEL)", Fonts.t10))
    col23.setVerticalAlignment(Element.ALIGN_BOTTOM)
    table.addCell(col21)
    table.addCell(col22)
    table.addCell(col23)

    // ３行目
    val col31 = new PdfPCell(cellBorder)
    col31.setFixedHeight(mm2pixel(180f))
    col31.setColspan(3)
    table.addCell(col31)

    doc.add(table)

    doc.close
    byteout
  }
}
