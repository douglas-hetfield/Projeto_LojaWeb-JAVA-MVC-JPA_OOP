<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container espaco-abaixo-0">
    <c:import url="msg.jsp"/>
    <form action="fc" method="POST" class="form" enctype="multipart/form-data">
        <input type="hidden" name="logica" value="ProdutoLogica">

        <c:if test="${empty produto.id}">
            <input type="hidden" name="action" value="cad">
        </c:if>
        <c:if test="${not empty produto.id}">
            <input type="hidden" name="action" value="alt">
            <input type="hidden" name="id" value="${produto.id}">
        </c:if>


        <h2>Cadastro de Produto</h2>
        <hr>
        <div class="container col-md-6">
            <div class="form-group">
                <label for="descricao">Descrição</label>
                <input type="text" name="descricao" class="form-control" value="${produto.descricao}" required placeholder="Faça uma breve descrição deste produto!">
            </div>

            <div class="form-group">
                <label for="quant">Quantidade</label>
                <input type="number" onkeypress="return SomenteNumero(event);" name="quant" min="0" step="1" class="form-control" value="${produto.quant}" required placeholder="Quantas unidades esse produto possui?">
            </div>

            <div class="form-group">
                <label for="valor">Valor</label>
                <input type="number" name="valor" min="0" step="0.01" class="form-control" value="${produto.valor}" required placeholder="Qual é o valor unitario deste produto?">
            </div>
            
            <div class="form-group">
                <label for="categoria">Categoria</label>
                <input type="text" id="categoria" name="categoria" oninput="uppercase_cat()" class="form-control" maxlength="60" value="${produto.categoria}" required placeholder="Exemplo: Desktop, Mouse, Monitor.">
            </div>
            
            
        </div>
        <div class="container col-md-6">

            <div class="form-group">
                <label for="foto1">Foto 1</label>
                <input type="file" name="foto1" class="form-control" value="${produto.foto1}" required>
            </div>

            <div class="form-group">
                <label for="foto2">Foto 2</label>
                <input type="file" name="foto2" class="form-control" value="${produto.foto2}">
            </div>

            <div class="form-group">
                <label for="foto3">Foto 3</label>
                <input type="file" name="foto3" class="form-control" value="${produto.foto3}">
            </div>
            
            <fieldset class="form-group float-left down">
                <label> Status: </label>
                <div class="radio-inline">
                    <label><input type="radio" name="ativo" class="" checked value="1"> Ativo  </label>
                </div>
                <div class="radio-inline">
                    <label><input type="radio" name="ativo" class="" value="0"> Desativado  </label>
                </div>
            </fieldset>

            <div class="form-group float-right">
                <button class="btn btn-info"> Salvar </button>
                <button type="reset" class="btn btn-danger" onclick="history.back()"> Cancelar </button>
            </div>
        </div>
            
    </form>
</div>