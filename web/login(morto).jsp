<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="msg.jsp"/>

<div class="container margin-top margin-bottom-login">
    <h2>Faça o login </h2>
    <hr>
    <form class="form" action="fc" method="post">
        <input type="hidden" name="logica" value="ClienteLogica">
        <input type="hidden" name="action" value="log">
        
        <div class="form-group">
            <label for="email">E-mail</label>
            <input type="email" name="email" class="form-control">
        </div>
        <div class="form-group">
            <label for="pws">Senha</label>
            <input type="password" name="pws" class="form-control">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-info">Logar</button>
        </div>
    </form>

</div>