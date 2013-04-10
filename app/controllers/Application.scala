package controllers

import play.api._
import play.api.mvc._
import play.api.libs.iteratee.Enumerator

import java.io._

import models._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def pdf1 = pdfFunc(TestDocument.getPdf)
  def pdf2 = pdfFunc(PdfTemplate.getPdf)
  def pdf3 = pdfFunc(SampleTable.getPdf)

  val pdfFunc = {(pdf:ByteArrayOutputStream) => Action {
    SimpleResult(
      header = ResponseHeader(200,
        Map(CONTENT_LENGTH -> pdf.size.toString,
            CONTENT_TYPE -> "application/pdf")),
      body = Enumerator(pdf.toByteArray)
    )
  }}
}
