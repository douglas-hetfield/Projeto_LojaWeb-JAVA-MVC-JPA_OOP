<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="container-fluid section-inicio">


    <!-- Carousel
                ================================================== -->
    <div id="myCarousel" class="carousel slide margin-top-carrousel" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img class="first-slide" src="imagens/slide1.jpg" alt="First slide">
                <div class="container">
                    <div class="carousel-caption">
                        <h3>Tenha mais segurança para você e sua família!</h3>
                        <p><a class="btn btn-lg btn-primary" href="https://www.americanas.com.br/" role="button">Ver mais</a></p>    <!-- TROCAR CAMINHO PARA A PAGINA DO PRODUTO -->
                    </div>
                </div>
            </div>
            <div class="item">
                <img class="second-slide" src="imagens/slide2.jpg" alt="Second slide">
                <div class="container">
                    <div class="carousel-caption">
                        <h3>Venha conferir as melhores marcas e os menores preços da internet!</h3>
                        <p><a class="btn btn-lg btn-primary" href="https://www.americanas.com.br/" role="button">Ver mais</a></p>     <!-- TROCAR CAMINHO PARA A PAGINA DO PRODUTO -->
                    </div>
                </div>
            </div>
            <div class="item">
                <img class="third-slide" src="imagens/slide3.jpg" alt="Third slide">
                <div class="container">
                    <div class="carousel-caption">
                        <h3>Veja os melhores componentes para sua rede!</h3>
                        <p><a class="btn btn-lg btn-primary" href="https://www.americanas.com.br/" role="button">Ver mais</a></p>     <!-- TROCAR CAMINHO PARA A PAGINA DO PRODUTO -->
                    </div>
                </div>
            </div>

        </div>
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div><!-- /.carousel -->

    <jsp:useBean id="produto" class="br.edu.lojamodelo.controller.CtrlProduto"></jsp:useBean>

        <div class="row">
            <h2 class="product"><a href="index.jsp?p=produto/desktop">Desktops</a></h2>

        <c:forEach var="itens" begin="0" end="5" step="1" items="${produto.listar('Desktop')}">
            <a class="link-produtos" href="fc?logica=ProdutoLogica&action=desc&id=${itens.id}">
                <div class="col-md-2 div-produtos">
                    <img class="imgs" src="img/produtos/${itens.foto1}">
                    <h4>${itens.descricao}</h4>
                    <h5>R$ ${itens.valor}</h5>
                </div>
            </a>

        </c:forEach>
    </div>
    
    <hr>

    <div class="row">
        <h2 class="product"><a href="index.jsp?p=produto/desktop">Notebooks</a></h2>

        <c:forEach var="itens" begin="0" end="5" step="1" items="${produto.listar('notebook')}">
            <a class="link-produtos" href="fc?logica=ProdutoLogica&action=desc&id=${itens.id}">
                <div class="col-md-2 div-produtos">
                    <img class="imgs" src="img/produtos/${itens.foto1}">
                    <h4>${itens.descricao}</h4>
                    <h5>R$ ${itens.valor}</h5>
                </div>
            </a>

        </c:forEach>
    </div>

    <hr>
    
    <div class="row">
        <h2 class="product"><a href="index.jsp?p=produto/desktop">Placa-Mãe</a></h2>

        <c:forEach var="itens" begin="0" end="5" step="1" items="${produto.listar('placamae')}">

            <a class="link-produtos" href="fc?logica=ProdutoLogica&action=desc&id=${itens.id}">
                <div class="col-md-2 div-produtos">
                    <img class="imgs" src="img/produtos/${itens.foto1}">
                    <h4>${itens.descricao}</h4>
                    <h5>R$ ${itens.valor}</h5>
                </div>
            </a>

        </c:forEach>
    </div>

</section>