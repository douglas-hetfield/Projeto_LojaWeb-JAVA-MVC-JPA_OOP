<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <title>Loja Modelo</title>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <!-- <link href="css/bootstrap-responsive.css" rel="stylesheet"> -->
        <!--<link href="css/bootstrap.css" rel="stylesheet"> -->

        <link rel="stylesheet" href="css/style.css">

    </head>
    <body class="row">
        <header class="container margin-bottom">
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="container">
                    <ul class="nav navbar-nav">
                        <li><div class="border-img left-object"><a href="indexF.jsp"><img src="img/Logo-Pronto.png" height="50px" width="140px"></a></div></li>
                    </ul>
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Menu</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>



                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                        <ul class="nav navbar-nav navbar-right">

                            <li><a class="brand" href="indexF.jsp">Página Inicial</a></li>
                            <li><a href="#">Olá ${funcionario.nome}</a></li>
                            <li><a href="fc?logica=FuncionarioLogica&action=off">Logof</a></li> 
                            
                        </ul>

                    </div>
                </div>
                
            </nav> 
        </header>

        <%--Carrega pagina com conteudo nesta area--%>
        <c:if test="${not empty param.p}">
            <c:import url="${param.p}.jsp"></c:import>
        </c:if>
        <c:if test="${empty param.p}">
            <c:import url="inicioF.jsp"></c:import>
        </c:if>

        <footer class="row footer-style">
            <div class="container">
                <div>
                    <p class="" align="center">Hardware Center &copy;</p>
                    <h5 class="center" align="center">(21) 99999-9999 | andre.tecnicodeinformatica10@gmail.com </h5>
                </div>
            </div> 
        </footer>

        <!-- JavaScript -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/viacep.js"></script>
        <script src="js/script.js"></script>
        <!--   <script src="js/bootstrap-collapse.js"></script> -->
    </body>
</html>