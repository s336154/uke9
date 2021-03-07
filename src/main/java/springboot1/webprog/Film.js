


$(() => {
    $("#regFilm").click(() => {

        const velgfilm = $("#velgfilm");
        const antall = $("#antall");
        const fornavn = $("#fornavn");
        const etternavn = $("#etternavn");
        const telefonnr = $("#telefonnr");
        const epost = $("#epost");

        const film = {
            velgfilm: velgfilm.val(),
            antall: antall.val(),
            fornavn: fornavn.val(),
            etternavn: etternavn.val(),
            telefonnr: telefonnr.val(),
            epost: epost.val()
        };

        if (inputval(film)) {
            $.post("/film", film, () => hent());


            velgfilm.val("");
            antall.val("");
            fornavn.val("");
            etternavn.val("");
            telefonnr.val("");
            epost.val("");
        } else {
            console.log("Mangler input");
        }
    });

    $("#slettAlle").click(() => {
        $.ajax("/film", {
            type: 'DELETE',
            success: () => hent(),
            error: (jqXhr, textStatus, errorMessage) => console.log(errorMessage)
        });
    });
});

const hent = () => $.get("/film", filmer => formater(filmer));

const inputval = film => {
    if (film.velgfilm === "") return false
    else if (film.antall === "") return false
    else if (film.fornavn === "") return false
    else if (film.etternavn === "") return false
    else if (film.telefonnr === "") return false
    else return film.epost !== "";
}

const formater = filmer => {
    let ut = "<table><tr><th>Velgfilm</th><th>Antall</th><th>Fornavn</th>" +
        "<th>Etternavn</th><th>Telefonnr</th><th>Epost</th></tr>";

    for (let film of filmer) {
        ut += "<tr><td>" + film.velgfilm + "</td><td>" + film.antall + "</td><td>" + film.fornavn + "</td>" +
            "<td>" + film.etternavn + "</td><td>" + film.telefonnr + "</td><td>" + film.epost + "</td></tr>";
    }

    ut += "</table>";

    $("#filmene").html(ut);
}

function slettFilmene() {
    $.get( "/slettAlle", function() {
        hentAlle();
    });

}