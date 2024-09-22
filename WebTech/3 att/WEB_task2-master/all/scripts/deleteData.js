function deleteData() {
    const cookies = document.cookie.split(";");

    cookies.forEach((cookie) => {
        const cookieName = cookie.split("=")[0].trim();

        console.log(cookieName)
        deleteCookie(cookieName);
    });

    window.location.reload();
}

function setListener() {
    const deleteButton = document.querySelector("#deleteData");

    if (deleteButton) {
        deleteButton.addEventListener("click", deleteData);
    }
}

window.addEventListener("load", setListener);
