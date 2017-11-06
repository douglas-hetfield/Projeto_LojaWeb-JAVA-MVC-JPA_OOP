<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="msg.jsp"/>
<div class="container">
    <div class="row">
         <h2>Cadastro de Funcionario</h2>

        <hr>
        <form class="form" action="fc" method="post">
            <input type="hidden" name="logica" value="FuncionarioLogica">
            <input type="hidden" name="action" value="cad">

            <div class="col-md-6">
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" name="nome" class="form-control" required placeholder="Informe seu nome">
                </div>

                <div class="form-group">
                    <label for="pws">Senha:</label>
                    <input type="password" name="pws" id="cpws" class="form-control" required placeholder="Digite uma senha com no mínimo de 6 caracteres">
                </div>

                <div class="form-group">
                    <label for="cpws">Confirmar Senha:</label>
                    <input type="password" name="cpws" id="cpws" class="form-control" required placeholder="confirme a senha anterior">
                </div>

            </div>   
            <div class="col-md-6">

                <div class="form-group">
                    <label for="email">E-mail:</label>
                    <input type="email" name="email" class="form-control" required placeholder="digite seu E-mail">
                </div>

                <div class="form-group">
                    <label for="cargo">Cargo:</label>
                    <select class=" form-control" name="cargo" id="cargo" >
                        <option value="ADM">Administrador(Site)</option>
                        <option value="Funcionario">Funcionario</option>
                    </select>
                </div>


                <div class="form-group right-button down">
                    <button type="submit" class="btn btn-info">Salvar</button>
                    <button type="reset" class="btn btn-danger">Cancelar</button>
                </div>
            </div>
        </form>
    </div>
</div>