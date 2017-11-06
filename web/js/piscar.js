function piscar() {
    var tempo = 3700;
    var ob = document.getElementById("image");
    var esconder = document.getElementById("esconder");
    var audio = document.getElementById("audio");

    if (ob.style.display == "none") {
        ob.style.position = "fixed";
        ob.style.display = "block";
        esconder.style.display = "block";
        audio.autoplay = true;
        audio.load();
        
    } else {
        ob.style.position = "relative";
        ob.style.display = "none";
        esconder.style.display = "none";
        audio.autoplay = false;
        audio.load();
        var tempo = 50000;

    }

    setTimeout('piscar()', tempo);
}
