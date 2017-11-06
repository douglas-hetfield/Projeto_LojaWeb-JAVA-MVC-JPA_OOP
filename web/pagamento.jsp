<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="msg.jsp"></c:import>

    <form action="fc" method="post" class="row" id="carrinho">
        <input type="hidden" name="logica" value="Carrinho">
        <input type="hidden" name="action" value="compra">
        <div class="container">
            <h2> Realizar Compra </h2>
            <p class=" col-md-6">
                <a href="index.jsp">

                </a>
            </p>
            <p class=" col-md-6 text-right">

                <input type="hidden" value='<f:formatNumber minFractionDigits="2" currencySymbol="R$">${pedido.valor}</f:formatNumber>' name="total" class="form-control campo" id="total" disabled> 

            </p>


            <table class="table table-hover col-md-12">
                <tr class=''>
                    <th class="col-md-6">Produto</th>
                    <th class="col-md-1">Quantidade</th>
                    <th class="col-md-2">Valor Unit.</th>
                    <th class="col-md-2">Total</th>

                </tr>

            <c:forEach items="${itens}" var="item"> 
                <input type="hidden" value="${item.produto.id}" name="idProduto"> 
                <input type="hidden" value="${cliente.id}" name="id"> 
                
                <tr>
                    <td class="col-md-6"> 
                        <div class="col-md-2">
                            <img width="80px" height="80px" src="img/produtos/${item.produto.foto1}" title="" alt="" class="">
                        </div>
                        <div class="col-md-10">${item.produto.descricao}</div>
                    </td>

                    <td class="col-md-1">
                        <input type="text" name="quant" placeholder="0" min="1" max="${item.produto.quant}" value="${item.quant}" step="1" class="form-control" disabled>
                    </td>

                    <td class="col-md-2"> 
                        <input type="text" name="valor" min="0.00" step="0.01" value='<f:formatNumber minFractionDigits="2" currencySymbol="R$">${item.produto.valor}</f:formatNumber>' disabled class="form-control campo">
                        </td>

                        <td class="col-md-2">
                            <input type="text" name="valorItem" min="0.00" step="0.01" value='<f:formatNumber minFractionDigits="2" currencySymbol="R$">${item.valor}</f:formatNumber>' disabled class="form-control campo valores">

                        </td>

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
                    <p>Frete(?): <span style="color: blue;">GRÁTIS PARA TODO BRASIL</span> <f:formatNumber minFractionDigits="2" currencySymbol="R$">${venda.frete}</f:formatNumber></p>
                    </strong>
                    <h3  style="border-top: solid 2px #222;padding: 10px 0; "><span style="color:blue; ">Total da Compra: </span><f:formatNumber minFractionDigits="2" currencySymbol="R$">${pedido.valor}</f:formatNumber></h3>


            </div>

            <div class="col-md-4">
                <div class="form-group">
                    <strong><label style="color: black;" for="formaPag">Cartão: </label></strong>
                    <select name="cartao" class="form-control" required>
                        <option value="" disabled selected>Selecione: </option>
                        <option value="cartao">Visa</option>
                        <option value="avista">Mastercard</option>
                        <option value="avista">Sei lá, mano</option>
                    </select>
                    <br>
                    <strong><label style="color: black;" for="formaPag">Parcelado ou A vista: </label></strong>
                    <select name="formaPag" class="form-control" required>
                        <option value="" disabled selected>Selecione: </option>
                        <option value="cartao">Parcelado</option>
                        <option value="avista">A vista</option>
                    </select>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary" onclick="finalizar(this.form)"> Finalizar Compra</button>

                    </div>
                </div>
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
    function finalizar(frm) {
        frm.action = "fc?logica=CarrinhoLogica&action=finalizar";
        frm.submit();
    }

</script>