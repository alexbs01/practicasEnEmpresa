const API_URL = 'http://localhost:8080/';
const URL_LOGIN = API_URL + 'login';
const URL_REGISTER = API_URL + 'register';

export async function login(toggleIsLogged, username, password) {
    console.log('Login model:', username, password);
    const response = await fetch(`${URL_LOGIN}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }),
    });

    console.log(JSON.stringify({ username, password }));

    if (!response.ok) {
        throw new Error('Error al iniciar sesión');
    }

    toggleIsLogged();
}

export async function register(username, password) {
    console.log('Register model:', username, password);
    const response = await fetch(`${URL_REGISTER}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }),
    });

    console.log(JSON.stringify({ username, password }));

    if (!response.ok) {
        throw new Error('Error al registrar el usuario');
    }

    return response.json();
}