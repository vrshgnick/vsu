let header;
let menu;
let footer;

function getElements() {
    header = document.querySelector(".header");
    menu = document.querySelector(".menu");
    footer = document.querySelector(".footer");
}

window.addEventListener("load", getElements);