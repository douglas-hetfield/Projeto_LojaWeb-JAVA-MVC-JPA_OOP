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
    <body class="row" >
        <!-- onload="piscar()" -->
        <header class="container margin-bottom">
            <c:if test="${autentic != null}">
                <script>alert("Login ou senha Inválido!");</script>
            </c:if>
            
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="container">
                    <ul class="nav navbar-nav">
                        <li><div class="border-img left-object"><a href="index.jsp"><img src="img/Logo-Pronto.png" height="50px" width="140px"></a></div></li>
                    </ul>
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Menu</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <div class="nav navbar-nav text-pesq ">
                        <form class="form" action="fc" method="post">
                            <input type="hidden" name="logica" value="ProdutoLogica">
                            <input type="hidden" name="action" value="listPesquisa">  
                            <div class="nav navbar-nav">
                                <input class="aumentar" type="search" id="pesquisa" name="pesquisa" placeholder="Pesquise aqui">
                                <button type="submit" class="btn btn-info btn-size" name="go" id="go" value="GO">Buscar</button>
                            </div>
                        </form>
                    </div>

                    <div  class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                        <ul class="nav navbar-nav navbar-right ">

                            <c:if test="${not empty cliente.id}">
                                <li><a class="hover-blue" href="#">Olá ${cliente.nome}</a></li>
                                <li><a class="hover-blue" href="fc?logica=ClienteLogica&action=off">Logof</a></li> 
                                </c:if>
                            <li><a class="hover-blue" href="index.jsp?p=carrinho">Carrinho ${sessionScope.tamanho}</a></li>
                                <c:if test="${empty cliente.id}">
                                <li><a class="hover-blue" href="index.jsp?p=formCliente">Cadastro</a></li>


                                <li><a class="dropdown-toggle hover-blue" data-toggle="dropdown" href="#">Login<span class="caret"></span></a>
                                    <ul class="dropdown-menu border-radius ">
                                        <form class="form" method="post" action="fc">
                                            <input type="hidden" name="logica" value="ClienteLogica">
                                            <input type="hidden" name="action" value="log">
                                            <div class="form-group login-div">
                                                <li><label for="email">Email:</label><input class="form-control" type="email" name="email" required></li>
                                            </div>
                                            <div class="form-group login-div">
                                                <li><label for="pws">Senha:</label><input class="form-control" type="password" name="pws" required></li>
                                            </div>
                                            <li><input class="btn btn-info botao-center" type="submit" value="Logar"></li>
                                            <span style="display: block;" class="botao-center text-center">ou</span>
                                            <span style="display: block; " class=" text-center"><a style="cursor: pointer;"  data-toggle="modal"  data-target="#janela">Esqueci minha Senha</a></span>
                                        </form>
                                    </ul>
                                    
                                </li>
                                
        
                                <!-- Inativo, foi substituido pelo dropdown! <li><a class="hover-blue" href="index.jsp?p=login">Login</a></li>   -->
                            </c:if>
                            <c:if test="${not empty cliente.id}">
                                <li><a class="hover-blue" href="index.jsp?p=formCliente">minhas informações</a></li>
                                </c:if>
                        </ul>
                    </div>
                </div>
                                
                <div class="container-fluid backgroud-mudar">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2" aria-expanded="false">
                        <span class="sr-only">Menu</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                        <ul class="nav navbar-nav">
                            <li><a href="index.jsp?p=produto/desktop">Desktop</a></li>
                            <li><a href="index.jsp?p=produto/notebook">Notebook</a></li>
                            <li><a href="index.jsp?p=produto/placamae">Placa-Mãe</a></li>
                            <li><a href="#">Memória-ram</a></li>
                            <li><a href="#">Processador</a></li>
                            <li><a href="#">HDs</a></li>
                            <li><a href="#">Placa de Vídeo</a></li>
                            <li><a href="#">Cooler</a></li>
                            <li><a href="#">Gabinete</a></li>
                            <li><a href="#">Monitor</a></li>
                            <li><a href="#">Teclado</a></li>
                            <li><a href="#">Mouse</a></li>
                            <li><a href="#">Impressora</a></li>
                            <li><a href="#">Swicht</a></li>
                            <li><a href="#">Servidore</a></li>
                            <li><a href="#">Roteadore</a></li>
                            <li><a href="#">Firewall</a></li>
                            <li><a href="#">Micro-tic</a></li>
                            <li><a href="#">Ferramentas</a></li>
                            <li><a href="#">Cabos</a></li>
                            <li><a href="#">Outros</a></li>
                        </ul>
                    </div>
                </div>
            </nav> 
        </header>

        <div class="aqui" id="esconder">
            <img src="img/andre/IMG_20171030_031601.jpg" name="image" id="image" class="jequiti">

            <audio id="audio" name="audio">
                <source src="music/snoop.wav" type="audio/wav" />
            </audio>
        </div>
        
        <%--Carrega pagina com conteudo nesta area--%>
        <c:if test="${not empty param.p}">
            <c:import url="${param.p}.jsp"></c:import>
        </c:if>
        <c:if test="${empty param.p}">
            <c:import url="inicio.jsp"></c:import>
        </c:if>

        

        <footer class="row footer-style fixed">
            <div class="container">
                <div>
                    <p class="" align="center">Hardware Center &copy;</p>
                    <h5 class="center" align="center">(21) 99999-9999 | andre.tecnicodeinformatica10@gmail.com </h5>
                </div>
            </div> 
        </footer>
        
        <form action="fc" method="post">
                <input type="hidden" name="logica" value="ClienteLogica">
                <input type="hidden" name="action" value="esqueceuSenha"> 
            <div class="modal fade" id="janela">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                        <button class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">ESQUECI MINHA SENHA</h4>  
                        </div>
                        <div class="modal-body">
                            <label for="email1">Digite seu email para recuperação de conta: </label>
                            <br>
                            <input type="text" name="email" placeholder="exemplo@gmail.com" id="email1" required>
                        </div>
                        <div class="modal-footer">
                        <button style="border: 2px solid black;" class="btn btn-primary" type="submit"  >Enviar</button>  
                        <button style="border: 2px solid black;" class="btn btn-danger" data-dismiss="modal">Fechar</button>  
                        </div>
                    </div>
                </div>
            </div>
        </form> 
       
         <c:if test="${enviado != null}">
                <script>alert("Um email foi enviado a: ${email}");</script>
             
                <!-- EU QUERIA O RETORNO DO SERVLET INVOCASSE ESSA JANELA, MAS NÃO DEU CEERTO 
                <div class="modal fade" id="janela">
                    <div class="modal-dialog">
                        <div class="modal-content text-center">
                        <div class="modal-body">
                            <h3>Um email foi enviado</h3>
                            <button>Ok.</button>
                        </div>
                        </div>
                    </div>
                 </div> -->
            </c:if>           
        <!-- JavaScript -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/viacep.js"></script>
        <script src="js/script.js"></script>
        <script src="js/piscar.js"></script>
        <!--   <script src="js/bootstrap-collapse.js"></script> -->

    </body>
</html>