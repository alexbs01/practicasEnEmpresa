function operation() {
    let a = parseFloat(document.getElementById("value1").value) || 0;
    let b = parseFloat(document.getElementById("value2").value) || 0;
    let operation = document.getElementById("operation").value;
    let result = 0;

    switch (operation) {
        case "+":
            result = a + b;
            break;
        case "-":
            result = a - b;
            break;
        case "*":
            result = a * b;
            break;
        case "/":
            result = a / b;
            break;
    }

    document.getElementById('result').textContent = "Resultado: " + result;
}

function restart() {
    document.getElementById('value1').value = '';
    document.getElementById('value2').value = '';
    document.getElementById('result').textContent = '';
}

function repeat() {
    let textToRepeat = document.getElementById('textToRepeat').value;
    let times = parseInt(document.getElementById('timesToRepeat').value);
    let result = '';

    for (let i = 0; i < times; i++) {
        result += textToRepeat + '<br>';
    }

    document.getElementById('resultRepeat').innerHTML = result;
}

function password() {
    let password = document.getElementById('password').value;
    
    if(password === '1234') {
        alert("Contraseña correcta");
    } else {
        alert("Contraseña incorrecta");
    }
}
/*
document.querySelector("html").addEventListener("click", () => {
    alert("Ouch! Stop poking me!");
});
*/

let myButton = document.querySelector("button");
let myHeading = document.querySelector("h1");

function setUserName() {
    const myName = prompt("Please enter your name.");

    if(!myName) {
        setUserName();
        return;
    }

    localStorage.setItem("name", myName);
    myHeading.textContent = `Hello, ${myName}`;
}

if (!localStorage.getItem("name")) {
    setUserName();
} else {
    const storedName = localStorage.getItem("name");
    myHeading.textContent = `Mozilla is cool, ${storedName}`;
}

