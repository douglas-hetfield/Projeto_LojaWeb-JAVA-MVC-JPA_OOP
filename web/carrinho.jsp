<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="msg.jsp"></c:import>
    
    <form action="sys" method="post" class="row" id="carrinho">
        
        <input type="hidden" name="logica" value="Carrinho">
        <input type="hidden" name="action" value="compra">
        <div class="container">
            <h2> Meu carrinho </h2> 
            <p class=" col-md-6">
                <a href="index.jsp">
                    <button type="button" class="btn btn-primary"> Escolher + Produto</button>
                </a>
            </p>
            <p class=" col-md-6 text-right">
                <button type="submit" class="btn btn-danger" onclick="pag(this.form)" <c:if test="${empty itens}"> disabled  </c:if>>Realizar Pagamento</button>
                <input type="hidden" value='<f:formatNumber minFractionDigits="2" currencySymbol="R$">${pedido.valor}</f:formatNumber>' name="total" class="form-control campo" id="total" disabled> 

            </p>
        

        <table class="table table-hover col-md-12">
            <tr class=''>
                <th class="col-md-6">Produto</th>
                <th class="col-md-1">Quantidade</th>
                <th class="col-md-2">Valor Unit.</th>
                <th class="col-md-2">Valor Total</th>
                <th class="col-md-1 right"><span class="glyphicon glyphicon-remove"></span></th>
            </tr>
        
        <c:forEach items="${itens}" var="item"> 
            <input type="hidden" value="${item.produto.id}" name="id"> 
            <input type="hidden" value="${cliente.id}" name="idUser"> 
            
            <tr>
                <td class="col-md-6"> 
                    <div class="col-md-2">
                        <img height="80px" width="80px" src="img/produtos/${item.produto.foto1}" title="" alt="" class="">
                    </div>
                    <div class="col-md-10">${item.produto.descricao}</div>
                </td>

                <td class="col-md-1">
                    <input type="number" name="quant" placeholder="0" min="1" max="${item.produto.quant}" value="${item.quant}" step="1" class="form-control" onclick="execute(this.form)">
                </td>

                <td class="col-md-2"> 
                    <input type="text" name="valor" min="0.00" step="0.01" value='<f:formatNumber minFractionDigits="2" currencySymbol="R$">${item.produto.valor}</f:formatNumber>' disabled class="form-control campo">
                    </td>

                    <td class="col-md-2">
                        <input type="text" name="valorItem" min="0.00" step="0.01" value='<f:formatNumber minFractionDigits="2" currencySymbol="R$">${item.valor}</f:formatNumber>' disabled class="form-control campo valores">
   
                    </td>
                    <td class="col-md-1 right"><a href="fc?logica=CarrinhoLogica&action=remove&id=${item.produto.id}"<span class="glyphicon glyphicon-remove"></span></td>
            </tr>
        </c:forEach>
    </table>      

<div class="col-md-12">
    <div class="col-md-8">
        
            <div class="well">
                <h4>Atenção:</h4>
                <p>
                    O prazo começa a contar a partir da aprovação do pagamento.<br>
                    Os produtos podem ser entregues separadamente.<br>
                </p>
            </div>
        
    </div>
    <div class="col-md-4 well">
        <strong>
            
            <p>Produtos: ${pedido.numeroItens}</p>
        <p>Frete: <span style="color: blue;">GRÁTIS PARA TODO BRASIL</span> <f:formatNumber minFractionDigits="2" currencySymbol="R$">${venda.frete}</f:formatNumber></p>
        </strong>
        <h3  style="border-top: solid 2px #222;padding: 10px 0">Total:<f:formatNumber minFractionDigits="2" currencySymbol="R$">${pedido.valor}</f:formatNumber></h3>

            <p><strong>Possui cupom ou vale? </strong>Você poderá usá-los na etapa de pagamento.</p>
    </div>
        </div>
    </form>     
</div>

<script>
    // window.onload(execute(this.form));

    function execute(frm) {
        frm.action = "fc?logica=CarrinhoLogica&action=calcular";
        frm.submit();
    }
    function pag(frm) {
        frm.action = "fc?logica=CarrinhoLogica&action=pagamento";
        frm.submit();
    }
    
</script>