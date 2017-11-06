<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="msg.jsp"></c:import>

<div class="row margin-top mais-margin-top altura-div-desc">
    <div class="col-md-8 altura-div">
            <div class="col-md-3"></div>
            <div class="col-md-5 altura">
            <c:if test="${not empty produto.foto1}">
                <img src="img/produtos/${produto.foto1}" class="img-responsive altura">
            </c:if>
        </div>
        <div class="col-md-4 altura">

            <div class="col-md-8">
                <c:if test="${not empty produto.foto2}">
                    <img src="img/produtos/${produto.foto2}" class="img-responsive">
                </c:if>
            </div>
            
            <div class="col-md-8 ">
                <c:if test="${not empty produto.foto3}">
                    <img src="img/produtos/${produto.foto3}" class="img-responsive">
                </c:if>
            </div>
        </div>
    </div>
    <div class="col-md-4 altura-div">
        <h2>Descrição do Produto</h2>
        <h4>&rAarr;( ${produto.descricao} )</h4>
        <br>
        <h4>Valor:</h4>
        <p class="redValor">
            <strong>
                R$
                <f:formatNumber minFractionDigits="2" currencySymbol="R$">
                    ${produto.valor}
                </f:formatNumber>
            </strong>
        </p>
        <a href="fc?logica=CarrinhoLogica&action=add&id=${produto.id}">
            <button class="btn btn-info"> Adicionar ao carrinho</button>
        </a>
    </div>
</div>
