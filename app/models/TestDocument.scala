package models

import com.itextpdf.text._
import com.itextpdf.text.pdf._

import com.mongodb.casbah.Imports._

import java.io._

object TestDocument
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

    val anchorTarget = new Anchor("文書の先頭ページ。", Fonts.underline_11)
    anchorTarget.setName("BackToTop")

    val paragraph1 = new Paragraph
    paragraph1.add(anchorTarget)
    doc.add(paragraph1)

    doc.add(new Paragraph("""
ゴシック１１ポイント（赤）で文字列を表示します。
小さなチームでは、働いてくれる人間が必要なのであって、人に仕事を振る人間が必要なのではない。皆何かを生み出さなければならない。結果を出さないと行けないのだ。だから仕切り屋を雇っては行けないということだ。
仕切り屋を雇っては行けない。彼らは小さなチームのお荷物だ。人に仕事を任せる人は、まわりを会議に巻き込むのも好きだ。実際、会議は彼らの大親友だ。会議では本人が重要に見える。一方、出席する他の人たちは、実際の仕事をする時間が削られてしまう。
""", Fonts.red_11))

    doc.add(new Paragraph("""
明朝１０ポイント（黒）で文字列を表示します。
人を子供扱いすれば、子供のような仕事しかしない。これが多くの会社、多くの管理職の人の扱い方だ。何をするにしても上司の許しがいる。
規則とはそんなにおこらない状況にたいして、会社が大げさに反応した傷跡だ。大げさな反応はやめよう。規則を作らないことだ。規則とは、何度も繰り返し起こり得ることに対して最後に考える手段である。
""", Fonts.m10))

    doc.add(new Paragraph("""
ゴシック１０ポイント（黒）で文字列を表示します。
肩を叩くのをためらってはいけない。意味のないことをしているスタッフがいることのほうが悪い。外を見渡せば、才能のある人はたくさんいる。本当に必要な時に、最適な人を見つけられるだろう。人が必要ないのなら、人は必要ないということだ。
タイガーウッズに安物のクラブを渡してもあなたが徹底的にうちのめされるという事実から逃げてはいけない。オフィスも、備品も、どうでもいい。そんなことに心酔いしれている人が多い。本当に重要なのはどのように顧客を増やし、利益を増やすかということだ。
""", Fonts.g10))

    doc.close

    byteout
  }
}
