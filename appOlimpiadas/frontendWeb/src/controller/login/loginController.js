import { login, register } from '../../model/login/loginModel.js';

async function getHash(password) {
    const encoder = new TextEncoder();
    const data = encoder.encode(password);
    const hashBuffer = await crypto.subtle.digest('SHA-256', data);
    const hashArray = Array.from(new Uint8Array(hashBuffer));
    const hashHex = hashArray.map(byte => byte.toString(16).padStart(2, '0')).join('');
    return hashHex;
}

export const handleLogin = async (setIsLogged, username, password) => {
    console.log('Login:', username, password);

    try {
        const hashedPassword = await getHash(password);
        console.log('Hashed password:', hashedPassword);

        await login(setIsLogged, username, hashedPassword);
        console.log('Login correcto');
        return true;
    } catch (error) {
        console.error('Error al iniciar sesión:', error);
        alert('Usuario o contraseña incorrectos');
        return false;
    }
}

export const handleRegister = async (username, password) => {
    console.log('Register:', username, password);

    try {
        const hashedPassword = await getHash(password);
        console.log('Hashed password:', hashedPassword);

        await register(username, hashedPassword);
        console.log('Registro correcto');
        return true;

    } catch (error) {
        console.error('Error al registrar el usuario:', error);
        alert('Ya existe un usuario con ese nombre');
        return false;
    }
}
