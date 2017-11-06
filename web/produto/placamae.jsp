<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="container-fluid section-inicio style-div-desktop">
    <h2 class="product">Desktops</h2>

    <jsp:useBean id="produto" class="br.edu.lojamodelo.controller.CtrlProduto"></jsp:useBean>

    <c:forEach var="itens" items="${produto.listar('placamae')}">
        <a class="link-produtos" href="fc?logica=ProdutoLogica&action=desc&id=${itens.id}">
            <div class="col-md-2 div-produtos">
            <img class="imgs" src="img/produtos/${itens.foto1}">
            <h4>${itens.descricao}</h4>
            <h5>R$ ${itens.valor}</h5>
        </div>
        </a>

    </c:forEach>
</section>