package cz.janys

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8000")
		.proxy(Proxy("localhost", 8000))
		.inferHtmlResources()
		.acceptHeader("""text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8""")
		.acceptEncodingHeader("""gzip, deflate""")
		.acceptLanguageHeader("""cs,en-US;q=0.7,en;q=0.3""")
		.connection("""keep-alive""")
		.contentTypeHeader("""application/x-www-form-urlencoded""")
		.doNotTrackHeader("""1""")
		.userAgentHeader("""Mozilla/5.0 (Windows NT 6.1; WOW64; rv:37.0) Gecko/20100101 Firefox/37.0""")

	val headers_1 = Map("""Accept""" -> """*/*""")

	val headers_3 = Map("""Accept""" -> """text/css,*/*;q=0.1""")

    val uri1 = """http://test.net/app"""

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("""/app/""")
			.resources(http("request_1")
			.get(uri1 + """/js/bootstrap.min.js""")
			.headers(headers_1)
			.check(status.is(304)),
            http("request_2")
			.get(uri1 + """/js/jquery.min.js""")
			.headers(headers_1)
			.check(status.is(304)),
            http("request_3")
			.get(uri1 + """/css/bootstrap.css""")
			.headers(headers_3)
			.check(status.is(304)),
            http("request_4")
			.get(uri1 + """/css/style.css""")
			.headers(headers_3)
			.check(status.is(304))))
		.pause(4)
		.exec(http("request_5")
			.get("""/app/person"""))
		.pause(1)
		.exec(http("request_6")
			.get("""/app/person/create"""))
		.pause(4)
		.exec(http("request_7")
			.post("""/app/person/create""")
			.formParam("""id""", """""")
			.formParam("""name""", """Name""")
			.formParam("""email""", """email@email.cz"""))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}