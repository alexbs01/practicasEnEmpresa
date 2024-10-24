const API_URL = 'http://localhost:8080/';
const GET_BY_PAIS = API_URL + 'paises/';
const GET_BY_SEDES = API_URL + 'sedes';
const ADD_PAIS = API_URL + 'paises/add';
const UPDATE_PAIS = API_URL + 'paises/update/';

// Obtener todos los países
export async function getAllPaises() {
    const response = await fetch(`${API_URL}paises`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
        credentials: 'include'
    });

    if (!response.ok) {
        throw new Error('Error al obtener los países');
    }
    
    return response.json();
}

// Obtener un país por su ID
export async function getPaisById(id) {
    const response = await fetch(`${GET_BY_PAIS}${id}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
        credentials: 'include'
    });

    if (!response.ok) {
        throw new Error('Error al obtener el país');
    }

    return await response.json();
}

// Query
export async function getSedes() {
    const response = await fetch(`${GET_BY_SEDES}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
        credentials: 'include'
    });

    if (!response.ok) {
        throw new Error('Error al obtener las sedes');
    }

    return await response.json();
}

// Agregar un país
export async function addPais(NOMBRE_PAIS, CODIGO_PAIS, VALOR_PAIS) {
    console.log(JSON.stringify({ NOMBRE_PAIS, CODIGO_PAIS, VALOR_PAIS }));
    const response = await fetch(`${ADD_PAIS}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        credentials: 'include',
        body: JSON.stringify({ NOMBRE_PAIS, CODIGO_PAIS, VALOR_PAIS }),
    });

    if (!response.ok) {
        throw new Error('Error al agregar el país');
    }

    return await response.json();
}

// Actualizar un país
export async function updatePais(id, NOMBRE_PAIS, CODIGO_PAIS, VALOR_PAIS) {
    console.log(JSON.stringify({ NOMBRE_PAIS, CODIGO_PAIS, VALOR_PAIS }));
    const response = await fetch(`${UPDATE_PAIS}${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        credentials: 'include',
        body: JSON.stringify({ NOMBRE_PAIS, CODIGO_PAIS, VALOR_PAIS }),
    });

    if (!response.ok) {
        throw new Error('Error al actualizar el país');
    }

    return await response.json();
}