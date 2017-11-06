<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="msg.jsp"/>
<div class="container margin-top margin-bottom-cliente">
    <c:if test="${not empty cliente.id}">
        <h2>Alterar minhas informações</h2>
    </c:if>
    <c:if test="${empty cliente.id}">
        <h2>Faça seu cadastro</h2>
    </c:if>
    <hr>
    <form class="form" action="fc" method="post">
        <input type="hidden" name="logica" value="ClienteLogica">
        <c:if test="${empty cliente.id}">
            <input type="hidden" name="action" value="cad">
        </c:if>
        <c:if test="${not empty cliente.id}">
            <input type="hidden" name="action" value="alt">
            <input type="hidden" name="id" value="${cliente.id}">
        </c:if>

        <div class="col-md-6">
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" name="nome" value="${cliente.nome}" class="form-control" required placeholder="Informe seu nome">
            </div>

            <div class="form-group">
                <label for="email">E-mail:</label>
                <input type="email" name="email" value="${cliente.email}" class="form-control" required placeholder="digite seu E-mail">
            </div>

            <div class="form-group">
                <label for="pws">Senha:</label>
                <input type="password" name="pws" id="cpws" class="form-control" required placeholder="Digite uma senha com no mínimo de 6 caracteres">
            </div>

            <div class="form-group">
                <label for="cpws">Confirmar Senha:</label>
                <input type="password" name="cpws" id="cpws" class="form-control" required placeholder="confirme a senha anterior">
            </div>

            <div class="form-group">
                <label for="cpf">CPF:</label>
                <input type="text" name="cpf" maxlength="14" onkeyup="salto(this.value, 'cpf')" onkeypress="masc_cpf(this)" value="${cliente.cpf}" class="form-control" required placeholder="Digite seu CPF">
            </div>

            <div class="form-group">
                <label for="cep">CEP:</label>
                <input type="text" name="cep" onkeyup="salto(this.value, 'cep')" onkeypress="masc_cep(this)" id="cep" value="${cliente.cep}" size="10" maxlength="9" onblur="pesquisacep(this.value);" class="form-control" required placeholder="Digite o CEP da sua residência">
            </div>
        </div>

        <div class="col-md-6">
            <div class="form-group">
                <label for="logradouro">Logradouro:</label>
                <input type="text" name="logradouro" id="rua" size="60" value="${cliente.logradouro}" class="form-control" required placeholder="Nome da sua rua">
            </div>

            <div class="form-group">
                <label for="bairro">Bairro:</label>
                <input type="text" name="bairro" id="bairro" size="40" value="${cliente.bairro}" class="form-control" required placeholder="Nome do seu bairro">
            </div>

            <div class="form-group">
                <label for="cidade">Cidade:</label>
                <input type="text" name="cidade" id="cidade" size="40" value="${cliente.cidade}" class="form-control" required placeholder="Nome da sua Cidade">
            </div>

            <div class="form-group">
                <label for="uf">UF:</label>
                <input type="text" name="uf" id="uf" oninput="uppercase()" size="2" maxlength="2" value="${cliente.uf}" class="form-control" required placeholder="Informe a UF">
            </div>
            
            <div class="form-group">
                <label for="numero">Número:</label>
                <input type="text" name="numero" id="numero" value="${cliente.numero}" class="form-control" required placeholder="Número da sua residência">
            </div>

            <div class="form-group">
                <label for="complemento">Complemento</label>
                <input type="text" name="complemento" class="form-control" value="${cliente.complemento}" required placeholder="Exemplo: Casa, apartamento, fundos.">
            </div>
        </div>

        <div class="form-group right-button">
            <button type="submit" class="btn btn-info">Salvar</button>
            <button type="reset" class="btn btn-danger">Cancelar</button>
        </div>
    </form>

</div>