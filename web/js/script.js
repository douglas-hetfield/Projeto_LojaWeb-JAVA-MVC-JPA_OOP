function verifica() {
    a = document.getElementById("pws").value;
    b = document.getElementById("cpws").value;
    if (a != b) {
        alert("As senhas não conferem! Por favor digite novamente!");
        document.getElementById("pws").value = "";
        document.getElementById("cpws").value = "";
        document.getElementById("pws").focus();
    }
}


function masc_cpf(masc) {
    if (masc.value.length == 3) {
        masc.value += ".";
    }
    if (masc.value.length == 7) {
        masc.value += ".";
    }
    if (masc.value.length == 11) {
        masc.value += "-";
    }
}

function uppercase() {
    document.getElementById("uf").value = document.getElementById("uf").value.toUpperCase();
}

function uppercase_cat() {
    document.getElementById("categoria").value = document.getElementById("categoria").value.toUpperCase();
}

function masc_cep(masc) {
    if (masc.value.length == 5) {
        masc.value += "-";
    }
}


function salto(digito, nome) {
    if (nome == "cpf") {
        if (digito.length > 13) {
            document.getElementById("cep").focus();
        }
    }
    if (nome == "cep") {
        if (digito.length > 8) {
            document.getElementById("numero").focus();
        }
    }
}

function SomenteNumero(e) {
    var tecla = (window.event) ? event.keyCode : e.which;
    if ((tecla > 47 && tecla < 58))
        return true;
    else {
        if (tecla == 8 || tecla == 0)
            return true;
        else
            return false;
    }
}

