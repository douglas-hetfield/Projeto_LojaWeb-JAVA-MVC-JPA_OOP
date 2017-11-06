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
            
        
        <h1>Lista de funcionários: </h1>
        
        <label>Status: </label>
        <form name="formulario"  action="fc" method="post">
            <input type="hidden" name="logica" value="FuncionarioLogica">
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
                <th>Nome</th> 
                <th>Email</th> 
                <th>Status</th> 
                <th>Ativar-Inativar</th> 
                
            </thead>
            <tbody>
                
            <c:forEach var="funcionario" items="${listaFuncionarios}">

                <tr>
                    <td>${funcionario.nome}</td>
                    <td>${funcionario.email}</td>
                    <td>
                        <c:if test="${funcionario.status == true}">
                            <span style="color: green; font-weight: bold;">Ativo</span>
                        </c:if>
                        <c:if test="${funcionario.status == false}">
                            Bloqueado
                        </c:if>
                    </td>
                    <td> 
                        <c:if test="${funcionario.status == false}">
                            <a href="fc?logica=FuncionarioLogica&action=status&id=${funcionario.id}" 
                           onclick="if( !confirm('Deseja inativar este usuário?') ){ return false;}">
                                <img width="30px" height="30px" src="imagens/ativar.jpg">
                            </a>
                        </c:if>
                        
                        <c:if test="${funcionario.status == true}">
                            <a href="fc?logica=FuncionarioLogica&action=status&id=${funcionario.id}" 
                           onclick="if( !confirm('Deseja inativar este usuário?') ){ return false;}">
                                <img width="30px" height="30px" src="imagens/inativar.jpg">
                            </a>
                        </c:if>
                        
                    </td>
                    
                </tr>
                
                </c:forEach>
            </table>
        </div>
    </body>
</html>
