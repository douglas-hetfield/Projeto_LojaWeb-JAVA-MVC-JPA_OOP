<%-- 
    Document   : ListaFuncionarios
    Created on : 17/10/2017, 23:46:05
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            
        
        <h1>Lista de produtos</h1>
        <hr>
        
        <label>Status: </label>
        <form name="formulario"  action="fc" method="post">
            <input type="hidden" name="logica" value="ProdutoLogica">
            <input type="hidden" name="action" value="list">
            
        <select name="status" onchange="submitform()">
            <option>Selecione: </option>
            <option value="1">Ativos</option>
            <option value="2">Inativos</option>
            <option value="0">Todos</option>
        </select>
            
        </form>
        
        <script type="text/javascript">
         function submitform() {
            document.formulario.submit();
         }
        </script>
        
        <table class="table">
            <thead>
                <th>Imagem</th> 
                <th>Id</th>
                <th>Categoria</th>
                <th>Descricao</th>
                <th>Quantidade</th>
                <th>Valor</th>
                <th>Status</th> 
                <th>Ativar-Inativar</th>
                <th>Alterar</th>
            </thead>
            <tbody>
                
            <c:forEach var="produto" items="${listaProdutos}">

                <tr>
                    <td><img height="60px" width="60px" src="img/produtos/${produto.foto1}"</td>
                    <td>${produto.id}</td>
                    <td>${produto.categoria}</td>
                    <td>${produto.descricao}</td>
                    <td>${produto.quant}</td>
                    <td>R$${produto.valor}</td>
                    <td>
                        <c:if test="${produto.ativo == true}">
                            <span style="color: green; font-weight: bold;">Ativo</span>
                        </c:if>
                        <c:if test="${produto.ativo == false}">
                            Bloqueado
                        </c:if>
                    </td>
                    <td> 
                        <c:if test="${produto.ativo == false}">
                            <a href="fc?logica=ProdutoLogica&action=status&id=${produto.id}" 
                           onclick="if( !confirm('Deseja inativar este usuário?') ){ return false;}">
                                <img width="30px" height="30px" src="imagens/ativar.jpg">
                            </a>
                        </c:if>
                        
                        <c:if test="${produto.ativo == true}">
                            <a href="fc?logica=ProdutoLogica&action=status&id=${produto.id}" 
                           onclick="if( !confirm('Deseja inativar este usuário?') ){ return false;}">
                                <img width="30px" height="30px" src="imagens/inativar.jpg">
                            </a>
                        </c:if>
                        
                    </td>
                    <td><a href="fc?logica=ProdutoLogica&action=edit&id=${produto.id}">Alterar</a></td>
                    
                </tr>
                
                </c:forEach>
            </table>
        </div>
    </body>
</html>
