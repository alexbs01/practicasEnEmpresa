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

    document.getElementById('result').textContent = result;
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
    //document.getElementById('resultRepeat').innerHTML = '';
    for (let i = 0; i < times; i++) {
        result += textToRepeat + '<br>';
    }

    document.getElementById('resultRepeat').innerHTML = result;
}
