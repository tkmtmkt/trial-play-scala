package controllers

import play.api._
import play.api.mvc._
import play.api.libs.iteratee.Enumerator

import models._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def test = Action {
    //Ok(models.TestDocument).as("application/pdf")

    val pdf = TestDocument.getPdf
    SimpleResult(
      header = ResponseHeader(200,
        Map(CONTENT_LENGTH -> pdf.size.toString,
            CONTENT_TYPE -> "application/pdf")),
      body = Enumerator(pdf.toByteArray)
    )
  }
}
