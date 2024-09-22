function createContainer() {
    const container = document.createElement("div");
    container.id = "lastSeen";
    container.style.display = "none";
    container.innerText = "Последний раз вы заходили: ";

    const placeholder = document.createElement("span");

    // Попробуем найти футер, если его нет, используем body
    const footer = document.querySelector("#footer") || document.body;
    footer.appendChild(container).appendChild(placeholder);
}



function displayLastSeen() {
    const lastSeen = getCookie("lastSeen");

    if (!lastSeen) {
        return;
    }

    const displayContainer = document.querySelector("#lastSeen");
    const displayPlace = displayContainer.querySelector("span");

    displayPlace.innerText = lastSeen;
    displayContainer.style.display = "";
}

function setLastSeen() {
    const date = new Date();

    setCookie("lastSeen", date.toLocaleString("ru"), {"max-age": 24 * 60 * 60});
}

window.addEventListener("load", createContainer);
window.addEventListener("load", displayLastSeen);
window.addEventListener("load", setLastSeen);