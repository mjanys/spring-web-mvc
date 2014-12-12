<%@tag description="Menu Template" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value="/"/>">
                Spring Web MVC
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="<c:url value="/person"/>">Persons</a>
                </li>
            </ul>
            <%--<form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">
                    Submit
                </button>
            </form>--%>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="https://github.com/mjanys/spring-web-mvc">GitHub</a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                        Links <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li>
                            <a href="http://spring.io/">spring.io</a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html">Spring WEB MVC</a>
                        </li>
                        <li>
                            <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/spring.tld.html">Spring taglib</a>
                        </li>
                        <li>
                            <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/spring-form.tld.html">Spring form taglib</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="http://www.tutorialspoint.com/jsp/">JSP Tutorial</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html">Maven</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>